package com.d1.sptest.emity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

//lobok用法其一，对class——》变量的getset生成替代
@Data
@TableName(value = "sys_user")
public class User {
    @TableId
    private  Integer id;
    private  String username;
    @JsonIgnore
    private  String password;
    private  String nikename;
    private  String email;
    private  String phone;
    private  String address;


}
