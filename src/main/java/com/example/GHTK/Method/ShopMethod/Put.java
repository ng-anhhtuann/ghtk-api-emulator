package com.example.GHTK.Method.ShopMethod;

import com.example.GHTK.Repository.Repository;
import org.springframework.web.bind.annotation.*;

@RestController("ShopRightPut")
@RequestMapping(value = "shop/put")
public class Put {
    @PutMapping(value = "address/{id}")
    public Object updateAddress(@PathVariable String id, @RequestBody String newThing) {
        Repository repository = Repository.getRepository();
        return repository.updateAddress(id, newThing);
    }

    @PutMapping(value = "name-shop/{id}")
    public Object updateNameShop(@PathVariable String id, @RequestBody String newThing) {
        Repository repository = Repository.getRepository();
        return repository.updateNameShopCustomer(id, newThing);
    }

    @PutMapping(value = "name-customer/{id}")
    public Object updateNameCustomer(@PathVariable String id, @RequestBody String newThing) {
        Repository repository = Repository.getRepository();
        return repository.updateNameCustomer(id, newThing);
    }

    @PutMapping(value = "area/{id}")
    public Object updateArea(@PathVariable String id, @RequestBody String newThing) {
        Repository repository = Repository.getRepository();
        return repository.updateAreaCustomer(id, newThing);
    }

    @PutMapping(value = "number/{id}")
    public Object updateNumber(@PathVariable String id, @RequestBody String newThing) {
        Repository repository = Repository.getRepository();
        return repository.updateNumberCustomer(id, newThing);
    }

    @PutMapping(value = "mail/{id}")
    public Object updateMail(@PathVariable String id, @RequestBody String newThing) {
        Repository repository = Repository.getRepository();
        return repository.updateMailCustomer(id, newThing);
    }
}
