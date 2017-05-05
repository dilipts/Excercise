/**
 * 
 */
package com.shopping.utility;

import java.math.BigDecimal;

import com.shopping.domain.Item;

public class PriceCalculationHelper {
	
	

	

	public BigDecimal getPriceForItem(String name, int quantity) {
		switch (name) {
			case Item.APPLE:
				// 0.35 * quantity;
				return new BigDecimal("0.35").multiply(BigDecimal.valueOf(quantity));
			case Item.BANANA:
				// 0.20 * quantity;
				return new BigDecimal("0.20").multiply(BigDecimal.valueOf(quantity));
			case Item.MELONS:
				if (quantity % 2 == 0) {
					// 0.50 * quantity / 2;
					return new BigDecimal("0.50").multiply(BigDecimal.valueOf(quantity / 2));
				} else {							
					BigDecimal offerPrice = BigDecimal.valueOf(Double.valueOf(quantity)/2).setScale(0,
															   BigDecimal.ROUND_CEILING);
					return new BigDecimal("0.50").multiply(offerPrice);
				}
			case Item.LIMES:
				if (quantity % 3 == 0) {
					// 0.15 * (quantity - quantity / 3);
					return new BigDecimal("0.15").multiply(BigDecimal.valueOf(quantity - quantity / 3));
				} else {
					BigDecimal remainder = BigDecimal.valueOf(quantity % 3);
					BigDecimal triplets = BigDecimal.valueOf((quantity - quantity % 3) / 3);
					return new BigDecimal("0.15").multiply(remainder).add(triplets.multiply(new BigDecimal("0.30")))
																	   .setScale(2);
				}
		default:
			throw new AssertionError("Unknown operations " + this);
		}

	}

}
