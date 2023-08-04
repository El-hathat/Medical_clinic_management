package com.example.CabinetMedical.Repository;


import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Models.Patient;
import com.example.CabinetMedical.Models.RDV;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDVRepository extends JpaRepository<RDV, Integer> {
    public List<RDV> findAllByMedcin(Medcin med);
    public List<RDV> findAllByPatient(Patient pt);
    public List<RDV> findAllByDateRDV(LocalDate date);
	


}
