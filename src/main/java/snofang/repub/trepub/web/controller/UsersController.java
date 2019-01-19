package snofang.repub.trepub.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import snofang.repub.trepub.entity.UserEntity;
import snofang.repub.trepub.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/list")
	public Page<UserEntity> GeUsers(){
		return null;
	}
}
							