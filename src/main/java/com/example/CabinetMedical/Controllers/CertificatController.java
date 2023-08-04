package com.example.CabinetMedical.Controllers;

import com.example.CabinetMedical.Models.Certificat;
import com.example.CabinetMedical.Models.Ordonnance;
import com.example.CabinetMedical.Services.CertificatService;
import com.example.CabinetMedical.Services.ConsultationService;
import com.example.CabinetMedical.Services.PatientService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CertificatController {

    @Autowired
    CertificatService ps;
    
    @Autowired
    ConsultationService pas;
    
    
    @PostMapping("/addcertificat/{num}")
    @ResponseBody
    public Certificat addcertificat(@PathVariable Integer num,@RequestBody Certificat crt) {
    	crt.setConsultation(pas.fetbynum(num));
    	crt.setDate_cer(LocalDate.now());
        return ps.ajoutercertificat(crt);

    }
}
