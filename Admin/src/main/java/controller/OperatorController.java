package controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Operator;
import model.WorkGroup;
import service.OperatorService;
import service.WorkGroupService;
import utils.ReturnInfo;

@Controller
@RequestMapping("operator")
public class OperatorController {

	@Autowired
	OperatorService oservice;

	@Autowired
	WorkGroupService wgservice;

	@RequestMapping("login")
	public @ResponseBody String login(Operator o, String code) {
		try {
//			 SecurityUtils.getSubject().getSession().setTimeout(5000);
			SecurityUtils.getSubject().login(new UsernamePasswordToken(o.getTel(), o.getPass()));
		} catch (AccountException e) { 
			return "";
		}
		return "true";
	}

	@RequestMapping("outlogin")
	public String outlogin() {
		SecurityUtils.getSubject().logout();
		return "redirect:/login.html";
	}

	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		String where = "";
		if (txt != null && txt != "")
			where = " where c_operator.name like '%" + txt + "%'";
		return oservice.getWhere(where, page, limit);
	}

	@RequestMapping("select")
	public @ResponseBody Operator getById(int id) {
		return oservice.getById(id);
	}

	@RequestMapping("insert")
	public @ResponseBody Integer insert(Operator o) {
		return oservice.insert(o);
	}

	@RequestMapping("delete")
	public @ResponseBody int delete(int id) {
		return oservice.delete(id);
	}

	@RequestMapping("update")
	public @ResponseBody Integer update(Operator o) {
		return oservice.update(o);
	}
	
	@RequestMapping("getGroup")
	public @ResponseBody List<WorkGroup> getGroup() {
		return wgservice.getAll();
	}
	
	@RequestMapping("getPower")
	public @ResponseBody String[] getPower() {
		return Operator.powername;
	}
	
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Operator.statusname;
	}
}
