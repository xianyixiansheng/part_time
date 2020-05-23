package com.liyi.part_time.dao;

import com.liyi.part_time.entity.TbBusiness;
import com.liyi.part_time.util.BaseDao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbBusiness)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 00:28:06
 */
public interface TbBusinessDao extends  BaseDao<TbBusiness>{

    public int getNum();

    TbBusiness queryByWxCode(String wxCode);

    public int setWxInfo(TbBusiness tbbusiness);

    //  通过主键删除相关外键数据
    int deleteByIdwithFK(Integer businessId);

    //  通过主键删除相关外键数据
    public int batchDeletewithFK(@Param("List") List<Integer> List);

    public int getCount(TbBusiness condition);

    public List<TbBusiness> pageByCondition(@Param("page") int page, @Param("limit") int limit,
                                         @Param("condition") TbBusiness condition);

    public int getCountWithAudit(TbBusiness condition);

    public List<TbBusiness> pageByConditionWithAudit(@Param("page") int page, @Param("limit") int limit,
                                            @Param("condition") TbBusiness condition);

    public List<TbBusiness> getDetail(Integer id);

    public int updateforbidden(Integer businessId);

    public int updatepass(Integer businessId);
}