package blog.wl.service;

import java.util.List;

import blog.wl.model.Album;

public interface AlbumService {
	public void add(Album album);
	public void update(Album album);
	public void delete(int albumid);
	public Album load(int albumid);
	public List<Album> list();
	
	public List<Album> listByPhotoname(String photoname);
}
