package blog.wl.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import blog.wl.model.User;


@Repository("userDao") //相当于创建一个对象userDao
public class UserDaoImple implements UserDao {

		private SessionFactory sessionFactory;
		  
		  
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		@Resource
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		@Override
		public void add(User user) {
			sessionFactory.getCurrentSession().save(user);
			sessionFactory.getCurrentSession().flush();
			//sessionFactory.getCurrentSession().save(user);
			
		}

		@Override
		public void update(User user) {
			
			sessionFactory.getCurrentSession().update(user);
			sessionFactory.getCurrentSession().flush();

		}

		@Override
		public void delete(int id) {
			
			User user = this.load(id);
			sessionFactory.getCurrentSession().delete(user);
			sessionFactory.getCurrentSession().flush();
			
		}

		@Override
		public User load(int id) {
			
			return (User) sessionFactory.getCurrentSession().load(User.class, id); 
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<User> list() {
			
			return sessionFactory.getCurrentSession().createQuery("from User").list();
			//return this.getSession().createQuery("from User").list();
		}

		@Override
		public User loadByUsername(String username) {
			return (User)sessionFactory.getCurrentSession().createQuery("from User where username=?")
					.setParameter(0, username).uniqueResult();
			//return (User)this.getSession().creatQuery("from User where username=?").setParameter(0,username).uniqueResult();
			
		}


	}

