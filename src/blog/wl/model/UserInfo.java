package blog.wl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="BUSER_BLOG")
public class UserInfo {
	private int id;
	private String username;
	private String title;
	private String content;
	private String author;
	private Date bdate;
	private String album;
	private String message;
	private String photo;
	private String type;
	//private String nextid;
	private int nextid;
	private int preid;
	
	@SequenceGenerator(name = "buser_sequence",allocationSize=1,initialValue=8,sequenceName="buser_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="buser_sequence")
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@NotEmpty(message="Title can not be null!")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@NotEmpty(message="Content can not be null!")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@NotEmpty(message="Author can not be null!")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNextid() {
		return nextid;
	}
	public void setNextid(int nextid) {
		this.nextid = nextid;
	}
	public int getPreid() {
		return preid;
	}
	public void setPreid(int preid) {
		this.preid = preid;
	}
}
