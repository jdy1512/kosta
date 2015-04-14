package json;

public class Address {
	private String zipcode;
	private String addressDetail;

	public Address(String zipcode, String addressDetail) {
		super();
		this.zipcode = zipcode;
		this.addressDetail = addressDetail;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

}
