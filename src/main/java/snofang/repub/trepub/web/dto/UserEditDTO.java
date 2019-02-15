package snofang.repub.trepub.web.dto;

import lombok.Data;

@Data
public class UserEditDTO {
	private Long id;
	private String email;
	private String username;
	private String password;
	private boolean enabled;
}
