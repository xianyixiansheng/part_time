package com.liyi.part_time.dao;

import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.util.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * (TbAdmin)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 00:25:55
 */
public interface TbAdminDao extends BaseDao<TbAdmin> {


    //验证登录
    public TbAdmin  Isvailed(@Param("adminName") String adminName,@Param("adminPsw") String adminPsw);

    //请求名字
    public TbAdmin queryByName(String name);

    //记录行数
    public int getCountWithTime(@Param("adminName") String adminName,@Param("adminSex") String adminSex, @Param("phone") String phone,
                                @Param("startDate") String startDate, @Param("endDate") String endDate);
    //获取搜索条件列表
    public List<TbAdmin> pageByConditionWithTime(@Param("page") int page, @Param("limit") int limit,@Param("adminName") String adminName,
                                                 @Param("adminSex") String adminSex, @Param("phone") String phone,
                                               @Param("startDate") String startDate, @Param("endDate") String endDate);
}

