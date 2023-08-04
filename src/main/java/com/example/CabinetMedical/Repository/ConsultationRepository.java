package com.example.CabinetMedical.Repository;

import com.example.CabinetMedical.Models.Consultation;
import com.example.CabinetMedical.Models.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

    public List<Consultation> findByPatient(String cin);
    public List<Consultation> findByPatient(Patient p);
    public Consultation findByNum(Integer num);

    
    
  
   


  
    

    
    
    
}
