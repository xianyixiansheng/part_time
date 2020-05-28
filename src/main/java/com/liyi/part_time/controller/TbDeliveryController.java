package com.liyi.part_time.controller;

import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.entity.TbDelivery;
import com.liyi.part_time.entity.TbResume;
import com.liyi.part_time.service.TbDeliveryService;
import com.liyi.part_time.util.BaseController;
import com.liyi.part_time.vo.DeliveryVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbDelivery)表控制层
 *
 * @author makejava
 * @since 2020-03-24 00:28:07
 */
@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("tbDelivery")
public class TbDeliveryController extends BaseController<TbDelivery> {
    /**
     * 服务对象
     */
    @Resource
    private TbDeliveryService tbDeliveryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbDelivery selectOne(Integer id) {
        return this.tbDeliveryService.queryById(id);
    }


    @RequestMapping("saveDelivery")
    @ResponseBody
    public TbDelivery saveDelivery(TbDelivery tbDelivery){
        //通过岗位id判断是否投递过当前岗位
        TbDelivery d=tbDeliveryService.queryByJobIdandResumeId(tbDelivery.getJobId(),tbDelivery.getResumeId());
        if (d == null)
            //没得话插入
            tbDeliveryService.insert(tbDelivery);
        else
        {
            //有的话更新
            tbDeliveryService.update(tbDelivery);
        }
        return tbDeliveryService.queryByJobIdandResumeId(tbDelivery.getJobId(),tbDelivery.getResumeId());
    }

    @RequestMapping("querByDelId")
    @ResponseBody
    public TbDelivery querByDelId(TbDelivery tbDelivery){
        //通过岗位id判断是否投递过当前岗位
        return  tbDeliveryService.queryByJobIdandResumeId(tbDelivery.getJobId(),tbDelivery.getResumeId());
    }

    @RequestMapping("queryByJobIdwithResumeId")
    @ResponseBody
    public TbDelivery queryByJobIdwithResumeId(Integer jobId,Integer resumeId){
        //通过岗位id判断是否投递过当前岗位
        return  tbDeliveryService.queryByJobIdwithResumeId(jobId,resumeId);
    }

    @RequestMapping("queryAllwithResumeId")
    @ResponseBody
    public List<TbDelivery> queryAllwithResumeId(Integer resumeId){
        //通过岗位id判断是否投递过当前岗位
        return  tbDeliveryService.queryAllwithResumeId(resumeId);
    }

    @RequestMapping("queryAllwithResumeIdandOverTime")
    @ResponseBody
    public List<TbDelivery> queryAllwithResumeIdandOverTime(Integer resumeId){
        //通过岗位id判断是否投递过当前岗位
        return  tbDeliveryService.queryAllwithResumeIdandOverTime(resumeId);
    }

    @RequestMapping("queryAllwithResumeIdandCancel")
    @ResponseBody
    public List<TbDelivery> queryAllwithResumeIdandCancel(Integer resumeId){
        //通过岗位id判断是否投递过当前岗位
        return  tbDeliveryService.queryAllwithResumeIdandCancel(resumeId);
    }

    @PostMapping("updateStatewithDelivery")
    @ResponseBody
    public TbDelivery updateStatewithDelivery(TbDelivery tbDelivery) {
        return this.tbDeliveryService.updateStatewithDelivery(tbDelivery);
    }

    @GetMapping("queryforEnd")
    @ResponseBody
    public DeliveryVO queryforEnd(Integer id) {
        return this.tbDeliveryService.queryforEnd(id);
    }
}