package common.controller;

import category.controller.FirstCategoryController;
import category.controller.GetProductInfoController;
import category.controller.ProductListController;
import category.controller.SecondCategoryController;
import category.controller.ThirdCategoryController;

public class HandlerMapping {

	public static Controller getController(String command){
		Controller controller = null;
		if(command.equals("first_category")){
			controller = new FirstCategoryController();
		}else if(command.equals("second_category")){
			controller = new SecondCategoryController();
		}else if(command.equals("third_category")){
			controller = new ThirdCategoryController();
		}else if(command.equals("get_product_list")){
			controller = new ProductListController();
		}else if(command.equals("get_product_info")){
			controller = new GetProductInfoController();
		}
		return controller;
	}
}
