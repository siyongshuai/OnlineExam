package haue.edu.cn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import haue.edu.cn.model.Admin;
import haue.edu.cn.model.Student;
import haue.edu.cn.service.impl.AdminServiceImpl;
import haue.edu.cn.service.impl.StudentServiceImpl;

@Controller
@SessionAttributes("currentUser")
public class LoginController {
	@Autowired
	private StudentServiceImpl studentService;

	@Autowired
	private AdminServiceImpl adminService;
	
	
	@RequestMapping(value="student/login.do",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView model = new ModelAndView("login");
		Student loginBean = new Student();
		model.addObject("loginBean",loginBean);
		return model;
		
	}
	
	@RequestMapping(value="student/login.do",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("loginBean") Student loginBean){
		ModelAndView model = null;
		Student currentUser = studentService.login(loginBean);
		
		if (currentUser!=null) {
			request.setAttribute("currentUser", currentUser);
			model = new ModelAndView("index");
			model.addObject("currentUser", currentUser);
		} else {
			model = new ModelAndView("login");
			model.addObject("loginBean", loginBean);
			request.setAttribute("message","login failed,please try agin");
			
		}
		return model;
	}
	
	@RequestMapping(value="admin/login.do",method=RequestMethod.GET)
	public ModelAndView displayAdminLogin(){
		ModelAndView modelAndView = new ModelAndView("admin/login");
		modelAndView.addObject("adminBean",new Admin() );
		return  modelAndView;
		
	}
	
	@RequestMapping(value="admin/login.do",method=RequestMethod.POST)
	public ModelAndView executeAdminLogin(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("adminBean") Admin adminBean){
		ModelAndView modelAndView = null;
		Admin currentAdmin =  adminService.excuteLogin(adminBean);
		if (currentAdmin!=null) {
			request.setAttribute("currentAdmin", currentAdmin);
			modelAndView = new ModelAndView("admin/index");
			modelAndView.addObject("currentAdmin", currentAdmin);
		} else {
			modelAndView = new ModelAndView("admin/login");
			modelAndView.addObject("adminBean", adminBean);
			request.setAttribute("message","用户名或密码错误，请重新登陆");
			
		}
		return modelAndView;
	
	}
	
	
	
	
	
}
