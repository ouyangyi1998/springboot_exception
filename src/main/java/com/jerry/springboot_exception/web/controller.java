package com.jerry.springboot_exception.web;

import com.jerry.springboot_exception.enums.CommonEnum;
import com.jerry.springboot_exception.exception.BizException;
import com.jerry.springboot_exception.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class controller {
    @PostMapping("/user")
    public boolean insert(@RequestBody User user)
    {
        if(user.getName()==null)
        {
            throw new BizException("-1","用户名不能为空");
        }
        return true;
    }
    @PutMapping("/user")
    public boolean update(@RequestBody User user)
    {

        String str=null;
        str.equals("111");
        return true;
    }
    @DeleteMapping("/user")
    public boolean delete(@RequestBody User user)
    {
        System.out.println(CommonEnum.BODY_NOT_MATCH.getResultMsg());
        Integer.parseInt("abc123");
        return true;
    }
    @GetMapping("/user")
    public List<User> findByUser(User user)
    {
        List<User> userList=new ArrayList<>();
        User user1=new User();
        user1.setAge(18);
        user1.setName("jerry");
        user1.setId(1L);
        userList.add(user1);
        return userList;
    }


}
