package com.baizhi.cmfz.serviceimpl;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.mapper.AdminMapper;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public void login(String name, String password) {
        Admin admin = adminMapper.selectOne(new Admin(null,name,null));
        if(admin==null) throw new RuntimeException("用户不存在！");
        if(!admin.getPassword().equals(password)) throw new RuntimeException("密码不正确！");
    }

}
