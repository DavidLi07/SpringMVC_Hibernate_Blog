package blog.wl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.wl.dao.UserDao;
import blog.wl.model.User;
import blog.wl.model.UserException;


@Service("userService")
public class UserServiceImple implements UserService {

	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		User u = userDao.loadByUsername(user.getUsername());
		if(u != null) throw new UserException("The User is already existence!");
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	public void delete(int id) {
		userDao.delete(id);

	}

	@Override
	public User load(int id) {
		
		return userDao.load(id);
	}

	@Override
	public List<User> list() {

		return userDao.list();
	}

	@Override
	public User login(String username, String password) {
		User u = userDao.loadByUsername(username);
		if(u == null) throw new UserException("User does not exist!");
		if(!u.getPassword().equals(password) ) throw new UserException("Password incorrect!");
		return u;
	}



}
