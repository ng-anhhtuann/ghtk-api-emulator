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
    @GetMapping(value = "allshipper")
    public Object getShipper(){
        Repository repository = Repository.getRepository();
        return repository.queryShipper();
    }
    @GetMapping(value = "shipperbyid")
    public Object getShipperById(@RequestBody String id){
        Repository repository = Repository.getRepository();
        return repository.queryShipperById(id);
    }
    @GetMapping(value = "allorder")
    public Object getOrder(){
        Repository repository = Repository.getRepository();
        return repository.queryOrder();
    }
    @GetMapping(value = "orderbyid")
    public Object getOrderById(@RequestBody String id){
        Repository repository = Repository.getRepository();
        return repository.queryOrderById(id);
    }
    @GetMapping(value = "allordernotapprove")
    public Object queryAllOrderNotApproved(){
        Repository repository = Repository.getRepository();
        return repository.queryAllOrderNotApproved();
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
    @GetMapping(value = "alltime")
    public Object getTime(){
        Repository repository = Repository.getRepository();
        return repository.queryTime();
    }
    @GetMapping(value = "areabyid")
    public Object getTimeById(@RequestBody String id){
        Repository repository = Repository.getRepository();
        return repository.queryTimeById(id);
    }@GetMapping(value = "allservice")
    public Object getService(){
        Repository repository = Repository.getRepository();
        return repository.queryService();
    }
    @GetMapping(value = "servicebyid")
    public Object getServiceById(@RequestBody String id){
        Repository repository = Repository.getRepository();
        return repository.queryServiceById(id);
    }@GetMapping(value = "alltype")
    public Object getType(){
        Repository repository = Repository.getRepository();
        return repository.queryType();
    }
    @GetMapping(value = "typebyid")
    public Object getTypeById(@RequestBody String id){
        Repository repository = Repository.getRepository();
        return repository.queryTypeById(id);
    }
}
