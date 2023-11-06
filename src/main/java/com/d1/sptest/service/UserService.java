package com.d1.sptest.service;

import com.d1.sptest.emity.User;
import com.d1.sptest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper usermapper;
    public int save(User user){
        if(user.getId() == null){//user没有id,则表示为新增
            return usermapper.insert(user);

        }else {//否则为更新
            return usermapper.update(user);
        }
    }
}
