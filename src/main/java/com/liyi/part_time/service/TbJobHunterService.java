package com.liyi.part_time.service;

import com.liyi.part_time.entity.TbJobHunter;
import com.liyi.part_time.util.BaseService;
import com.liyi.part_time.util.LayuiPage;
import com.liyi.part_time.vo.FeedBackVO;
import com.liyi.part_time.vo.JobHunterVO;


/**
 * (TbJobHunter)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 00:28:09
 */
public interface TbJobHunterService extends  BaseService<TbJobHunter>{

    TbJobHunter queryByWxCode(String wxCode);

    public Integer getNum();

    public boolean setWxName(TbJobHunter tbJobHunter);

    public boolean setWxInfo(TbJobHunter tbJobHunter);

    public boolean setPhone(TbJobHunter tbJobHunter);

    public LayuiPage<JobHunterVO> getPageWithTime(int page, int limit, String condition);

}