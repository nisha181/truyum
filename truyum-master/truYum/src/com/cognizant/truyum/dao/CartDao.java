package com.cognizant.truyum.dao;
import java.util.*;
import com.cognizant.truyum.model.*;

public interface CartDao {

	void addCartItem(long userId,long menuItemId);
	List<MenuItem> getAllCartItems(long userId)throws CartEmptyException;
	void removeCartItem(long userId,  long menuItemId);
	
}
