package de.urr4.drinkmanagerbackend.repositories;

import de.urr4.wine.entities.Wine;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WineRepository extends Neo4jRepository<Wine, UUID> {
}
