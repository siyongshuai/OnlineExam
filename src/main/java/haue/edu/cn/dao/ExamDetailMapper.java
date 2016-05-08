package haue.edu.cn.dao;

import haue.edu.cn.model.ExamDetail;

public interface ExamDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamDetail record);

    int insertSelective(ExamDetail record);

    ExamDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamDetail record);

    int updateByPrimaryKey(ExamDetail record);
}