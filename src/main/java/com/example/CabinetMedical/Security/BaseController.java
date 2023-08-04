package com.example.CabinetMedical.Security;


import com.example.CabinetMedical.Models.Medcin;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class BaseController {
public BaseController(){};
    public Medcin getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Medcin md= (Medcin) authentication.getPrincipal();
        return new Medcin(md.getCin(), md.getNom(), md.getPrenom(), md.getEmail(), md.getPassword(),md.getNom_cabinet(), md.getRole(),md.getEtat());
    }
}
