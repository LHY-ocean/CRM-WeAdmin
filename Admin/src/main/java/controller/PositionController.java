package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Position;
import service.PositionService;
import utils.ReturnInfo;

@Controller
@RequestMapping("position")
public class PositionController extends BasicController<Position> {
	
	@Autowired
	PositionService service;
	
	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null&&txt!="")
			where=" where posname like '%"+txt+"%'";
		return super.index(where, page, limit);
	}
	
}
