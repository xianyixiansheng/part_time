package com.liyi.part_time.util;

import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BaseDao<T>{

    public T queryById(Integer id);

    List<T> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<T> queryAll(T t);

    int insert(T t);

    int update(T t);

    int deleteById(Integer id);

    public int batchDelete(@Param("List") List<Integer> List);

    public int getCount(Object condition);

    public List<T> pageByCondition(@Param("page") int page, @Param("limit") int limit,
                                         @Param("condition") Object condition);




}
