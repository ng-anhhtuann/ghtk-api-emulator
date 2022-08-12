package com.example.GHTK.Method.AdminMethod;

import com.example.GHTK.Repository.Repository;
import org.springframework.web.bind.annotation.*;

import static com.example.GHTK.Repository.Repository.getRepository;

@RestController("AdminRightGet")
@RequestMapping(value = "admin/get")
public class Get {
    @GetMapping(value = "all-customer")
    public Object getCustomer() {
        Repository repository = getRepository();
        return repository.queryCustomer();
    }

    @GetMapping(value = "customer-by-id")
    public Object getCustomerById(@RequestBody String id) {
        Repository repository = getRepository();
        return repository.queryCustomerById(id);
    }

    @GetMapping(value = "all-shipper")
    public Object getShipper() {
        Repository repository = getRepository();
        return repository.queryShipper();
    }

    @GetMapping(value = "shipper-by-id")
    public Object getShipperById(@RequestBody String id) {
        Repository repository = getRepository();
        return repository.queryShipperById(id);
    }

    @GetMapping(value = "all-order")
    public Object getOrder() {
        Repository repository = getRepository();
        return repository.queryOrder();
    }

    @GetMapping(value = "order-by-id")
    public Object getOrderById(@RequestBody String id) {
        Repository repository = getRepository();
        return repository.queryOrderByIdOrder(id);
    }

    @GetMapping(value = "all-order-not-approve")
    public Object queryAllOrderNotApproved() {
        Repository repository = getRepository();
        return repository.queryAllOrderNotApproved();
    }
    @GetMapping(value = "all-order-approve")
    public Object queryAllOrderApproved() {
        Repository repository = getRepository();
        return repository.queryAllOrderApproved();
    }

    @GetMapping(value = "all-order-same-shop")
    public Object queryAllOrderByIdCustomer(@RequestBody String id) {
        Repository repository = getRepository();
        return repository.queryAllOrderByIdCustomer(id);
    }

    @GetMapping(value = "all-order-same-shipper")
    public Object queryAllOrderByIdShipper(@RequestBody String id) {
        Repository repository = getRepository();
        return repository.queryAllOrderByIdShipper(id);
    }

    @GetMapping(value = "all-area")
    public Object getArea() {
        Repository repository = getRepository();
        return repository.queryArea();
    }

    @GetMapping(value = "area-by-id")
    public Object getAreaById(@RequestBody String id) {
        Repository repository = getRepository();
        return repository.queryAreaById(id);
    }

    @GetMapping(value = "all-time")
    public Object getTime() {
        Repository repository = getRepository();
        return repository.queryTime();
    }

    @GetMapping(value = "time-by-id")
    public Object getTimeById(@RequestBody String id) {
        Repository repository = getRepository();
        return repository.queryTimeById(id);
    }

    @GetMapping(value = "all-service")
    public Object getService() {
        Repository repository = getRepository();
        return repository.queryService();
    }

    @GetMapping(value = "service-by-id")
    public Object getServiceById(@RequestBody String id) {
        Repository repository = getRepository();
        return repository.queryServiceById(id);
    }

    @GetMapping(value = "all-type")
    public Object getType() {
        Repository repository = getRepository();
        return repository.queryType();
    }

    @GetMapping(value = "type-by-id")
    public Object getTypeById(@RequestBody String id) {
        Repository repository = getRepository();
        return repository.queryTypeById(id);
    }
}
