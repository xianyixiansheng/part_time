package com.liyi.part_time.dao;

import com.liyi.part_time.entity.TbJobHunter;
import com.liyi.part_time.util.BaseDao;
import com.liyi.part_time.vo.FeedBackVO;
import com.liyi.part_time.vo.JobHunterVO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbJobHunter)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 00:28:09
 */
public interface TbJobHunterDao extends  BaseDao<TbJobHunter>{

    TbJobHunter queryByWxCode(String wxCode);

    public int getNum();

    public int setWxName(TbJobHunter tbJobHunter);

    public int setWxInfo(TbJobHunter tbJobHunter);

    public int setPhone(TbJobHunter tbJobHunter);

    public int getCount(TbJobHunter condition);

    public List<TbJobHunter> pageByCondition(@Param("page") int page, @Param("limit") int limit,
                                         @Param("condition") TbJobHunter condition);

    public int getCountWithTime(@Param("name") String name,@Param("sex") String sex, @Param("phone") String phone,
                                @Param("eduschool") String eduschool, @Param("startDate") String startDate, @Param("endDate") String endDate);

    public List<JobHunterVO> pageByConditionWithTime(@Param("page") int page, @Param("limit") int limit, @Param("name") String name,@Param("sex") String sex, @Param("phone") String phone,
                                                     @Param("eduschool") String eduschool, @Param("startDate") String startDate, @Param("endDate") String endDate);
}