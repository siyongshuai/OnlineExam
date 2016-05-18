package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.ExamInfo;
import haue.edu.cn.service.impl.ExamInfoServiceImpl;

@Controller
@RequestMapping("manage_page/ei")
public class ExamInfoController implements CommonController<ExamInfo> {

	@Autowired
	private ExamInfoServiceImpl eiService;
	
	
	
	@Override
	@RequestMapping("get.do")
	@ResponseBody
	public List<ExamInfo> get() {
		// TODO Auto-generated method stub
		return eiService.get();
	}

	@Override
	@RequestMapping("one.do")
	@ResponseBody
	public ExamInfo getOne(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping("add.do")
	@ResponseBody
	public AjaxResult add(@RequestBody ExamInfo record) {
		// TODO Auto-generated method stub
		if(eiService.add(record)>0){
			return new AjaxResult();
		}else {
			return null;
		}
		
		
	}

	@Override
	@RequestMapping("delete.do")
	@ResponseBody
	public AjaxResult delete(@RequestBody ExamInfo record) {
		if(eiService.delete(record)>0){
			return new AjaxResult();
		}else {
			return null;
		}
	}

	@Override
	@RequestMapping("update.do")
	@ResponseBody
	public AjaxResult update(@RequestBody ExamInfo record) {
		if(eiService.update(record)>0){
			return new AjaxResult();
		}else {
			return null;
		}
	}

	@Override
	@RequestMapping("query.do")
	@ResponseBody
	public List<ExamInfo> query(@RequestBody ExamInfo condition) {
		return eiService.query(condition);
	}

}
