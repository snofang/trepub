package snofang.repub.trepub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.boot.web.server.LocalServerPort;

public abstract class BaseControllerTest {

	@LocalServerPort
	protected int port;
	
	@Autowired
	protected TestRestTemplate restTemplate;
	
	public BaseControllerTest() {
		restTemplate.setUriTemplateHandler(new RootUriTemplateHandler("http://localhost:" + port));
	}

}
