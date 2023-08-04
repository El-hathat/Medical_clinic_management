package com.example.CabinetMedical.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CabinetMedical.Models.Medcin;


@Repository
public interface MedcinRepository extends JpaRepository<Medcin, String>{
	 Medcin findByEmail(String email);
	Medcin findByCin(String cin);
	 Medcin findByPwd(String pwd);
	 Medcin deleteByCin(String cin);
	
}
