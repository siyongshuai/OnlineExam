package haue.edu.cn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import haue.edu.cn.model.Student;
import haue.edu.cn.service.impl.StudentServiceImpl;

@Controller
@SessionAttributes("currentUser")
public class LoginController {
	@Autowired
	private StudentServiceImpl studentService;

	
	@RequestMapping(value="student/login.do",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView model = new ModelAndView("login");
		Student loginBean = new Student();
		model.addObject("loginBean",loginBean);
		return model;
		
	}
	
	@RequestMapping(value="student/login2.do",method=RequestMethod.POST)
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
	
	
}
