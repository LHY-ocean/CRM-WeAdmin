package controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
	
	@RequestMapping("login")
	public @ResponseBody String login(User u, String code) {
		try {
//			SecurityUtils.getSubject().getSession().setTimeout(5000);
			SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getUsername(),u.getUserpwd()));
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
