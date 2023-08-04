package com.example.CabinetMedical.Models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "rdv")
@Data
@AllArgsConstructor

public class RDV {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num")
	private int num;
	@Column
	private LocalDate dateRDV;
	@Column
	private String heureRDV;
	@Column
	private String note;
	@Column
	private String etat;

	public RDV() {
		// TODO Auto-generated constructor stub
	}

	public RDV(LocalDate dateRDV, String heureRDV, String note, String etat, Medcin medcin, Patient patient) {

		this.num = num;
		this.dateRDV = dateRDV;
		this.heureRDV = heureRDV;
		this.note = note;
		this.etat = etat;
		this.medcin = medcin;
		this.patient = patient;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public LocalDate getDateRDV() {
		return dateRDV;
	}

	public void setDateRDV(LocalDate dateRDV) {
		this.dateRDV = dateRDV;
	}

	public String getHeureRDV() {
		return heureRDV;
	}

	public void setHeureRDV(String heureRDV) {
		this.heureRDV = heureRDV;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public void setMedcin(Medcin medcin) {
		this.medcin = medcin;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "RDV [num=" + num + ", dateRDV=" + dateRDV + ", heureRDV=" + heureRDV + ", note=" + note + ", etat="
				+ etat + ", medcin=" + medcin + ", patient=" + patient + "]";
	}

	@ManyToOne()
	@JoinColumn(name = "medcin")
	private Medcin medcin;

	@ManyToOne()
	@JoinColumn(name = "patient")
	private Patient patient;

}