package blog.wl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.wl.dao.MessageDao;
import blog.wl.model.Message;
import blog.wl.model.Pager;

@Service("messageService")
public class MessageServiceImple implements MessageService {
	
	private MessageDao messageDao;
	
	public MessageDao getMessageDao() {
		return messageDao;
	}

	@Resource
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public void add(Message message) {
		messageDao.add(message);

	}

	@Override
	public void update(Message message) {
		messageDao.update(message);

	}

	@Override
	public void delete(int messageid) {
		messageDao.delete(messageid);

	}

	@Override
	public Message load(int messageid) {
		return messageDao.load(messageid);
	}

	@Override
	public List<Message> list() {
		return messageDao.list();
	}

	@Override
	public List<Message> loadByMessagetype(String messagetype) {
		// TODO Auto-generated method stub
		return messageDao.loadByMessagetype(messagetype);
	}

	@Override
	public Pager<Message> find() {
		// TODO Auto-generated method stub
		return messageDao.find();
	}

	@Override
	public Pager<Message> findByMessagetype(String messagetype) {
		// TODO Auto-generated method stub
		return messageDao.findByMessagetype(messagetype);
	}

}
