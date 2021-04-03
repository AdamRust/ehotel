package eHotel.connections;

import java.sql.*;
import java.time.LocalDate;
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
						"arust051", "4@8#tD@C3P6ka#kr");
															
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
				if (result.next()) {
					acc.setUsername(result.getString("username"));
					acc.setPassword(result.getString("password"));
					acc.setRole(result.getInt("role"));
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
					cust.setCustomerID(result.getInt("customer_id"));
					cust.setAddressID(result.getInt("address_id"));
					cust.setFirstName(result.getString("first_name"));
					cust.setMiddleInitial(result.getString("middle_initial"));
					cust.setLastName(result.getString("last_name"));
					cust.setSin(result.getString("sin"));
					cust.setRegistrationDate(result.getString("registration_date"));
					cust.setUsername(result.getString("username"));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return cust;
		}
		
		public Customer getCustomerFromUsername(String username) {
			getConn();
			
			Customer cust = new Customer();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_CUSTOMER_FROM_USERNAME);
	            ps.setString(1, username);	   
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					cust.setCustomerID(result.getInt("customer_id"));
					cust.setAddressID(result.getInt("address_id"));
					cust.setFirstName(result.getString("first_name"));
					cust.setMiddleInitial(result.getString("middle_initial"));
					cust.setLastName(result.getString("last_name"));
					cust.setSin(result.getString("sin"));
					cust.setRegistrationDate(result.getString("registration_date"));
					cust.setUsername(result.getString("username"));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return cust;
		}
		
		public int createNewCustomer(String custFirstName, String custMidInit, String custLastName, String custSin,
				Date custRegDate, String custAcc_Username, String custAcc_Pwd, int custAcc_Role, String custAddr_StreetName, 
				String custAddr_StreetNum, String custAddr_UnitNum, String custAddr_PostalCode, String custAddr_City, 
				String custAddr_State, String custAddr_Country) {
			getConn();
			
			int success = -1;
			int new_addr_id = -1;
			int new_cust_id = -1;
			PreparedStatement ps2 = null;
			PreparedStatement ps3 = null;
			
			try {
				// Prepare SQL for new Account
				ps = db.prepareStatement(SQL.INSERT_NEW_ACCOUNT);
				ps.setString(1, custAcc_Username);
				ps.setString(2, custAcc_Pwd);
				ps.setInt(3, custAcc_Role);
				// Execute query
				ps.executeUpdate();
				
				// Prepare SQL for new Address
				ps2 = db.prepareStatement(SQL.INSERT_NEW_ADDRESS, Statement.RETURN_GENERATED_KEYS);
				ps2.setString(1, custAddr_StreetName);
				ps2.setString(2, custAddr_StreetNum);
				ps2.setString(3, custAddr_UnitNum);
				ps2.setString(4, custAddr_PostalCode);
				ps2.setString(5, custAddr_City);
				ps2.setString(6, custAddr_State);
				ps2.setString(7, custAddr_Country);
				// Execute query
				
				success = ps2.executeUpdate();
				if (success == 1) {
					result = ps2.getGeneratedKeys();
					// Retrieve account_id for new Account
					if (result.next()) {
						new_addr_id = result.getInt("address_id");
					}
				}
	
				// Prepare SQL for new Customer
				ps3 = db.prepareStatement(SQL.INSERT_NEW_CUSTOMER, Statement.RETURN_GENERATED_KEYS);
				ps3.setInt(1, new_addr_id);
				ps3.setString(2, custFirstName);
				ps3.setString(3, custMidInit);
				ps3.setString(4, custLastName);
				ps3.setString(5, custSin);
				ps3.setDate(6, custRegDate);
				ps3.setString(7, custAcc_Username);
				// Execute query
				success = ps3.executeUpdate();
				if (success == 1) {
					result = ps3.getGeneratedKeys();
					// Retrieve account_id for new Account
					if (result.next()) {
						new_cust_id = result.getInt("customer_id");
					}
				}
				ps2.close();
				ps3.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
			
			return new_cust_id;
		}
		
		// Employee
		public Employee getEmployeeFromID(int emp_id) {
			getConn();
			
			Employee emp = new Employee();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_EMPLOYEE_FROM_ID);
	            ps.setInt(1, emp_id);
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					emp.setEmployeeID(result.getInt("employee_id"));
					emp.setHotelID(result.getInt("hotel_id"));
					emp.setAddressID(result.getInt("address_id"));
					emp.setFirstName(result.getString("first_name"));
					emp.setMiddleInitial(result.getString("middle_initial"));
					emp.setLastName(result.getString("last_name"));
					emp.setSin(result.getString("sin"));
					emp.setSalary(result.getInt("salary"));
					emp.setPosition(result.getString("position"));
					emp.setUsername(result.getString("username"));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return emp;
		}
		
		public Employee getEmployeeFromUsername(String username) {
			getConn();
			
			Employee emp = new Employee();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_EMPLOYEE_FROM_USERNAME);
	            ps.setString(1, username);
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					emp.setEmployeeID(result.getInt("employee_id"));
					emp.setHotelID(result.getInt("hotel_id"));
					emp.setAddressID(result.getInt("address_id"));
					emp.setFirstName(result.getString("first_name"));
					emp.setMiddleInitial(result.getString("middle_initial"));
					emp.setLastName(result.getString("last_name"));
					emp.setSin(result.getString("sin"));
					emp.setSalary(result.getInt("salary"));
					emp.setPosition(result.getString("position"));
					emp.setUsername(result.getString("username"));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return emp;
		}
		
		// Hotel
		public Hotel getHotelFromID(int hotel_id) {
			getConn();
			
			Hotel hotel = new Hotel();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_HOTEL_FROM_ID);
	            ps.setInt(1, hotel_id);
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					hotel.setHotelID(result.getInt("hotel_id"));
					hotel.setBrandID(result.getInt("brand_id"));
					hotel.setManagerID(result.getInt("manager_id"));
					hotel.setAddressID(result.getInt("address_id"));
					hotel.setStarCategory(result.getInt("star_category"));
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
					brand.setBrandID(result.getInt("brand_id"));
					brand.setAddressID(result.getInt("address_id"));
					brand.setNumberOfHotels(result.getInt("number_of_hotels"));
					brand.setLocation(result.getString("location"));
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return brand;
		}
		
		// Room
		public Room getRoomFromID(int room_id) {
			getConn();
			
			Room room = new Room();
			
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_ROOM_FROM_ID);
	            ps.setInt(1, room_id);
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					room.setRoomID(result.getInt("room_id"));
					room.setHotelID(result.getInt("hotel_id"));
					room.setPrice(result.getFloat("price"));
					room.setCapacity(result.getInt("capacity"));
					room.setIsSeaView(result.getBoolean("is_sea_view"));
					room.setIsMountainView(result.getBoolean("is_mountain_view"));
					room.setIsExtendible(result.getBoolean("is_extendible"));
					room.setRoomName(result.getString("room_name"));
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
					room.setRoomID(result.getInt("room_id"));
					room.setHotelID(result.getInt("hotel_id"));
					room.setPrice(result.getFloat("price"));
					room.setCapacity(result.getInt("capacity"));
					room.setIsSeaView(result.getBoolean("is_sea_view"));
					room.setIsMountainView(result.getBoolean("is_mountain_view"));
					room.setIsExtendible(result.getBoolean("is_extendible"));
					room.setRoomName(result.getString("room_name"));
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
					room.setRoomID(result.getInt("room_id"));
					room.setHotelID(result.getInt("hotel_id"));
					room.setPrice(result.getFloat("price"));
					room.setCapacity(result.getInt("capacity"));
					room.setIsSeaView(result.getBoolean("is_sea_view"));
					room.setIsMountainView(result.getBoolean("is_mountain_view"));
					room.setIsExtendible(result.getBoolean("is_extendible"));
					room.setRoomName(result.getString("room_name"));
					avail_rooms.add(room);
				}
	            
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return avail_rooms;
		}
		
		// Booking
		public int createBooking(int cust_id, int room_id, LocalDate bookingDate, LocalDate checkInDate, LocalDate checkOutDate, int numOfOccupants) {
			getConn();
			
			int booking_id = -1;
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.CREATE_NEW_BOOKING, Statement.RETURN_GENERATED_KEYS);
	            ps.setInt(1, cust_id);
	            ps.setInt(2, room_id);
	            ps.setObject(3, bookingDate);
	            ps.setObject(4, checkInDate);
	            ps.setObject(5, checkOutDate);
	            ps.setInt(6, numOfOccupants);
	            
	            // Execute query
	            int success = ps.executeUpdate();
	            if (success == 1) {
	            	result = ps.getGeneratedKeys();
		            // Retrieve result
					if (result.next()) {
						booking_id = result.getInt("booking_id");
					}
	            }
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return booking_id;
		}
		
		public ArrayList<Booking> getAllBookings() {
			getConn();
			
			ArrayList<Booking> bookings = new ArrayList<Booking>();
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_ALL_BOOKINGS);
	            
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				while (result.next()) {
					Booking booking = new Booking();
					booking.setBookingID(result.getInt("booking_id"));
					booking.setCustomerID(result.getInt("customer_id"));
					booking.setRoomID(result.getInt("room_id"));
					booking.setBookingDate(result.getString("booking_date"));
					booking.setCheckInDate(result.getString("check_in_date"));
					booking.setCheckOutDate(result.getString("check_out_date"));
					booking.setNumberOfOccupants(result.getInt("number_of_occupants"));
					
					bookings.add(booking);
				}
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return bookings;
		}
		
		public Booking getBookingFromID(int bookingId) {
			getConn();
			
			Booking booking = new Booking();
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.GET_BOOKING_FROM_ID);
	            ps.setInt(1, bookingId);
	            
	            // Execute query
	            result = ps.executeQuery();
	            // Retrieve result
				if (result.next()) {
					booking.setBookingID(result.getInt("booking_id"));
					booking.setCustomerID(result.getInt("customer_id"));
					booking.setRoomID(result.getInt("room_id"));
					booking.setBookingDate(result.getString("booking_date"));
					booking.setCheckInDate(result.getString("check_in_date"));
					booking.setCheckOutDate(result.getString("check_out_date"));
					booking.setNumberOfOccupants(result.getInt("number_of_occupants"));
				}
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return booking;
		}
		
		// Rental
		public int createRental(LocalDate rental_date, int booking_id, String credit_card_name, String credit_card_number,
				String credit_card_cvv, LocalDate credit_card_expiry_date) {
			getConn();
			
			int rental_id = -1;
			try{
	        	// Prepare SQL query
	            ps = db.prepareStatement(SQL.CREATE_NEW_RENTAL, Statement.RETURN_GENERATED_KEYS);
	            ps.setObject(1, rental_date);
	            ps.setInt(2, booking_id);
	            ps.setString(3, credit_card_name);
	            ps.setString(4, credit_card_number);
	            ps.setString(5, credit_card_cvv);
	            ps.setObject(6, credit_card_expiry_date);
	            
	            // Execute query
	            int success = ps.executeUpdate();
	            if (success == 1) {
	            	result = ps.getGeneratedKeys();
		            // Retrieve result
					if (result.next()) {
						rental_id = result.getInt("rental_id");
					}
	            }
	        } catch(SQLException e){
	            e.printStackTrace();
	        } finally {
	        	closeDB();
	        }
			
			return rental_id;
		}
		
	}

