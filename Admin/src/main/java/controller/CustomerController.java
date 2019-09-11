package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Customer;
import model.Level;
import model.User;
import service.CustomerService;
import service.LevelService;
import service.UserService;
import utils.ReturnInfo;

@Controller
@RequestMapping("customer")
public class CustomerController extends BasicController<Customer> {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	LevelService lservice;
	
	@Autowired
	UserService uservice;
	
	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null&&txt!="")
			where=" where cusname like '%"+txt+"%'";
		return super.index(where, page, limit);
	}
	
	@RequestMapping("getLevel")
	public @ResponseBody List<Level> getLevel() {
		return lservice.getAll();
	}
	
	@RequestMapping("getUser")
	public @ResponseBody List<User> getUser() {
		return uservice.getAll();
	}
}
