package snofang.repub.trepub.web.controller;

import org.modelmapper.ModelMapper;
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
import snofang.repub.trepub.web.dto.UserEditDTO;
import snofang.repub.trepub.web.dto.UserViewDTO;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("add")
	public UserViewDTO addUser(@RequestBody UserEditDTO user) {
		UserEntity ue = this.modelMapper.map(user, UserEntity.class);
		ue = this.userService.createUser(ue);
		return this.modelMapper.map(ue, UserViewDTO.class);
	}
	
	@GetMapping("list")
	public Page<UserViewDTO> geUsers(@RequestParam String username, Pageable page){
		return this.userService.getUsers(username, page).map(ue -> this.modelMapper.map(ue, UserViewDTO.class));
	}
}
							