package com.codingdojo.blackbelt.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.blackbelt.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	ArrayList<Idea> findAll();
	ArrayList<Idea> findAllByOrderByLikesAsc();
	ArrayList<Idea> findAllByOrderByLikesDesc();
}