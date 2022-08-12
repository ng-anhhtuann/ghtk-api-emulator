package com.example.GHTK.Method.ShopMethod;

import com.example.GHTK.Repository.Repository;
import org.springframework.web.bind.annotation.*;

@RestController("ShopRightGet")
@RequestMapping(value = "{id}/get")
public class Get {
    @GetMapping(value = "all-order")
    public Object getAllOrderOfCustomer(@PathVariable String id) {
        Repository repository = Repository.getRepository();
        return repository.queryAllOrderByIdCustomer(id);
    }
}
