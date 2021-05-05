package com.kodehive.kampus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.kampus.model.MahasiswaModel;
import com.kodehive.kampus.model.MahasiswaProfilModel;
import com.kodehive.kampus.service.MahasiswaProfileService;
import com.kodehive.kampus.service.MahasiswaService;

@Controller
@RequestMapping("/mahasiswa/profil")
public class MahasiswaProfileController {
	
	@Autowired
	private MahasiswaProfileService mahasiswaProfileService;
	
	@Autowired
	private MahasiswaService mahasiswaService;

	@RequestMapping("/home")
	public String home() {
		return "/profile/home";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		this.bacaDataProfile(model);
		
		return "/profile/add";
	}
	
	@RequestMapping("/read")
	public String readProfil(Model model) {
		
		List<MahasiswaProfilModel> mahasiswaProfileModelList = new ArrayList<MahasiswaProfilModel>();
		mahasiswaProfileModelList = this.mahasiswaProfileService.cariSemuaNamaMahasiswa();
		
		model.addAttribute("mahasiswaProfileModelList", mahasiswaProfileModelList);
		return "/profile/list";
		
	}
	
	public void bacaDataProfile(Model model) {
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		mahasiswaModelList = this.mahasiswaService.readAll();
		
		model.addAttribute("mahasiswaModelList", mahasiswaModelList);
		
	}
	
	
}
