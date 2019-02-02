package snofang.repub.trepub;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import snofang.repub.trepub.web.view.ItemView;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemsControllerTests extends BaseControllerTest{

	@Test
	public void TestItemsGet() throws Exception{
		String itemId = "7777";
		ResponseEntity<ItemView> i = restTemplate.getForEntity("/items/get?itemId=" + itemId, ItemView.class);
		assertThat(i.getBody().id.equals(itemId));
		
	}
}
