package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDao;
import model.Customer;
import service.CustomerService;

@Service
public class CustomerServiceImpl extends BasicServiceImpl<Customer> implements CustomerService {

	@Autowired
	CustomerDao dao;

	
	@Override
	public Customer selectById(Integer id) {
		return dao.selectById(" where customer.id="+id, "limit 1");
	}

	

}
