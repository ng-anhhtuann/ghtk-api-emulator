package com.example.GHTK.Method.AdminMethod;

import com.example.GHTK.Repository.Repository.AdminRepository;
import org.springframework.web.bind.annotation.*;

import static com.example.GHTK.Repository.Repository.AdminRepository.getRepository;

@RestController("AdminRightGet")
@RequestMapping(value = "admin/get")
public class Get {
    @GetMapping(value = "all-customer")
    public Object getCustomer() {
        AdminRepository repository = getRepository();
        return repository.queryCustomer();
    }

    @GetMapping(value = "customer-by-id")
    public Object getCustomerById(@RequestParam String id) {
        AdminRepository repository = getRepository();
        return repository.queryCustomerById(id);
    }

    @GetMapping(value = "all-shipper")
    public Object getShipper() {
        AdminRepository repository = getRepository();
        return repository.queryShipper();
    }

    @GetMapping(value = "shipper-by-id")
    public Object getShipperById(@RequestParam String id) {
        AdminRepository repository = getRepository();
        return repository.queryShipperById(id);
    }

    @GetMapping(value = "all-order")
    public Object getOrder() {
        AdminRepository repository = getRepository();
        return repository.queryOrder();
    }

    @GetMapping(value = "order-by-id")
    public Object getOrderById(@RequestParam String id) {
        AdminRepository repository = getRepository();
        return repository.queryOrderByIdOrder(id);
    }

    @GetMapping(value = "all-order-not-approved")
    public Object queryAllOrderNotApproved() {
        AdminRepository repository = getRepository();
        return repository.queryAllOrderNotApproved();
    }
    @GetMapping(value = "all-order-approved")
    public Object queryAllOrderApproved() {
        AdminRepository repository = getRepository();
        return repository.queryAllOrderApproved();
    }

    @GetMapping(value = "all-order-same-shop")
    public Object queryAllOrderByIdCustomer(@RequestParam String id) {
        AdminRepository repository = getRepository();
        return repository.queryAllOrderByIdCustomer(id);
    }

    @GetMapping(value = "all-order-same-shipper")
    public Object queryAllOrderByIdShipper(@RequestParam String id) {
        AdminRepository repository = getRepository();
        return repository.queryAllOrderByIdShipper(id);
    }

    @GetMapping(value = "all-area")
    public Object getArea() {
        AdminRepository repository = getRepository();
        return repository.queryArea();
    }

    @GetMapping(value = "area-by-id")
    public Object getAreaById(@RequestParam String id) {
        AdminRepository repository = getRepository();
        return repository.queryAreaById(id);
    }

    @GetMapping(value = "all-time")
    public Object getTime() {
        AdminRepository repository = getRepository();
        return repository.queryTime();
    }

    @GetMapping(value = "time-by-id")
    public Object getTimeById(@RequestBody String id) {
        AdminRepository repository = getRepository();
        return repository.queryTimeById(id);
    }

    @GetMapping(value = "all-service")
    public Object getService() {
        AdminRepository repository = getRepository();
        return repository.queryService();
    }

    @GetMapping(value = "service-by-id")
    public Object getServiceById(@RequestParam String id) {
        AdminRepository repository = getRepository();
        return repository.queryServiceById(id);
    }

    @GetMapping(value = "all-type")
    public Object getType() {
        AdminRepository repository = getRepository();
        return repository.queryType();
    }

    @GetMapping(value = "type-by-id")
    public Object getTypeById(@RequestParam String id) {
        AdminRepository repository = getRepository();
        return repository.queryTypeById(id);
    }
}
