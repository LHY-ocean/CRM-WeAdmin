package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Order;
import service.OrderService;
import utils.ReturnInfo;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService oservice;


	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		String where = "";
		if (txt != null && txt != "")
			where = " where c_operator.name like '%" + txt + "%'";
		return oservice.getWhere(where, page, limit);
	}

	@RequestMapping("select")
	public @ResponseBody Order getById(int id) {
		return oservice.getById(id);
	}

	@RequestMapping("insert")
	public @ResponseBody Integer insert(Order o) {
		return oservice.insert(o);
	}

	@RequestMapping("delete")
	public @ResponseBody int delete(int id) {
		return oservice.delete(id);
	}

	@RequestMapping("update")
	public @ResponseBody Integer update(Order o) {
		return oservice.update(o);
	}
	
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Order.statusname;
	}
}
