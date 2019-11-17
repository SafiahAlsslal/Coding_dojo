package com.codingdojo.blackbelt.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.blackbelt.models.Idea;
import com.codingdojo.blackbelt.repositories.IdeaRepository;

@Service
public class IdeaService {

	private final IdeaRepository ideaRepo;

	
	public IdeaService(IdeaRepository ideaRepo) {
		this.ideaRepo = ideaRepo;
	}
	
	public ArrayList<Idea> all(){
		return (ArrayList<Idea>) ideaRepo.findAll();
	}
	public ArrayList<Idea> allasc(){
		return (ArrayList<Idea>) ideaRepo.findAllByOrderByLikesAsc();
	}
	
	public ArrayList<Idea> alldesc(){
		return (ArrayList<Idea>) ideaRepo.findAllByOrderByLikesDesc();
	}
	
	
	    // creates 
	    public Idea create_new (Idea l) {
	        return ideaRepo.save(l);
	    }
	    
	    public Idea find_one (Long id) {
	        Optional<Idea> idea = ideaRepo.findById(id);
	        if(idea.isPresent()) {
	            return idea.get();
	        } else {
	            return null;
	        }
	    }
	    
	    //delete
	    public void delete(Long id) {
	    	ideaRepo.deleteById(id);
	    }
	    
	    //update
	
	    public Idea update(Idea l ) {
		     return ideaRepo.save(l);
		    }
}
