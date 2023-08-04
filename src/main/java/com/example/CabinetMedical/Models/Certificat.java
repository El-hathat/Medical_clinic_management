package com.example.CabinetMedical.Models;


import java.time.LocalDate;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Certificat")
@Data
public class Certificat {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable=false)
	private int num;
	@Column(nullable=false)
	private LocalDate date_cer;
	@Column
	private int nbjours;
	@Column
	private String type;
	
	
	   @OneToOne()
	    @JoinColumn(name = "consultation", referencedColumnName = "num")
	    private Consultation consultation;

	public Certificat(int num, LocalDate date_cer, int nbjours, String type, Consultation consultation) {
		this.num = num;
		this.date_cer = date_cer;
		this.nbjours = nbjours;
		this.type = type;
		this.consultation = consultation;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setDate_cer(LocalDate date_cer) {
		this.date_cer = date_cer;
	}

	public void setNbjours(int nbjours) {
		this.nbjours = nbjours;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
	public Certificat() {
	}
	public int getNum() {
		return num;
	}

	public LocalDate getDate_cer() {
		return date_cer;
	}

	public int getNbjours() {
		return nbjours;
	}

	public String getType() {
		return type;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	
}
