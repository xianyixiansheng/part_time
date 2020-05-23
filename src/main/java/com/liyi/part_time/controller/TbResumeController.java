package com.liyi.part_time.controller;

import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.entity.TbResume;
import com.liyi.part_time.service.TbResumeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbResume)表控制层
 *
 * @author Liyi
 * @since 2020-03-24 00:28:08
 */
@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("tbResume")
public class TbResumeController {
    /**
     * 服务对象
     */
    @Resource
    private TbResumeService tbResumeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbResume selectOne(Integer id) {
        return this.tbResumeService.queryById(id);
    }

    @GetMapping("queryByBusinessId")
    @ResponseBody
    public List<TbResume> queryByBusinessId(Integer id) {
        return this.tbResumeService.queryByBusinessId(id);
    }

    @GetMapping("queryByResumeId")
    @ResponseBody
    public TbResume queryByResumeId(Integer id) {
        return this.tbResumeService.queryByResumeId(id);
    }

    @GetMapping("queryAll")
    @ResponseBody
    public List<TbResume> queryAll(TbResume tbResume) {
        return this.tbResumeService.queryAll(tbResume);
    }

    @RequestMapping("saveResume")
    @ResponseBody
    public TbResume saveResume(TbResume tbResume){
        TbResume t = tbResumeService.queryById(tbResume.getJobHunterId());
        if (t == null)
            tbResumeService.insert(tbResume);
        else
            tbResumeService.update(tbResume);
        return tbResumeService.queryById(tbResume.getJobHunterId());
    }
    @RequestMapping("getPage")
    @ResponseBody
    public List<TbResume> getPageWithFK(String eduschool){
        List<TbResume> tbResume=tbResumeService.getPage(eduschool);
        return tbResume;
    }

}