package controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Client;
import model.ClientType;
import model.Operator;
import model.Src;
import service.ClientService;
import service.ClientTypeService;
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
	
	@Autowired
	ClientTypeService ctservice;
	



	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		String where = "";
		if (txt != null && txt != "")
			where = " where C_client.name like '%" + txt + "%'";
		return cservice.getWhere(where, page, limit);
	}

	@RequestMapping("no_index")
	public @ResponseBody ReturnInfo no_index(String txt, Integer page, Integer limit) {
		String where = " where C_client.count = 0 and ( C_client.operatorids is null or C_client.operatorids = '' ) ";
		if (txt != null && txt != "")
			where = " where C_client.count = 0 and  ( C_client.operatorids is null or C_client.operatorids = '' ) and C_client.name like '%" + txt + "%'";
		return cservice.getWhere(where, page, limit);
	}
	
	@RequestMapping("new_index")
	public @ResponseBody ReturnInfo new_index(String txt, Integer page, Integer limit) {
		Operator user = (Operator)SecurityUtils.getSubject().getSession().getAttribute("user");
		int id = user.getId();
		String where = " where C_client.count = 0 and C_client.operatorids like '%"+id+"%'";
		if (txt != null && txt != "")
			where = " where C_client.count = 0 and C_client.operatorids like '%"+id+"%' and C_client.name like '%" + txt + "%'";
		return cservice.getWhere(where, page, limit);
	}
	
	@RequestMapping("new_pea")
	public @ResponseBody String new_pea(int id ,Client c) {
			c.setId(id);
			c.setOperatorids(null);
			cservice.updateOpids(c); 
		return   "{\"status\":1}";
	}
	
	@RequestMapping("new_peach")
	public @ResponseBody String new_peach(String str,Client c) {
		String[] ids = str.split(",");
		for(int i=1;i<ids.length;i++) {
			c.setId(Integer.valueOf(ids[i]));
			c.setOperatorids(null);
			cservice.updateOpids(c); 
		}
		return   "{\"status\":1}";
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
	
	@RequestMapping("updateOpids")
	public @ResponseBody String updateOpids(Client c,String str) {
		String[] ids = str.split(",");
		for(int i=1;i<ids.length;i++) {
			c.setId(Integer.valueOf(ids[i]));
			cservice.updateOpids(c); 
		}
		return   "{\"status\":1}";
	}
	
	@RequestMapping("getClientType")
	public @ResponseBody List<ClientType> getClientType() {
		return ctservice.getAll();
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
		return Client.linkstatusname;
	}
	
	@RequestMapping("getClient")
	public @ResponseBody String[] getClient() {
		return Client.clientstatusname;
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
