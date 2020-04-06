package com.cognizant.truyum.dao;
import java.util.*;
import com.cognizant.truyum.model.*;

public class CartDaoCollectionImpl{

	private static HashMap<Long, Cart> userCarts=null;
	
	CartDaoCollectionImpl()
	{
		try
		{
		if(CartDaoCollectionImpl.userCarts==null)
		{
			CartDaoCollectionImpl.userCarts = new HashMap<>();
		}
		}
		catch(Exception e)
		{
		}
	}
	public void addCartItem(long userId, long menuItemId)
	{
		Cart cart =CartDaoCollectionImpl.userCarts.getOrDefault(userId, new Cart(new ArrayList<MenuItem>(), 0));
		List<MenuItem> items = cart.getMenuItemList();
		MenuItemDaoCollectionImpl m= new MenuItemDaoCollectionImpl();
		List<MenuItem> menuitems = m.getMenuItemList();
		for(MenuItem item : menuitems){
			if(item.getId()==menuItemId)
			{	items.add(item);
				cart.setMenuItemList(items);
				cart.setTotal(cart.getTotal() + item.getPrice());
				CartDaoCollectionImpl.userCarts.put(userId, cart);
			}
		}
	}
	/*public List<MenuItem>  getAllCartItems(final long userId) throws CartEmptyException
	{
		return CartDaoCollectionImpl.userCarts.get(userId).getMenuItemList();
	}*/
	
	public Cart getAllCartItems(final long userId) throws CartEmptyException
	{
		return CartDaoCollectionImpl.userCarts.get(userId);
	}
	
	
	
	public void removeCartItem(long userId,long menuItemId)
	{
		Cart c = CartDaoCollectionImpl.userCarts.get(userId);
		List<MenuItem> items = c.getMenuItemList();
		MenuItem obj = null;
		for(MenuItem item : items){
			if(item.getId()==menuItemId){
				obj  = item;
			}
		}
		if(obj!=null)
			{
				items.remove(obj);
				c.setMenuItemList(items);
				c.setTotal(c.getTotal()-obj.getPrice());
			}
		CartDaoCollectionImpl.userCarts.put(userId, c);
		}
	}