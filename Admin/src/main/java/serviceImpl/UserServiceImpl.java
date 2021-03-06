package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User;
import service.UserService;

@Service
public class UserServiceImpl extends BasicServiceImpl<User> implements UserService {
	
	@Autowired
	UserDao dao;
	

}
