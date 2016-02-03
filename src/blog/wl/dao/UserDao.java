package blog.wl.dao;

import java.util.List;

import blog.wl.model.User;

public interface UserDao {
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public List<User> list();
	public User loadByUsername(String username);

}
