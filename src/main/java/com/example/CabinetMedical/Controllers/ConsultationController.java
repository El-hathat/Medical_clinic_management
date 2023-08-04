package com.example.CabinetMedical.Controllers;

import com.example.CabinetMedical.Models.Consultation;
import com.example.CabinetMedical.Models.Ordonnance;
import com.example.CabinetMedical.Models.Patient;
import com.example.CabinetMedical.Services.ConsultationService;
import com.example.CabinetMedical.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.ScatteringByteChannel;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ConsultationController {
    @Autowired
    ConsultationService ps;
    @Autowired
    PatientService pas;

    @PostMapping("/addconsultation/{cin}")
    @ResponseBody
    public Consultation addconsultation(@PathVariable String cin,@RequestBody Consultation cons) {
cons.setPatient(pas.getPatientByCin(cin));

        return ps.ajouterconsultation(cons);

    }

    
    
    
    @GetMapping("/gettotalByMedcin/{md}")
    @ResponseBody
    public double getConsultationbyPatient(@PathVariable String md){
        try {
            double r=0;
     
            List<Consultation> Consultations = ps.getConsultationbyPatient(md);
            for (Consultation bb:Consultations) {
                r=r+bb.getPrix();
               
            }

           // double totalSum = Consultations.stream().mapToDouble(Consultation::getPrix).sum();
            return r;

        } catch (Exception e) {
            return 0;
        }
        
         
       
 
    }  
    
    @GetMapping("/allConsult/{cin}")
    public List<Consultation> AllConsultation(@PathVariable String cin){
    	return ps.getAllConsultation(cin);
    }
    
    @GetMapping("/getByNum/{num}")
    public Optional<Consultation> getConsBynum(@PathVariable int num){
    	return ps.getByNum(num);
    }
    
    
    
    @GetMapping("/consultations/{dateStar}/{dateFin}/{cabinet}")
    @ResponseBody
    public List<Consultation> allConsultations(@PathVariable CharSequence dateStar,@PathVariable CharSequence dateFin ,@PathVariable String cabinet){
       
    	return ps.GetAllBetwenDate(LocalDate.parse(dateStar),LocalDate.parse(dateFin),cabinet);
    }
    
    
    
    @DeleteMapping("/deleteConsultation/{num}")
    public String deleteconsult(@PathVariable int num) {
    	
    	ps.deleteConsult(num);
      
    	return "supprimer avec succes";
    } 
    
    
    @GetMapping("/caisse/{cabinet}")
    @ResponseBody
    public List<Integer> allConsultations(@PathVariable String cabinet){
      
    	return ps.getCaisseParMois(cabinet);
    }
    
}
