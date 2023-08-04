package com.example.CabinetMedical.Models;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Medcin")
public class Medcin implements UserDetails{

	
	@Id
    @Column(name = "cin")
    private String cin;
	
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "email")
    private String email;

    @Column(name = "pwd")
    private String pwd;

	@Column(name = "nom_cabinet")
	private String nom_cabinet;

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public Boolean getEtat() {
		return etat;
	}

	@Column(name = "etat")
	private Boolean etat;

	@Column(name = "role")
	private String role;
    public Medcin() {
		// TODO Auto-generated constructor stub
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}





	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public Medcin(String cin, String nom, String prenom, String email, String pwd, String nom_cabinet, String role,Boolean etat) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pwd = pwd;
		this.nom_cabinet = nom_cabinet;
		this.role = role;
		this.etat=etat;
		this.patient = new ArrayList<>();
		this.rdv = new ArrayList<>();
		this.plageHr = new ArrayList<>();
	}

	public boolean egaliter(String pwd1) {
		
			if(this.pwd==pwd1) {
				return true;
			}
		return false;
	}


	@Override
	public String toString() {
		return "Medcin{" +
				"cin='" + cin + '\'' +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", email='" + email + '\'' +
				", pwd='" + pwd + '\'' +
				", nom_cabinet='" + nom_cabinet + '\'' +
				", patient=" + patient +
				", rdv=" + rdv +
				", plageHr=" + plageHr +
				'}';
	}

	public String getNom_cabinet() {
		return nom_cabinet;
	}


	public void setNom_cabinet(String nom_cabinet) {
		this.nom_cabinet = nom_cabinet;
	}

	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	public void setPassword(String pwd) {
		this.pwd = pwd;
	}












	@OneToMany(mappedBy = "medcin")
	private List<Patient> patient;

	@OneToMany(mappedBy = "medcin")
    private List<RDV> rdv;
    
    @OneToMany(mappedBy = "medcin")
    private List<PlageHoraire> plageHr;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.pwd;
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	
    
    
}
