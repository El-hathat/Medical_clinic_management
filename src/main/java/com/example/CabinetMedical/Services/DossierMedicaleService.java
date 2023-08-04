package com.example.CabinetMedical.Services;

import com.example.CabinetMedical.Models.Consultation;
import com.example.CabinetMedical.Models.DossierMedicale;
import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Models.Patient;
import com.example.CabinetMedical.Repository.DossierMedicaleRepository;
import com.example.CabinetMedical.Repository.MedcinRepository;
import com.example.CabinetMedical.Repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DossierMedicaleService {
    @Autowired
    private DossierMedicaleRepository rep;
    @Autowired
    private PatientRepository repmed;
    
    public DossierMedicale getDtnByCin(Patient patient) {
        return rep.findDate_NaissanceByPatient(patient);
    }
    public DossierMedicale addDossier(DossierMedicale dossier) {
        
            dossier.setDate_creation(LocalDate.now());
            System.out.println(dossier.toString());
           return rep.save(dossier);
           
       

    }
    public List<Integer> getNombreDossiersParMois(String cabinet) {
    	List<Patient> listmed = repmed.findPatientsByCabinet(cabinet);
    	 List<DossierMedicale> dossiersMedicaux= new ArrayList<>();
    	for (Patient patient : listmed) {
    		dossiersMedicaux.add(rep.findByPatient(patient));
		}
        
        List<Integer> NbPatients= new ArrayList(Collections.nCopies(12, 0)); 
        for (DossierMedicale dossierMedical : dossiersMedicaux) {
        	if(dossierMedical!=null) {
            LocalDate dateCreation = dossierMedical.getDate_creation();
            if(dateCreation.getYear()==LocalDate.now().getYear()) {
           NbPatients.set(dateCreation.getMonthValue()-1, NbPatients.get(dateCreation.getMonthValue()-1)+1);
            }
            }
        }

      

        return NbPatients;
    }
}
