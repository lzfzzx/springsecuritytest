package com.example.springsecuritytest.entity;

import lombok.Data;

/**
 * Created by Lzf on 2020/5/9.
 */
//定义一个查询条件的类
@Data
public class UserQueryCondition {
    private String username;
    private int age;
    private int ageTo;
    private String xxx;
}
