package blog.wl.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.wl.model.Album;
import blog.wl.model.Message;
import blog.wl.model.User;
import blog.wl.model.UserInfo;
import blog.wl.service.AlbumService;
import blog.wl.service.MessageService;
import blog.wl.service.UserInfoService;
import blog.wl.service.UserService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	private UserService userService; // 4 services
	private UserInfoService userinfoService;
	private AlbumService albumService;
	private MessageService messageService;

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserInfoService getUserinfoService() {
		return userinfoService;
	}

	@Resource
	public void setUserinfoService(UserInfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public AlbumService getAlbumService() {
		return albumService;
	}

	@Resource
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	@Resource
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	// Manager index
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("load", userinfoService.listByUsername("Recommend"));
		model.addAttribute("loadnew", userinfoService.listByUsername("New"));
		return "/manager/index";
	}

	// aboutme and edit
	@RequestMapping(value = "/aboutme", method = RequestMethod.GET)
	public String aboutme(Model model) {
		model.addAttribute("aboutme", userService.load(22));
		return "/manager/aboutme";
	}

	@RequestMapping(value = "/{id}/aboutmeedit", method = RequestMethod.GET)
	public String aboutmeedit(@PathVariable int id, Model model) {
		model.addAttribute(userService.load(id));
		return "/manager/aboutmeedit";
	}

	@RequestMapping(value = "/{id}/aboutmeedit", method = RequestMethod.POST)
	public String update(@PathVariable int id, @Validated User user,
			BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "/manager/aboutmeedit";
		}
		User tu = userService.load(id);
		tu.setPassword(user.getPassword());
		tu.setNickname(user.getNickname());
		tu.setEmail(user.getEmail());
		userService.update(tu);
		return "redirect:/manager/aboutme";
	}

	// Message and message delete and reply
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message(Model model) {
		// model.addAttribute("messagelist",messageService.list());
		model.addAttribute("messagelist",
				messageService.findByMessagetype("Message"));
		return "/manager/message";
	}

	@RequestMapping(value = "/{messageid}/messagedelete", method = RequestMethod.GET)
	public String messagedelete(@PathVariable int messageid) {
		messageService.delete(messageid);
		return "redirect:/manager/message";
	}

	@RequestMapping(value = "/{messageid}/messagereply", method = RequestMethod.GET)
	public String messagereply(@PathVariable int messageid, Model model) {
		model.addAttribute(messageService.load(messageid));
		return "/manager/messagereply";
	}

	@RequestMapping(value = "/{messageid}/messagereply", method = RequestMethod.POST)
	public String messagereply(@PathVariable int messageid,
			@Validated Message message, BindingResult br, Model model) {
/*		if (br.hasErrors()) {
			return "/manager/messagereply";
		}*/
		Message me = messageService.load(messageid);
		me.setMessagereply(message.getMessagereply());
		//me.setId(message.getId());
		messageService.update(me);
		return "redirect:/manager/message";
	}

	// Display album and add album
	@RequestMapping(value = "/album", method = RequestMethod.GET)
	public String album(Model model) {
		// model.addAttribute("albumlist",albumService.list());
		model.addAttribute("albumlist", albumService.list());
		model.addAttribute("albumreply",
				messageService.loadByMessagetype("Photo"));
		// model.addAttribute("albumcomment",new Message());
		return "/manager/album";
	}

	// album 4 types
	@RequestMapping(value = "/albumme", method = RequestMethod.GET)
	public String albumme(Model model) {
		model.addAttribute("album", albumService.listByPhotoname("Me"));
		return "/manager/albumtype";
	}

	@RequestMapping(value = "/albumcool", method = RequestMethod.GET)
	public String albumcool(Model model) {
		model.addAttribute("album", albumService.listByPhotoname("Cool"));
		return "/manager/albumtype";
	}

	@RequestMapping(value = "/albumbeauty", method = RequestMethod.GET)
	public String albumbeauty(Model model) {
		model.addAttribute("album", albumService.listByPhotoname("Beauty"));
		return "/manager/albumtype";
	}

	@RequestMapping(value = "/albumsea", method = RequestMethod.GET)
	public String albumsea(Model model) {
		model.addAttribute("album", albumService.listByPhotoname("Sea"));
		return "/manager/albumtype";
	}
	
	@RequestMapping(value = "/addalbum", method = RequestMethod.GET)
	public String addalbum(Model model) {
		model.addAttribute("addalbum", new Album());
		return "/manager/albumadd";
	}

	@RequestMapping(value = "/addalbum", method = RequestMethod.POST)
	public String addalbum(@Validated Album album, BindingResult br) {
		if (br.hasErrors()) {
			return "/manager/albumadd";
		}
		album.setPhoto(album.getPhoto().substring(35));
		album.setPdate(new Date());
		albumService.add(album);
		return "redirect:/manager/album";
	}

	// Album comment delete and reply
	@RequestMapping(value = "/{messageid}/albumreplydelete", method = RequestMethod.GET)
	public String albumreplydelete(@PathVariable int messageid) {
		messageService.delete(messageid);
		return "redirect:/manager/album";
	}

	@RequestMapping(value = "/{messageid}/albumreplyreply", method = RequestMethod.GET)
	public String albumreplyreply(@PathVariable int messageid, Model model) {
		model.addAttribute("albumreplyreply", messageService.load(messageid));
		return "/manager/albumreplyreply";
	}

	@RequestMapping(value = "/{messageid}/albumreplyreply", method = RequestMethod.POST)
	public String albumreplyreply(@PathVariable int messageid,
			@Validated Message message, BindingResult br, Model model) {
/*		if (br.hasErrors()) {
			return "/manager/albumreplyreply";
		}*/
		Message me = messageService.load(messageid);
		me.setMessagereply(message.getMessagereply());
		//me.setId(message.getId());
		messageService.update(me);
		return "redirect:/manager/album";
	}

	// Album delete and edit
	@RequestMapping(value = "/{albumid}/albumdelete", method = RequestMethod.GET)
	public String albumdelete(@PathVariable int albumid) {
		albumService.delete(albumid);
		return "redirect:/manager/album";
	}

	@RequestMapping(value = "/{albumid}/albumedit", method = RequestMethod.GET)
	public String albumedit(@PathVariable int albumid, Model model) {
		model.addAttribute("album", albumService.load(albumid));
		return "/manager/albumedit";
	}

	@RequestMapping(value = "/{albumid}/albumedit", method = RequestMethod.POST)
	public String albumedit(@PathVariable int albumid, @Validated Album album,
			BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "/manager/albumedit";
		}
		Album al = albumService.load(albumid);
		al.setAlbum(album.getAlbum());
		al.setPhoto(album.getPhoto());
		albumService.update(al);
		return "redirect:/manager/album";
	}

	// Photo details, add photo and edit photo delete photo
	@RequestMapping(value = "/{albumid}/albumdetail", method = RequestMethod.GET)
	public String albumdetail(@PathVariable int albumid, Model model) {
		model.addAttribute("albumdetail", albumService.load(albumid));
		model.addAttribute("albumreply",
				messageService.loadByMessagetype("Photo"));
		return "/manager/albumdetail";
	}

	@RequestMapping(value = "/{albumid}/addphoto", method = RequestMethod.GET)
	public String addphoto(@PathVariable int albumid, Model model) {
		model.addAttribute("addphoto", new Album());
		return "/manager/albumdetailadd";
	}

	@RequestMapping(value = "/{albumid}/addphoto", method = RequestMethod.POST)
	public String addphoto(@PathVariable int albumid, @Validated Album album,
			BindingResult br) {
		if (br.hasErrors()) {
			return "/manager/albumdetailadd";
		}
		albumService.add(album);
		return "redirect:/manager/{albumid}/albumdetail";
	}

	@RequestMapping(value = "/{albumid}/{albumid}/photodelete", method = RequestMethod.GET)
	public String photodelete(@PathVariable int albumid) {
		albumService.delete(albumid);
		return "redirect:/manager/album";
	}

	@RequestMapping(value = "/{albumid}/{albumid}/photoedit", method = RequestMethod.GET)
	public String photoedit(@PathVariable int albumid, Model model) {
		model.addAttribute("album", albumService.load(albumid));
		return "/manager/albumdetailedit";
	}

	@RequestMapping(value = "/{albumid}/{albumid}/photoedit", method = RequestMethod.POST)
	public String photoedit(@PathVariable int albumid, @Validated Album album,
			BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "/manager/albumdetailedit";
		}
		Album al = albumService.load(albumid);
		al.setAlbum(album.getAlbum());
		al.setPhoto(album.getPhoto());
		albumService.update(al);
		return "redirect:/manager/{albumid}/albumdetail";
	}

	// Photo comment delete and reply
	@RequestMapping(value = "/{albumid}/{messageid}/photoreplydelete", method = RequestMethod.GET)
	public String photoreplydelete(@PathVariable int albumid,@PathVariable int messageid) {
		messageService.delete(messageid);
		return "redirect:/manager/{albumid}/albumdetail";
	}

	@RequestMapping(value = "/{albumid}/{messageid}/photoreplyreply", method = RequestMethod.GET)
	public String photoreplyreply(@PathVariable int messageid, Model model) {
		model.addAttribute("photoreplyreply", messageService.load(messageid));
		return "/manager/albumdetailreplyreply";
	}

	@RequestMapping(value = "/{albumid}/{messageid}/photoreplyreply", method = RequestMethod.POST)
	public String photoreplyreply(@PathVariable int messageid,
			@Validated Message message, BindingResult br, Model model) {
/*		if (br.hasErrors()) {
			return "/manager/albumdetailreplyreply";
		}*/
		Message me = messageService.load(messageid);
		me.setMessagereply(message.getMessagereply());
		//me.setId(message.getId());
		messageService.update(me);
		return "redirect:/manager/{albumid}/albumdetail";
	}
	
	// Article
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public String article(Model model) {
		model.addAttribute("pagers", userinfoService.find());
		// model.addAttribute("articlelist",userinfoService.list());
		return "/manager/article";
	}

	// Article four types
	@RequestMapping(value = "/dairy", method = RequestMethod.GET)
	public String articledairy(Model model) {
		model.addAttribute("type", userinfoService.listByType("Dairy"));
		return "/manager/articletype";
	}

	@RequestMapping(value = "/life", method = RequestMethod.GET)
	public String articlelife(Model model) {
		model.addAttribute("type", userinfoService.listByType("Life"));
		return "/manager/articletype";
	}

	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public String articleweather(Model model) {
		model.addAttribute("type", userinfoService.listByType("Weather"));
		return "/manager/articletype";
	}

	@RequestMapping(value = "/mood", method = RequestMethod.GET)
	public String articlemood(Model model) {
		model.addAttribute("type", userinfoService.listByType("Mood"));
		return "/manager/articletype";
	}

	// Article details
	@RequestMapping(value = "/{id}/articledetail", method = RequestMethod.GET)
	public String articledetail(@PathVariable int id, Model model) {
		model.addAttribute("articledetail", userinfoService.load(id));
		// model.addAttribute("articlereply",userinfoService.list());
		model.addAttribute("articlereply",
				messageService.loadByMessagetype("Article"));
		return "/manager/articledetail";
	}

	// Article add, delete and edit
	@RequestMapping(value = "/addarticle", method = RequestMethod.GET)
	public String addarticle(Model model) {
		model.addAttribute(new UserInfo());
		return "/manager/articleadd";
	}

	@RequestMapping(value = "/addarticle", method = RequestMethod.POST)
	public String addarticle(@Validated UserInfo userInfo, BindingResult br) {
		if (br.hasErrors()) {
			return "/manager/articleadd";
		}	
		userInfo.setBdate(new Date());
		userInfo.setNextid(1);
		userInfo.setPreid(1);
		userInfo.getPhoto();
		String str = userInfo.getPhoto().substring(35);
		userInfo.setPhoto(str);	
	//	System.out.println(userInfo.getPhoto());
		userinfoService.add(userInfo);
		return "redirect:/manager/article";
	}

	@RequestMapping(value = "/{id}/articledelete", method = RequestMethod.GET)
	public String articledelete(@PathVariable int id) {
		userinfoService.delete(id);
		return "redirect:/manager/article";
	}

	@RequestMapping(value = "/{id}/articleedit", method = RequestMethod.GET)
	public String articleedit(@PathVariable int id, Model model) {
		model.addAttribute("article", userinfoService.load(id));
		return "/manager/articleedit";
	}

	@RequestMapping(value = "/{id}/articleedit", method = RequestMethod.POST)
	public String articleedit(@PathVariable int id,
			@Validated UserInfo userinfo, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "/manager/articleedit";
		}
		UserInfo article = userinfoService.load(id);
		article.setTitle(userinfo.getTitle());
		article.setAuthor(userinfo.getAuthor());
		article.setType(userinfo.getType());
		article.setUsername(userinfo.getUsername());
		//article.setPhoto(userinfo.getPhoto().substring(35));
		article.setPhoto(userinfo.getPhoto());
		article.setContent(userinfo.getContent());
		userinfoService.update(article);
		return "redirect:/manager/article";
	}

	// Article comment delete and reply
	@RequestMapping(value = "/{id}/{messageid}/articlereplydelete", method = RequestMethod.GET)
	public String articlereplydelete(@PathVariable int id,
			@PathVariable int messageid) {
		messageService.delete(messageid);
		return "redirect:/manager/{id}/articledetail";
	}

	@RequestMapping(value = "/{id}/{messageid}/articlereplyreply", method = RequestMethod.GET)
	public String articlereplyreply(@PathVariable int id,
			@PathVariable int messageid, Model model) {
		model.addAttribute("articlereplyreply", messageService.load(messageid));
		return "/manager/articlereplyreply";
	}

	@RequestMapping(value = "/{id}/{messageid}/articlereplyreply", method = RequestMethod.POST)
	public String articlereplyreply(@PathVariable int id,
			@PathVariable int messageid, @Validated Message message,
			BindingResult br, Model model) {
/*		if (br.hasErrors()) {
			return "/manager/articlereplyreply";
		}*/
		Message me = messageService.load(messageid);
		me.setMessagereply(message.getMessagereply());
		//me.setId(message.getId());
		messageService.update(me);
		return "redirect:/manager/{id}/articledetail";
	}

}
