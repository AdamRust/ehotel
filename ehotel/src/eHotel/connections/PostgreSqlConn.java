package eHotel.connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import eHotel.entities.*;
import eHotel.util.SQL; 


public class PostgreSqlConn{
	
		Connection db = null;
	    PreparedStatement ps = null;
	    ResultSet result = null;
	    Statement statement = null;
	    String sql;


		public void getConn(){
			
			try {
				
				Class.forName("org.postgresql.Driver"); 
								
				db = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/group_a07_g27",
						"UOTTAWA USERNAME", "UOTTAWA PASSWORD");
															
			}catch(Exception e) {
				System.out.print("Error caught: " + e.getMessage());
			}
						
		}
		
		public void closeDB() {
				try {
					if(result != null){
						result.close();
					}
					if(ps!=null){
						ps.close();
					}
					if(statement!=null){
						statement.close();
					}
					if(db!=null){
						db.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		
//		public String getPasswordByUsername(String username){
//			getConn();
//
//			String pwd = "";
//			
//	        try{
//	        	// Prepare SQL query
//	            ps = db.prepareStatement(SQL.GET_PASSWORD_FROM_USERNAME);
//	            ps.setString(1, username);	   
//	            // Execute query
//	            result = ps.executeQuery();
//	            // Retrieve result
//				while(result.next()) {
//					pwd = result.getString(1);
//				}
//	            
//	        } catch(SQLException e){
//	            e.printStackTrace();
//	        } finally {
//	        	closeDB();
//	        }
//	        
//			return pwd;       
//	    }
//		
//		public String[] getuserinforbycustSSN(String param){
//			getConn();
//
//			String[] pwd = new String[2];
//			
//	        try{
//	            ps = db.prepareStatement("select * from ehotel.customer where customer_ssn=?");
//	            
//	            ps.setString(1, param);	               
//	            result = ps.executeQuery();
//	
//				while(result.next()) {
//					pwd[0] = result.getString(2);
//					pwd[1] = result.getString(3);
//				}
//	            
//	        } catch(SQLException e){
//	            e.printStackTrace();
//	        } finally {
//	        	closeDB();
//	        }
//			return pwd;       
//	    }
//		
//		public boolean insertNewCustomer(String[] param){
//			getConn();
//
//			
//	        try{
//	        	statement = db.createStatement();
//	        	sql = "insert into ehotel.customer values('"+param[0]+"','"+param[1]+"','"+param[2]+"')";
//	        	// ps = db.prepareStatement(SQL.CONSTANT)
//	        	// ps.setString(1, param[0]);
//	        	// ps.setString(2, param[1]);
//	        	// ps.setString(3, param[2]);
//	        	System.out.print(sql);
//	            
//	            statement.executeUpdate(sql);
//	            
//	            return true;
//
//	        } catch(SQLException e){
//	            e.printStackTrace();
//	            return false;
//	        } finally {
//	        	closeDB();
//	        }	       
//	    }
//		
//		public  ArrayList<Room> getAllAvailRooms(){
//			
//			getConn();
//			
//			ArrayList<Room> Rooms = new ArrayList<Room>();
//			
//			try {
//				ps = db.prepareStatement("select * from ehotel.room where room_status='available'" );
//				result = ps.executeQuery();
//				while(result.next()){
//					int room_id = result.getInt("room_id");
//					int hotel_id = result.getInt("hotel_id");
//					int price = result.getInt("price");
//					int capacity = result.getInt("capacity");
//					boolean is_sea_view = result.getBoolean("is_sea_view");
//					boolean is_mountain_view = result.getBoolean("is_mountain_view");
//					boolean is_extendible = result.getBoolean("is_extendible");
//					// TODO: add query for amenities
//					Room room = new Room(room_id, hotel_id, price, capacity, is_sea_view, is_mountain_view, is_extendible);
//					Rooms.add(room);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//	        	closeDB();
//	        }
//						
//			return Rooms;
//			
//		}
//		
//		public  ArrayList<Room> getbookedRooms(String custSSN){
//			
//			getConn();
//			
//			ArrayList<Room> Rooms = new ArrayList<Room>();
//			
//			try {
//				ps = db.prepareStatement("select * from ehotel.room where customer_ssn='"+custSSN+"'");
//				result = ps.executeQuery();
//				while(result.next()){
//					int room_id = result.getInt("room_id");
//					int hotel_id = result.getInt("hotel_id");
//					int price = result.getInt("price");
//					int capacity = result.getInt("capacity");
//					boolean is_sea_view = result.getBoolean("is_sea_view");
//					boolean is_mountain_view = result.getBoolean("is_mountain_view");
//					boolean is_extendible = result.getBoolean("is_extendible");
//					// TODO: add query for amenities
//					Room room = new Room(room_id, hotel_id, price, capacity, is_sea_view, is_mountain_view, is_extendible);
//					Rooms.add(room);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//	        	closeDB();
//	        }
//						
//			return Rooms;
//			
//		}
//		
//		public String bookRoom(String custName, String roomno){
//			getConn();
//			String custSSN="";
//			
//	        try{
//	        	
//	        	ps = db.prepareStatement("select customer_ssn from ehotel.customer where customer_name='"+custName+"'");
//				result = ps.executeQuery();
//				
//				while(result.next()){
//					custSSN = result.getString("customer_ssn");
//				}
//				
//				
//	        	statement = db.createStatement();
//	        	sql = "update ehotel.room set customer_ssn='"+custSSN+"', room_status='booked' where room_no='"+roomno+"'";
//	            statement.executeUpdate(sql);
//	            
//	            
//	            return custSSN;
//
//	        } catch(SQLException e){
//	            e.printStackTrace();
//	            return "";	 
//	        } finally {
//	        	closeDB();
//	        }
//			      
//	    }
		
		// Account
		public Account getAccountFromUsername(String username) {
			getConn();
			
			Account acc = new Account();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_ACCOUNT_FROM_USERNAME);
	            ps.setString(1, username);	   
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				while(result.next()) {
					acc.setAccountID(result.getInt(1));
					acc.setUsername(result.getString(2));
					acc.setPassword(result.getString(3));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return acc;
		}
		
		public Account getAccountFromID(String account_id) {
			getConn();
			
			Account acc = new Account();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_ACCOUNT_FROM_ID);
	            ps.setString(1, account_id);	   
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					acc.setAccountID(result.getInt(1));
					acc.setUsername(result.getString(2));
					acc.setPassword(result.getString(3));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return acc;
		}
		
		//Customer
		public Customer getCustomerFromID(int cust_id) {
			getConn();
			
			Customer cust = new Customer();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_CUSTOMER_FROM_ID);
	            ps.setInt(1, cust_id);	   
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					cust.setCustomerID(result.getInt(1));
					cust.setAddressID(result.getInt(2));
					cust.setFirstName(result.getString(3));
					cust.setMiddleInitial(result.getString(4));
					cust.setLastName(result.getString(5));
					cust.setSin(result.getString(6));
					cust.setRegistrationDate(result.getString(7));
					cust.setAccountID(result.getInt(8));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return cust;
		}
		
		public Customer getCustomerFromAccountID(int acc_id) {
			getConn();
			
			Customer cust = new Customer();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_CUSTOMER_FROM_ACCOUNT_ID);
	            ps.setInt(1, acc_id);	   
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					cust.setCustomerID(result.getInt(1));
					cust.setAddressID(result.getInt(2));
					cust.setFirstName(result.getString(3));
					cust.setMiddleInitial(result.getString(4));
					cust.setLastName(result.getString(5));
					cust.setSin(result.getString(6));
					cust.setRegistrationDate(result.getString(7));
					cust.setAccountID(result.getInt(8));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return cust;
		}
		
		// Employee
		public Employee getEmployeeFromID(int emp_id, int hotel_id) {
			getConn();
			
			Employee emp = new Employee();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_EMPLOYEE_FROM_ID);
	            ps.setInt(1, emp_id);
	            ps.setInt(2, hotel_id);
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					emp.setEmployeeID(result.getInt(1));
					emp.setHotelID(result.getInt(2));
					emp.setAddressID(result.getInt(3));
					emp.setFirstName(result.getString(4));
					emp.setMiddleInitial(result.getString(5));
					emp.setLastName(result.getString(6));
					emp.setSin(result.getString(7));
					emp.setSalary(result.getInt(8));
					emp.setPosition(result.getString(9));
					emp.setAccountID(result.getInt(10));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return emp;
		}
		
		// Hotel
		public Hotel getHotelFromID(int hotel_id, int brand_id) {
			getConn();
			
			Hotel hotel = new Hotel();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_HOTEL_FROM_ID);
	            ps.setInt(1, hotel_id);
	            ps.setInt(2, brand_id);
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					hotel.setHotelID(result.getInt(1));
					hotel.setBrandID(result.getInt(2));
					hotel.setManagerID(result.getInt(3));
					hotel.setAddressID(result.getInt(4));
					hotel.setStarCategory(result.getInt(5));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return hotel;
		}
		
		// Hotel Brand
		public HotelBrand getHotelBrandFromID(int brand_id) {
			getConn();
			
			HotelBrand brand = new HotelBrand();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_HOTEL_BRAND_FROM_ID);
	            ps.setInt(1, brand_id);
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					brand.setBrandID(result.getInt(1));
					brand.setAddressID(result.getInt(2));
					brand.setNumberOfHotels(result.getInt(3));
					brand.setLocation(result.getString(4));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return brand;
		}
		
		// Room
		public Room getRoomFromID(int room_id, int hotel_id) {
			getConn();
			
			Room room = new Room();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_ROOM_FROM_ID);
	            ps.setInt(1, room_id);
	            ps.setInt(2, hotel_id);
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					room.setRoomID(result.getInt(1));
					room.setHotelID(result.getInt(2));
					room.setPrice(result.getInt(3));
					room.setCapacity(result.getInt(4));
					room.setIsSeaView(result.getBoolean(5));
					room.setIsMountainView(result.getBoolean(6));
					room.setIsExtendible(result.getBoolean(7));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return room;
		}
		
		public ArrayList<Room> getBookedRoomsForCustomer(int cust_id) {
			getConn();
			
			ArrayList<Room> booked_rooms = new ArrayList<Room>();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_BOOKED_ROOMS_FOR_CUSTOMER);
	            ps.setInt(1, cust_id);
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				while (result.next()) {
					Room room = new Room();
					room.setRoomID(result.getInt(1));
					room.setHotelID(result.getInt(2));
					room.setPrice(result.getInt(3));
					room.setCapacity(result.getInt(4));
					room.setIsSeaView(result.getBoolean(5));
					room.setIsMountainView(result.getBoolean(6));
					room.setIsExtendible(result.getBoolean(7));
					
					booked_rooms.add(room);
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return booked_rooms;
		}
		
		public ArrayList<Room> getAllAvailRooms() {
			getConn();
			
			ArrayList<Room> avail_rooms = new ArrayList<Room>();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_ALL_AVAIL_ROOMS);
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				while (result.next()) {
					Room room = new Room();
					room.setRoomID(result.getInt(1));
					room.setHotelID(result.getInt(2));
					room.setPrice(result.getInt(3));
					room.setCapacity(result.getInt(4));
					room.setIsSeaView(result.getBoolean(5));
					room.setIsMountainView(result.getBoolean(6));
					room.setIsExtendible(result.getBoolean(7));
					
					avail_rooms.add(room);
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return avail_rooms;
		}
		
	}

