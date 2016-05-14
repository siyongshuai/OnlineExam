package haue.edu.cn.dao;

import java.util.List;

import haue.edu.cn.model.ExamDetail;

public interface ExamDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamDetail record);

    int insertSelective(ExamDetail record);

    ExamDetail selectByPrimaryKey(Integer id);
    
    List<ExamDetail> selectAll();
    
    List<ExamDetail> selectByCondition(ExamDetail condition);
    
    List<ExamDetail> selectUserAnswer();
    
    int updateMore(List<ExamDetail> examDetails);
    
    int insertMore(List<ExamDetail> examDetails);

    int updateByPrimaryKeySelective(ExamDetail record);

    int updateByPrimaryKey(ExamDetail record);
}