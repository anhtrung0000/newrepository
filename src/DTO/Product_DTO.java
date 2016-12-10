package DTO;

public class Product_DTO {
	int productId, productCategoryId;
	String productName,color,size, images, Decription;
	float price;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getDecription() {
		return Decription;
	}
	public void setDecription(String decription) {
		Decription = decription;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product_DTO [productId=" + productId + ", productCategoryId="
				+ productCategoryId + ", productName=" + productName
				+ ", color=" + color + ", size=" + size + ", images=" + images
				+ ", Decription=" + Decription + ", price=" + price + "]";
	}
	
}
