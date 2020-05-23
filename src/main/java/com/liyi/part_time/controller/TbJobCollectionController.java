package com.liyi.part_time.controller;

import com.liyi.part_time.entity.TbDelivery;
import com.liyi.part_time.entity.TbJobCollection;
import com.liyi.part_time.service.TbJobCollectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbJobCollection)表控制层
 *
 * @author makejava
 * @since 2020-03-24 00:28:05
 */
@RestController
@RequestMapping("tbJobCollection")
public class TbJobCollectionController {
    /**
     * 服务对象
     */
    @Resource
    private TbJobCollectionService tbJobCollectionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbJobCollection selectOne(Integer id) {
        return this.tbJobCollectionService.queryById(id);
    }


    @RequestMapping("saveJobCollection")
    @ResponseBody
    public TbJobCollection saveJobCollection(TbJobCollection tbJobCollection){
        //通过岗位id判断是否投递过当前岗位
        TbJobCollection d=tbJobCollectionService.queryByJobIdandResumeId(tbJobCollection.getJobId(),tbJobCollection.getResumeId());
        if (d == null)
            //没得话插入
        {
            tbJobCollectionService.insert(tbJobCollection);
        }

        else
        {
            //有的话更新
            if(tbJobCollection.getCstate()==1)
            {
                tbJobCollection.setCstate(0);
            }
            else {
                tbJobCollection.setCstate(1);
            }
            tbJobCollectionService.update(tbJobCollection);
        }
        return tbJobCollectionService.queryByJobIdandResumeId(tbJobCollection.getJobId(),tbJobCollection.getResumeId());
    }

    @RequestMapping("queryCollectionId")
    @ResponseBody
    public TbJobCollection queryCollectionId(TbJobCollection tbJobCollection){
        //通过岗位id判断是否投递过当前岗位
        return  tbJobCollectionService.queryByJobIdandResumeId(tbJobCollection.getJobId(),tbJobCollection.getResumeId());
    }
}