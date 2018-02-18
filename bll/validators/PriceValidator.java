package bll.validators;

import model.Product;

public class PriceValidator implements Validator<Product> {

	public boolean isValid(Product product) {
		return product.getPrice()>0;
	}

}
