package cn.enjoy.controller;

import cn.enjoy.vo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xujianhao
 * @version 1.0
 * @description: 用户控制层
 * @date 2021/8/26 22:25
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @RequestMapping("/get/{name}")
    @HystrixCommand
    public  Object get(@PathVariable("name")String name) {
        User users = new User();
        users.setName(name);
        users.setAge(18);
        users.setSex("F");
        return users;
    }
}
