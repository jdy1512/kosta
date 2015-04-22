package category.vo;

public class Product {
	private String productId;
	private String productName;
	private int productPrice;
	private String productMaker;
	private String productInfo;
	private String thirdCategoryId;
	
	public Product() {}

	public Product(String productId, String productName, int productPrice,
			String productMaker, String productInfo, String thirdCategoryId) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productMaker = productMaker;
		this.productInfo = productInfo;
		this.thirdCategoryId = thirdCategoryId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductMaker() {
		return productMaker;
	}

	public void setProductMaker(String productMaker) {
		this.productMaker = productMaker;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getThirdCategoryId() {
		return thirdCategoryId;
	}

	public void setThirdCategoryId(String thirdCategoryId) {
		this.thirdCategoryId = thirdCategoryId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productPrice=" + productPrice
				+ ", productMaker=" + productMaker + ", productInfo="
				+ productInfo + ", thirdCategoryId=" + thirdCategoryId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((productInfo == null) ? 0 : productInfo.hashCode());
		result = prime * result
				+ ((productMaker == null) ? 0 : productMaker.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productPrice;
		result = prime * result
				+ ((thirdCategoryId == null) ? 0 : thirdCategoryId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productInfo == null) {
			if (other.productInfo != null)
				return false;
		} else if (!productInfo.equals(other.productInfo))
			return false;
		if (productMaker == null) {
			if (other.productMaker != null)
				return false;
		} else if (!productMaker.equals(other.productMaker))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice != other.productPrice)
			return false;
		if (thirdCategoryId == null) {
			if (other.thirdCategoryId != null)
				return false;
		} else if (!thirdCategoryId.equals(other.thirdCategoryId))
			return false;
		return true;
	}
}
