package com.example.CabinetMedical.Services;

import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Models.Ordonnance;
import com.example.CabinetMedical.Models.Patient;
import com.example.CabinetMedical.Repository.OrdonnanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdonnanceService {

    @Autowired
    private OrdonnanceRepository rep;
    public Ordonnance ajouterordonnance(Ordonnance ord) {
        return rep.save(ord);
    }
}
