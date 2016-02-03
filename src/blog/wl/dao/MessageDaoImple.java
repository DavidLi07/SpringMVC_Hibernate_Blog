package blog.wl.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import blog.wl.model.Message;
import blog.wl.model.Pager;
import blog.wl.model.SystemContext;

@Repository("messageDao")
public class MessageDaoImple implements MessageDao {
	
	private SessionFactory sessionFactory;
	  
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void add(Message message) {
		this.sessionFactory.getCurrentSession().save(message);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void update(Message message) {
		this.sessionFactory.getCurrentSession().update(message);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void delete(int messageid) {
		Message message = this.load(messageid);
		this.sessionFactory.getCurrentSession().delete(message);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public Message load(int messageid) {
		return (Message) this.sessionFactory.getCurrentSession().load(Message.class, messageid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> list() {
		return this.sessionFactory.getCurrentSession().createQuery("from Message order by messageid").list();
	}

	@Override
	public Message loadByMessagename(String messagename) {
		return (Message) this.sessionFactory.getCurrentSession().createQuery("from Message where messagename=? order by messageid")
				.setParameter(0, messagename).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> loadByMessagetype(String messagetype) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Message where messagetype=? order by messageid").setParameter(0, messagetype).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Message> find() {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Message order by messageid");
		query.setFirstResult(offset).setMaxResults(size);
		List<Message> datas = query.list();
		Pager<Message> us = new Pager<Message>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
/*		System.out.println(us.getDatas());
		System.out.println(us.getOffset());
		System.out.println(us.getSize());		*/
		Long total = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from Message").uniqueResult();
		us.setTotal(total);
/*		System.out.println(us.getTotal());*/
		return us;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Message> findByMessagetype(String messagetype) {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Message where messagetype=? order by messageid").setParameter(0, messagetype);
		query.setFirstResult(offset).setMaxResults(size);
		List<Message> datas = query.list();
		Pager<Message> us = new Pager<Message>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
/*		System.out.println(us.getDatas());
		System.out.println(us.getOffset());
		System.out.println(us.getSize());		*/
		Long total = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from Message where messagetype=? order by messageid").setParameter(0, messagetype).uniqueResult();
		us.setTotal(total);
/*		System.out.println(us.getTotal());*/
		return us;
	}

}
