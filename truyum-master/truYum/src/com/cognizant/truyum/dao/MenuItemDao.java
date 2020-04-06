package com.cognizant.truyum.dao;
import java.util.*;
import com.cognizant.truyum.model.*;

public interface MenuItemDao {

	List<MenuItem> getMenuItemListAdmin();
	List<MenuItem> getMenuItemListCustomer();
	void modifyMenuItem(MenuItem menuItem);
	MenuItem getMenuItem(long menuItemId);
	
}
