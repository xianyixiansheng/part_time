package com.liyi.part_time.controller;

import com.alibaba.fastjson.JSONObject;
import com.liyi.part_time.constants.Constant;
import com.liyi.part_time.entity.TbJobHunter;
import com.liyi.part_time.service.TbJobHunterService;
import com.liyi.part_time.util.*;
import com.liyi.part_time.vo.FeedBackVO;
import com.liyi.part_time.vo.JobHunterVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * (TbJobHunter)表控制层
 *
 * @author makejava
 * @since 2020-03-24 00:28:09
 */
@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("tbJobHunter")
public class TbJobHunterController extends BaseController<TbJobHunter>{
    /**
     * 服务对象
     */
    @Resource
    private TbJobHunterService tbJobHunterService;

    @Resource
    private HttpRequestUtil httpRequestUtil;

//    @GetMapping("selectOne")
//    public TbJobHunter selectOne(Integer id) {
//        return this.tbJobHunterService.queryById(id);
//    }


    @RequestMapping("login")
    public TbJobHunter login(String code, HttpSession session){
        //访问微信接口，获取openid
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String params = "appid="+ Constant.APPID+"&secret=" + Constant.SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String result = httpRequestUtil.sendGet(url, params);
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject);
        String openid = jsonObject.getString("openid");

        //判断该用户是否是新用户
        if (openid!=null){
            TbJobHunter tojobhunter = tbJobHunterService.queryByWxCode(openid);
            if (tojobhunter == null){
                //添加新用户
                tojobhunter = new TbJobHunter();
                tojobhunter.setWxCode(openid);
                tbJobHunterService.insert(tojobhunter);
            }
            session.setAttribute(Constant.CUSTOMER, tojobhunter);
            return tojobhunter;
        }
        return null;
    }

    @RequestMapping("setWxName")
    @ResponseBody
    public boolean setWxName(TbJobHunter tojobhunter){
        if (tojobhunter == null || tojobhunter.getWxName() == null)
            return false;
        boolean flag = tbJobHunterService.setWxName(tojobhunter);
        return flag;
    }

    @RequestMapping("setWxInfo")
    @ResponseBody
    public boolean setWxInfo(TbJobHunter tojobhunter){
        if (tojobhunter == null || tojobhunter.getWxName() == null||tojobhunter.getImg()==null||tojobhunter.getSex()==null||tojobhunter.getCreateTime()==null)
            return false;
        boolean flag = tbJobHunterService.setWxInfo(tojobhunter);
        return flag;
    }

    @RequestMapping("setPhone")
    @ResponseBody
    public boolean setPhone(TbJobHunter tojobhunter){
        if (tojobhunter == null || tojobhunter.getPhone() == null)
            return false;
        boolean flag = tbJobHunterService.setPhone(tojobhunter);
        return flag;
    }


    @RequestMapping("getLayuiPage")
    @ResponseBody
    public LayuiPage<TbJobHunter> getPage(Integer page, Integer limit, String searchParams)throws Exception{
        TbJobHunter tojobhunter= JSONObject.parseObject(searchParams, TbJobHunter.class);
        LayuiPage<TbJobHunter> layPage = tbJobHunterService.getPage(page, limit, tojobhunter);
        return layPage;
    }

    @RequestMapping("getLayuiPageWithTime")
    @ResponseBody
    public LayuiPage<JobHunterVO> getPageWithTime(Integer page, Integer limit, String searchParams)throws Exception{
        LayuiPage<JobHunterVO> layPage = tbJobHunterService.getPageWithTime(page, limit, searchParams);
        return layPage;
    }

    @RequestMapping("getNum")
    @ResponseBody
    public Integer getNum(){
        return tbJobHunterService.getNum();
    }

}