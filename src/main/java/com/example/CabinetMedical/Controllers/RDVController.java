package com.example.CabinetMedical.Controllers;

import com.example.CabinetMedical.Models.Consultation;
import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Models.RDV;
import com.example.CabinetMedical.Services.PatientService;
import com.example.CabinetMedical.Services.RDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class RDVController {

    @Autowired
    RDVService ps;
    
    @Autowired
    PatientService pas;
    
    @PostMapping("/findPatientsByCab")
    @ResponseBody
    public int getRdvByCab(@RequestBody Medcin med){
        try {
            return ps.countByMedcin(med);

        } catch (Exception e) {
            return 0;
        }

    }
    @PostMapping("/addrdv")
    @ResponseBody
    public RDV addrdv(@RequestBody RDV rdv) {
    	
    
        return ps.save(rdv);
    }

    
    @DeleteMapping("/delRDV/{num}")
    @ResponseBody
    public String delRDVByNum(@PathVariable int num) {
System.out.println(num);
       
            ps.delRdv(num);

       return "supprimer avec succes";
    }

    @GetMapping("/listeRDV/{cabinet}")
    @ResponseBody
    public List<RDV> getAllRDV(@PathVariable String cabinet){
    	return ps.listesRDV(cabinet);
    }
     
    @GetMapping("/listeRDVByNum/{cin}")
    @ResponseBody
    public List<RDV> getAllRDVByNum(@PathVariable String cin){
    	return ps.getAllRDVBYCin(pas.getPatientByCin(cin));
    }
    
    
    @GetMapping("/listeRDVByNDate/{dateRDV}")
    @ResponseBody
    public List<RDV> getAllRDVByDate(@PathVariable CharSequence dateRDV){
    	return ps.getAllRDVBYdate(LocalDate.parse(dateRDV));
    }

}
