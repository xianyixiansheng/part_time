package com.liyi.part_time.controller;

import com.alibaba.fastjson.JSONObject;
import com.liyi.part_time.constants.Constant;
import com.liyi.part_time.entity.TbBusiness;
import com.liyi.part_time.entity.TbJobHunter;
import com.liyi.part_time.service.TbBusinessService;
import com.liyi.part_time.util.BaseController;
import com.liyi.part_time.util.HttpRequestUtil;
import com.liyi.part_time.util.LayuiPage;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * (TbBusiness)表控制层
 *
 * @author makejava
 * @since 2020-03-24 00:28:06
 */
@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("tbBusiness")
public class TbBusinessController extends  BaseController<TbBusiness>{
    /**
     * 服务对象
     */
    @Resource
    private TbBusinessService tbBusinessService;

    @Resource
    private HttpRequestUtil httpRequestUtil;

    @GetMapping("selectOne")
    public TbBusiness selectOne(Integer id) {
        return this.tbBusinessService.queryById(id);
    }

    @PostMapping("deletewithFk")
    @ResponseBody
    public boolean deletewithFk(Integer id) {return this.tbBusinessService.deleteByIdwithFK(id);}

    @RequestMapping("batchDeletewithFK")
    @ResponseBody
    public boolean batchDeletewithFK(Integer[] ids){
        if (ids == null|| ids.length == 0)
            return false;
        List<Integer> List = Arrays.asList(ids);
        boolean flag = tbBusinessService.deleteByListwithFK(List);
        return flag;
    }

    @RequestMapping("getLayuiPage")
    @ResponseBody
    public LayuiPage<TbBusiness> getPage(Integer page, Integer limit, String searchParams)throws Exception{
        TbBusiness tbBusiness = JSONObject.parseObject(searchParams, TbBusiness.class);
        LayuiPage<TbBusiness> layPage = tbBusinessService.getPage(page, limit, tbBusiness);
        return layPage;
    }

    @RequestMapping("getLayuiPageWithAudit")
    @ResponseBody
    public LayuiPage<TbBusiness> getPageWithAudit(Integer page, Integer limit, String searchParams)throws Exception{
        TbBusiness tbBusiness = JSONObject.parseObject(searchParams, TbBusiness.class);
        LayuiPage<TbBusiness> layPage = tbBusinessService.getPageWithAudit(page, limit, tbBusiness);
        return layPage;
    }

    @RequestMapping("getDetail")
    @ResponseBody
    public List<TbBusiness>  getDetail(Integer id){
        List<TbBusiness> tbusiness=tbBusinessService.getDetail(id);
        return tbusiness;
    }


    @RequestMapping("update")
    @ResponseBody
    public TbBusiness update(TbBusiness tbBusiness) {
        TbBusiness tbBusines=this.tbBusinessService.update(tbBusiness);
        return tbBusines;
    }

    @RequestMapping("login")
    public TbBusiness login(String code, HttpSession session){
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
            TbBusiness tbbusiness = tbBusinessService.queryByWxCode(openid);
            if (tbbusiness == null){
                //添加新用户
                tbbusiness = new TbBusiness();
                tbbusiness.setBusinessWxcode(openid);
                tbBusinessService.insert(tbbusiness);
            }
            session.setAttribute(Constant.BUSINESS, tbbusiness);
            return tbbusiness;
        }
        return null;
    }

    @RequestMapping("exitCompanyInfo")
    @ResponseBody
    public boolean exitCompanyInfo(TbBusiness tbBusiness){
        if (this.tbBusinessService.queryById(tbBusiness.getBusinessId()).getEmail()!=null)
            return  true;
        return false;
    }

    @RequestMapping("setWxInfo")
    @ResponseBody
    public boolean setWxInfo(TbBusiness tbBusiness){
        if (tbBusiness == null || tbBusiness.getBusinessWxName() == null||tbBusiness.getBusinessImg()==null)
            return false;
        boolean flag = tbBusinessService.setWxInfo(tbBusiness);

        return flag;
    }

    @RequestMapping("getNum")
    @ResponseBody
    public Integer getNum(){
        return tbBusinessService.getNum();
    }

}