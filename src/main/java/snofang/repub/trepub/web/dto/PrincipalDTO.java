package snofang.repub.trepub.web.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * as a custom principal
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String email;

}
