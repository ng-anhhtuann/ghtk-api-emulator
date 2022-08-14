package com.example.GHTK.Method.ShopMethod;

import com.example.GHTK.Repository.Repository.ShopRepository;
import org.springframework.web.bind.annotation.*;

@RestController("ShopRightPut")
@RequestMapping(value = "{id}/update")
public class Put {
    @PutMapping(value = "address-customer")
    public Object updateAddress(@PathVariable String id, @RequestBody String newThing) {
        ShopRepository repository = ShopRepository.getRepository();
        return repository.updateAddressCustomer(id, newThing);
    }

    @PutMapping(value = "name-shop")
    public Object updateNameShop(@PathVariable String id, @RequestBody String newThing) {
        ShopRepository repository = ShopRepository.getRepository();
        return repository.updateNameShopCustomer(id, newThing);
    }

    @PutMapping(value = "name-customer")
    public Object updateNameCustomer(@PathVariable String id, @RequestBody String newThing) {
        ShopRepository repository = ShopRepository.getRepository();
        return repository.updateNameCustomer(id, newThing);
    }

    @PutMapping(value = "area-customer")
    public Object updateArea(@PathVariable String id, @RequestBody String newThing) {
        ShopRepository repository = ShopRepository.getRepository();
        return repository.updateAreaCustomer(id, newThing);
    }

    @PutMapping(value = "number-customer")
    public Object updateNumber(@PathVariable String id, @RequestBody String newThing) {
        ShopRepository repository = ShopRepository.getRepository();
        return repository.updateNumberCustomer(id, newThing);
    }

    @PutMapping(value = "mail-customer")
    public Object updateMail(@PathVariable String id, @RequestBody String newThing) {
        ShopRepository repository = ShopRepository.getRepository();
        return repository.updateMailCustomer(id, newThing);
    }
}
