<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%!boolean isUserAuthenticated = false; int userType=1;%>

<div id="bottomHeader">
	<div id="mySidebar" class="sidebar">
		<% if(isUserAuthenticated && userType == 0){ %>
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a href="/OnlineAuction">Home</a>
			<a href="/OnlineAuction/profile">My Profile</a>
			<a href="/OnlineAuction/buyerhistory">Purchased Products</a>
			<a href="/OnlineAuction/logout">Log Out</a>
			
		<%} else if(isUserAuthenticated && userType == 1){ %>
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a href="/OnlineAuction">Home</a>
			<a href="/OnlineAuction/profile">My Profile</a>
			<a href="/OnlineAuction/addproduct">Add Product</a>
			<a href="/OnlineAuction/scheduleauction">Schedule Auction</a>
			<a href="/OnlineAuction/sellerhistory">Product History</a>
			<a href="/OnlineAuction/logout">Log Out</a>
		<%} %>
	</div>

	<%
		if (isUserAuthenticated) {
	%>
	<div id="main">
		<button class="openbtn" onclick="openNav()">&#9776;</button>
	</div>
	<%
		} else {
	%>
	<div id="main">
	<div style="float:right">
	<a href="/OnlineAuction/login" class="navbarButton">Login</a>
	<a href="/OnlineAuction/register" class="navbarButton">Sign Up</a>
	</div>
	</div>
	<%
		}
	%>


</div>