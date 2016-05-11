package haue.edu.cn.dao;

import java.util.List;

import haue.edu.cn.model.Question;
import haue.edu.cn.model.QuestionWithBLOBs;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionWithBLOBs record);

    int insertSelective(QuestionWithBLOBs record);

    QuestionWithBLOBs selectByPrimaryKey(Integer id);
    
    List<QuestionWithBLOBs> selectAll();

    int updateByPrimaryKeySelective(QuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QuestionWithBLOBs record);

    int updateByPrimaryKey(Question record);
}