package com.example.CabinetMedical.Security;



import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.CabinetMedical.Models.Medcin;
import com.example.CabinetMedical.Services.MedcinService;

/**
 * @author Khalid Elshafie <abolkog@gmail.com>
 * @Created 08/10/2018 9:41 PM.
 */
@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    private MedcinService medcinService;

    @Override
    public void run(String... strings) throws Exception {



            Medcin user = new Medcin("hat", "hathatmed", "hathatmed","hathatmed","hathatmed","hathatmed","medcin",true);
            medcinService.save(user);
            Medcin user1 = new Medcin("sam", "hathatmed","hathatmed","alasahbi","hathatmed","hathatmed","medcin",true);
            medcinService.save(user1);
            Medcin user2 = new Medcin("sim", "hathatmed", "hathatmed","alilo","hathatmed","hathatmed","medcin",true);
            medcinService.save(user2);

    }
}
