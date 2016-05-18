package haue.edu.cn.dao;

import java.util.List;

import haue.edu.cn.model.ExamInfo;
import haue.edu.cn.model.ScoreCondition;

public interface ExamInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamInfo record);

    int insertSelective(ExamInfo record);

    ExamInfo selectByPrimaryKey(Integer id);
    
    List<ExamInfo> selectAll();
    
    List<ExamInfo> selectByCondition(ExamInfo condition);
    
    List<ExamInfo> selectUserScore(ScoreCondition scoreCondition);
    
    int updateMore(List<ExamInfo> examInfos);

    int updateByPrimaryKeySelective(ExamInfo record);

    int updateByPrimaryKey(ExamInfo record);
}