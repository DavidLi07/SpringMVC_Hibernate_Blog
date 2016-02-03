package blog.wl.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import blog.wl.model.Message;
import blog.wl.model.User;
import blog.wl.model.UserInfo;
import blog.wl.service.AlbumService;
import blog.wl.service.MessageService;
import blog.wl.service.UserInfoService;
import blog.wl.service.UserService;

@Controller
@SessionAttributes("loginUser")
public class IndexController {
	private UserService userService; // userService use userDao
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

	// User login and logout
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, Model model) {
		User u = userService.login(username, password);
		model.addAttribute("loginUser", u);
		return "redirect:/manager/index";
	}

	@RequestMapping("/manager/logout")
	public String logout(Model model, HttpSession session) {
		model.asMap().remove("loginUser");
		session.invalidate();
		return "redirect:/login";
	}

	// Index
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		// model.addAttribute("load",userinfoService.load(2));
		model.addAttribute("load", userinfoService.listByUsername("Recommend"));
		model.addAttribute("loadnew", userinfoService.listByUsername("New"));
		// model.addAttribute("loadarticle",userinfoService.load(1));
		return "index";
	}

	/*
	 * @RequestMapping(value="/blog",method=RequestMethod.GET) public String
	 * blog(){ return "blog"; }
	 */
	// About me
	@RequestMapping(value = "/aboutme", method = RequestMethod.GET)
	public String aboutme(Model model) {
		model.addAttribute("aboutme", userService.load(22));
		model.addAttribute("test",userinfoService.list());
		//model.addAttribute("test",userinfoService.loadByRowbumber(2));
		return "aboutme";
	}

	// Message and leave a message
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message(Model model) {
		// model.addAttribute("messagelist",messageService.list());
		// model.addAttribute("messagelist",messageService.loadByMessagetype("Message"));
		model.addAttribute("messagelist",
				messageService.findByMessagetype("Message")); // display message
		model.addAttribute(new Message()); // leave a message
		return "message";
	}

	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public String message(@Validated Message message, BindingResult br) {
		if (br.hasErrors()) {
			return "/message";
		}
		message.setMdate(new Date()); // set Date and type
		message.setMessagetype("Message");
		messageService.add(message);
		return "redirect:/message";
	}

	// Album display and comment and leave a comment
	@RequestMapping(value = "/album", method = RequestMethod.GET)
	public String album(Model model) {
		model.addAttribute("albumlist", albumService.list());
		model.addAttribute("albumreply",
				messageService.loadByMessagetype("Photo")); // album comment
		model.addAttribute(new Message());    //zhi neng yong new Message() dangzuo message
		// model.addAttribute("album2",albumService.load(1));
		return "album";
	}

	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String album(@Validated Message message, BindingResult br) {
		if (br.hasErrors()) {
			return "album";
		}
		message.setMdate(new Date());
		message.setMessagetype("Photo");
		messageService.add(message);
		return "redirect:/album";
	}

	// album 4 types
	@RequestMapping(value = "/albumme", method = RequestMethod.GET)
	public String albumme(Model model) {
		model.addAttribute("album", albumService.listByPhotoname("Me"));
		return "albumtype";
	}

	@RequestMapping(value = "/albumcool", method = RequestMethod.GET)
	public String albumcool(Model model) {
		model.addAttribute("album", albumService.listByPhotoname("Cool"));
		return "albumtype";
	}

	@RequestMapping(value = "/albumbeauty", method = RequestMethod.GET)
	public String albumbeauty(Model model) {
		model.addAttribute("album", albumService.listByPhotoname("Beauty"));
		return "albumtype";
	}

	@RequestMapping(value = "/albumsea", method = RequestMethod.GET)
	public String albumsea(Model model) {
		model.addAttribute("album", albumService.listByPhotoname("Sea"));
		return "albumtype";
	}

	// Album detail, photo comment and leave a comment
	@RequestMapping(value = "/{albumid}/albumdetail", method = RequestMethod.GET)
	public String albumdetail(@PathVariable int albumid, Model model) {
		model.addAttribute("albumdetail", albumService.load(albumid));
		model.addAttribute("albumreply",
				messageService.loadByMessagetype("Photo"));
		model.addAttribute(new Message());
		return "albumdetail";
	}

	@RequestMapping(value = "/{albumid}/albumdetail", method = RequestMethod.POST)
	public String albumdetail(@Validated Message message, BindingResult br) {
		if (br.hasErrors()) {
			return "/albumdetail";
		}
		message.setMdate(new Date());
		message.setMessagetype("Photo");
		messageService.add(message);
		return "redirect:/{albumid}/albumdetail";
	}

	// article display
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public String article(Model model) {
		model.addAttribute("pagers", userinfoService.find());

		// model.addAttribute("articlelist",userinfoService.list());
		return "article";
	}

	// article 4 types
	@RequestMapping(value = "/dairy", method = RequestMethod.GET)
	public String articledairy(Model model) {
		model.addAttribute("type", userinfoService.listByType("Dairy"));
		return "articletype";
	}

	@RequestMapping(value = "/life", method = RequestMethod.GET)
	public String articlelife(Model model) {
		model.addAttribute("type", userinfoService.listByType("Life"));
		return "articletype";
	}

	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public String articleweather(Model model) {
		model.addAttribute("type", userinfoService.listByType("Weather"));
		return "articletype";
	}

	@RequestMapping(value = "/mood", method = RequestMethod.GET)
	public String articlemood(Model model) {
		model.addAttribute("type", userinfoService.listByType("Mood"));
		return "articletype";
	}

	// Article details
	@RequestMapping(value = "/{id}/articledetail", method = RequestMethod.GET)
	public String articledetail(@PathVariable int id,Model model) {
		//model.addAttribute("articledetail", userinfoService.load(id));
		model.addAttribute("articledetail", userinfoService.load(id));
		UserInfo nextid = new UserInfo();
		System.out.println(id);
		//System.out.println(userinfoService.loadpreByid(id));
		if(id==1){
			nextid.setPreid(userinfoService.load(id).getId());
	        nextid.setNextid(userinfoService.loadnextidByid(id).getId());
			//nextid.setPreid(userinfoService.loadpreByid(id).getId());
	       // nextid.setPreid(userinfoService.load(id).getPreid());
			nextid.setId(userinfoService.load(id).getId());			
			nextid.setTitle(userinfoService.load(id).getTitle());
			nextid.setContent(userinfoService.load(id).getContent());
			nextid.setAuthor(userinfoService.load(id).getAuthor());
			nextid.setBdate(userinfoService.load(id).getBdate());
			nextid.setUsername(userinfoService.load(id).getUsername());
			nextid.setPhoto(userinfoService.load(id).getPhoto());
			nextid.setType(userinfoService.load(id).getType());
			System.out.println(nextid.getNextid());
			System.out.println(nextid.getPreid());
			userinfoService.merge(nextid);
		}else if(id ==66){
			nextid.setPreid(userinfoService.loadpreByid(id).getId());
			nextid.setNextid(userinfoService.load(id).getId());
			nextid.setId(userinfoService.load(id).getId());		
			nextid.setTitle(userinfoService.load(id).getTitle());
			nextid.setContent(userinfoService.load(id).getContent());
			nextid.setAuthor(userinfoService.load(id).getAuthor());
			nextid.setBdate(userinfoService.load(id).getBdate());
			nextid.setUsername(userinfoService.load(id).getUsername());
			nextid.setPhoto(userinfoService.load(id).getPhoto());
			nextid.setType(userinfoService.load(id).getType());
			System.out.println(nextid.getNextid());
			System.out.println(nextid.getPreid());
			userinfoService.merge(nextid);
		}
		else{
            nextid.setNextid(userinfoService.loadnextidByid(id).getId());
			nextid.setPreid(userinfoService.loadpreByid(id).getId());
       // nextid.setPreid(userinfoService.load(id).getPreid());
		nextid.setId(userinfoService.load(id).getId());
		
		nextid.setTitle(userinfoService.load(id).getTitle());
		nextid.setContent(userinfoService.load(id).getContent());
		nextid.setAuthor(userinfoService.load(id).getAuthor());
		nextid.setBdate(userinfoService.load(id).getBdate());
		nextid.setUsername(userinfoService.load(id).getUsername());
		nextid.setPhoto(userinfoService.load(id).getPhoto());
		nextid.setType(userinfoService.load(id).getType());
		System.out.println(nextid.getNextid());
		System.out.println(nextid.getPreid());
		userinfoService.merge(nextid);
		}
		//userinfoService.update(nextid);
		// model.addAttribute("articlereply",userinfoService.list());
		model.addAttribute("articlereply",messageService.loadByMessagetype("Article"));
		model.addAttribute(new Message());
		return "articledetail";
	}

	@RequestMapping(value = "/{id}/articledetail", method = RequestMethod.POST)
	public String articledetail(@Validated Message message, BindingResult br) {
		if (br.hasErrors()) {
			return "/articledetail";
		}
		message.setMdate(new Date());
		message.setMessagetype("Article");
		messageService.add(message);
		return "redirect:/{id}/articledetail";
	}

}
