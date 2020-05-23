package com.liyi.part_time.controller;

import com.alibaba.fastjson.JSONObject;
import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.service.TbAdminService;
import com.liyi.part_time.util.BaseController;
import com.liyi.part_time.util.LayuiPage;
import com.liyi.part_time.Result.*;
import com.ndktools.javamd5.Mademd5;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * (TbAdmin)表控制层
 *
 * @author makejava
 * @since 2020-03-24 00:25:57
 */
@Controller
@RequestMapping("tbAdmin")
public class TbAdminController extends BaseController<TbAdmin> {
    /**
     * 服务对象
     */
    @Resource
    private TbAdminService tbAdminService;

    @RequestMapping("queryByName")
    @ResponseBody
    public TbAdmin queryByName(String name){
        TbAdmin tbAdmin = tbAdminService.queryByName(name);
        return tbAdmin;
    }

    @RequestMapping("getLayuiPageWithTime")
    @ResponseBody
    public LayuiPage<TbAdmin> getPageWithTime(Integer page, Integer limit, String searchParams)throws Exception{
        LayuiPage<TbAdmin> layPage = tbAdminService.getPageWithTime(page, limit, searchParams);
        return layPage;
    }


    //    管理员注册
    //    发送短信验证码
    //	 @param number接收手机号码
    @RequestMapping("register")
    @ResponseBody
    public Result register(HttpServletRequest  request, String adminName, String adminPsw, String phone, String code, String adminSex,Integer state,String entry_time) {
        JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
        if(!json.getString("verifyCode").equals(code)){
            return ResultFactory.buildFailResult("添加失败，验证码错误！");
        }
        if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
            return  ResultFactory.buildFailResult("添加失败，验证码已过期！");
        }
        TbAdmin tbAdmin =  new TbAdmin();
        tbAdmin.setAdminName(adminName);
        Mademd5 md5 = new Mademd5();//new一个MD5对象
        String pswwithMD5andsalt = md5.toMd5(adminPsw+"Liyi123!@#");//调用方法进行加盐加密
        tbAdmin.setAdminPsw(pswwithMD5andsalt);
        tbAdmin.setPhone(phone);
        tbAdmin.setEntry_time(entry_time);
        tbAdmin.setAdminSex(adminSex);
        tbAdmin.setState(state);
        tbAdminService.insert(tbAdmin);
        return ResultFactory.buildSuccessResult("登录成功", tbAdmin);
    }


///  结合用户名、密码和验证码进行登录验证
    @RequestMapping("verificationWithResult")
    @ResponseBody
    public Result verificationWithResult(String username,String password,String captcha) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String lowerCasestr=session.getAttribute("validateCode").toString().toLowerCase();
        String upperCasestr=session.getAttribute("validateCode").toString().toUpperCase();
        System.out.println(lowerCasestr);
        TbAdmin tbAdmin = tbAdminService.queryByName(username);
        Mademd5 md5 = new Mademd5();//new一个MD5对象
        String pswwithMD5andsalt = md5.toMd5(password+"Liyi123!@#");//调用方法进行加盐加密
        if(!lowerCasestr.equals(captcha)&&!upperCasestr.equals(captcha)&&!session.getAttribute("validateCode").toString().equals(captcha))//说明验证码不匹配
        {
            return ResultFactory.buildFailResult("登录失败，验证码不存在");
        }
        else if(tbAdmin==null)
        {
            return ResultFactory.buildFailResult("登录失败，用户名不存在");
        }
        else if(!pswwithMD5andsalt.equals( tbAdmin.getAdminPsw()))
        {
            return ResultFactory.buildFailResult("登录失败，密码不存在");
        }
        else
        {
            session.setAttribute("user_name", username);
            session.setAttribute("user_sex", tbAdmin.getAdminSex());
            session.setAttribute("user_phone",tbAdmin.getPhone());
            session.setAttribute("user_Entrytime",tbAdmin.getEntry_time());
            session.setAttribute("states",tbAdmin.getState());
            System.out.println(tbAdmin.toString());
            return ResultFactory.buildSuccessResult("登录成功", tbAdmin);
        }
    }



    @RequestMapping("updatePsw")
    @ResponseBody
    public Result updatePsw(String old_password,String new_password)
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String username=session.getAttribute("user_name").toString();
        TbAdmin tbAdmin = tbAdminService.queryByName(username);
        Mademd5 md5 = new Mademd5();//new一个MD5对象
        String pswwithMD5andsalt = md5.toMd5(old_password+"Liyi123!@#");//调用方法进行加盐加密
        if(!pswwithMD5andsalt.equals(tbAdmin.getAdminPsw()))
        {
            return ResultFactory.buildFailResult("修改失败，旧密码错误！");
        }
        else
        {
            String newpswwithMD5andsalt = md5.toMd5(new_password+"Liyi123!@#");//调用方法进行加盐加密
            tbAdmin.setAdminPsw(newpswwithMD5andsalt);
            tbAdminService.update(tbAdmin);
            return ResultFactory.buildSuccessResult("修改成功", tbAdmin);
        }
    }


    @RequestMapping("updateInfo")
    @ResponseBody
    public Result updateInfo(String adminName,String adminSex,String adminphone,String entry_time)
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String name=session.getAttribute("user_name").toString();
        TbAdmin tbAdmin = tbAdminService.queryByName(name);
        tbAdmin.setAdminName(adminName);
        tbAdmin.setAdminSex(adminSex);
        tbAdmin.setPhone(adminphone);
        tbAdmin.setEntry_time(entry_time);
        if(tbAdminService.update(tbAdmin)!=null)
        {
            session.setAttribute("user_name", tbAdmin.getAdminName());
            session.setAttribute("user_sex", tbAdmin.getAdminSex());
            session.setAttribute("user_phone",tbAdmin.getPhone());
            session.setAttribute("user_Entrytime",tbAdmin.getEntry_time());
            return ResultFactory.buildSuccessResult("修改基本信息成功", tbAdmin);
        }
        else
        {
            return ResultFactory.buildFailResult("修改失败，旧密码错误！");
        }
    }
}