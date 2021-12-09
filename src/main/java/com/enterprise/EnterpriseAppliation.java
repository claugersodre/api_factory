package com.enterprise;

import com.enterprise.entities.enterprise.User;

import com.enterprise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@SpringBootApplication
public class EnterpriseAppliation {



    public static void main(String[] args) {




        SpringApplication.run(EnterpriseAppliation.class, args);

//        User user1 = new User(1L,false,"Jhon");
//        Api api1 = new Api(1l,"/path","get",new Description(1l,"1","sumary","description"),
//                new Parameters(1l,"name","description in","Description parameter","require","type"),new Tag(1l,"tag"),new Ref(1l,"reference"));
//        Workspace trampo = new Workspace(1l,"trampo 1",user1,api1);
//        Enterprise empresa = new Enterprise(1l,"empresa",trampo);
//        System.out.println(empresa);



    }


}
