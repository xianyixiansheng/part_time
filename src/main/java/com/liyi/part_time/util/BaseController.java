package com.liyi.part_time.util;
import com.alibaba.fastjson.JSONObject;
import com.liyi.part_time.entity.TbAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

public class BaseController <T>{

    @Autowired
    private BaseService<T> service;

    @GetMapping("selectOne")
    @ResponseBody
    public T selectOne(Integer id) {
        return this.service.queryById(id);
    }

    @PostMapping("add")
    @ResponseBody
    public T add(T t){
        return this.service.insert(t);
    }

    @PostMapping("delete")
    @ResponseBody
    public boolean delete(Integer id) {
        return this.service.deleteById(id);
    }

    @PostMapping("update")
    @ResponseBody
    public T update(T t) {
        return this.service.update(t);
    }

    @RequestMapping("batchDelete")
    @ResponseBody
    public boolean batchDelete(Integer[] ids){
        if (ids == null|| ids.length == 0)
            return false;
        List<Integer> List = Arrays.asList(ids);
        boolean flag = service.deleteByList(List);
        return flag;
    }
}
