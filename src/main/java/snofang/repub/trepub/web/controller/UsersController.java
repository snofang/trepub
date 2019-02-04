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
import snofang.repub.trepub.service.UtilService;
import snofang.repub.trepub.web.dto.UserDTO;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UtilService utilService;
	
	@PostMapping("add")
	public UserEntity addUser(@RequestBody UserDTO user) {
		return this.userService.createUser(this.utilService.map(user, UserEntity.class));
	}
	
	@GetMapping("list")
	public Page<UserDTO> geUsers(@RequestParam String username, @RequestParam Pageable page){
		return this.userService.getUsers(username, page);
	}
}
							