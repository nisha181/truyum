package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String args[]) {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		testGetAllCartItems();
	}

	static void testAddCartItem() {
		CartDaoCollectionImpl c = new CartDaoCollectionImpl();
		c.addCartItem(11L, 1);
		c.addCartItem(11L, 2);
		c.addCartItem(10L, 3);
	
	}
	
	static void testGetAllCartItems() {
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		CartDaoCollectionImpl c = new CartDaoCollectionImpl();
	try {		
			menuItemList = c.getAllCartItems(11L).getMenuItemList();
			double d= c.getAllCartItems(11L).getTotal();
			for(MenuItem i: menuItemList)
			{
				System.out.println(i);
			}
			System.out.println(d);
	} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
/*	

	static void testGetAllCartItems() {
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		CartDaoCollectionImpl c = new CartDaoCollectionImpl();
	try {
			menuItemList = c.getAllCartItems(11L);
			for(MenuItem i: menuItemList)
			{
				System.out.println(i);
			}
	} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	static void testRemoveCartItem() {
		CartDaoCollectionImpl c = new CartDaoCollectionImpl();
		c.removeCartItem(11L,1);

	}
}
