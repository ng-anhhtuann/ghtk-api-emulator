package com.example.GHTK.Method.ShopMethod;

import com.example.GHTK.Model.UserRight.Order;
import com.example.GHTK.Repository.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController("ShopRightPost")
@RequestMapping(value = "user/post")
public class Post {
    @PostMapping(value = "post-order")
    public Object insertOrder(@RequestBody Order order) throws SQLException {
        Repository repository = Repository.getRepository();
        return repository.createOrder(order);
    }
}
