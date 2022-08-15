package com.example.GHTK.Method.ShipperMethod;

import com.example.GHTK.Repository.Repository.ShipperRepository;
import org.springframework.web.bind.annotation.*;

@RestController("ShipperRightPut")
@RequestMapping(value = "{id}/update")
public class Put {
    @PutMapping(value = "take-order")
    public Object getAllOrderAvailable(@PathVariable String id, @RequestBody String idOrder) {
        ShipperRepository repository = ShipperRepository.getRepository();
        return repository.registerOrder(idOrder,id);
    }
    @PutMapping(value = "name-shipper")
    public Object updateNameShipper(@PathVariable String id, @RequestBody String newThing) {
        ShipperRepository repository = ShipperRepository.getRepository();
        return repository.updateNameShipper(id, newThing);
    }

    @PutMapping(value = "address-shipper")
    public Object updateAddressShipper(@PathVariable String id, @RequestBody String newThing) {
        ShipperRepository repository = ShipperRepository.getRepository();
        return repository.updateAddressShipper(id, newThing);
    }

    @PutMapping(value = "number-shipper")
    public Object updateNumberShipper(@PathVariable String id, @RequestBody String newThing) {
        ShipperRepository repository = ShipperRepository.getRepository();
        return repository.updateNumberShipper(id, newThing);
    }

    @PutMapping(value = "mail-shipper")
    public Object updateMailShipper(@PathVariable String id, @RequestBody String newThing) {
        ShipperRepository repository = ShipperRepository.getRepository();
        return repository.updateMailShipper(id, newThing);
    }
}
