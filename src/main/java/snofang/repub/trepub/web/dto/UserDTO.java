package snofang.repub.trepub.web.dto;

import java.util.List;

import lombok.Data;
import snofang.repub.trepub.entity.RoleEntity;

@Data
public class UserDTO {
	private String email;
	private String username;
	private String password;
	private boolean enabled;
	private List<RoleEntity> roles;

}
