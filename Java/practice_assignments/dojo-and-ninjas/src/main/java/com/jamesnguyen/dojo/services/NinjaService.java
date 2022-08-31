package com.jamesnguyen.dojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamesnguyen.dojo.models.Ninja;
import com.jamesnguyen.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepo;
	
	//get all ninjas
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	
	//save ninja
	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
}
