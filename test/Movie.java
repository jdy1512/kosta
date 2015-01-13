public class Movie{
	String genre;
	String actor;
	String movieDirector;
	long movieTime;
	float grade;
	String synopsis;

	public Movie(){}
	
	public Movie(String genre, String actor, String movieDirector, 
		long movieTime, float grade, String synopsis){
		this.genre = genre;
		this.actor = actor;
		this.movieDirector = movieDirector;
		this.movieTime = movieTime;
		this.grade = grade;
		this.synopsis = synopsis;
	}
	
	public String toString(){
		return genre+", "+actor+", "+movieDirector+", "+movieTime+", "+grade+", "+synopsis;
	}
}