package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.ClientType;
import service.ClientTypeService;
import utils.ReturnInfo;

@Controller
@RequestMapping("clienttype")
public class ClientTypeController {
	
	@Autowired
	ClientTypeService ctservice;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where = " where name like '%"+txt+"%'";
		return ctservice.getWhere(where, page, limit);
	}
	
	@RequestMapping("select")
	public @ResponseBody ClientType getById(int id) {
		return ctservice.getById(id);
	}
	
	@RequestMapping("insert")
	public @ResponseBody Integer insert(ClientType c) {
		return ctservice.insert(c);
	}
	
	@RequestMapping("delete")
	public @ResponseBody int delete(int id) {
		return ctservice.delete(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody Integer update(ClientType c) {
		return ctservice.update(c);
	}
}
