package com.example.CabinetMedical.Models;

import java.time.LocalDate;




import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ordonnance")
@Data

public class Ordonnance {

	@Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    @Column(name = "num")
	    private int num;
	  
	    @Column(name = "Date_Ordonnance")
	    private LocalDate dateOrd;
	    
	    @Column(name = "Medicaments")
	    private String medicament;
	    
	    
	    @OneToOne()
	    @JoinColumn(name = "Consultation", referencedColumnName = "num")
	    private Consultation consultation;

	public Ordonnance() {
	}

	public Ordonnance(int num, LocalDate dateOrd, String medicament, Consultation consultation) {
		this.num = num;
		this.dateOrd = dateOrd;
		this.medicament = medicament;
		this.consultation = consultation;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public LocalDate getDateOrd() {
		return dateOrd;
	}

	public void setDateOrd(LocalDate dateOrd) {
		this.dateOrd = dateOrd;
	}

	public String getMedicament() {
		return medicament;
	}

	public void setMedicament(String medicament) {
		this.medicament = medicament;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
}
