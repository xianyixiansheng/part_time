package com.liyi.part_time.controller;

import com.alibaba.fastjson.JSONObject;
import com.liyi.part_time.entity.TbFeedback;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.service.TbFeedbackService;
import com.liyi.part_time.util.BaseController;
import com.liyi.part_time.util.LayuiPage;
import com.liyi.part_time.vo.FeedBackVO;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * (TbFeedback)表控制层
 *
 * @author makejava
 * @since 2020-04-08 21:29:57
 */
@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("tbFeedback")
public class TbFeedbackController  extends BaseController<TbFeedback> {
    /**
     * 服务对象
     */
    @Resource
    private TbFeedbackService tbFeedbackService;

    @RequestMapping("getLayuiPage")
    @ResponseBody
    public LayuiPage<FeedBackVO> getPage(Integer page, Integer limit, String searchParams)throws Exception{
        FeedBackVO vo = JSONObject.parseObject(searchParams, FeedBackVO.class);
        LayuiPage<FeedBackVO> layPage = tbFeedbackService.getPage(page, limit, vo);
        return layPage;
    }

    @RequestMapping("getLayuiPageWithTime")
    @ResponseBody
    public LayuiPage<FeedBackVO> getPageWithTime(Integer page, Integer limit, String searchParams)throws Exception{
        LayuiPage<FeedBackVO> layPage = tbFeedbackService.getPageWithTime(page, limit, searchParams);
        return layPage;
    }

    @RequestMapping("getstates")
    @ResponseBody
    List<TbFeedback> getstates(){
        return tbFeedbackService.getstates();
    }

    @RequestMapping("getDetail")
    @ResponseBody
    public FeedBackVO getDetail(Integer orderId){
        FeedBackVO detail = tbFeedbackService.getDetail(orderId);
        return detail;
    }

    @RequestMapping("getNum")
    @ResponseBody
    public Integer getNum(){
        return tbFeedbackService.getNum();
    }


}