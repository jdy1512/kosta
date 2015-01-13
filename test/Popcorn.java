public class PopcornStore{
	int popcornNo;
	int employeeNo;
	int storeSize;
	int storeFloor;

	public PopcornStore(){}
	
	public PopcornStore(int popcornNo, int employeeNo, int storeSize, int storeFloor){
		this.popcornNo = popcornNo;
		this.employeeNo = employeeNo;
		this.storeSize = storeSize;
		this.storeFloor = storeFloor;
	}
	
	public String toString(){
		return "popcornNo : "+popcornNo+", employeeNo : "+employeeNo+", storeSize : "
			+storeSize+", storeFloor : "+storeFloor;
	}
}