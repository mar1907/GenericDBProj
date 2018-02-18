package bll.validators;

import bll.validators.Validator;
import model.Product_Order;

public class QuantityValidator implements Validator<Product_Order> {

	public boolean isValid(Product_Order product_order) {
		return product_order.getQuantity()>0;
	}

}
