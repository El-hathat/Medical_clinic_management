package com.example.CabinetMedical.Services;

import com.example.CabinetMedical.Models.Consultation;
import com.example.CabinetMedical.Models.DossierMedicale;
import com.example.CabinetMedical.Models.Ordonnance;
import com.example.CabinetMedical.Models.Patient;
import com.example.CabinetMedical.Repository.ConsultationRepository;
import com.example.CabinetMedical.Repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationRepository rep;
    
    @Autowired
    private PatientRepository reppat;
    
    public void deleteConsult(int num) {
    	
  	rep.deleteById(num);
  	 
  }
    
    
    public Consultation ajouterconsultation(Consultation cnt) {
    	cnt.setDateConsultation(LocalDate.now());
        return rep.save(cnt);
    }
    
    public List<Consultation> getConsultationbyPatient(String md){
      
        return rep.findByPatient(md);
    }  
    
    public List<Consultation> getAllConsultation(String cin){
      
        return rep.findByPatient(reppat.findPatientByCin(cin));
    }
    
    public Optional<Consultation> getByNum(int num){
        
        return rep.findById(num);
    }
public Consultation fetbynum(int num){
        
        return rep.findByNum(num);
    }
    
    public List<Consultation> GetAllBetwenDate(LocalDate d1,LocalDate d2,String cabinet){
    	List<Patient> pt=reppat.findPatientsByCabinet(cabinet);
    	//List<Consultation> consult=new ArrayList<>();
    	List<Consultation> consul=new ArrayList<>();
    	for(Patient pat:pt) {
        for(Consultation consultation:rep.findByPatient(pat)) {
      	 if(consultation.getDateConsultation().isAfter(d1) && consultation.getDateConsultation().isBefore(d2) || consultation.getDateConsultation().equals(d1) || consultation.getDateConsultation().equals(d2) ) {
      	  consul.add(consultation);
      	
      	 }
        }
    	}
       
    	return consul;
    }
    
    
    
    public List<Integer> getCaisseParMois(String cabinet) {
    	List<Patient> listeP=reppat.findPatientsByCabinet(cabinet);
    	
        List<Consultation> consultationListe = new ArrayList<>();
        
        for(Patient p:listeP) {
        	for(Consultation consult:rep.findByPatient(p)) {
        	consultationListe.add(consult);
        }}
        List<Integer> caisse= new ArrayList(Collections.nCopies(12, 0)); 
        for (Consultation consult : consultationListe) {
        	if(!(consult.getDateConsultation()==null)) {
            LocalDate dateCreation = consult.getDateConsultation();
         
            if(dateCreation.getYear()==LocalDate.now().getYear()) {
           caisse.set(dateCreation.getMonthValue()-1, caisse.get(dateCreation.getMonthValue()-1)+(int)consult.getPrix());
            }
        }}

      

        return caisse;
    }
   
    
}
