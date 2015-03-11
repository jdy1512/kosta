public class Theater{
	int screenSize;
	int chairCnt;
	int theaterCost;
	boolean isCouple;
	boolean isVIP;
	int theaterNo;
	String curRunningMovieName;

	public Theater(){}
	
	public Theater(int screenSize, int chairCnt, int theaterCost, 
		boolean isCouple, boolean isVIP, int theaterNo, String curRunningMovieName){
		this.screenSize = screenSize;
		this.chairCnt = chairCnt;
		this.theaterCost = theaterCost;
		this.isCouple = isCouple;
		this.isVIP = isVIP;
		this.theaterNo = theaterNo;
		this.curRunningMovieName = curRunningMovieName;
	}
	
	public String toString(){
		return "screenSize : "+screenSize+", chairCnt : "+chairCnt+", theaterCost : "+theaterCost+", isCouple : "
			+isCouple+", isVIP : "+isVIP+", theaterNo : "+theaterNo+", curRunningMovieName : "+curRunningMovieName;
	}
}