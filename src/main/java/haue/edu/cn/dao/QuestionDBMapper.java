package haue.edu.cn.dao;

import haue.edu.cn.model.QuestionDB;
import haue.edu.cn.model.QuestionDBWithBLOBs;

public interface QuestionDBMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionDBWithBLOBs record);

    int insertSelective(QuestionDBWithBLOBs record);

    QuestionDBWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionDBWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QuestionDBWithBLOBs record);

    int updateByPrimaryKey(QuestionDB record);
}