package com.example.CabinetMedical.Models;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "PlageHoraire")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlageHoraire {

	
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id_plage")
private int id_plage;

 @Column(name = "date_plage")
private LocalDate date_plage;

 @Column(name = "heure_deb")
private String heure_deb;

 @Column(name = "heure_fin")
private String heure_fin;
 
 
 @ManyToOne
 @JoinColumn(name="medcin", nullable=false)
private Medcin medcin;
}
