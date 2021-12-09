package com.enterprise;

import com.enterprise.entities.enterprise.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnterpriseAppliation {
    public static void main(String[] args) {
        User user1 = new User(1L,true,"clauger","123456");
        SpringApplication.run(EnterpriseAppliation.class, args);

//        User user1 = new User(1L,false,"Jhon");
//        Api api1 = new Api(1l,"/path","get",new Description(1l,"1","sumary","description"),
//                new Parameters(1l,"name","description in","Description parameter","require","type"),new Tag(1l,"tag"),new Ref(1l,"reference"));
//        Workspace trampo = new Workspace(1l,"trampo 1",user1,api1);
//        Enterprise empresa = new Enterprise(1l,"empresa",trampo);
//        System.out.println(empresa);



    }
}
