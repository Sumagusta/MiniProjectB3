package com.kodehive.kampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodehive.kampus.model.MahasiswaProfilModel;
import com.kodehive.kampus.repository.MahasiswaProfileRepository;
import com.kodehive.kampus.repository.MahasiswaRepository;

@Service
public class MahasiswaProfileService {

	@Autowired
	private MahasiswaProfileRepository mahasiswaProfileRepository;
	
	public void simpanProfile(MahasiswaProfilModel mahasiswaProfileModel) {
		mahasiswaProfileRepository.save(mahasiswaProfileModel);
	}
	
	public List<MahasiswaProfilModel> cariSemuaNamaMahasiswa() {
		return mahasiswaProfileRepository.findAll();
	}
	
}
