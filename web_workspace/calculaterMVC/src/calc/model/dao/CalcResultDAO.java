package calc.model.dao;

public class CalcResultDAO {
	private static CalcResultDAO instance = new CalcResultDAO();
	
	public static CalcResultDAO getInstance() {
		return instance;
	}
}
