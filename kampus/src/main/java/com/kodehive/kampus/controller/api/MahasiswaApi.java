package com.kodehive.kampus.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodehive.kampus.model.MahasiswaModel;
import com.kodehive.kampus.service.MahasiswaService;

@Controller
@ResponseBody
public class MahasiswaApi {

	@Autowired
	private MahasiswaService mahasiswaService;

// GET POST PUT DELETE

	@GetMapping("/api/mahasiswa/get")
	public List<MahasiswaModel> getMapp() {
		List<MahasiswaModel> mahasiswaModellList = new ArrayList<MahasiswaModel>();
		mahasiswaModellList = this.mahasiswaService.readAll();

		return mahasiswaModellList;
	}
	
//	@GetMapping("/api/tinggi")
//	public Optional<MahasiswaModel> usia() {
//		return this.mahasiswaService.searhDesc();
//	}
	
	@GetMapping("/api/tinggi/{limit}")
	public List<MahasiswaModel> usia(@PathVariable int limit) {
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		mahasiswaModelList = this.mahasiswaService.usiaTertinggi(limit);
		
		return mahasiswaModelList;
	}

	@PostMapping("/api/post")
	public Map<String, Object> postData(@RequestBody MahasiswaModel mahasiswaModel) {
		this.mahasiswaService.saveMhs(mahasiswaModel);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("Pesan", Boolean.TRUE);
		map.put("Berhasil", "Data sudah berhasil diinput");

		return map;
	}

	@PutMapping("/api/put")
	public Map<String, Object> putData(@RequestBody MahasiswaModel mahasiswaModel) {
		
		this.mahasiswaService.update(mahasiswaModel);
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("Pesan", Boolean.TRUE);
		map.put("Berhasil", "Data sudah berhasil diupdate");

		return map;
	}

}
