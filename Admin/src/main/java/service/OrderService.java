package service;

import java.util.List;

import model.Order;
import utils.ReturnInfo;

public interface OrderService {
	
	public int getSize(String where);

	public ReturnInfo getWhere(String where, Integer page, Integer limit);

	public List<Order> getAll();

	public Order getById(int id);

	public int delete(int id);

	public Integer insert(Order o);

	public Integer update(Order o);

}
