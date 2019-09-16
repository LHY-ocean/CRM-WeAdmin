package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.ClientType;
import model.Product;
import service.ClientTypeService;
import service.ProductService;
import utils.ReturnInfo;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where = " where name like '%"+txt+"%'";
		return pservice.getWhere(where, page, limit);
	}
	
	@RequestMapping("select")
	public @ResponseBody Product getById(int id) {
		return pservice.getById(id);
	}
	
	@RequestMapping("insert")
	public @ResponseBody Integer insert(Product c) {
		return pservice.insert(c);
	}
	
	@RequestMapping("delete")
	public @ResponseBody int delete(int id) {
		return pservice.delete(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody Integer update(Product c) {
		return pservice.update(c);
	}
}
