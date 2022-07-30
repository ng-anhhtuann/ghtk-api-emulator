package com.example.GHTK.Method.AdminRight;

import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "get")
public class Get {
    @GetMapping(value = "allcustomer")
    public Object getCustomer(){
        Repository repository = Repository.getRepository();
        return repository.queryCustomer();
    }
    @GetMapping(value = "customerbyid")
    public Object getCustomerById(@RequestBody String id){
        Repository repository = Repository.getRepository();
        return repository.queryCustomerById(id);
    }
    @GetMapping(value = "allarea")
    public Object getArea(){
        Repository repository = Repository.getRepository();
        return repository.queryArea();
    }
    @GetMapping(value = "areabyid")
    public Object getAreaById(@RequestBody String id){
        Repository repository = Repository.getRepository();
        return repository.queryAreaById(id);
    }
}
