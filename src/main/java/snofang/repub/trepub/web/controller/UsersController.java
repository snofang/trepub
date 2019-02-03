package snofang.repub.trepub.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import snofang.repub.trepub.entity.UserEntity;
import snofang.repub.trepub.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@PostMapping("add")
	public UserEntity addUser(@RequestBody UserEntity userEntity) {
		return this.userService.createUser(userEntity);
	}
	
	@GetMapping("list")
	public Page<UserEntity> geUsers(@RequestParam String userName, @RequestParam Pageable page){
		return this.userService.getUsers(userName, page);
	}
}
							