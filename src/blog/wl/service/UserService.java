package blog.wl.service;

import java.util.List;

import blog.wl.model.User;

public interface UserService {
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public List<User> list();
	public User login(String username, String password);

}
