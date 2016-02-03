package blog.wl.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import blog.wl.model.Pager;
import blog.wl.model.SystemContext;
import blog.wl.model.UserInfo;

@Repository("userinfoDao")
public class UserInfoDaoImple implements UserInfoDao {
	
	private SessionFactory sessionFactory;
	  
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(UserInfo userinfo) {
		sessionFactory.getCurrentSession().save(userinfo);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public void update(UserInfo userinfo) {
		sessionFactory.getCurrentSession().update(userinfo);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public void delete(int id) {
		UserInfo userinfo = this.load(id);
		sessionFactory.getCurrentSession().delete(userinfo);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public UserInfo load(int id) {
		return (UserInfo) sessionFactory.getCurrentSession().load(UserInfo.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> list() {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo where rownum < 10 order by id").list();
	}

	@Override
	public UserInfo loadByUsername(String username) {
		return (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where username=?")
				.setParameter(0, username).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<UserInfo> find() {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserInfo order by id");
		query.setFirstResult(offset).setMaxResults(size);
		List<UserInfo> datas = query.list();
		Pager<UserInfo> us = new Pager<UserInfo>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
/*		System.out.println(us.getDatas());
		System.out.println(us.getOffset());
		System.out.println(us.getSize());		*/
		Long total = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from UserInfo").uniqueResult();
		us.setTotal(total);
/*		System.out.println(us.getTotal());*/
		return us;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> listByUsername(String username) {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo where username=? order by id").setParameter(0, username).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> listByType(String type) {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo where type=? order by id").setParameter(0, type).list();
	}

	@Override   //try use rownumber to get datas
	public UserInfo loadByRowbumber(int rownum) {
		return (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where rownum=?")
				.setParameter(0, rownum).uniqueResult();
	}

	@Override
	public UserInfo loadByRownumber(int id, int rownum) {
		// TODO Auto-generated method stub
		return(UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where rownum=?")
				.setParameter(0, rownum).uniqueResult();
	}

	@Override
	public UserInfo loadnextidByid(int id) {
		// TODO Auto-generated method stub
		return (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where id >? and rownum=1 order by id asc")
				.setParameter(0, id).uniqueResult();
	}

	@Override
	public UserInfo loadpreByid(int id) {
		// TODO Auto-generated method stub
		return (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where id <? and rownum=1 order by id desc")
				.setParameter(0, id).uniqueResult();
	}
	
	@Override
	public void merge(UserInfo userinfo) {
		sessionFactory.getCurrentSession().merge(userinfo);
		sessionFactory.getCurrentSession().flush();	
	}



}
