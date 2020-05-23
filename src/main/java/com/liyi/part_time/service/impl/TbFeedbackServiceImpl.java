package com.liyi.part_time.service.impl;

import com.liyi.part_time.entity.TbFeedback;
import com.liyi.part_time.dao.TbFeedbackDao;
import com.liyi.part_time.entity.TbJob;
import com.liyi.part_time.service.TbFeedbackService;
import com.liyi.part_time.util.LayuiPage;
import com.liyi.part_time.vo.FeedBackVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbFeedback)表服务实现类
 *
 * @author makejava
 * @since 2020-04-08 21:29:57
 */
@Service("tbFeedbackService")
public class TbFeedbackServiceImpl implements TbFeedbackService {
    @Resource
    private TbFeedbackDao tbFeedbackDao;

    /**
     * 通过ID查询单条数据
     *
     * @param feedbackId 主键
     * @return 实例对象
     */
    @Override
    public TbFeedback queryById(Integer feedbackId) {
        return this.tbFeedbackDao.queryById(feedbackId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbFeedback> queryAllByLimit(int offset, int limit) {
        return this.tbFeedbackDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbFeedback 实例对象
     * @return 实例对象
     */
    @Override
    public TbFeedback insert(TbFeedback tbFeedback) {
        this.tbFeedbackDao.insert(tbFeedback);
        return tbFeedback;
    }

    /**
     * 修改数据
     *
     * @param tbFeedback 实例对象
     * @return 实例对象
     */
    @Override
    public TbFeedback update(TbFeedback tbFeedback) {
        this.tbFeedbackDao.update(tbFeedback);
        return this.queryById(tbFeedback.getFeedbackId());
    }

    /**
     * 通过主键删除数据
     *
     * @param feedbackId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer feedbackId) {
        return this.tbFeedbackDao.deleteById(feedbackId) > 0;
    }


    @Override
    public boolean deleteByList(List<Integer> List) {
        int flag = tbFeedbackDao.batchDelete(List);
        return flag > 0;
    }

    @Override
    public LayuiPage<TbFeedback> getPage(int page, int limit, TbFeedback tbFeedback){

        int count = tbFeedbackDao.getCount(tbFeedback);
        List<TbFeedback> data= tbFeedbackDao.pageByCondition((page - 1) * limit, limit, tbFeedback);
        LayuiPage<TbFeedback> layPage = new LayuiPage<>(count, data);
        return layPage;
    }


    @Override
    public LayuiPage<FeedBackVO> getPageWithTime(int page, int limit, String condition){
        String[] params = condition.split(",");
        String realName = params[0].equals("null")? null: params[0];
        String businessName = params[1].equals("null")? null: params[1];
        String jobName = params[2].equals("null")? null: params[2];
        Integer isassrest = params[3].equals("null")?null: Integer.valueOf(params[3]);
        String startDate = params[4].equals("null")? null: params[4];
        String endDate = params[5].equals("null")? null: params[5];
        int count = tbFeedbackDao.getCountWithTime(realName,businessName,jobName,isassrest,startDate,endDate);
        List<FeedBackVO> data= tbFeedbackDao.pageByConditionWithTime((page - 1) * limit, limit, realName,businessName,jobName,isassrest,startDate,endDate);
        LayuiPage<FeedBackVO> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

    @Override
    public LayuiPage<FeedBackVO> getPage(int page, int limit, FeedBackVO vo) {

        int count = tbFeedbackDao.getCount(vo);
        List<FeedBackVO> data= tbFeedbackDao.pageByVOCondition((page - 1) * limit, limit, vo);
        LayuiPage<FeedBackVO> layPage = new LayuiPage<>(count, data);
        return layPage;
    }

    @Override
    public FeedBackVO getDetail(Integer orderId) {
        FeedBackVO detail = tbFeedbackDao.getDetail(orderId);
        return detail;
    }

    @Override
    public List<TbFeedback> getstates() {
        return tbFeedbackDao.getstates();
    }

    @Override
    public Integer getNum()
    {
        return tbFeedbackDao.getNum();
    }
}