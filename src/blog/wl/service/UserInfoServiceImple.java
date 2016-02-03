package blog.wl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.wl.dao.UserInfoDao;
import blog.wl.model.Pager;
import blog.wl.model.UserInfo;

@Service("userinfoService")
public class UserInfoServiceImple implements UserInfoService {
	
	private UserInfoDao userinfoDao;
	
	

	public UserInfoDao getUserinfoDao() {
		return userinfoDao;
	}

	@Resource
	public void setUserinfoDao(UserInfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}

	@Override
	public void add(UserInfo userinfo) {
		userinfoDao.add(userinfo);

	}

	@Override
	public void update(UserInfo userinfo) {
		userinfoDao.update(userinfo);

	}

	@Override
	public void delete(int id) {
		userinfoDao.delete(id);

	}

	@Override
	public UserInfo load(int id) {
		
		return userinfoDao.load(id);
	}

	@Override
	public List<UserInfo> list() {

		return userinfoDao.list();
	}

	@Override
	public Pager<UserInfo> find() {

		return userinfoDao.find();
	}

	@Override
	public UserInfo loadByUsername(String username) {
		
		return userinfoDao.loadByUsername(username);
	}

	@Override
	public List<UserInfo> listByUsername(String username) {

		return userinfoDao.listByUsername(username);
	}

	@Override
	public List<UserInfo> listByType(String type) {

		return userinfoDao.listByType(type);
	}

	@Override
	public UserInfo loadByRowbumber(int rownum) {
		// TODO Auto-generated method stub
		return userinfoDao.loadByRowbumber(rownum);
	}

	@Override
	public UserInfo loadnextidByid(int id) {
		// TODO Auto-generated method stub
		return userinfoDao.loadnextidByid(id);
	}

	@Override
	public void merge(UserInfo userinfo) {
		// TODO Auto-generated method stub
		userinfoDao.merge(userinfo);
	}

	@Override
	public UserInfo loadpreByid(int id) {
		// TODO Auto-generated method stub
		return userinfoDao.loadpreByid(id);
	}


}
