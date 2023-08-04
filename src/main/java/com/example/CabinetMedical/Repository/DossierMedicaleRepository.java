package com.example.CabinetMedical.Repository;

import com.example.CabinetMedical.Models.DossierMedicale;
import com.example.CabinetMedical.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierMedicaleRepository extends JpaRepository<DossierMedicale, Integer> {
    public DossierMedicale findDate_NaissanceByPatient(Patient patient);
    public DossierMedicale findByPatient(Patient patient);

}
