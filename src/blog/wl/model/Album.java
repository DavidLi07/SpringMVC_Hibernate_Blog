package blog.wl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BALBUM")
public class Album {
	private int albumid;
	private String album;
	private String photoname;
	private String photo;
	private String photonumber;
	private Date pdate;
	private String pcontent;
	private String pcomment;
	private int id;
	
	@SequenceGenerator(name = "blogalbum_sequence",allocationSize=1,initialValue=1,sequenceName="blogalbum_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogalbum_sequence")
	@Id
	public int getAlbumid() {
		return albumid;
	}
	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPhotonumber() {
		return photonumber;
	}
	public void setPhotonumber(String photonumber) {
		this.photonumber = photonumber;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getPcomment() {
		return pcomment;
	}
	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
