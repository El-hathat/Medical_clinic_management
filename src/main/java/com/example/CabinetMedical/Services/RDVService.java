package com.example.CabinetMedical.Services;


import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Models.Patient;
import com.example.CabinetMedical.Models.RDV;
import com.example.CabinetMedical.Repository.MedcinRepository;
import com.example.CabinetMedical.Repository.PatientRepository;
import com.example.CabinetMedical.Repository.RDVRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RDVService {

    @Autowired
    private RDVRepository rep;
    
    @Autowired
    private PatientRepository reppat;
    
    @Autowired
    private MedcinRepository medc;
    
    
    public int countByMedcin(Medcin med){
    	int i=0;
    	for(Patient pt:reppat.findPatientsByCabinet(med.getNom_cabinet())) {
    		
    		for(RDV rd:rep.findAllByPatient(pt)) {
    			i++;
    		}
    	}
    	return i; 
         
    }

    public RDV save(RDV rdv) {

        //  System.out.println("from service");
        return this.rep.save(rdv);

    }
    
    
    public void delRdv(int num) {
    	rep.deleteById(num);
    }
    
    public List<RDV> listesRDV(String cabinet) {
List<RDV> listeRDV=new ArrayList<>();
    	for(Patient pt:this.reppat.findPatientsByCabinet(cabinet)) {
    		for(RDV rdv:rep.findAllByPatient(pt)) {
    			listeRDV.add(rdv);
    			
    		}
    		
    	}
    	return listeRDV;

    }
    
    public List<RDV> getAllRDVBYCin(Patient pt){
    	return rep.findAllByPatient(pt);
    }
    
    
    public List<RDV> getAllRDVBYdate(LocalDate date){
    	return rep.findAllByDateRDV(date);
    }
}
