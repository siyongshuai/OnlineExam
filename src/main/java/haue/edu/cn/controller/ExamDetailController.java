package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.ExamDetail;
import haue.edu.cn.service.impl.ExamDetailServiceImpl;

@Controller
@RequestMapping("manage_page/ed")
public class ExamDetailController implements CommonController<ExamDetail> {

	AjaxResult ajaxResult = new AjaxResult();
	@Autowired
	private ExamDetailServiceImpl edService;
	
	@Override
	@RequestMapping("get.do")
	@ResponseBody
	public List<ExamDetail> get() {
		// TODO Auto-generated method stub
		return edService.getUserAnswers();
	}

	@Override
	@RequestMapping("one.do")
	@ResponseBody
	public ExamDetail getOne(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		return edService.getOne(id);
	}

	@Override
	@RequestMapping("add.do")
	@ResponseBody
	public AjaxResult add(@RequestBody ExamDetail record) {
		// TODO Auto-generated method stub
		if(edService.add(record)>0){
			return  ajaxResult;
		}else {
			return null;
		}
		
	}

	@RequestMapping("many.do")
	@ResponseBody
	public AjaxResult addMany(@RequestBody List<ExamDetail> examDetails) {
		// TODO Auto-generated method stub
		try {
			if(edService.addMany(examDetails)>0){
				return  ajaxResult;
			}else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("批量增加发生异常");
			return null;
			
		}
		
		
	}
	@Override
	@RequestMapping("delete.do")
	@ResponseBody
	public AjaxResult delete(ExamDetail record) {
		// TODO Auto-generated method stub
		if(edService.delete(record)>0){
			return  ajaxResult;
		}else {
			return null;
		}
	}

	@Override
	@RequestMapping("update.do")
	@ResponseBody
	public AjaxResult update(ExamDetail record) {
		if(edService.update(record)>0){
			return  ajaxResult;
		}else {
			return null;
		}
	}

	@Override
	@RequestMapping("query.do")
	@ResponseBody
	public List<ExamDetail> query(ExamDetail condition) {
	
	return edService.query(condition);
	}

}
