package com.example.GHTK.Method.AdminMethod;

import com.example.GHTK.Repository.Repository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminRightPut")
@RequestMapping(value = "admin/put")
public class Put {
    @PutMapping(value = "approve-all-order")
    public Object approvedAllOrder(){
        Repository repository = Repository.getRepository();
        return repository.approveAllOrder();
    }
}
