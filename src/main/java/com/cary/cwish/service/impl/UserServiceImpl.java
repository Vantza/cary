package com.cary.cwish.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cary.cwish.dao.IUserDao;
import com.cary.cwish.pojo.User;
import com.cary.cwish.service.IUserService;

@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDao userDao;  
    public User getUserById(int userId) throws Exception {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }  
  
} 
