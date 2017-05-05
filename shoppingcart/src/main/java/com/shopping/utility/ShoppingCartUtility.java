/**
 * 
 */
package com.shopping.utility;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

public class ShoppingCartUtility {

	private PriceCalculationHelper priceCalculationHelper;

	private Map<String, Integer> cartItemsMap;

	public ShoppingCartUtility() {
		priceCalculationHelper = new PriceCalculationHelper();
	}

	public BigDecimal addItemToCart(List<String> items) {
		cartItemsMap = new HashMap<String, Integer>();
		cartItemsMap = populateCartItems(items);
		BigDecimal totalPrice = getTotalCartPrice(cartItemsMap);
		return totalPrice;
	}

	private BigDecimal getTotalCartPrice(Map<String, Integer> cartItemsMap) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		if (!CollectionUtils.isEmpty(cartItemsMap)) {
			for (Map.Entry<String, Integer> cartItem : cartItemsMap.entrySet()) {
				BigDecimal price = priceCalculationHelper.getPriceForItem(cartItem.getKey(), 
						                                                  cartItem.getValue());
				totalPrice = totalPrice.add(price);
			}
		}

		return totalPrice;
	}

	private Map<String, Integer> populateCartItems(List<String> items) {
		if (!CollectionUtils.isEmpty(items)) {
			for (String item : items) {
				if (cartItemsMap.containsKey(item)) {
					int quantity = cartItemsMap.get(item);
					cartItemsMap.put(item, ++quantity);
				} else {
					cartItemsMap.put(item, 1);
				}
			}
		}
		return cartItemsMap;
	}

}
