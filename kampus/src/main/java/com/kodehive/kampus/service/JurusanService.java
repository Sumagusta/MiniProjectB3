package com.kodehive.kampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodehive.kampus.model.JurusanModel;
import com.kodehive.kampus.repository.JurusanRepository;

@Service
public class JurusanService {
	
	@Autowired
	private JurusanRepository jurusanRepository;

	public List<JurusanModel> readData(){
		return jurusanRepository.findAll();
	}
	
}
