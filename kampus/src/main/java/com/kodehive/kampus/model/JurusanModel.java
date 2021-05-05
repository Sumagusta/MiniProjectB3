package com.kodehive.kampus.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="J_Jurusan")
public class JurusanModel {
	
	@Id
	private String kodeJurusan;
	private String namaJurusan;
	
	public String getKodeJurusan() {
		return kodeJurusan;
	}
	public void setKodeJurusan(String kodeJurusan) {
		this.kodeJurusan = kodeJurusan;
	}
	public String getNamaJurusan() {
		return namaJurusan;
	}
	public void setNamaJurusan(String namaJurusan) {
		this.namaJurusan = namaJurusan;
	}
	
	
}
