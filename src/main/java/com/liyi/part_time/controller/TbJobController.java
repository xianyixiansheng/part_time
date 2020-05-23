package com.liyi.part_time.controller;

import com.alibaba.fastjson.JSONObject;
import com.liyi.part_time.entity.TbBusiness;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.service.TbJobService;
import com.liyi.part_time.util.BaseController;
import com.liyi.part_time.util.LayuiPage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbJob)表控制层
 *
 * @author makejava
 * @since 2020-03-24 00:28:06
 */
@RestController
@RequestMapping("tbJob")
public class TbJobController extends BaseController<TbJob>{
    /**
     * 服务对象
     */
    @Resource
    private TbJobService tbJobService;


    @RequestMapping("getLayuiPage")
    @ResponseBody
    public LayuiPage<TbJob> getPage(Integer page, Integer limit, String searchParams)throws Exception{
        TbJob tbjob = JSONObject.parseObject(searchParams, TbJob.class);
        LayuiPage<TbJob> layPage = tbJobService.getPage(page, limit, tbjob);
        return layPage;
    }

    @RequestMapping("getLayuiPageWithTime")
    @ResponseBody
    public LayuiPage<TbJob> getPageWithTime(Integer page, Integer limit, String searchParams)throws Exception{
        LayuiPage<TbJob> layPage = tbJobService.getPageWithTime(page, limit, searchParams);
        return layPage;
    }

    @RequestMapping("getJobByBusinessId")
    @ResponseBody
    public List<TbJob> getJobByBusinessId(Integer id){
        List<TbJob> tbJob=tbJobService.getJobByBusinessId(id);
        return tbJob;
    }

    @RequestMapping("getJobById")
    @ResponseBody
    public List<TbJob> getJobById(Integer id){
        List<TbJob> tbJob=tbJobService.getJobById(id);
        return tbJob;
    }

    @RequestMapping("getPageWithFK")
    @ResponseBody
    public List<TbJob> getPageWithFK(String jobName){
        List<TbJob> tbJob=tbJobService.getPageWithFK(jobName);
        return tbJob;
    }

    @RequestMapping("getListwithDelivery")
    @ResponseBody
    public List<TbJob>  getListwithDelivery(Integer id, String jobName){
        List<TbJob> tbJob=tbJobService.getListwithDelivery(id,jobName);
        return tbJob;
    }

    @RequestMapping("getListwithCollection")
    @ResponseBody
    public List<TbJob>  getListwithCollection(Integer id){
        List<TbJob> tbJob=tbJobService.getListwithCollection(id);
        return tbJob;
    }

    @RequestMapping("queryJobWithDelivery")
    @ResponseBody
    public List<TbJob>  queryJobWithDelivery(Integer id, String jobName){
        List<TbJob> tbJob=tbJobService.queryJobWithDelivery(id,jobName);
        return tbJob;
    }

    @RequestMapping("queryJobWithInvite")
    @ResponseBody
    public List<TbJob>  queryJobWithInvite(Integer id, String jobName){
        List<TbJob> tbJob=tbJobService.queryJobWithInvite(id,jobName);
        return tbJob;
    }
    @RequestMapping("queryJobWithDeliveryandResume")
    @ResponseBody
    public List<TbJob>  queryJobWithDeliveryandResume(Integer jobId, Integer businessId){
        List<TbJob> tbJob=tbJobService.queryJobWithDeliveryandResume(jobId,businessId);
        return tbJob;
    }

    @RequestMapping("queryJobWithDeliveryandnotnull")
    @ResponseBody
    public List<TbJob>  queryJobWithDeliveryandnotnull(Integer businessId){
        List<TbJob> tbJob=tbJobService.queryJobWithDeliveryandnotnull(businessId);
        return tbJob;
    }

    @RequestMapping("queryJobWithDeliveryandjobnotnull")
    @ResponseBody
    public List<TbJob>  queryJobWithDeliveryandjobnotnull(Integer jobId, Integer businessId){
        List<TbJob> tbJob=tbJobService.queryJobWithDeliveryandjobnotnull(jobId,businessId);
        return tbJob;
    }

    @RequestMapping("getNum")
    @ResponseBody
    public Integer getNum(){
        return tbJobService.getNum();
    }
}