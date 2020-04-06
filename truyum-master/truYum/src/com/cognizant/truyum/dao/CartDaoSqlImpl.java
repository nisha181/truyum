package com.cognizant.truyum.dao;
import com.cognizant.truyum.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CartDaoSqlImpl implements CartDao {
	
	public List<MenuItem> getAllCartItems(long userId)throws CartEmptyException
	{
		List<MenuItem> list=new ArrayList<MenuItem>();
		try {
			  Connection connection = ConnectionHandler.getConnection();
			  String sql = "SELECT * FROM menuitem WHERE id in (Select menuId from cart where userId=?)";
			  PreparedStatement ps = connection.prepareStatement(sql);
			  ps.setLong(1, userId);
			  ResultSet rs = ps.executeQuery();
			  while(rs.next()){
			  long id = rs.getLong(1);
			  String name = rs.getString(2);
			  float price = rs.getFloat(3);
			  boolean active = rs.getBoolean(4);
			  Date dateOfLaunch = rs.getDate(5);
			  String category = rs.getString(6);
			  boolean freeDelivery = rs.getBoolean(7);
			  MenuItem item = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			  list.add(item);
			  }
			 } catch (ClassNotFoundException | SQLException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			 }
		return list;
	}
	public void addCartItem(long userId,long menuItemId)
	{
		 try {
			  Connection connection = ConnectionHandler.getConnection();
			  String sql = "INSERT INTO cart VALUES(?, ?)";
			  PreparedStatement ps = connection.prepareStatement(sql);
			  ps.setLong(1, userId);
			  ps.setLong(2, menuItemId);
			  ps.executeUpdate();
			 } catch (ClassNotFoundException | SQLException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			 }
	
	}
	public void removeCartItem(long userId,long menuItemId)
	{
		try
		{
			  Connection connection = ConnectionHandler.getConnection();
			  String sql = "DELETE FROM cart WHERE userId=? AND menuId=?";
			  PreparedStatement ps = connection.prepareStatement(sql);
			  ps.setLong(1, userId);
			  ps.setLong(2, menuItemId);
			  ps.executeUpdate();
			 } catch (ClassNotFoundException | SQLException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		 }
	}

	
}
