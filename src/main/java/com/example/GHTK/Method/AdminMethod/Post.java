package com.example.GHTK.Method.AdminMethod;

import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Repository.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController("AdminRightPost")
@RequestMapping(value = "admin/post")
public class Post {
    @PostMapping(value = "area")
    public Object post(@RequestBody Area area) throws SQLException {
        Repository repository = Repository.getRepository();
        return repository.insert(area);
    }
    @PostMapping(value = "service")
    public Object post(@RequestBody Service service) throws SQLException {
        Repository repository = Repository.getRepository();
        return repository.insert(service);
    }
    @PostMapping(value = "timeLine")
    public Object post(@RequestBody TimeLine timeLine) throws SQLException {
        Repository repository = Repository.getRepository();
        return repository.insert(timeLine);
    }
    @PostMapping(value = "type")
    public Object post(@RequestBody Type type) throws SQLException {
        Repository repository = Repository.getRepository();
        return repository.insert(type);
    }
}
