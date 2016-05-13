package haue.edu.cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import haue.edu.cn.model.PaperCondition;
import haue.edu.cn.model.Question;
import haue.edu.cn.model.QuestionCondition;
import haue.edu.cn.model.QuestionID;
import haue.edu.cn.model.QuestionWithBLOBs;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionWithBLOBs record);

    int insertSelective(QuestionWithBLOBs record);

    QuestionWithBLOBs selectByPrimaryKey(Integer id);
    
    List<QuestionWithBLOBs> selectAll();
    
    List<QuestionID> selectIdByRandom(@Param("qtype") Integer qtype,@Param("num") Integer num);

    List<Integer> selectIdsByRandom(@Param("qtype") Integer qtype,@Param("num") Integer num);
//    在无resultMap下，能不能将自定义对象作为参数
    List<Integer>  selectRandomIdsByCondition(QuestionCondition questionCondition);
    
    List<Integer> selectRandomIds (PaperCondition paperCondition);
    
    int updateByPrimaryKeySelective(QuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QuestionWithBLOBs record);

    int updateByPrimaryKey(Question record);
}