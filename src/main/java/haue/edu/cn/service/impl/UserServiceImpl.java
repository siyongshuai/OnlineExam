package haue.edu.cn.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haue.edu.cn.dao.UserMapper;
import haue.edu.cn.model.User;
import haue.edu.cn.service.UserService;

@Service("userService")
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserMapper userDao;
	
	
	@Override
	public User getUserById(Integer id) {
		
		return  userDao.selectByPrimaryKey(id);
	}


	@Override
	public List<User> getUserByRandom(Object[] userIds) {
		
		return userDao.selectByUserIds(userIds);
	}


	@Override
	public User getUserByIdNoPara(Integer userId) {
		
		return userDao.selectByUserId(userId);
	}

}
