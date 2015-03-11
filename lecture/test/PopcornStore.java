public class PopcornStore{
	int popcornCnt;
	int employeeCnt;
	int storeSize;
	int storeFloor;

	public PopcornStore(){}
	
	public PopcornStore(int popcornCnt, int employeeCnt, int storeSize, int storeFloor){
		this.popcornCnt = popcornCnt;
		this.employeeCnt = employeeCnt;
		this.storeSize = storeSize;
		this.storeFloor = storeFloor;
	}
	
	public String toString(){
		return "popcornCnt : "+popcornCnt+", employeeCnt : "+employeeCnt+", storeSize : "
			+storeSize+", storeFloor : "+storeFloor;
	}
}