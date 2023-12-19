package com.example.reports.reportsnovo;

import com.example.reports.reportsnovo.model.Animal;
import com.example.reports.reportsnovo.model.Client;
import com.example.reports.reportsnovo.model.Report;
import com.example.reports.reportsnovo.model.Vet;
import com.example.reports.reportsnovo.repository.AnimalRepository;
import com.example.reports.reportsnovo.repository.ClientRepository;
import com.example.reports.reportsnovo.repository.ReportRepository;
import com.example.reports.reportsnovo.repository.VetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.util.Set;

@SpringBootApplication
@EnableTransactionManagement
public class ReportsnovoApplication {

	private static final Logger log = LoggerFactory.getLogger(ReportsnovoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReportsnovoApplication.class, args);
	}

	//posso criar um data.sql - que o fato de ter o H2 vai iniciar a base de dados e inserir as propriedades (no application properties)
	@Bean
	public CommandLineRunner initDatabase(ClientRepository clientRepository,
										  AnimalRepository animalRepository,
										  VetRepository vetRepository,
										  ReportRepository reportRepository) {
		return (args) -> {
			Client maria = clientRepository.save(new Client("maria", 45678723));
			Client alice = clientRepository.save(new Client("alice", 78945612));
			Client ana = clientRepository.save(new Client("ana", 78546932));

			log.info("List all clients");
			clientRepository.findAll().forEach(client -> {
				log.info(client.toString());
			});

			Animal cocada = animalRepository.save(new Animal("Cocada", "cat", 34554333, maria));
			Animal pudim = animalRepository.save(new Animal("pudim", "cat", 123456789, maria));
			Animal amarela = animalRepository.save(new Animal("amarela", "cat", 456321789, ana));
			Animal fred = animalRepository.save(new Animal("fred", "cat", 1235647856, alice));

			log.info("List all animals");
			animalRepository.findAll().forEach(animal -> {
			log.info(animal.toString());
			});

			maria = clientRepository.findClientById(maria.getId()).get();

			Vet eduarda = vetRepository.save(new Vet("Eduarda", 13777));
			Vet daniela = vetRepository.save(new Vet("Daniela", 13789));

			log.info("List all vets");
			vetRepository.findAll().forEach(vet -> {
				log.info(vet.toString());
			});

			Report ultra1 = reportRepository.save(new Report("ultrasound",
					"splenomegaly, reactive mesentery adjacent to the stomach.", LocalDateTime.now(), eduarda, cocada, maria));

			Report ultra2 = reportRepository.save(new Report("ultrassound", "The right kidney measures and the left kidney measures . " +
					"Both kidneys are free of hydronephrosis. The right kidney contains a 12 cm cyst.", LocalDateTime.now(), eduarda, pudim, maria));

			Report ultra3 = reportRepository.save(new Report("ultrasound", "The spleen is of uniform echo texture and does not appear enlarged."
					, LocalDateTime.now(), daniela, amarela, ana));

			Report ultra4 = reportRepository.save(new Report("ultrasound", "Multiple gallstones are noted within the contracted gallbladder"
					, LocalDateTime.now(), daniela, fred, alice));


			log.info("List all reports");
			reportRepository.findAll().forEach(report -> {
				log.info(report.toString());
			});
		};
	}
}