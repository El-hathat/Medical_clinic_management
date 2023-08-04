package com.example.CabinetMedical.Controllers;

import com.example.CabinetMedical.Models.DossierMedicale;
import com.example.CabinetMedical.Models.Ordonnance;
import com.example.CabinetMedical.Services.DossierMedicaleService;
import com.example.CabinetMedical.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class DossierMedicaleController {

    @Autowired
    DossierMedicaleService ps;
    @Autowired
    PatientService serv;


    @PostMapping("/addDossier")
    public DossierMedicale ajouterDossier(@RequestBody DossierMedicale dossier) {
        return ps.addDossier(dossier);

    }

    @GetMapping("/getDtnByCin/{cin}")
    @ResponseBody
    public LocalDate detDTN(@PathVariable String cin) {
        return ps.getDtnByCin(serv.getPatientByCin(cin)).getDate_Naissance();

    }
   @GetMapping("/NombrePatEnMois/{cabinet}")
    @ResponseBody
    public List<Integer> addordonnance(@PathVariable String cabinet) {
        return ps.getNombreDossiersParMois(cabinet);

    }
}
