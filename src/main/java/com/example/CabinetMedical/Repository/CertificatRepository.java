package com.example.CabinetMedical.Repository;

import com.example.CabinetMedical.Models.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatRepository extends JpaRepository<Certificat, Integer> {


}
