package blog.wl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.wl.dao.AlbumDao;
import blog.wl.model.Album;

@Service("albumService")
public class AlbumServiceImple implements AlbumService {
	private AlbumDao albumDao;
	
	public AlbumDao getAlbumDao() {
		return albumDao;
	}

	@Resource
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	@Override
	public void add(Album album) {
		albumDao.add(album);

	}

	@Override
	public void update(Album album) {
		albumDao.update(album);

	}

	@Override
	public void delete(int albumid) {
		albumDao.delete(albumid);

	}

	@Override
	public Album load(int albumid) {
		return albumDao.load(albumid);
	}

	@Override
	public List<Album> list() {
		return albumDao.list();
	}

	@Override
	public List<Album> listByPhotoname(String photoname) {
		return albumDao.listByPhotoname(photoname);
	}

}
