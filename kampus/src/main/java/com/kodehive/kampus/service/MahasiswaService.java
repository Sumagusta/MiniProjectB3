package com.kodehive.kampus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.kampus.model.MahasiswaModel;
import com.kodehive.kampus.repository.MahasiswaRepository;

@Service
public class MahasiswaService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private MahasiswaRepository mahasiswaRepository;

	public void saveMhs(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.save(mahasiswaModel);
	}

	public void update(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.save(mahasiswaModel);
	}

//	public Optional<MahasiswaModel> searhDesc() {
//		return this.mahasiswaRepository.findTop2ByOrderBySeatNumberAsc();
//				
//	}

	public List<MahasiswaModel> usiaTertinggi(int limit) {
		return entityManager.createQuery("select m from MahasiswaModel m order by m.usia desc", MahasiswaModel.class)
				.setMaxResults(limit).getResultList();
	}

	@Transactional(readOnly = true)
	public void delete(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.delete(mahasiswaModel);
	}

	public List<MahasiswaModel> readAll() {
		return mahasiswaRepository.cariSemuaData();
	}

	public MahasiswaModel searchCode(String kd_mhs) {
		return mahasiswaRepository.cariKode(kd_mhs);
	}

	// logic
	public List<MahasiswaModel> readWhereUsiaByOperator(int katakunci_usia, String katakunci_operator) {
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();

		if (katakunci_operator.equals("=")) {
			mahasiswaModelList = mahasiswaRepository.queryWhereUsiaEqual(katakunci_usia);
		} else if (katakunci_operator.equals(">")) {
			mahasiswaModelList = mahasiswaRepository.queryWhereUsiaMore(katakunci_usia);
		} else if (katakunci_operator.equals("<")) {
			mahasiswaModelList = mahasiswaRepository.queryWhereUsiaLess(katakunci_usia);
		} else if (katakunci_operator.equals(">=")) {
			mahasiswaModelList = mahasiswaRepository.queryWhereUsiaMoreEqual(katakunci_usia);
		} else if (katakunci_operator.equals("<=")) {
			mahasiswaModelList = mahasiswaRepository.queryWhereUsiaLessEqual(katakunci_usia);
		} else {
			mahasiswaModelList = mahasiswaRepository.queryWhereUsiaNotEqual(katakunci_usia);
		}

		return mahasiswaModelList;

	}

}
