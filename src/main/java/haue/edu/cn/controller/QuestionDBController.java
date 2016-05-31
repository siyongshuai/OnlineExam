package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.QuestionDB;
import haue.edu.cn.service.impl.QuestionDBServiceImpl;

@Controller
@RequestMapping("admin/questiondb/")
public class QuestionDBController implements CommonController<QuestionDB> {

	
	@Autowired
	private QuestionDBServiceImpl questionDBService;
	
	@RequestMapping("get.do")
	public @ResponseBody List<QuestionDB> get(){
	 return questionDBService.getAll();
	}

	@Override
	public QuestionDB getOne(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="add.do",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult add(@RequestBody QuestionDB record) {
		try {
			 questionDBService.add(record);
			 return new AjaxResult();
		} catch (Exception e) {
			System.out.println("增加题库异常");
			return null;
		}
		
	}

	@Override
	@RequestMapping(value="delete.do",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult delete(@RequestBody QuestionDB record) {
		try {
			 questionDBService.delete(record);
			 return new AjaxResult();
		} catch (Exception e) {
			System.out.println("删除题库异常");
			return null;
		}
	}

	@Override
	@RequestMapping(value="update.do",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult update(@RequestBody QuestionDB record) {
		try {
			 questionDBService.update(record);
			 return new AjaxResult();
		} catch (Exception e) {
			System.out.println("更新题库异常");
			return null;
		}
	}

	@Override
	@RequestMapping("query.do")
	@ResponseBody
	public List<QuestionDB> query(@RequestBody QuestionDB condition) {
		try {
			return questionDBService.query(condition);
		} catch (Exception e) {
			System.out.println("查询题库异常");
			return null;
		}
	}

	@Override
	@RequestMapping("manage.do")
	public String manage() {
		return "admin/questiondb";
	}
}
