/**
 * This java file is a class that that model the class Products for auction 
 * ProducForAuction is a child class extending Product as Super class
 */
package com.auctivity.model.beans;

import java.sql.Timestamp;
import java.util.Date;

public class ProductForAuction extends Product {

	public enum status {
		NEW, OPEN, UNSOLD, SOLD;
	}
	
	private int bidProductID;
	private double minBidValue;
	private Timestamp bidStartDate;
	private Timestamp bidEndDate;
	// @buyerId must be registered with @userId
	private int userID;
	private double soldPrice;
	private status bidStatus;
	/**
	 * @param bidProductID
	 * @param minBidValue
	 * @param bidStartDate
	 * @param bidEndDate
	 * @param userID
	 * @param soldPrice
	 * @param bidStatus
	 */
	public ProductForAuction(int bidProductID, double minBidValue, Timestamp bidStartDate, Timestamp bidEndDate,
			int userID, double soldPrice, status bidStatus) {
		super();
		this.bidProductID = bidProductID;
		this.minBidValue = minBidValue;
		this.bidStartDate = bidStartDate;
		this.bidEndDate = bidEndDate;
		this.userID = userID;
		this.soldPrice = soldPrice;
		this.bidStatus = bidStatus;
	}
	/**
	 * @return the bidProductID
	 */
	public int getBidProductID() {
		return bidProductID;
	}
	/**
	 * @param bidProductID the bidProductID to set
	 */
	public void setBidProductID(int bidProductID) {
		this.bidProductID = bidProductID;
	}
	/**
	 * @return the minBidValue
	 */
	public double getMinBidValue() {
		return minBidValue;
	}
	/**
	 * @param minBidValue the minBidValue to set
	 */
	public void setMinBidValue(double minBidValue) {
		this.minBidValue = minBidValue;
	}
	/**
	 * @return the bidStartDate
	 */
	public Timestamp getBidStartDate() {
		return bidStartDate;
	}
	/**
	 * @param bidStartDate the bidStartDate to set
	 */
	public void setBidStartDate(Timestamp bidStartDate) {
		this.bidStartDate = bidStartDate;
	}
	/**
	 * @return the bidEndDate
	 */
	public Timestamp getBidEndDate() {
		return bidEndDate;
	}
	/**
	 * @param bidEndDate the bidEndDate to set
	 */
	public void setBidEndDate(Timestamp bidEndDate) {
		this.bidEndDate = bidEndDate;
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return the soldPrice
	 */
	public double getSoldPrice() {
		return soldPrice;
	}
	/**
	 * @param soldPrice the soldPrice to set
	 */
	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}
	/**
	 * @return the bidStatus
	 */
	public status getBidStatus() {
		return bidStatus;
	}
	/**
	 * @param bidStatus the bidStatus to set
	 */
	public void setBidStatus(status bidStatus) {
		this.bidStatus = bidStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bidEndDate == null) ? 0 : bidEndDate.hashCode());
		result = prime * result + bidProductID;
		result = prime * result + ((bidStartDate == null) ? 0 : bidStartDate.hashCode());
		result = prime * result + ((bidStatus == null) ? 0 : bidStatus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(minBidValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(soldPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductForAuction other = (ProductForAuction) obj;
		if (bidEndDate == null) {
			if (other.bidEndDate != null)
				return false;
		} else if (!bidEndDate.equals(other.bidEndDate))
			return false;
		if (bidProductID != other.bidProductID)
			return false;
		if (bidStartDate == null) {
			if (other.bidStartDate != null)
				return false;
		} else if (!bidStartDate.equals(other.bidStartDate))
			return false;
		if (bidStatus != other.bidStatus)
			return false;
		if (Double.doubleToLongBits(minBidValue) != Double.doubleToLongBits(other.minBidValue))
			return false;
		if (Double.doubleToLongBits(soldPrice) != Double.doubleToLongBits(other.soldPrice))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductForAuction [bidProductID=" + bidProductID + ", minBidValue=" + minBidValue + ", bidStartDate="
				+ bidStartDate + ", bidEndDate=" + bidEndDate + ", userID=" + userID + ", soldPrice=" + soldPrice
				+ ", bidStatus=" + bidStatus + "]";
	}
}