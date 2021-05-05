package com.kodehive.kampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.kampus.model.SkripsiModel;

@Controller
public class SkripsiController {
	
	@RequestMapping("/isi")
	public String isiData() {
		SkripsiModel skripsiModel = new SkripsiModel();
		skripsiModel.setKode("S001");
		skripsiModel.setJudul("Globalisasi");
		skripsiModel.setNilai("B");
		skripsiModel.setTahun(2020);
		
		return "index";
		
	}
}
