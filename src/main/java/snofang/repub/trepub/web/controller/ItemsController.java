package snofang.repub.trepub.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import snofang.repub.trepub.web.view.Item;

@RestController
public class ItemsController {
	
	@RequestMapping(method=RequestMethod.GET, path="/items/get")
	public Item GeItem(@RequestParam(name="itemId", defaultValue="0")String itemId) {
		return new Item(itemId, "hello again!");
	}
}
