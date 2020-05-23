package com.liyi.part_time.util;

import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BaseService<T> {

    T queryById(Integer id);

    List<T> queryAllByLimit(int offset, int limit);

    T insert(T t);

    T update(T t);

    boolean deleteById(Integer id);

    boolean deleteByList(List<Integer> List);

    public LayuiPage<T> getPage(int page, int limit, T condition);

}
