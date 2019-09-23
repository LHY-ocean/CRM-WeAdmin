package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Client;
import model.Operator;
import model.Src;
import service.ClientService;
import service.OperatorService;
import service.SrcService;
import utils.ReturnInfo;

@Controller
@RequestMapping("client")
public class ClientController {

	@Autowired
	ClientService cservice;
	
	@Autowired
	OperatorService oservice;
	
	@Autowired
	SrcService srcservice;
	



	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		String where = "";
		if (txt != null && txt != "")
			where = " where C_client.name like '%" + txt + "%'";
		return cservice.getWhere(where, page, limit);
	}

	@RequestMapping("no_index")
	public @ResponseBody ReturnInfo no_index(String txt, Integer page, Integer limit) {
		String where = " where C_client.count = 0 and C_client.operatorids = 0";
		if (txt != null && txt != "")
			where = " where C_client.count = 0 and C_client.operatorids = 0 and C_client.name like '%" + txt + "%'";
		return cservice.getWhere(where, page, limit);
	}
	
	@RequestMapping("select")
	public @ResponseBody Client getById(int id) {
		return cservice.getById(id);
	}

	@RequestMapping("insert")
	public @ResponseBody Integer insert(Client c) {
		return cservice.insert(c);
	}

	@RequestMapping("delete")
	public @ResponseBody int delete(int id) {
		return cservice.delete(id);
	}

	@RequestMapping("update")
	public @ResponseBody Integer update(Client c) {
		return cservice.update(c);
	}
	
	@RequestMapping("getClientType")
	public @ResponseBody List<Client> getClientType() {
		return cservice.getAll();
	}
	
	@RequestMapping("getOperator")
	public @ResponseBody List<Operator> getOperator() {
		return oservice.getAll();
	}
	
	@RequestMapping("getSrc")
	public @ResponseBody List<Src> getSrc() {
		return srcservice.getAll();
	}
	
	@RequestMapping("getLink")
	public @ResponseBody String[] getLink() {
		return Client.statusname;
	}
	
	@RequestMapping("getClient")
	public @ResponseBody String[] getClient() {
		return Client.linkstatusname;
	}
	
	@RequestMapping("getPurpose")
	public @ResponseBody String[] getPurpose() {
		return Client.purposestatusname;
	}
	
	@RequestMapping("getAssess")
	public @ResponseBody String[] getAssess() {
		return Client.assessstatusname;
	}
	
	@RequestMapping("getExec")
	public @ResponseBody String[] getExec() {
		return Client.execstatusname;
	}
	
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Client.statusname;
	}
	
	@RequestMapping("getSex")
	public @ResponseBody String[] getSex() {
		return Client.sexname;
	}
}
