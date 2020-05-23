package com.liyi.part_time.controller;
import com.alibaba.fastjson.JSONObject;
import com.liyi.part_time.Result.Result;
import com.liyi.part_time.Result.ResultFactory;
import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.service.TbAdminService;
import com.ndktools.javamd5.Mademd5;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("shortmessage")
public class ShortMessageController {

    @Resource
    private TbAdminService tbAdminService;
    /**
     * 获得sessionId
     */
    @RequestMapping("getSessionId")
    @ResponseBody
    public Object getSessionId(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            return session.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    发送短信验证码
//	 @param number接收手机号码
    @RequestMapping("sendSms")
    @ResponseBody
    public Object sendSms(HttpServletRequest  request, String phoneNum) {
        try {
            JSONObject json = null;
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);//生成6位验证码
            //发送短信
            ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com","105322", "bed94431-3e24-4c6d-a321-a9e6b0194951");
            Map<String, String> params = new HashMap<String, String>();
            System.out.println(verifyCode);
            params.put("message", "您的验证码为:" + verifyCode + "，该验证码有效期为5分钟，该验证码只能使用一次！");
            params.put("number", phoneNum);
            String result = client.send(params);
            System.out.print(result);
            json = JSONObject.parseObject(result);
            if(json.getIntValue("code") != 0)//发送短信失败
                return "fail";
            HttpSession session = request.getSession();//将验证码存到session中,同时存入创建时间
            json = new JSONObject();//以json存放，这里使用的是阿里的fastjson
            json.put("verifyCode", verifyCode);
            json.put("createTime", System.currentTimeMillis());
            request.getSession().setAttribute("verifyCode", json);  // 将认证码存入SESSION
            request.getSession().setAttribute("createTime", System.currentTimeMillis());
            return session.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//     微信端用户注册
    @RequestMapping("verifycode")
    @ResponseBody
    public Object verifycode(HttpServletRequest request,String phoneNum, String code) {
        JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
        if(!json.getString("verifyCode").equals(code)){
            return ResultFactory.buildFailResult("添加失败，验证码错误！");//验证码错误
        }
        if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
            return ResultFactory.buildFailResult("添加失败，验证码已过期！");//验证码过期
        }

        return ResultFactory.buildSuccessResult("登录成功", json);

    }



}
