package snofang.repub.trepub;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import snofang.repub.trepub.entity.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsersControllerTests extends BaseControllerTest {
	
	@Test
	public void TestItemsGet() throws Exception{
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(TestUtils.getNewUniqueName("un_"));
		userEntity.setPassword("trepub123");
		userEntity.setEmail(userEntity.getUsername()+ "@trepub.snofang");
		ResponseEntity<UserEntity> r = restTemplate.postForEntity("/api/users/add", userEntity, UserEntity.class);
		assertThat(r.getBody().getId() > 0);
	}


}
