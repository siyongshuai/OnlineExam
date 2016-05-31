package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.Student;
import haue.edu.cn.service.impl.StudentServiceImpl;
@Controller
@RequestMapping("admin/student")
public class StudentController implements CommonController<Student> {

	@Autowired
	private StudentServiceImpl studentService;
	
	
	
	
	@RequestMapping("info.do")
	public String getStudentInfo(HttpSession session){
		try {
			return "personInfo";
		} catch (Exception e) {
			System.out.println("查看个人信息失败");
			return null;
		}
		
	}
	
	@RequestMapping("password.do")
	public String updatePassword(HttpSession session){
		return "password";
	}
	
	@Override
	@RequestMapping("get.do")
	@ResponseBody
	public List<Student> get() {
		try {
			return studentService.get();
		} catch (Exception e) {
			System.out.println("获取学生用户失败");
			return null;
		}
		
	}

	@Override
	@RequestMapping("one.do")
	@ResponseBody
	public Student getOne(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		return studentService.getOne(id);
	}

	@Override
	@RequestMapping("add.do")
	@ResponseBody
	public AjaxResult add(@RequestBody Student record) {
		// TODO Auto-generated method stub
		if (studentService.add(record)>0) {
			return new AjaxResult();
		}
		else {
			return null;
		}
	}

	@Override
	@RequestMapping("delete.do")
	@ResponseBody
	public AjaxResult delete(@RequestBody Student record) {
	
		if (studentService.delete(record)>0) {
			return new AjaxResult();
		}
		else {
			return null;
		}
	}

	@Override
	@RequestMapping("update.do")
	@ResponseBody
	public AjaxResult update(@RequestBody Student record) {
		if (studentService.update(record)>0) {
			return new AjaxResult();
		}
		else {
			return null;
		}
	}

	@Override
	@RequestMapping("query.do")
	@ResponseBody
	public List<Student> query(@RequestBody Student condition) {
	return studentService.query(condition);
	}

	@Override
	@RequestMapping("manage.do")
	public String manage() {
		return "admin/student";
	}

	
	@RequestMapping(value="password.do",method=RequestMethod.GET)
	public ModelAndView  editPassword(ModelAndView mav){
		mav.setViewName("passwd");
		return mav;
	}
	
	@RequestMapping(value="password.do",method=RequestMethod.POST)
	@ResponseBody
	public String updatePassword(HttpSession session,String newpasswd){
		try {
			Student student  =  (Student) session.getAttribute("currentUser");
			System.out.println("获取的新密码为"+newpasswd);
			student.setUserpass(newpasswd);
			studentService.update(student);
			if(studentService.update(student)==1){
			return "successPassword";	
			}
			else {
			return "failPassword";
			}
		} catch (Exception e) {
			System.out.println("更新密码异常");
			return null;
		}
		
		
	}
	
	
	
	
	
	
}
