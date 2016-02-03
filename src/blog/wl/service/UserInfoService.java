package blog.wl.service;

import java.util.List;

import blog.wl.model.Pager;
import blog.wl.model.UserInfo;

public interface UserInfoService {
	public void add(UserInfo userinfo);
	public void update(UserInfo userinfo);
	public void delete(int id);
	public UserInfo load(int id);
	public List<UserInfo> list();
	public Pager<UserInfo> find();
	public UserInfo loadByUsername(String username);
	public List<UserInfo> listByUsername(String username);
	public List<UserInfo>listByType(String type);
	
	public UserInfo loadByRowbumber(int rownum);
	
	public UserInfo loadnextidByid(int id);
	public UserInfo loadpreByid(int id);
	public void merge(UserInfo userinfo);

}
