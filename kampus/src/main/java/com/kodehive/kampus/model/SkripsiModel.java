package com.kodehive.kampus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SKRIPSI")
public class SkripsiModel {

	//property
	@Id
	private String kode;
	private String judul;
	private String nilai;
	private int tahun;
	
	//Plain Old Java Object
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															
	public String getJudul() { // ngambil data
		return judul;
	}
	
	public void setJudul(String judul) {// sett data / buat data
		this.judul = judul;
	}
	
	public String getNilai() {
		return nilai;
	}
	public void setNilai(String nilai) {
		this.nilai = nilai;
	}
	public int getTahun() {
		return tahun;
	}
	public void setTahun(int tahun) {
		this.tahun = tahun;
	}
	
		
}
