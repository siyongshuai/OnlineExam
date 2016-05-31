package haue.edu.cn.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.User;
import haue.edu.cn.service.UserService;

@Controller
@RequestMapping(value = "admin")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/query.do")
	@ResponseBody
	public  User getUserById(HttpServletRequest request){
		Integer userId = Integer.parseInt(request.getParameter("id"));
		return userService.getUserById(userId);
	}
	@RequestMapping("/user/queryno.do")
	@ResponseBody
	public  User getUserByIdNoPara(HttpServletRequest request){
		Integer userId = Integer.parseInt(request.getParameter("id"));
		return userService.getUserByIdNoPara(userId);
	}
	
	
	@RequestMapping("/user/get.do")
	@ResponseBody
	public  List<User> getUserByRandom(){
		Object[] userIds = new Object[5];
		
		Random random = new Random();
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		 
		while(hashSet.size()< userIds.length){
			hashSet.add(random.nextInt(10)+1);
			
		}
		
	    userIds = hashSet.toArray();
	    for (int i = 0; i < userIds.length; i++) {
			System.out.print(userIds[i]+"\t");
		}
		return userService.getUserByRandom(userIds);
		
	}
}
