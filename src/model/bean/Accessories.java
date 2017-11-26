package model.bean;

public class Accessories {
	private int accessoriesId;
	private String accessoriesName;
	private long price;
	private int size;
	private int quantity;
	private String image;
	private String color;
	private String description;

	public Accessories() {
		super();
	}
	
	public Accessories(int accessoriesId, String accessoriesName, long price, int size, int quantity, String image,
			String color, String description) {
		super();
		this.accessoriesId = accessoriesId;
		this.accessoriesName = accessoriesName;
		this.price = price;
		this.size = size;
		this.quantity = quantity;
		this.image = image;
		this.color = color;
		this.description = description;
	}

	public int getAccessoriesId() {
		return accessoriesId;
	}
	public void setAccessoriesId(int accessoriesId) {
		this.accessoriesId = accessoriesId;
	}
	public String getAccessoriesName() {
		return accessoriesName;
	}
	public void setAccessoriesName(String accessoriesName) {
		this.accessoriesName = accessoriesName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Accessories [accessoriesId=" + accessoriesId + ", accessoriesName=" + accessoriesName + ", price="
				+ price + ", size=" + size + ", quantity=" + quantity + ", image=" + image + ", color=" + color
				+ ", description=" + description + "]";
	}
	
}
