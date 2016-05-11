package haue.edu.cn.dao;

import java.util.List;

import haue.edu.cn.model.QuestionDB;

public interface QuestionDBMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionDB record);

    int insertSelective(QuestionDB record);

    QuestionDB selectByPrimaryKey(Integer id);
    
    List<QuestionDB> selectAll();

    int updateByPrimaryKeySelective(QuestionDB record);

    int updateByPrimaryKey(QuestionDB record);
}