package haue.edu.cn.dao;

import java.util.List;

import haue.edu.cn.model.PaperDetail;

public interface PaperDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaperDetail record);

    int insertSelective(PaperDetail record);
    
    int insertMore(List<PaperDetail> paperDetails);

    PaperDetail selectByPrimaryKey(Integer id);
    
    
    List<PaperDetail> selectAll();
    
    List<PaperDetail> selectByCondition(PaperDetail condition);

    List<PaperDetail> selectQuestionsByPaperId(Integer pid);
    
    int updateByPrimaryKeySelective(PaperDetail record);

    int updateByPrimaryKey(PaperDetail record);
}