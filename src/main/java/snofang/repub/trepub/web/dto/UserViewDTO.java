package snofang.repub.trepub.web.dto;

import lombok.Data;

@Data
public class UserViewDTO {
	private Long id;
	private String email;
	private String username;
	private boolean enabled;
}
