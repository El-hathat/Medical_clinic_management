package com.example.CabinetMedical.Services;

import com.example.CabinetMedical.Models.Certificat;
import com.example.CabinetMedical.Models.Ordonnance;
import com.example.CabinetMedical.Repository.CertificatRepository;
import com.example.CabinetMedical.Repository.OrdonnanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificatService {
    @Autowired
    private CertificatRepository rep;


    public Certificat ajoutercertificat(Certificat crt) {
    	System.out.println(crt.toString());
        return rep.save(crt);
    }
    
}
