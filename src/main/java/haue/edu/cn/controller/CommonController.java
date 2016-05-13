package haue.edu.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;

@Controller
@RequestMapping("manage_page/paper")
public interface CommonController<T> {

	@RequestMapping("get.do")
	@ResponseBody
	public List<T> get();

	@RequestMapping("one.do")
	public T getOne(HttpServletRequest request);

	@RequestMapping("add.do")
	public AjaxResult add(T record);

	@RequestMapping("delete.do")
	public AjaxResult delete(T record);

	@RequestMapping("update.do")
	public AjaxResult update(T record);

	
	@RequestMapping("query.do")
	@ResponseBody
	public List<T> query(T condition);

	

}
