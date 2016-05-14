package haue.edu.cn.dao;

import java.util.List;

import haue.edu.cn.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);
    
    List<Student> selectByCondition(Student condition);
    
    List<Student> selectAll();
    
    Student selectByLogin(Student student);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}