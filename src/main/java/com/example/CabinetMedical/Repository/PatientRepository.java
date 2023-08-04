package com.example.CabinetMedical.Repository;

import com.example.CabinetMedical.Models.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.CabinetMedical.Models.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
	
	public Patient findPatientByCin(String cin);
	public List<Patient> findByCinStartingWithIgnoreCase(String cin);
	public List<Patient> findByNomStartingWithIgnoreCase(String nom);
	public List<Patient> findPatientsByCabinet(String md);

	public int countByCabinet(String md);


}
