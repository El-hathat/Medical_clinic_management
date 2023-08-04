package com.example.CabinetMedical.Models;



import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Table(name = "Consultation")
@Data

public class Consultation {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    @Column(name = "num")
	    private int num;
	 
	    @Column(name = "dateConsultation")
	    private LocalDate dateConsultation;
	    
	    @Column(name = "Designation")
	    private String designation;
	    
	    @Column(name = "poids")
	    private float poids;
		@Column(name = "prix")
		private float prix;
	    
	    @Column(name = "taille")
	    private int taille;
	    
	    @Column(name = "temperature")
	    private float tempr;
	    
	    @Column(name = "frq_card")
	    private float frq_card;
	    

	    @OneToOne(mappedBy = "consultation")
	    private Certificat certificat;
	    
	    @OneToOne(mappedBy = "consultation")
	    private Ordonnance ordonnance;
	    
	    
	    
		public Ordonnance getOrdonnance() {
			return ordonnance;
		}
		public Patient getPatient() {
			return patient;
		}


		@ManyToOne
		 @JoinColumn(name="patient", nullable=false)
	    private Patient patient;

	public Consultation(int num, LocalDate dateConsultation, String designation,float prix, float poids, int taille, float tempr, float frq_card, Patient patient) {
		this.num = num;
		this.dateConsultation = dateConsultation;
		this.designation = designation;
		this.poids = poids;
		this.taille = taille;
		this.tempr = tempr; 
		this.frq_card = frq_card;
		this.patient = patient;
		this.prix=prix;
	}
	public Consultation() {
	}
	public void setNum(int num) {
		this.num = num;
	}

	

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public void setTempr(float tempr) {
		this.tempr = tempr;
	}

	public void setFrq_card(float frq_card) {
		this.frq_card = frq_card;
	}

	public void setCertificat(Certificat certificat) {
		this.certificat = certificat;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getNum() {
		return num;
	}

	

	public LocalDate getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(LocalDate dateConsultation) {
		this.dateConsultation = dateConsultation;
	}
	public String getDesignation() {
		return designation;
	}

	public float getPoids() {
		return poids;
	}

	public int getTaille() {
		return taille;
	}

	public float getTempr() {
		return tempr;
	}

	public float getFrq_card() {
		return frq_card;
	}


	@Override
	public String toString() {
		return "Consultation [num=" + num + ", dateConsultation=" + dateConsultation + ", designation=" + designation
				+ ", poids=" + poids + ", prix=" + prix + ", taille=" + taille + ", tempr=" + tempr + ", frq_card="
				+ frq_card + ", certificat=" + certificat + ", ordonnance=" + ordonnance + ", patient=" + patient + "]";
	}
	
	
	
}

