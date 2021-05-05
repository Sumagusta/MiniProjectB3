package com.kodehive.kampus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "M_MahasiswaProfil")
public class MahasiswaProfilModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProfil;
	@Column(name="kd_mhs")
	private String kd_mhs;
	
	@OneToOne()
	@JoinColumn(name="kd_mhs", nullable=true, insertable=false, updatable=false)
	private MahasiswaModel mahasiswaModel;

	private String email;
	private String noHP;
	
	public int getIdProfil() {
		return idProfil;
	}
	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}
	
	public String getKd_mhs() {
		return kd_mhs;
	}
	public void setKd_mhs(String kd_mhs) {
		this.kd_mhs = kd_mhs;
	}
	public MahasiswaModel getMahasiswaModel() {
		return mahasiswaModel;
	}
	public void setMahasiswaModel(MahasiswaModel mahasiswaModel) {
		this.mahasiswaModel = mahasiswaModel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNoHP() {
		return noHP;
	}
	public void setNoHP(String noHP) {
		this.noHP = noHP;
	}

	
}
