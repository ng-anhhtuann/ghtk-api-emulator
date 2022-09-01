package com.example.GHTK.Method.ShipperMethod;

import com.example.GHTK.Repository.Repository.ShipperRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ShipperRightPost")
@RequestMapping(value = "/{id}/get")
public class Get {
    @GetMapping(value = "all-available-order")
    public Object getAllOrderAvailable(@PathVariable String id) {
        ShipperRepository repository = ShipperRepository.getRepository();
        return repository.queryAllOrderAvailable();
    }

    @GetMapping(value = "all-order-registered")
    public Object getAllOrderRegistered(@PathVariable String id) {
        ShipperRepository repository = ShipperRepository.getRepository();
        return repository.queryAllOrderByIdShipper(id);
    }
}
