package com.liyi.part_time.service.impl;

import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.dao.TbAdminDao;
import com.liyi.part_time.entity.TbBusiness;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.service.TbAdminService;
import com.liyi.part_time.util.LayuiPage;
import com.liyi.part_time.util.ResultMessage;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TbAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 00:25:56
 */
@Service("tbAdminService")
public class TbAdminServiceImpl implements TbAdminService {
    @Resource
    private TbAdminDao tbAdminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    @Override
    public TbAdmin queryById(Integer adminId) {
        return this.tbAdminDao.queryById(adminId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbAdmin> queryAllByLimit(int offset, int limit) {
        return this.tbAdminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public TbAdmin insert(TbAdmin tbAdmin) {
        this.tbAdminDao.insert(tbAdmin);
        return tbAdmin;
    }

    /**
     * 修改数据
     *
     * @param tbAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public TbAdmin update(TbAdmin tbAdmin) {
        this.tbAdminDao.update(tbAdmin);
        return this.queryById(tbAdmin.getAdminId());
    }

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adminId) {
        return this.tbAdminDao.deleteById(adminId) > 0;
    }

    @Override
    public boolean deleteByList(List<Integer> List) {
        int flag = tbAdminDao.batchDelete(List);
        return flag > 0;
    }


    @Override
    public LayuiPage<TbAdmin> getPage(int page, int limit, TbAdmin tbAdmin){

        int count = tbAdminDao.getCount(tbAdmin);
        List<TbAdmin> data= tbAdminDao.pageByCondition((page - 1) * limit, limit, tbAdmin);
        LayuiPage<TbAdmin> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

    @Override
    public TbAdmin queryByName(String name) {
        return this.tbAdminDao.queryByName(name);
    }

    @Override
    public LayuiPage<TbAdmin> getPageWithTime(int page, int limit, String condition){
        String[] params = condition.split(",");
        String adminName = params[0].equals("null")? null: params[0];
        String adminSex = params[1].equals("null")? null: params[1];
        String phone = params[2].equals("null")? null: params[2];
        String startDate = params[3].equals("null")? null: params[3];
        String endDate = params[4].equals("null")? null: params[4];
        int count = tbAdminDao.getCountWithTime(adminName,adminSex,phone,startDate,endDate);
        List<TbAdmin> data= tbAdminDao.pageByConditionWithTime((page - 1) * limit, limit,adminName,adminSex,phone,startDate,endDate);
        LayuiPage<TbAdmin> layPage = new LayuiPage<>(count, data);
        return layPage;
    }
}