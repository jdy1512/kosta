public class Cafe{
	int coffeeCnt;
	int employeeCnt;
	int storeSize;
	int storeFloor;

	public Cafe(){}
	
	public Cafe(int coffeeCnt, int employeeCnt, int storeSize, int storeFloor){
		this.coffeeCnt = coffeeCnt;
		this.employeeCnt = employeeCnt;
		this.storeSize = storeSize;
		this.storeFloor = storeFloor;
	}
	
	public String toString(){
		return "coffeeCnt : "+coffeeCnt+", employeeCnt : "+employeeCnt+", storeSize : "
			+storeSize+", storeFloor : "+storeFloor;
	}
}