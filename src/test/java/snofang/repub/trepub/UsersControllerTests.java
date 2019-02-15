package snofang.repub.trepub;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import snofang.repub.trepub.entity.UserEntity;
import snofang.repub.trepub.web.dto.UserEditDTO;
import snofang.repub.trepub.web.dto.UserViewDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsersControllerTests extends BaseControllerTest {
	
	@Test
	public void TestUserCreationAndListing() throws Exception{
		//user creation
		UserEditDTO userEditDTO = new UserEditDTO();
		userEditDTO.setUsername(TestUtils.getNewUniqueName("un_"));
		userEditDTO.setPassword("trepub123");
		userEditDTO.setEmail(userEditDTO.getUsername()+ "@trepub.snofang");
		ResponseEntity<UserViewDTO> r = 
				restTemplate.postForEntity("/api/users/add", userEditDTO, UserViewDTO.class);
		assertThat(r.getBody().getId() > 0);
		
		Page<UserViewDTO> t;
		//user listing
		restTemplate.getForEntity("/api/users", Page<UserViewDTO>.getClass() )
		
	}


}
