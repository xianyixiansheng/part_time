package com.liyi.part_time.service;

import com.liyi.part_time.entity.TbBusiness;
import com.liyi.part_time.util.BaseService;
import com.liyi.part_time.util.LayuiPage;

import java.util.List;

/**
 * (TbBusiness)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 00:28:06
 */
public interface TbBusinessService extends BaseService<TbBusiness>{

    public Integer getNum();

    TbBusiness queryByWxCode(String wxCode);

    public boolean setWxInfo(TbBusiness tbJobHunter);

    boolean deleteByIdwithFK(Integer id);

    boolean deleteByListwithFK(List<Integer> List);

    public List<TbBusiness> getDetail(Integer id);

    boolean updateforbidden(Integer id);

    boolean updatepass(Integer id);

    public LayuiPage<TbBusiness> getPageWithAudit(int page, int limit, TbBusiness condition);

}