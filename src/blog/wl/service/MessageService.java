package blog.wl.service;

import java.util.List;

import blog.wl.model.Message;
import blog.wl.model.Pager;

public interface MessageService {
	public void add(Message message);
	public void update(Message message);
	public void delete(int messageid);
	public Message load(int messageid);
	public List<Message> list();
	public List<Message> loadByMessagetype(String messagetype);
	public Pager<Message> find();
	public Pager<Message> findByMessagetype(String messagetype);
 
}
