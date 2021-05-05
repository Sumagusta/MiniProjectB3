package com.kodehive.kampus.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BerandaController {
	
	@RequestMapping("/beranda")
	public String beranda() {
		return "Beranda";
	}
	
	@RequestMapping("/login/action")
	public String beranda(HttpServletRequest request, Model model) {
		
		String requestUser = request.getParameter("username");	
		
		model.addAttribute("hasilLempar", requestUser);
		
		String html = "Beranda";
		return html;
	}
	
	
}



