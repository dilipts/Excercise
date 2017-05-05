package com.shopping.utility;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shopping.configuration.CartConfiguration;
import com.shopping.domain.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {CartConfiguration.class })
public class ShoppingCartUtilityTest {

	private ShoppingCartUtility shoppingCartUtility;
	private List<String> items;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		shoppingCartUtility = new ShoppingCartUtility();
		items = new ArrayList<String>();

	}

	@Test
	public void testShoppingCart() {
		BigDecimal totalPrice = addItemToCart(Item.APPLE);
		assertForPrice("0.35", totalPrice);
		
		totalPrice = addItemToCart(Item.APPLE);
		assertForPrice("0.70", totalPrice);
		
		totalPrice = addItemToCart(Item.BANANA);
		assertForPrice("0.90", totalPrice);
	}

	
	@Test
	public void testMelons() {
		BigDecimal totalPrice = addItemToCart(Item.MELONS);
		assertForPrice("0.50", totalPrice);
		
		totalPrice = addItemToCart(Item.MELONS);
		assertForPrice("0.50", totalPrice);
		
		totalPrice = addItemToCart(Item.MELONS);
		assertForPrice("1.0", totalPrice);
		
		totalPrice = addItemToCart(Item.MELONS);
		assertForPrice("1.00", totalPrice);
		
		totalPrice = addItemToCart(Item.MELONS);
		assertForPrice("1.50", totalPrice);
		
		totalPrice = addItemToCart(Item.MELONS);
		assertForPrice("1.50", totalPrice);

	}

	@Test
	public void testLimes() {
		
		BigDecimal totalPrice = addItemToCart(Item.LIMES);
		assertForPrice("0.15", totalPrice);
		
		totalPrice = addItemToCart(Item.LIMES);
		assertForPrice("0.30", totalPrice);
		
		totalPrice = addItemToCart(Item.LIMES);
		assertForPrice("0.30", totalPrice);
		
		totalPrice = addItemToCart(Item.LIMES);
		assertForPrice("0.45", totalPrice);
		
		totalPrice = addItemToCart(Item.LIMES);
		assertForPrice("0.60", totalPrice);
		
		totalPrice = addItemToCart(Item.LIMES);
		assertForPrice("0.60", totalPrice);
		
		totalPrice = addItemToCart(Item.LIMES);
		assertForPrice("0.75", totalPrice);
		
		totalPrice = addItemToCart(Item.LIMES);
		assertForPrice("0.90", totalPrice);
		
		totalPrice = addItemToCart(Item.LIMES);
		assertForPrice("0.90", totalPrice);

	}
	
	@Test
	public void testForNullOrEmpty() {
		BigDecimal totalPrice = shoppingCartUtility.addItemToCart(null);
		assertForPrice("0.00", totalPrice);
		
		totalPrice = shoppingCartUtility.addItemToCart(items);
		assertForPrice("0.00", totalPrice);
		
	}
	
	private BigDecimal addItemToCart(String name) {
		items.add(name);
		BigDecimal totalPrice = shoppingCartUtility.addItemToCart(items);
		return totalPrice;
	}
	
	private void assertForPrice(String exptectedPrice, BigDecimal actualPrice) {
		assertTrue(new BigDecimal(exptectedPrice).compareTo(actualPrice) == 0);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		shoppingCartUtility = null;
		items = null;
	}

}
