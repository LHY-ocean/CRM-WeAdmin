package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Client;
import model.Revisit;
import service.ClientService;
import service.RevisitService;
import utils.ReturnInfo;

@Controller
@RequestMapping("revisit")
public class RevisitController {

	@Autowired
	RevisitService service;
	
	@Autowired
	ClientService clientservice;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where = " where name like '%"+txt+"%'";
		return service.getWhere(where, page, limit);
	}
	
	@RequestMapping("select")
	public @ResponseBody Revisit getById(int id) {
		return service.getById(id);
	}
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Revisit r) {
		 service.insert(r);
		 Client c = clientservice.getById(r.getClientid());
		 clientservice.updateCount(c);
		 return "{\"status\":1}";
	}
	
	@RequestMapping("delete")
	public @ResponseBody int delete(int id) {
		return service.delete(id);
	}
	
	@RequestMapping("update")
	public @ResponseBody Integer update(Revisit r) {
		return service.update(r);
	}
}
