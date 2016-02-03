package blog.wl.dao;

import java.util.List;

import blog.wl.model.Message;
import blog.wl.model.Pager;

public interface MessageDao {
	public void add(Message message);
	public void update(Message message);
	public void delete(int messageid);
	public Message load(int messageid);
	public List<Message> list();
	public Message loadByMessagename(String messagename);
	public List<Message> loadByMessagetype(String messagetype);
	public Pager<Message> find();
	public Pager<Message> findByMessagetype(String messagetype);
}
