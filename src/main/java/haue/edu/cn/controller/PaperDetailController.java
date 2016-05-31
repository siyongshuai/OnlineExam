package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;
import haue.edu.cn.model.PaperCondition;
import haue.edu.cn.model.PaperDetail;
import haue.edu.cn.service.impl.PaperDetailServiceImpl;

@Controller
@RequestMapping("admin/pd")
public class PaperDetailController implements CommonController<PaperDetail> {
	
	AjaxResult ajaxResult = new AjaxResult();

	@Autowired
	private PaperDetailServiceImpl paperDetailService;
	
	
	@Override
	@RequestMapping("get.do")
	@ResponseBody
	public List<PaperDetail> get() {
		// TODO Auto-generated method stub
		return paperDetailService.get();
	}
	
	@RequestMapping("display.do")
	public String dispaly(HttpServletRequest request,HttpServletResponse response,Model model) {
		try {
			int pid = Integer.parseInt(request.getParameter("id"));
			List<PaperDetail> questionList = paperDetailService.getQuestions(pid);
			model.addAttribute("questionList", questionList);
			return "display";
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	@RequestMapping("one.do")
	@ResponseBody
	public PaperDetail getOne(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		return paperDetailService.getOne(Integer.parseInt(request.getParameter("id")));
	}

	@Override
	@RequestMapping("addOne.do")
	@ResponseBody
	public AjaxResult add(@RequestBody PaperDetail record) {
		// TODO Auto-generated method stub
	
			if(paperDetailService.add(record)>0){
				return  ajaxResult;
			}else {
				return null;
			}
				
	}

	@RequestMapping("add.do")
	@ResponseBody
	public AjaxResult generate(@RequestBody PaperCondition paperCondition ) {
		if(paperDetailService.addMany(paperCondition)>0){
			return  ajaxResult;
		}else {
			return null;
		}
	}

	@RequestMapping("batch.do")
	@ResponseBody
	public AjaxResult addBatch() {
		// TODO Auto-generated method stub
		int qtype = 1;
		int num =10;
		if(paperDetailService.addBatch(qtype, num)>0){
			return  ajaxResult;
		}else {
			return null;
		}
	}
	
	@Override
	@RequestMapping("delete.do")
	@ResponseBody
	public AjaxResult delete(@RequestBody PaperDetail record) {
	try {
		if (paperDetailService.delete(record) > 0) {
			return ajaxResult;
		} else {
			return null;
		}
	} catch (Exception e) {
		System.out.println("删除paperDetail异常");
		return new AjaxResult();
	}
	
	}

	@Override
	@RequestMapping("update.do")
	@ResponseBody
	public AjaxResult update(@RequestBody PaperDetail record) {
		try {
			if (paperDetailService.update(record) > 0) {
				return ajaxResult;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("更新paperDetail异常");
			return null;
		}
		
		
	}

	@Override
	@RequestMapping("query.do")
	@ResponseBody
	public List<PaperDetail> query(PaperDetail condition) {
		return paperDetailService.get();
	}

	@Override
	@RequestMapping("manage.do")
	public String manage() {
		return "admin/pd";
	}

}
