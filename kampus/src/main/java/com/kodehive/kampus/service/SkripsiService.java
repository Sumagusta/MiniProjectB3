package com.kodehive.kampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodehive.kampus.model.MahasiswaModel;
import com.kodehive.kampus.model.SkripsiModel;
import com.kodehive.kampus.repository.SkripsiRepository;

@Service
public class SkripsiService {
	
	// Dependencies Injection
	@Autowired
	private SkripsiRepository skripsiRepository;
	
	public void simpan(SkripsiModel skripsiModel) { // input datannya termasuk input ID
		skripsiRepository.save(skripsiModel);
	}
	
	public void update(SkripsiModel skripsiModel) { // input datanya kecuali ID
		skripsiRepository.save(skripsiModel);
	}
	
	public MahasiswaModel searchCode(String code) {
		return skripsiRepository.cari(code);
	}
	
}
