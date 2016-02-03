package blog.wl.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import blog.wl.model.Album;

@Repository("albumDao")
public class AlbumDaoImple implements AlbumDao {
	
	private SessionFactory sessionFactory;
	  
	  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Album album) {
		this.sessionFactory.getCurrentSession().save(album);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void update(Album album) {
		this.sessionFactory.getCurrentSession().update(album);
		this.sessionFactory.getCurrentSession().flush();

	}

	@Override
	public void delete(int albumid) {
		Album album = this.load(albumid);
		this.sessionFactory.getCurrentSession().delete(album);
		this.sessionFactory.getCurrentSession().flush();

	}

	@Override
	public Album load(int albumid) {
		return (Album) this.sessionFactory.getCurrentSession().load(Album.class, albumid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> list() {
		return sessionFactory.getCurrentSession().createQuery("from Album order by albumid").list();
	}

	@Override
	public Album loadByPhotoname(String photoname) {
		return (Album) sessionFactory.getCurrentSession().createQuery("from Album where photoname=? order by albumid")
				.setParameter(0, photoname).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> listByPhotoname(String photoname) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Album where photoname=? order by albumid").setParameter(0, photoname).list();
	}

}
