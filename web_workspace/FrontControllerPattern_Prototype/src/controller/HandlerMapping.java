package controller;

public class HandlerMapping {

	public static Controller getController(String command) {
		Controller controller = null;

		// 업무처리 컨트롤러 호출
		if (command.equals("register")) {
			// 등록 컨트롤러 호출
			controller = new RegisterController();
		} else if (command.equals("search")) {
			// 조회 컨트롤러 호출
			controller = new SearchController();
		} else if (command.equals("link")) {
			controller = new LinkController();
		}

		return controller;
	}
}
