package com.example.CabinetMedical.Controllers;



import java.util.List;
import java.util.Map;

import com.example.CabinetMedical.Security.BaseController;
import com.example.CabinetMedical.Security.SignInRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.CabinetMedical.Models.Medcin;

import com.example.CabinetMedical.Services.MedcinService;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MedcinController {
	@Autowired
	MedcinService serv;

	BaseController bs=new BaseController();

	@GetMapping("/medcins")
	@ResponseBody
	public List<Medcin> afficherTout(){
		return serv.getAllMedcin();	
	}


	@PostMapping("/currentUser")
	@ResponseBody
	public Medcin getCurrentUser(){

		return bs.getCurrentUser();
	}
	
	@GetMapping("/login/{email}/{pwd}")
	public boolean valider(@PathVariable("email") String email,@PathVariable("pwd") String pwd){
		//System.out.println(serv.tester(email,pwd));
		return serv.tester(email,pwd);	
	}
	
	@GetMapping("/getMed")
	@ResponseBody
	public Medcin  medcinEm() {

		return serv.getEmail(getCurrentUser().getEmail());

	}
	@DeleteMapping("/delMedecin/{cin}")
	@ResponseBody
	public void delMedcinByCin(@PathVariable String cin) {

		try {
			serv.delMedcin(cin);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@PutMapping("/setEtatMedecin/{cin}")
	@ResponseBody
	public void setEtatMedecin(@PathVariable String cin) {

		try {
			serv.setEtatMedcin(cin);

		} catch (Exception e) {
			// TODO: handle exception
		}}


	@PutMapping("/setmoduser/{cin}")
	@ResponseBody
	public void setmoduser(@PathVariable String cin,@RequestBody String nouveaupwd) {

		try {
			serv.setmoduser(cin,nouveaupwd);

		} catch (Exception e) {
			// TODO: handle exception
		}}

	@PutMapping  ("/setmedecin/{cin}")
	@ResponseBody
	public void setmed(@PathVariable String cin,@RequestBody Medcin med) {

		try {
			serv.setmed(cin,med);

		} catch (Exception e) {
			// TODO: handle exception
		}}



	@PostMapping("/registrer")
	@ResponseBody
	public Medcin addmedcin(@RequestBody Medcin med) {
		 System.out.println(med.toString());
		return serv.save(med);
	}

	@GetMapping("/chekpassword/{cin}/{pwd}")
	@ResponseBody
	public boolean checkPwd(@PathVariable String cin,@PathVariable String  pwd) {
		//String pwd=(String) req.get("pwd");
		System.out.println(pwd);
		return serv.checkPassword(cin,pwd);
	}

	
}
