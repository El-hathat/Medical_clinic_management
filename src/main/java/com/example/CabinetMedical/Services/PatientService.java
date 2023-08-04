package com.example.CabinetMedical.Services;





import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Models.Patient;
import com.example.CabinetMedical.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService {

    @Autowired
    private PatientRepository rep;


    public Patient ajouterPatient(Patient patient) {
        return rep.save(patient);
    }

    public List<Patient> getPatients() {
        return rep.findAll();
    }


    public Patient getPatientByCin(String cin){
        return rep.findPatientByCin(cin);
    }
    public List<Patient> findPatientsByCabinet(String md){
        return rep.findPatientsByCabinet(md);
    }
    public List<Patient> getPatientsSeaech(String cin) {
        return rep.findByCinStartingWithIgnoreCase(cin);
    }
    public void validerPatient(String cin) {
        Patient patient=rep.findPatientByCin(cin);
        patient.setEtat("Valider");
        rep.saveAndFlush(patient);
    }

    public void setpat(String cin,Patient pat) {
        System.out.println(pat.toString());
        Patient patient=rep.findPatientByCin(cin);
        patient.setNom(pat.getNom());
        patient.setPrenom(pat.getPrenom());
        patient.setEmail(pat.getEmail());
        patient.setSexe(pat.getSexe());
        patient.setAdresse(pat.getAdresse());
        patient.setAge(pat.getAge());
        patient.setTel(pat.getTel());

        rep.saveAndFlush(patient);
    }
    public List<Patient> getPatientsSeaechNom(String nom) {
        return rep.findByNomStartingWithIgnoreCase(nom);
    }
    public int countByCabinet(String cin){
        return rep.countByCabinet(cin);
    }
    public void setEtatPatient(String cin) {
        Patient patient=rep.findPatientByCin(cin);
        patient.setEtat("En Attente");
        rep.saveAndFlush(patient);
    }
    public void delPatient(String cin) {
        this.rep.deleteById(cin);
    }

}
