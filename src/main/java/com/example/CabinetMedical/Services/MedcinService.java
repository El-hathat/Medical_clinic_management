package com.example.CabinetMedical.Services;

import java.util.List;
import java.util.Optional;

import com.example.CabinetMedical.Models.Patient;
import com.example.CabinetMedical.Security.BaseController;
import com.example.CabinetMedical.Security.SignInRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Repository.MedcinRepository;



@Service
public class MedcinService implements UserDetailsService{

	@Autowired
	 MedcinRepository rep;
	PasswordEncoder pscode;
	/*public boolean checkPassword(String rawPassword, String cin) {
		System.out.println(rawPassword+ "  ___from service ____ "+rep.findByCin(cin));
		return pscode.matches(rawPassword, rep.findByCin(cin).getPwd());
	}*/



	public Medcin getEmail(String email) {
		return rep.findByEmail(email);

		
	}
	/*public MyUserDetails findByEmail(Medcin user2) throws Exception {
		Optional<Medcin> user = Optional.of(rep.findByEmail(user2));

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + user2));

		return user.map(MyUserDetails::new).get();
	}

	public Medcin addMedcin(Medcin user) {
		user.setPwd(getPasswordEncoder().encode(user.getPwd()));
		return rep.save(user);
	}
*/
	
	public List<Medcin> getAllMedcin(){
		
		return (List<Medcin>) rep.findAll();	
	}
	
	
	public Medcin getByEmail(String email) {
		return rep.findByEmail(email);
	}
	
	public boolean tester(String email, String pwd) {
		Medcin md=getByEmail(email);
		if(md==null){return false;};
		if(md.getPwd().equals(pwd)){

			return true;
		}else {
		return false;
		}
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Medcin user = rep.findByEmail(email);
		//System.out.println(user.toString());
        if (user == null) {
        	 System.out.println("medcin makaynx");
            throw new UsernameNotFoundException("User not found");
           
        }
        System.out.println("medcin kayn");
 return user;  
       // return new User("elhathat",passwordEncoder().encode("mohamed"), AuthorityUtils.NO_AUTHORITIES);
	}

	
	  @Bean
	    private PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	   

	    public Medcin save(Medcin med) {
	    	//System.out.println(med.toString());
	        med.setPwd(passwordEncoder().encode(med.getPwd()));
	        Medcin md=med;
	      //  System.out.println("from service");
	        return this.rep.save(md);
	       
	    }
	public void setEtatMedcin(String cin) {
		Medcin medcin=rep.findByCin(cin);
		medcin.setEtat(!medcin.getEtat());
		rep.saveAndFlush(medcin);
	}
	public void setmoduser(String cin,String pwd) {
		Medcin medcin=rep.findByCin(cin);
		medcin.setPwd(passwordEncoder().encode(pwd));
		rep.saveAndFlush(medcin);
	}

	public void setmed(String cin,Medcin med) {
		System.out.println(med.toString());
		Medcin medcin=rep.findByCin(cin);
		medcin.setNom(med.getNom());
		medcin.setPrenom(med.getPrenom());
		medcin.setEmail(med.getEmail());

		rep.saveAndFlush(medcin);
	}

	public void delMedcin(String cin) {
		this.rep.deleteById(cin);
	}

	    public List<Medcin> findAll() {
	        return rep.findAll();
	    }

	    public boolean checkPassword(String cin, String pwd) {
	    	System.out.println(pwd);
	        return passwordEncoder().matches(pwd, rep.findByCin(cin).getPwd());
	    }
	
}
