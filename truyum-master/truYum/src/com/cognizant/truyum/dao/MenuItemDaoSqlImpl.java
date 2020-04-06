package com.cognizant.truyum.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.cognizant.truyum.model.*;

public class MenuItemDaoSqlImpl implements MenuItemDao{

	
public List<MenuItem> getMenuItemListAdmin()
{
List<MenuItem> list=new ArrayList<MenuItem>();
	try
	{
		Connection c = ConnectionHandler.getConnection();
		String sql="Select * from menuitem";
		PreparedStatement ps=c.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			long id=rs.getLong(1);
			String name=rs.getString(2);
			float price = rs.getFloat(3);
			boolean active = rs.getBoolean(4);
			Date dateOfLaunch = rs.getDate(5);
			String category = rs.getString(6);
			boolean freeDelivery = rs.getBoolean(7);
			MenuItem item=new MenuItem(id,name,price,active,dateOfLaunch,category,freeDelivery);
			list.add(item);	
			}	
		}catch(ClassNotFoundException | SQLException e)
		{e.printStackTrace();}
		return list;
		}
	public List<MenuItem> getMenuItemListCustomer() 
	{
		List<MenuItem> list=new ArrayList<MenuItem>();
		try
		{
			Connection c = ConnectionHandler.getConnection();
			String sql="Select * from menuitem where active=true and dateOfLaunch < curdate()";
			PreparedStatement ps=c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price = rs.getFloat(3);
				boolean active = rs.getBoolean(4);
				Date dateOfLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				MenuItem item=new MenuItem(id,name,price,active,dateOfLaunch,category,freeDelivery);
				list.add(item);	
				}	
			}catch(ClassNotFoundException | SQLException e)
			{e.printStackTrace();}
			return list;
			}
	public MenuItem getMenuItem(long menuItemId)
	{
		 try {
			  Connection connection = ConnectionHandler.getConnection();
			  String sql = "SELECT * FROM menuitem WHERE id = ? ";
			  PreparedStatement ps = connection.prepareStatement(sql);
			  ps.setLong(1,menuItemId);
			  ResultSet rs = ps.executeQuery();
			  if(rs.next()){
			  long id = rs.getLong(1);
			  String name = rs.getString(2);
			  float price = rs.getFloat(3);
			  boolean active = rs.getBoolean(4);
			  Date dateOfLaunch = rs.getDate(5);
			  String category = rs.getString(6);
			  boolean freeDelivery = rs.getBoolean(7);
			  MenuItem item = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			  return item;
			  }
			 } catch (ClassNotFoundException | SQLException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			 }
			 return null;
	}
	void editMenuItem(MenuItem menuItem)
	{
		
	}
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		try {
			  Connection connection = ConnectionHandler.getConnection();
			  String sql = "UPDATE menuitem SET id = ?, name = ?, price = ?, active = ?, dateOfLaunch = ?, category=?, freedilevry = ? where id = ?";
			  PreparedStatement ps = connection.prepareStatement(sql);
			  ps.setLong(1, menuItem.getId());
			  ps.setString(2, menuItem.getName());
			  ps.setFloat(3, menuItem.getPrice());
			  ps.setBoolean(4, menuItem.isActive());
			  ps.setDate(5,new java.sql.Date(menuItem.getdateOfLaunch().getTime())); 
			  ps.setString(6, menuItem.getCategory());
			  ps.setBoolean(7, menuItem.isfreeDelivery());
			  ps.setLong(8, menuItem.getId());
			  ps.executeUpdate();
			 } catch (ClassNotFoundException | SQLException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			 }
	}
}
