package com.example.demo.repository;

import com.example.demo.entity.Publication;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PublicationRepository extends Neo4jRepository<Publication, String> {
}
