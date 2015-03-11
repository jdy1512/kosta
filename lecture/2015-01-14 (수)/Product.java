public class Product{
	int productNo;
	String productName;
	int price;
	String maker;
	int stock;
	String info;
	
	public Product(){}
	public Product(int pNo, String pName, int pCost, String pMaker){
		productNo = pNo;
		productName = pName;
		price = pCost;
		maker = pMaker;
	}
	public Product(int pNo, String pName, int pCost, String pMaker, int pStock, String pInfo){
		productNo = pNo;
		productName = pName;
		price = pCost;
		maker = pMaker;
		stock = pStock;
		info = pInfo;
	}
	
	public String getDetails(){
		return "productNo : "+productNo+", productName : "+productName+", price : "+price
			+", maker : "+maker+", stock : "+stock+", info : "+info;
	}
}