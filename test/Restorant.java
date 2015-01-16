public class Restorant{
	int foodCnt;
	int employeeCnt;
	int storeSize;
	int storeFloor;

	public Restorant(){}
	
	public Restorant(int foodCnt, int employeeCnt, int storeSize, int storeFloor){
		this.foodCnt = foodCnt;
		this.employeeCnt = employeeCnt;
		this.storeSize = storeSize;
		this.storeFloor = storeFloor;
	}
	
	public String toString(){
		return "foodCnt : "+foodCnt+", employeeCnt : "+employeeCnt+", storeSize : "
			+storeSize+", storeFloor : "+storeFloor;
	}
}