package com.liyi.part_time.service.impl;

import com.liyi.part_time.entity.TbAdmin;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.entity.TbJobHunter;
import com.liyi.part_time.dao.TbJobHunterDao;
import com.liyi.part_time.service.TbJobHunterService;
import com.liyi.part_time.util.BaseController;
import com.liyi.part_time.util.LayuiPage;
import com.liyi.part_time.vo.FeedBackVO;
import com.liyi.part_time.vo.JobHunterVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbJobHunter)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 00:28:09
 */
@Service("tbJobHunterService")
public class TbJobHunterServiceImpl implements TbJobHunterService {
    @Resource
    private TbJobHunterDao tbJobHunterDao;

    /**
     * 通过ID查询单条数据
     *
     * @param jobHunterId 主键
     * @return 实例对象
     */
    @Override
    public TbJobHunter queryById(Integer jobHunterId) {
        return this.tbJobHunterDao.queryById(jobHunterId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbJobHunter> queryAllByLimit(int offset, int limit) {
        return this.tbJobHunterDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbJobHunter 实例对象
     * @return 实例对象
     */
    @Override
    public TbJobHunter insert(TbJobHunter tbJobHunter) {
        this.tbJobHunterDao.insert(tbJobHunter);
        return tbJobHunter;
    }

    /**
     * 修改数据
     *
     * @param tbJobHunter 实例对象
     * @return 实例对象
     */
    @Override
    public TbJobHunter update(TbJobHunter tbJobHunter) {
        this.tbJobHunterDao.update(tbJobHunter);
        return this.queryById(tbJobHunter.getJobHunterId());
    }

    /**
     * 通过主键删除数据
     *
     * @param jobHunterId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer jobHunterId) {
        return this.tbJobHunterDao.deleteById(jobHunterId) > 0;
    }

    @Override
    public boolean deleteByList(List<Integer> List) {
        int flag = tbJobHunterDao.batchDelete(List);
        return flag > 0;
    }

    @Override
    public TbJobHunter queryByWxCode(String wxCode) {
        TbJobHunter tbJobHunter = tbJobHunterDao.queryByWxCode(wxCode);
        return tbJobHunter;
    }

    @Override
    public boolean setWxName(TbJobHunter tbJobHunter) {
        int rows = tbJobHunterDao.setWxName(tbJobHunter);
        return rows>0;
    }

    @Override
    public boolean setWxInfo(TbJobHunter tbJobHunter) {

        return this.tbJobHunterDao.update(tbJobHunter)>0;
    }


    @Override
    public boolean setPhone(TbJobHunter tbJobHunter) {
        int rows = tbJobHunterDao.setPhone(tbJobHunter);
        return rows>0;
    }

    @Override
    public LayuiPage<TbJobHunter> getPage(int page, int limit, TbJobHunter tbJobHunter){

        int count = tbJobHunterDao.getCount(tbJobHunter);
        List<TbJobHunter> data= tbJobHunterDao.pageByCondition((page - 1) * limit, limit, tbJobHunter);
        LayuiPage<TbJobHunter> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

    @Override
    public LayuiPage<JobHunterVO> getPageWithTime(int page, int limit, String condition){
        String[] params = condition.split(",");
        String name = params[0].equals("null")? null: params[0];
        String sex = params[1].equals("null")? null: params[1];
        String phone = params[2].equals("null")? null: params[2];
        String eduschool = params[3].equals("null")? null:params[3];
        String startDate = params[4].equals("null")? null: params[4];
        String endDate = params[5].equals("null")? null: params[5];
        int count = tbJobHunterDao.getCountWithTime(name,sex,phone,eduschool,startDate,endDate);
        List<JobHunterVO> data= tbJobHunterDao.pageByConditionWithTime((page - 1) * limit, limit, name,sex,phone,eduschool,startDate,endDate);
        LayuiPage<JobHunterVO> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

    @Override
    public Integer getNum()
    {
        return tbJobHunterDao.getNum();
    }
}