import kr.or.kosta.Worker;
import kr.or.kosta.temp.TempWorker;

public class Caller{
	
	public static void main(String[] args){
		Worker w = new Worker();
		w.go();
		
		
		TempWorker w2 = new TempWorker();
		w2.come();
	}
}