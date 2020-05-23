package com.liyi.part_time.service;

import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.entity.TbFeedback;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.util.BaseService;
import com.liyi.part_time.util.LayuiPage;
import com.liyi.part_time.vo.FeedBackVO;

import java.util.List;

/**
 * (TbFeedback)表服务接口
 *
 * @author makejava
 * @since 2020-04-08 21:29:57
 */
public interface TbFeedbackService  extends BaseService<TbFeedback> {

    public Integer getNum();

    public LayuiPage<FeedBackVO> getPage(int page, int limit, FeedBackVO condition);

    public List<TbFeedback> getstates();

    public FeedBackVO getDetail(Integer id);

    public LayuiPage<FeedBackVO> getPageWithTime(int page, int limit, String condition);
}