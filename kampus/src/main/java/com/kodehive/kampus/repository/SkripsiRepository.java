package com.kodehive.kampus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.kampus.model.MahasiswaModel;
import com.kodehive.kampus.model.SkripsiModel;

// CRUD = Create, Read, Update, Delete

public interface SkripsiRepository extends JpaRepository<SkripsiModel, String> {
	
	@Query("select m from MahasiswaModel m where nm_mhs = 'M001'")
	MahasiswaModel cari(String code);
	
}
