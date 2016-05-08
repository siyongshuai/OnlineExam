package haue.edu.cn.service;


import java.util.List;

import haue.edu.cn.model.User;


public interface UserService {

User getUserById(Integer id);

User getUserByIdNoPara(Integer userId);

List<User> getUserByRandom(Object[] userIds);
	
}
