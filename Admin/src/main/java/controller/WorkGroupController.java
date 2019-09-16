package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.ClientType;
import model.Product;
import model.WorkGroup;
import service.ClientTypeService;
import service.ProductService;
import service.WorkGroupService;
import utils.ReturnInfo;

@Controller
@RequestMapping("workgroup")
public class WorkGroupController {
	
	@Autowired
	WorkGroupService wgservice;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where = " where name like '%"+txt+"%'";
		return wgservice.getWhere(where, page, limit);
	}
	
	@RequestMapping("select")
	public @ResponseBody WorkGroup getById(int id) {
		return wgservice.getById(id);
	}
	
	@RequestMapping("insert")
	public @ResponseBody Integer insert(WorkGroup c) {
		return wgservice.insert(c);
	}
	
	@RequestMapping("delete")
	public @ResponseBody int delete(int id) {
		return wgservice.delete(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody Integer update(WorkGroup c) {
		return wgservice.update(c);
	}
}
