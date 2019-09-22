package service;

import java.util.List;

import model.OrderDetails;
import utils.ReturnInfo;

public interface OrderDetailsService {
	
	public int getSize(String where);

	public ReturnInfo getWhere(String where, Integer page, Integer limit);

	public List<OrderDetails> getAll();

	public OrderDetails getById(int id);

	public int delete(int id);

	public Integer insert(OrderDetails o);

	public Integer update(OrderDetails o);
	
}
