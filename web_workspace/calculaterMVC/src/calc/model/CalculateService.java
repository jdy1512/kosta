package calc.model;

public class CalculateService {
	private static CalculateService instance = new CalculateService();
	
	public static CalculateService getInstance() {
		return instance;
	}

	public int plus(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	public int minus(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}
}
