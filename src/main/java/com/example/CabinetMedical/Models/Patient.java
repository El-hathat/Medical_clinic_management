package com.example.CabinetMedical.Models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Patient")
@Data
@AllArgsConstructor

public class Patient implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(nullable=false)
    private String cin;
    @Column(nullable=false)
    private String nom;
    @Column(nullable=false)
    private String prenom;
    @Column(nullable=false)
    private int age;
    @Column(nullable=false)
    private String sexe;
    @Column(nullable=false)
    private String adresse;
    @Column(nullable=false)
    private String tel;
    @Column(nullable=false)
    private String email;
    @Column(nullable=true)
    private String cabinet;
    public Patient() {
    }

    @Column(nullable=false)
    private String etat;

    public Patient(String cin, String nom, String prenom, int age, String sexe, String adresse, String tel, String email, String nom_cabinet, String etat, Medcin medcin) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.cabinet = nom_cabinet;
        this.etat = etat;
        this.medcin = medcin;
    }

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultation;
    
    
    
    @OneToOne(mappedBy = "patient")
    private DossierMedicale dossierM;
    
    @ManyToOne
	 @JoinColumn(name="medcin")
   private Medcin medcin;
    
    
   @OneToMany(mappedBy = "patient")
    private List<RDV> rdv;

  /*  public Medcin getMedcin() {
	return medcin;
}*/

public void setMedcin(Medcin medcin) {
	this.medcin = medcin;
}

/*public List<RDV> getRdv() {
	return rdv;
}*/

	public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getSexe() {
        return sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getEtat() {
        return etat;
    }


    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setConsultation(List<Consultation> consultation) {
        this.consultation = consultation;
    }

    public void setDossierM(DossierMedicale dossierM) {
        this.dossierM = dossierM;
    }



    public void setRdv(List<RDV> rdv) {
        this.rdv = rdv;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
 
    }

	@Override
	public String toString() {
		return "Patient [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", sexe=" + sexe
				+ ", adresse=" + adresse + ", tel=" + tel + ", email=" + email + ", cabinet=" + cabinet + ", etat="
				+ etat + ", consultation=" + consultation + ", dossierM=" + dossierM + ", medcin=" + medcin + ", rdv="
				+ rdv + "]";
	}
    
    
    
}
