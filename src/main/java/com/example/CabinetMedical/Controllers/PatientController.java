package com.example.CabinetMedical.Controllers;

import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Models.Patient;
import com.example.CabinetMedical.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
    PatientService ps;

    @PostMapping("/addPatient")
    @ResponseBody
    public Patient addPatient(@RequestBody Patient patient) {
    	System.out.println(patient);
        return ps.ajouterPatient(patient);

    }

    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> getAllPatients() {
        return ps.getPatients();

    }
    @GetMapping("/getPatientByCin/{cin}")
    @ResponseBody
    public Patient getPatientByCin(@PathVariable  String cin){
        return ps.getPatientByCin(cin);

    }

    @GetMapping("/PatientsByCabinet/{md}")
    @ResponseBody
    public List<Patient> getPatientByMedcin(@PathVariable String md){
        return ps.findPatientsByCabinet(md);

    }

    @GetMapping("/findPatientsByMedcin/{md}")
    @ResponseBody
    public int getPatientByCab(@PathVariable String md){
        try {
            return ps.countByCabinet(md);

        } catch (Exception e) {
            return 0;
        }

    }
    @GetMapping("/getAllByCinSearch/{cin}")
    public List<Patient> getAllByCinSearch(@PathVariable String cin){
        System.out.println(cin);
        return ps.getPatientsSeaech(cin);


    }

    @PutMapping  ("/setpatient/{cin}")
    @ResponseBody
    public void setpat(@PathVariable String cin,@RequestBody Patient pat) {

        try {
            ps.setpat(cin,pat);

        } catch (Exception e) {
            // TODO: handle exception
        }}
    // validerPatient
    @PutMapping("/validerPatient/{cin}")
    @ResponseBody
    public void patientValider(@PathVariable String cin) {

        try {
            ps.validerPatient(cin);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @GetMapping("/getAllByNomSearch/{nom}")
    public List<Patient> getAllByNomSearch(@PathVariable String nom){
        System.out.println(nom);
        return ps.getPatientsSeaechNom(nom);


    }

    @PutMapping("/setEtatPatient/{cin}")
    @ResponseBody
    public void setEtatPatient(@PathVariable String cin) {

        try {
            ps.setEtatPatient(cin);

        } catch (Exception e) {
            // TODO: handle exception
        }}

    @DeleteMapping("/delPatient/{cin}")
    @ResponseBody
    public void delPatientByCin(@PathVariable String cin) {

        try {
            ps.delPatient(cin);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
