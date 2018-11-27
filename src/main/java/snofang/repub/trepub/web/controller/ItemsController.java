package snofang.repub.trepub.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import snofang.repub.trepub.web.view.ItemView;

@RestController
public class ItemsController {
	
	@RequestMapping(method=RequestMethod.GET, path="/items/get")
	public ItemView GeItem(@RequestParam(name="itemId", defaultValue="0")String itemId) {
		return new ItemView(itemId, "hello again!");
	}
}
