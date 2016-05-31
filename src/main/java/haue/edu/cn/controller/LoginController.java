package haue.edu.cn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import haue.edu.cn.model.Admin;
import haue.edu.cn.model.Student;
import haue.edu.cn.service.impl.AdminServiceImpl;
import haue.edu.cn.service.impl.StudentServiceImpl;

@Controller
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
	public ModelAndView executeLogin(HttpServletRequest request,HttpServletResponse response,HttpSession session,
			@ModelAttribute("loginBean") Student loginBean){
		ModelAndView model = null;
		Student currentUser = studentService.login(loginBean);
		
		if (currentUser!=null) {
			request.setAttribute("currentUser", currentUser);
			
			session.setAttribute("currentUser", currentUser);
			model = new ModelAndView("student");
			model.addObject("currentUser", currentUser);
		} else {
			model = new ModelAndView("login");
			model.addObject("loginBean", loginBean);
			request.setAttribute("message","用户名和密码不匹配，请重新登陆");
			
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
			request.getSession().setAttribute("currentAdmin", currentAdmin);
			modelAndView = new ModelAndView("admin/index");
			modelAndView.addObject("currentAdmin", currentAdmin);
		} else {
			modelAndView = new ModelAndView("admin/login");
			modelAndView.addObject("adminBean", adminBean);
			request.setAttribute("message","用户名和密码不匹配，请重新登陆");
		}
		return modelAndView;
	
	}
	
	@RequestMapping("admin/info.do")
	public String getAdminInfo(HttpSession session){
		return "admin/personInfo";
	}
	
	
// 退出功能
	@RequestMapping(value="admin/logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login.do";
	}
	
	@RequestMapping(value="student/logout",method=RequestMethod.GET)
	public String studentLogout(HttpSession session){
		session.invalidate();
		return "redirect:login.do";
	}
	
	
	
	
}
