package com.example.GHTK.Method.AdminMethod;

import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Repository.Repository.AdminRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController("AdminRightPost")
@RequestMapping(value = "/admin/post")
@ResponseStatus(HttpStatus.CREATED)
public class Post {
    @PostMapping(value = "area")
    public Object post(@RequestBody Area area) throws SQLException {
        AdminRepository repository = AdminRepository.getRepository();
        return repository.insert(area);
    }
    @PostMapping(value = "service")
    public Object post(@RequestBody Service service) throws SQLException {
        AdminRepository repository = AdminRepository.getRepository();
        return repository.insert(service);
    }
    @PostMapping(value = "timeLine")
    public Object post(@RequestBody TimeLine timeLine) throws SQLException {
        AdminRepository repository = AdminRepository.getRepository();
        return repository.insert(timeLine);
    }
    @PostMapping(value = "type")
    public Object post(@RequestBody Type type) throws SQLException {
        AdminRepository repository = AdminRepository.getRepository();
        return repository.insert(type);
    }
}
