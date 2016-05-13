package haue.edu.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.QuestionDB;
import haue.edu.cn.service.impl.QuestionDBServiceImpl;

@Controller
@RequestMapping("manage_page/questiondb/")
public class QuestionDBController {

	
	@Autowired
	private QuestionDBServiceImpl questionDBService;
	
	@RequestMapping("get.do")
	public @ResponseBody List<QuestionDB> get(){
	 return questionDBService.getAll();
	}
}
