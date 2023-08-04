package com.example.CabinetMedical.Repository;

import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Models.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Integer> {
    Ordonnance findByNum(Integer num);
}
