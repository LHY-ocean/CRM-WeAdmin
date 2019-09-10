package controller;

import java.lang.reflect.Field;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import serviceImpl.BasicServiceImpl;
import utils.ReturnInfo;

public class BasicController<T> {
	
	BasicServiceImpl<T> basicService;
	
	@ModelAttribute
	public void init() throws Exception{
		Field f = this.getClass().getDeclaredField("service");
		f.setAccessible(true);
		Object service = f.get(this);
		basicService = (BasicServiceImpl<T>) service;
	}
	
	//首页查询显示
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		return basicService.select(txt,page,limit);
	}
	
	//删除
	@RequestMapping("delete")
	public @ResponseBody String delete(Integer id) {
		basicService.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping("select")
	public @ResponseBody T select(Integer id) {
		return basicService.selectById(id);
	}
	
	//新增
	@RequestMapping("insert")
	public @ResponseBody String insert(T t) {
		basicService.insert(t);
		return "{\"status\":1}";
	}
	
	//修改
	@RequestMapping("update")
	public @ResponseBody String update(T t) {
		basicService.update(t);
		return "{\"status\":1}";
	}
	
}
