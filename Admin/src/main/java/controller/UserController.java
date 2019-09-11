package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Position;
import model.User;
import service.PositionService;
import service.UserService;
import utils.ReturnInfo;

@Controller
@RequestMapping("user")
public class UserController extends BasicController<User> {
	
	@Autowired
	UserService service;
	
	@Autowired
	PositionService pservice;
	
	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null&&txt!="")
			where=" where username like '%"+txt+"%'";
		return super.index(where, page, limit);
	}
	
	@RequestMapping("getUsersex")
	public @ResponseBody String[] getUsersex() {
		return User.usersexs;
	}
	
	@RequestMapping("getPosition")
	public @ResponseBody List<Position> getPosition() {
		return pservice.getAll();
	}
}
