package com.kodehive.kampus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodehive.kampus.model.JurusanModel;
import com.kodehive.kampus.model.MahasiswaModel;
import com.kodehive.kampus.service.JurusanService;
import com.kodehive.kampus.service.MahasiswaService;
import com.kodehive.kampus.service.SkripsiService;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {

	@Autowired
	private MahasiswaService mahasiswaService;
	
	@Autowired
	private JurusanService jurusanService;

	@RequestMapping("/home")
	public String home() {
		return "/mahasiswa/home";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		this.readJurusan(model);
		return "/mahasiswa/add";
	}

	@RequestMapping("/create")
	public String create(HttpServletRequest request) {
		String kodeMahasiswa = request.getParameter("kodeMahasiswa");
		String namaMahasiswa = request.getParameter("namaMahasiswa");
		String alamat = request.getParameter("alamat");
		String jenisKelamin = request.getParameter("jk");
		String status = request.getParameter("status");
		String kodeJurusan = request.getParameter("jurusan");

		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel.setKd_mhs(kodeMahasiswa);
		mahasiswaModel.setNm_mhs(namaMahasiswa);
		mahasiswaModel.setJk(jenisKelamin);
		mahasiswaModel.setAlamat(alamat);
		mahasiswaModel.setStatus(status);
		mahasiswaModel.setKodeJurusan(kodeJurusan);
		
		mahasiswaService.saveMhs(mahasiswaModel);

		String html = "/mahasiswa/home";
		return html;
	}

	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		String kd_mhs = request.getParameter("kd_mhs");
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = this.mahasiswaService.searchCode(kd_mhs);

		model.addAttribute("modalEditLempar", mahasiswaModel);// attrName, attrValue

		return "/mahasiswa/edit";
	}

	@RequestMapping("/list")
	public String readMahasiswa(Model model) {
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		mahasiswaModelList = mahasiswaService.readAll();
		model.addAttribute("mahasiswaModelList", mahasiswaModelList);

		return "/mahasiswa/list";
	}

	@RequestMapping("cari_usia")
	public String cariUsia() {
		return "/mahasiswa/cari_usia";
	}

	@RequestMapping(value = "proses_cari_usia")
	public String menuProsesCariUsia(HttpServletRequest request, Model model) {
		int katakunci_usia = Integer.valueOf(request.getParameter("katakunci_usia"));
		String katakunci_operator = request.getParameter("katakunci_operator");

		List<MahasiswaModel> dosenModelList = new ArrayList<MahasiswaModel>();
		dosenModelList = mahasiswaService.readWhereUsiaByOperator(katakunci_usia, katakunci_operator);

		model.addAttribute("mahasiswaModelList", dosenModelList);
		String html = "mahasiswa/cari_usia";
		return html;
	}

	@RequestMapping("/remove")
	public String remove(HttpServletRequest request, Model model) {
		String kodeMahasiswa = request.getParameter("kd_mhs");

		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = this.mahasiswaService.searchCode(kodeMahasiswa);

		model.addAttribute("bingkisanDelete", mahasiswaModel);

		String html = "/mahasiswa/remove";
		return html;

	}

	@RequestMapping("/read_jurusan")
	public void readJurusan(Model model) {
		List<JurusanModel> jurusanModelList = new ArrayList<JurusanModel>();
		jurusanModelList = this.jurusanService.readData();
		
		model.addAttribute("jurusanModelList", jurusanModelList);
	}

}
