package snofang.repub.trepub.web.view;


public class Item {
	public String id;
	public String content;
	public String getId() {
		return id;
	}
	public Item(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
