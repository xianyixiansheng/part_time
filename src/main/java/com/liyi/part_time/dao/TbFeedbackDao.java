package com.liyi.part_time.dao;

import com.liyi.part_time.entity.TbFeedback;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.util.BaseDao;
import com.liyi.part_time.vo.FeedBackVO;
import org.apache.ibatis.annotations.Param;
import com.liyi.part_time.vo.FeedBackVO;
import java.util.List;

/**
 * (TbFeedback)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-08 21:29:57
 */
public interface TbFeedbackDao extends BaseDao<TbFeedback> {

    public int getNum();

    public List<FeedBackVO> pageByVOCondition(@Param("page") int page, @Param("limit") int limit,
                                              @Param("condition") Object condition);

    public FeedBackVO getDetail(Integer id);

    public List<TbFeedback> getstates();

    public int getCountWithTime(@Param("realName") String realName,@Param("businessName") String businessName, @Param("jobName") String jobName,
                                @Param("isassrest") Integer isassrest, @Param("startDate") String startDate, @Param("endDate") String endDate);

    public List<FeedBackVO> pageByConditionWithTime(@Param("page") int page, @Param("limit") int limit, @Param("realName") String realName,@Param("businessName") String businessName, @Param("jobName") String jobName,
                                                    @Param("isassrest") Integer isassrest, @Param("startDate") String startDate, @Param("endDate") String endDate);
}