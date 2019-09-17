package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Src;
import service.SrcService;
import utils.ReturnInfo;

@Controller
@RequestMapping("src")
public class SrcController {
	
	@Autowired
	SrcService srcservice;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where = " where name like '%"+txt+"%'";
		return srcservice.getWhere(where, page, limit);
	}
	
	@RequestMapping("select")
	public @ResponseBody Src getById(int id) {
		return srcservice.getById(id);
	}
	
	@RequestMapping("insert")
	public @ResponseBody Integer insert(Src s) {
		return srcservice.insert(s);
	}
	
	@RequestMapping("delete")
	public @ResponseBody int delete(int id) {
		return srcservice.delete(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody Integer update(Src s) {
		return srcservice.update(s);
	}
}
