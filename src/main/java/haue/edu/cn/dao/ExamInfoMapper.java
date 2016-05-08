package haue.edu.cn.dao;

import haue.edu.cn.model.ExamInfo;

public interface ExamInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamInfo record);

    int insertSelective(ExamInfo record);

    ExamInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamInfo record);

    int updateByPrimaryKey(ExamInfo record);
}