package com.example.GHTK.Method.ShopMethod;

import com.example.GHTK.Repository.Repository.ShopRepository;
import org.springframework.web.bind.annotation.*;

@RestController("ShopRightGet")
@RequestMapping(value = "/{id}/get")
public class Get {
    @GetMapping(value = "all-order-customer")
    public Object getAllOrderOfCustomer(@PathVariable String id) {
        ShopRepository repository = ShopRepository.getRepository();
        return repository.queryAllOrderByIdCustomer(id);
    }
}
