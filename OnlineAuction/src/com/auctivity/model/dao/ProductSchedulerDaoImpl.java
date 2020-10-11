package com.auctivity.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.beans.ProductForAuction.status;
import com.auctivity.utility.DBConnection;

public class ProductSchedulerDaoImpl implements IProductSchedulerDao {

	@Override
	public int scheduleAuction(ProductForAuction productAuction) {
		// TODO Auto-generated method stub
		
		int status=0;
		
		Connection conn = DBConnection.getConnectionId();	
		PreparedStatement ps,ps1;
		ResultSet resultset;
		int productId = 0;
		try {
			ps = conn.prepareStatement("insert into OnlineAuctionDB.ProductBid(MinBidValue,BidStartDate,BidEndDate,ProductID,Status) values(?,?,?,?,?)");
			//ps1=conn.prepareStatement("select ProductID from OnlineAuctionDB.Product where ProductName = '"+productAuction.getProductName()+"'");
//			
//			resultset=ps1.executeQuery();
//			while(resultset.next())
//			{
//				productId=resultset.getInt(1);
//		    }
			
			System.out.println(productId+","+productAuction.getProductName());
			ps.setDouble(1,productAuction.getMinBidValue());		
			ps.setTimestamp(2,new Timestamp(java.sql.Date.valueOf(productAuction.getBidStartDate()).getTime()));
			ps.setTimestamp(3,new Timestamp(java.sql.Date.valueOf(productAuction.getBidEndDate()).getTime()));
			//ps.setInt(4,300);
			ps.setInt(4,productAuction.getProductId());
			//ps.setDouble(6,0);
			ps.setInt(5,productAuction.getBidStatus());
			status = ps.executeUpdate();
			System.out.println("Schedule Auction status::"+status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return status;
	}

	@Override
	public List<Product> getProductList(int sellerId) 
	{
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		Connection conn = DBConnection.getConnectionId();	
		PreparedStatement ps;
		ResultSet resultset;

		try
		{
			ps = conn.prepareStatement("select ProductID,ProductName from OnlineAuctionDB.Product where SellerID=?");
			ps.setInt(1,sellerId);
			resultset = ps.executeQuery();
			while (resultset.next())
			{
				int productId = resultset.getInt(1);
                String productName = resultset.getString(2);
                Product product = new Product(productId, productName);
                    
                System.out.println("Id name =="+productId+","+productName);
                productList.add(product);
			}
			System.out.println(sellerId);
			System.out.println(productList);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return productList;
	}

	

}
