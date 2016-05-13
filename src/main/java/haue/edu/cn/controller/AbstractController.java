package haue.edu.cn.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haue.edu.cn.model.AjaxResult;

@Controller
@RequestMapping()
public abstract class AbstractController<T> {
	
	@RequestMapping("get.do")
	@ResponseBody
	public abstract List<T> get();

	@RequestMapping("one.do")
	public abstract T getOne(Integer id);

	@RequestMapping("add.do")
	public abstract AjaxResult add(T record);

	@RequestMapping("delete.do")
	public abstract AjaxResult delete(T record);

	@RequestMapping("update.do")
	public abstract AjaxResult update(T record);

	
	@RequestMapping("query.do")
	@ResponseBody
	public abstract List<T> query(T condition);
}
