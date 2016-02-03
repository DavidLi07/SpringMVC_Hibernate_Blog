package blog.wl.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.wl.model.User;
import blog.wl.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;	
		
	public UserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value={"/users"}, method= RequestMethod.GET)
	public String list(Model model){

		 model.addAttribute("list",userService.list());
	
		return "user/list";	
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());
		return "user/useradd";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated User user,BindingResult br) {
		if(br.hasErrors()) {
			return "user/useradd";
		}
		userService.add(user);		
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id, Model model){
		model.addAttribute(userService.load(id));
		return "user/usershow";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute(userService.load(id));
		return "user/userupdate";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated User user,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "user/userupdate";
		}
		User u=userService.load(id);
		u.setPassword(user.getPassword());
		u.setNickname(user.getNickname());
		u.setEmail(user.getEmail());
		userService.update(u);		
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/user/users";
	}
}
