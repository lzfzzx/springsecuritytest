package com.example.springsecuritytest.controller;

import com.example.springsecuritytest.entity.UserInfo;
import com.example.springsecuritytest.entity.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lzf on 2020/5/9.
 */
/*声明为RESTful风格*/
@RestController
@RequestMapping("/user")/*这里声明后下面就不需要/user前缀*/
public class UserController {
    /*RESTful风格的请求包含两参数，一个URL和一个method*/
//    @RequestMapping(value = "/user", method = RequestMethod.GET)  与下面的GetMapping等价
    @GetMapping()/*@RequestMapping的变体*/
    @JsonView(UserInfo.UserSimpleViews.class)
//    public List<UserInfo> query(@RequestParam(name = "username",required = false,defaultValue = "tom") String username  /*传过来的请求必须携带HTTP参数*/){
    public List<UserInfo> query(UserQueryCondition userQueryCondition, @PageableDefault(page = 2, size = 17, sort = "username"/*定义一个默认的分页*/) Pageable pageable) {/*spring会接收一个查询类*/
        List<UserInfo> userInfos = new ArrayList<>();
//        System.out.println(username);
        System.out.println(userQueryCondition);
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        userInfos.add(new UserInfo());
        userInfos.add(new UserInfo());
        userInfos.add(new UserInfo());
        return userInfos;
    }

    //    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    public UserInfo getInfo(@PathVariable String id) {/*该注解作用：将url的{id}参数作为值传到我的java方法里
//    ,url参数必须跟java方法参数名一致，否则要设置注解的name属性与URL的参数名一致*/
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("tom");
//        return userInfo;
//    }
//    如何针对传进来的参数写正则表达式去做限制
//@RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET) /*\\d+表达式说明我只能接收数字*/
    @GetMapping("/{id:\\d+}")
    @JsonView(UserInfo.UserDetailView.class)
    public UserInfo getInfo(@PathVariable String id) {/*该注解作用：将url的{id}参数作为值传到我的java方法里
    ,url参数必须跟java方法参数名一致，否则要设置注解的name属性与URL的参数名一致*/
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("tom");
        return userInfo;
    }
}
