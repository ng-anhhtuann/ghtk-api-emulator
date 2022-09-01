package com.example.GHTK.Method.AdminMethod;

import com.example.GHTK.Repository.Repository.AdminRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminRightPut")
@RequestMapping(value = "/admin/put")
public class Put {
    @PutMapping(value = "approve-all-order")
    public Object approvedAllOrder(){
        AdminRepository repository = AdminRepository.getRepository();
        return repository.approveAllOrder();
    }
    @PutMapping(value = "approve-one-order/{id}")
    public Object approvedOneOrder(@PathVariable String id){
        AdminRepository repository = AdminRepository.getRepository();
        return repository.approveOneOrder(id);
    }
}
