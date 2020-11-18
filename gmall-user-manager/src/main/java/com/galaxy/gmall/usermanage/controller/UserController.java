package com.galaxy.gmall.usermanage.controller;

import com.galaxy.gmall.usermanage.bean.UserInfo;
import com.galaxy.gmall.usermanage.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class UserController {
    @Autowired
    private IUserInfoService userInfoService;
    @RequestMapping("findAll")
    @ResponseBody
    public List<UserInfo> findAll(){
        return userInfoService.getUserInfoListAll();
    }

    @RequestMapping("add")
    @ResponseBody
    public void add(){
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("test@qq.com");
        userInfo.setLoginName("test");
        userInfo.setName("testQQ");
        userInfo.setPasswd("test");
        userInfoService.addUser(userInfo);
    }

    @RequestMapping("upd")
    @ResponseBody
    public void upd(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId("4");
        userInfo.setNickName("testAdmin-test");
        userInfoService.updateUser(userInfo);
    }

    @RequestMapping("upd1")
    @ResponseBody
    public void upd1(String name){
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName("testAdmin-test");
        userInfoService.updateUserByName(name,userInfo);
    }

    @RequestMapping("del")
    @ResponseBody
    public void del(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId("4");
        userInfoService.delUser(userInfo);
    }

}
