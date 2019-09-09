package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Customer;
import model.Product;
import service.CustomerService;
import service.ProductService;
import utils.ReturnInfo;

@Controller
@RequestMapping("WeAdmin")
public class CustomerController extends BasicController<Customer> {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	ProductService proServiec;
	
	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null&&txt!="")
			where=" where cus_name like '%"+txt+"%'";
		return super.index(where, page, limit);
	}
	
	@RequestMapping("getCus_sex")
	public @ResponseBody String[] getCus_sex() {
		return Customer.cus_sexname;
	}
	
	@RequestMapping("getProduct")
	public @ResponseBody List<Product> getProduct() {
		return proServiec.selectAll();
	}
}
