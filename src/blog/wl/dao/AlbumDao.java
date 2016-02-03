package blog.wl.dao;

import java.util.List;

import blog.wl.model.Album;

public interface AlbumDao {
	public void add(Album album);
	public void update(Album album);
	public void delete(int albumid);
	public Album load(int albumid);
	public List<Album> list();
	public Album loadByPhotoname(String photoname);
	public List<Album> listByPhotoname(String photoname);
}
