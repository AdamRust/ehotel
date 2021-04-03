/*
 * Script to modify some tables for the ehotel application database,
 * for the CSI 2132 final project of the Winter term 2021.
 * 
 * The script named CSI_2132_ehotel_Create_Tables.sql contains the commands
 * used to initially create all the tables. However, during development we
 * recognized that some changes needed to be made to the model. This script
 * contains all the SQL for making the necessary changes.
 *
 * Section: A07
 * Group: 27
 */

-- Modify Customer and Employee to remove FK account_id and replace with FK username from Account.
ALTER TABLE customer
DROP CONSTRAINT fk_customer_account;

ALTER TABLE customer
DROP COLUMN account_id;

ALTER TABLE employee
DROP CONSTRAINT fk_employee_account;

ALTER TABLE employee
DROP COLUMN account_id;

ALTER TABLE account
DROP CONSTRAINT account_pkey;

ALTER TABLE account
ADD PRIMARY KEY(username);

ALTER TABLE account
DROP COLUMN account_id;

ALTER TABLE account
DROP CONSTRAINT unique_username;

ALTER TABLE customer
ADD COLUMN username VARCHAR(50) NOT NULL;

ALTER TABLE customer
ADD CONSTRAINT fk_customer_account
FOREIGN KEY(username) REFERENCES account(username) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE employee
ADD COLUMN username VARCHAR(50) NOT NULL;

ALTER TABLE employee
ADD CONSTRAINT fk_employee_account
FOREIGN KEY(username) REFERENCES account(username) ON DELETE CASCADE ON UPDATE CASCADE;

-- Modify Hotel to have a single PK column and a FK to HotelBrand, instead of a composite key of these 2 columns
ALTER TABLE hotel
DROP CONSTRAINT hotel_pkey;

ALTER TABLE hotel
ADD PRIMARY KEY(hotel_id);

-- ALTER TABLE hotel
-- DROP CONSTRAINT unique_hotel_id;

-- Modify Employee to have a single PK column and a FK to Hotel, instead of a composite key of these 2 columns
ALTER TABLE employee
DROP CONSTRAINT employee_pkey;

ALTER TABLE employee
ADD PRIMARY KEY(employee_id);

-- ALTER TABLE employee
-- DROP CONSTRAINT unique_employee_id;

-- Modify Room to have a single PK column and a FK to Hotel, instead of a composite key of these 2 columns
ALTER TABLE room
DROP CONSTRAINT room_pkey;

ALTER TABLE room
ADD PRIMARY KEY(room_id);

-- ALTER TABLE room
-- DROP CONSTRAINT unique_room_id;

-- Change datatype of Price from INT to NUMERIC
ALTER TABLE room
ALTER COLUMN price TYPE NUMERIC USING price::NUMERIC;

-- Add column room_num to Room to store the number of each room within its associated hotel
-- Using VARCHAR as we could have rooms such as "13A" or maybe even "Penthouse"
ALTER TABLE room
ADD COLUMN room_name VARCHAR(50) NOT NULL;

-- Add column to Hotel for Hotel Name
ALTER TABLE hotel
ADD COLUMN hotel_name VARCHAR(50);

-- Add column to Hotel Brand for Brand Name
ALTER TABLE hotel_brand
ADD COLUMN brand_name VARCHAR(50);

-- Create rental table for storing rentals created by Employees when a Customer checks-in (also stores payment info)
CREATE TABLE ehotel.rental (
    rental_id SERIAL PRIMARY KEY,
    rental_date DATE NOT NULL,
    booking_id INT NOT NULL, -- rentals always connected to a booking (Employee first creates a booking if one doesn't exist already)
    credit_card_name VARCHAR(50),
    credit_card_number VARCHAR(50),
    credit_card_cvv VARCHAR(50),
    credit_card_expiry_date DATE,
    FOREIGN KEY(booking_id) REFERENCES booking(booking_id) ON DELETE CASCADE
);