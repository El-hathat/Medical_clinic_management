package com.example.CabinetMedical.Controllers;

import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Models.Ordonnance;
import com.example.CabinetMedical.Models.Patient;
import com.example.CabinetMedical.Services.OrdonnanceService;
import com.example.CabinetMedical.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class OrdonnanceController {
    @Autowired
    OrdonnanceService ps;

    @PostMapping("/addordonnance")
    @ResponseBody
    public Ordonnance addordonnance(@RequestBody Ordonnance ord) {
        return ps.ajouterordonnance(ord);

    }
}
