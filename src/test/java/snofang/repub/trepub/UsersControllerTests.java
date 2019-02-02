package snofang.repub.trepub;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import snofang.repub.trepub.entity.UserEntity;
import snofang.repub.trepub.web.view.ItemView;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsersControllerTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
	public void TestItemsGet() throws Exception{
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(TestUtils.getNewUniqueName("un_"));
		userEntity.setPassword("trepub123");
		userEntity.setEmail(userEntity.getUsername()+ "@trepub.snofang");
		ResponseEntity<ItemView> i = restTemplate.postForEntity("/api/users" + itemId, ItemView.class);
		assertThat(i.getBody().id.equals(itemId));
		
	}


}
