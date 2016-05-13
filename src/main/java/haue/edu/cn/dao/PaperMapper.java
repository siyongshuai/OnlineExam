package haue.edu.cn.dao;

import java.util.List;

import haue.edu.cn.model.Paper;

public interface PaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer id);
    
    List<Paper> selectAll();
    
    List<Paper> selectQuestionsByPaperId(Integer pid);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);
}