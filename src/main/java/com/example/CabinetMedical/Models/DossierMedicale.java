package com.example.CabinetMedical.Models;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "DossierMedicale")
@Data

public class DossierMedicale {

	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    @Column(name = "num")
	    private int num;
	 
	    @Column(name = "DateNaissance")
	    private LocalDate dateNaissance;

	    @Column(name = "Sang")
	    private String Sang;
	    
	    @Column(name = "Situation")
	    private String Situation;
	    
	    @Column(name = "Note")
	    private String note;
	    
	    @Column(name = "date_creation")
	    private LocalDate date_creation;
	    


	    @OneToOne()
	    @JoinColumn(name = "Patient", referencedColumnName = "cin")
	    private Patient patient;

	public DossierMedicale(int num,  String sang, String situation_F, String note, LocalDate date_creation, Patient patient) {
		this.num = num;

		this.Sang = sang;
		this.Situation = situation_F;
		this.note = note;
		this.date_creation = date_creation;
		this.patient = patient;
	}

	public int getNum() {
		return num;
	}

	public DossierMedicale() {
	}

	public void setNum(int num) {
		this.num = num;
	}

	public LocalDate getDate_Naissance() {
		return dateNaissance;
	}

	public void setDate_Naissance(LocalDate date_Naissance) {
		this.dateNaissance = date_Naissance;
	}

	public String getSang() {
		return Sang;
	}

	public void setSang(String sang) {
		Sang = sang;
	}

	public String getSituation_F() {
		return Situation;
	}

	public void setSituation_F(String situation_F) {
		Situation= situation_F;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDate getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(LocalDate date_creation) {
		this.date_creation = date_creation;
	}

	

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "DossierMedicale [num=" + num + ", dateNaissance=" + dateNaissance + ", Sang=" + Sang + ", Situation="
				+ Situation + ", note=" + note + ", date_creation=" + date_creation + ", patient=" + patient + "]";
	}
	
	
}
