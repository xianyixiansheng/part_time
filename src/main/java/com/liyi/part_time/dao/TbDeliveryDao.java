package com.liyi.part_time.dao;

import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.entity.TbDelivery;
import com.liyi.part_time.util.BaseDao;
import com.liyi.part_time.vo.DeliveryVO;
import org.apache.ibatis.annotations.Param;

import java.awt.print.PrinterGraphics;
import java.util.List;


/**
 * (TbDelivery)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 00:28:07
 */
public interface TbDeliveryDao extends BaseDao<TbDelivery> {

    public TbDelivery queryByJobIdandResumeId(@Param("jobId") Integer jobId,@Param("resumeId")  Integer resumeId);

    public TbDelivery queryByJobIdwithResumeId(@Param("jobId") Integer jobId,@Param("resumeId")  Integer resumeId);

    public List<TbDelivery> queryAllwithResumeId(Integer resumeId);

    public List<TbDelivery> queryAllwithResumeIdandOverTime(Integer resumeId);

    public int updateStatewithDelivery(TbDelivery tbDelivery);

    public DeliveryVO queryforEnd(Integer id);
}