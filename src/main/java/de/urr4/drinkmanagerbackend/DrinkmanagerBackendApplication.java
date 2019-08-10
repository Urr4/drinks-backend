package de.urr4.drinkmanagerbackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
@EntityScan(basePackages = {"de.urr4.wine.entities"})
public class DrinkmanagerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrinkmanagerBackendApplication.class, args);
    }

}
