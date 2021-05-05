package com.kodehive.kampus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.kampus.model.MahasiswaModel;

public interface MahasiswaRepository extends JpaRepository<MahasiswaModel, String> {
	
	@Query("select m from MahasiswaModel m")
	List<MahasiswaModel> cariSemuaData();
	
	@Query("select m from MahasiswaModel m where kd_mhs = ?1")
	MahasiswaModel cariKode(String kd_mhs);
	
	List<MahasiswaModel>searchAlamat();
	
	//varian condition
	@Query("SELECT D FROM MahasiswaModel D WHERE D.usia =?1")
	List<MahasiswaModel> queryWhereUsiaEqual(int katakunci_usia);
	
	@Query("SELECT D FROM MahasiswaModel D WHERE D.usia >?1")
	List<MahasiswaModel> queryWhereUsiaMore(int katakunci_usia);
	
	@Query("SELECT D FROM MahasiswaModel D WHERE D.usia <?1")
	List<MahasiswaModel> queryWhereUsiaLess(int katakunci_usia);
	
	@Query("SELECT D FROM MahasiswaModel D WHERE D.usia >=?1")
	List<MahasiswaModel> queryWhereUsiaMoreEqual(int katakunci_usia);
	
	@Query("SELECT D FROM MahasiswaModel D WHERE D.usia <=?1 ")
	List<MahasiswaModel> queryWhereUsiaLessEqual(int katakunci_usia);
	
	@Query("SELECT D FROM MahasiswaModel D WHERE D.usia !=?1")
	List<MahasiswaModel> queryWhereUsiaNotEqual(int katakunci_usia);
	
}
