package com.example.GHTK.Method.ShopMethod;

import com.example.GHTK.Model.UserRight.Order;
import com.example.GHTK.Repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController("ShopRightPost")
@RequestMapping(value = "{id}/post")
public class Post {
    @PostMapping(value = "post-order")
    public Object insertOrder(@RequestBody Order order, @PathVariable String id) throws SQLException {
        Repository repository = Repository.getRepository();
        return repository.createOrder(order);
    }
}
