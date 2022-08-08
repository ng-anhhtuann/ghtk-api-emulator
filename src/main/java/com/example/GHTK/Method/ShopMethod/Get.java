package com.example.GHTK.Method.ShopMethod;

import com.example.GHTK.Repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ShopRightGet")
@RequestMapping(value = "shop/get")
public class Get {
    @GetMapping(value = "all-order/{id}")
    public Object getAllOrderOfCustomer(@PathVariable String id) {
        Repository repository = Repository.getRepository();
        return repository.queryAllOrderOfCustomer(id);
    }
}
