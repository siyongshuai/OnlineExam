package haue.edu.cn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.Admin;
import haue.edu.cn.service.impl.AdminServiceImpl;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	
	
	@RequestMapping(value="password.do",method=RequestMethod.GET)
	public String displayPassword(){
		return "admin/passwd";
	}
	
	
	@RequestMapping(value="password.do",method=RequestMethod.POST)
	@ResponseBody
	public String updatePassword(HttpSession session,String newpasswd){
		try {
			Admin admin = (Admin) session.getAttribute("currentAdmin");
			System.out.println("获取的新密码为"+newpasswd);
			admin.setUserpass(newpasswd);
			if (adminService.update(admin)==1) {
				return "successUpdatePassword";
			}
			else {
				return "failUpdatePassword";
			}
		} catch (Exception e) {
			System.out.println("更新密码发生异常");
			return null;
			
		}
		
	}
	
}
