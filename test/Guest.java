public class Guest{
	String name;
	int age;
	String gender;
	String addr;
	int money;
	int movieCnt;

	public Guest(){}
	
	public Guest(String genre, int age, String gender, 
		String addr, int money, int movieCnt){
		this.genre = genre;
		this.age = age;
		this.gender = gender;
		this.addr = addr;
		this.money = money;
		this.movieCnt = movieCnt;
	}
	
	public String toString(){
		return "genre : "+genre+", age : "+age+", gender : "+gender+", addr : "
			+addr+", money : "+money+", movieCnt : "+movieCnt;
	}
}