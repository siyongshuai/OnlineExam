package haue.edu.cn.dao;

import haue.edu.cn.model.QuestionID;

public interface QuestionIDMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionID record);

    int insertSelective(QuestionID record);
}