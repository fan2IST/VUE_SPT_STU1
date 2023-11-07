package com.d1.sptest.controller;

import com.d1.sptest.emity.User;
import com.d1.sptest.mapper.UserMapper;
import com.d1.sptest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;
    //新增or修改
    @PostMapping
    public Integer save(@RequestBody User user){

        //新增或者更新
         return userService.save(user);
    }
    //查询所有数据
    @GetMapping
    public List<User> index(){
        List<User> all = userMapper.findAll();

        return all;
    }
    //删除
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
       return userMapper.deleteById(id);
    }
    //分页查询接口 ?pageNum=1&pageSize=10
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String username){
        pageNum = (pageNum - 1) * pageSize;//真实页码从0开始
        username = "%" + username + "%";
        List<User> data = userMapper.selectPage(pageNum,pageSize,username);//压入列表
        Integer total = userMapper.selectTotal(username);
        Map<String, Object> res = new HashMap<>();//键值对存储
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
