package bll.validators;

import model.Product;

public class StockValidator implements Validator<Product> {

	public boolean isValid(Product product) {
		return product.getStock()>=0;
	}

}
