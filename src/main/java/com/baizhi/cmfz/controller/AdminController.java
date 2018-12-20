package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.conf.ValidateImageCodeUtils;
import com.baizhi.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("login")
    public String login(HttpSession session,String name,String password,String enCode){
        try{
            adminService.login(name,password);
            session.setAttribute("name",name);
            String code = (String)session.getAttribute("code");
            if(enCode.equals(code)){
                return "redirect:/menu/show";
            }else{
                return "redirect:/login.jsp";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/login.jsp";
        }
    }
    @RequestMapping("code")
    public void createValidCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String code = ValidateImageCodeUtils.getSecurityCode();
        session.setAttribute("code",code);
        BufferedImage image = ValidateImageCodeUtils.createImage(code);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image,"png",outputStream);
        outputStream.close();
    }
}
