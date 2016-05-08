package haue.edu.cn.dao;

import java.util.List;

import haue.edu.cn.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);
    
    User selectByUserId(Integer userId);
    
    List<User> selectByUserIds(Object[] userIds);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}