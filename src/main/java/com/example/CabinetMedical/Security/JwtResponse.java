package com.example.CabinetMedical.Security;


import com.example.CabinetMedical.Models.Medcin;

public class JwtResponse {

    Medcin med;
    private String token;

    public JwtResponse(Medcin med,String token) {
        this.med=med;
        this.token = token;
    }

    public Medcin getMed() {
        return med;
    }

    public void setMed(Medcin med) {
        this.med = med;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
