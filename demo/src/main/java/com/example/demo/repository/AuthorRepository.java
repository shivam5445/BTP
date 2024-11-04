package com.example.demo.repository;

import com.example.demo.entity.Author;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AuthorRepository extends Neo4jRepository<Author, String> {
}
