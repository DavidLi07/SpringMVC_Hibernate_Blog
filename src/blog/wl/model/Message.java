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
@Table(name="Blog_Message")
public class Message {
	private int messageid;
	private int id;
	private String messagecontent;
	private String messagename;
	private Date mdate;
	private String messagephoto;
	private String messagetype;
	private String albumid;
	private String messagereply;
		
	@SequenceGenerator(name = "blogmessage_sequence",allocationSize=1,initialValue=1,sequenceName="blogmessage_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogmessage_sequence")
	@Id
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@NotEmpty(message="Content can not be null!")
	public String getMessagecontent() {
		return messagecontent;
	}
	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}
	@NotEmpty(message="Name can not be null!")
	public String getMessagename() {
		return messagename;
	}
	public void setMessagename(String messagename) {
		this.messagename = messagename;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public String getMessagephoto() {
		return messagephoto;
	}
	public void setMessagephoto(String messagephoto) {
		this.messagephoto = messagephoto;
	}
	public String getMessagetype() {
		return messagetype;
	}
	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}
	public String getAlbumid() {
		return albumid;
	}
	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}
	public String getMessagereply() {
		return messagereply;
	}
	public void setMessagereply(String messagereply) {
		this.messagereply = messagereply;
	}
	
}
