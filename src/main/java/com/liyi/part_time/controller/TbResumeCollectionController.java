package com.liyi.part_time.controller;

import com.liyi.part_time.entity.TbResumeCollection;
import com.liyi.part_time.service.TbResumeCollectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbResumeCollection)表控制层
 *
 * @author makejava
 * @since 2020-03-24 00:28:08
 */
@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("tbResumeCollection")
public class TbResumeCollectionController {
    /**
     * 服务对象
     */
    @Resource
    private TbResumeCollectionService tbResumeCollectionService;

    /**
     * 通过主键查询单条数据
     *
     * @param resumeId 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbResumeCollection selectOne(Integer resumeId,Integer businessid) {
        return this.tbResumeCollectionService.queryByResumeId(resumeId,businessid);
    }



    @RequestMapping("saveResumeCollection")
    @ResponseBody
    public TbResumeCollection saveResumeCollection(TbResumeCollection tbResumeCollection){
        TbResumeCollection d=tbResumeCollectionService.queryByResumeId(tbResumeCollection.getResumeId(),tbResumeCollection.getBusinessid());
        if (d == null)
        {
            tbResumeCollection.setState(1);
            tbResumeCollectionService.insert(tbResumeCollection);
        }
        else
        {
            if(d.getState()==0)
                d.setState(1);
            else
                d.setState(0);
            d.setUpdatetime(tbResumeCollection.getUpdatetime());
            tbResumeCollectionService.update(d);
        }
        return tbResumeCollectionService.queryByResumeId(tbResumeCollection.getResumeId(),tbResumeCollection.getBusinessid());
    }
}