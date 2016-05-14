package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.Student;
import haue.edu.cn.service.impl.StudentServiceImpl;
@Controller
@RequestMapping("front_page/student")
@SessionAttributes("currentUser")
public class StudentController implements CommonController<Student> {

	@Autowired
	private StudentServiceImpl studentService;
	@Override
	@RequestMapping("get.do")
	@ResponseBody
	public List<Student> get() {
		// TODO Auto-generated method stub
		return studentService.get();
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
		// TODO Auto-generated method stub
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

	
	public String login(@RequestBody Student student,ModelMap model ){
		Student currentUser = studentService.login(student);
		if (currentUser!=null) {
			model.addAttribute("currentUser", currentUser);
			return "readyToExam";
		}
		else{
			return null;
		}
	}
	
}
