package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Level;
import service.LevelService;
import utils.ReturnInfo;

@Controller
@RequestMapping("level")
public class LevelController extends BasicController<Level> {
	
	@Autowired
	LevelService service;
	
	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null&&txt!="")
			where=" where levelname like '%"+txt+"%'";
		return super.index(where, page, limit);
	}
	
}
