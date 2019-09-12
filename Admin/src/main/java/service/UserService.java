package service;

import java.util.List;

import model.User;

public interface UserService extends BasicService<User> {
	List<User> getAll();

	User selectUser(User user);
}
