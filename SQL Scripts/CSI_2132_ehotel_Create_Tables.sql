/*
 * Script to create all tables for the ehotel application database,
 * for the CSI 2132 final project of the Winter term 2021.
 * 
 * Section: A07
 * Group: 27
 */

CREATE TABLE hotel_brand (
    brand_id SERIAL PRIMARY KEY,
    address_ID INT NOT NULL,
    number_of_hotels INT NOT NULL,
    location VARCHAR(50),
    FOREIGN KEY(address_id) REFERENCES address(address_id) ON DELETE RESTRICT
);

CREATE TABLE hotel (
    hotel_id INT, -- TODO: Change hotel_id to PK
    brand_id INT,
    manager_id INT NOT NULL,
    address_id INT NOT NULL,
    star_category INT CONSTRAINT hotel_star_range CHECK (star_category >= 1 AND star_category <= 5),
    PRIMARY KEY(hotel_id, brand_id),
    UNIQUE (hotel_id), -- TODO: Remove unique constraint, replaced by PK constraint
    FOREIGN KEY(brand_id) REFERENCES hotel_brand(brand_id) ON DELETE CASCADE,
    FOREIGN KEY(address_id) REFERENCES address(address_id) ON DELETE RESTRICT
);

CREATE TABLE employee (
    employee_id INT, -- TODO: Change employee_id to PK
    hotel_id INT NOT NULL,
    address_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    middle_initial VARCHAR(3),
    last_name VARCHAR(50) NOT NULL,
    sin VARCHAR(9) NOT NULL,
    salary INT,
    position VARCHAR(50),
    PRIMARY KEY(employee_id, hotel_id),
    UNIQUE(employee_id), -- TODO: Remove unique constraint, replaced by PK constraint
    FOREIGN KEY(hotel_id) REFERENCES hotel(hotel_id) ON DELETE CASCADE,
    FOREIGN KEY(address_id) REFERENCES address(address_id) ON DELETE RESTRICT
);

CREATE TABLE address (
    address_id SERIAL PRIMARY KEY,
    street_name VARCHAR(50),
    street_number VARCHAR(10),
    unit_number VARCHAR(10),
    postal_code VARCHAR(6),
    city VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50)
);

CREATE TABLE room (
    room_id INT, -- TODO: Change room_id to PK, add room_name column
    hotel_id INT,
    price INT NOT NULL DEFAULT 0, -- TODO: change price to NUMERIC
    capacity INT NOT NULL DEFAULT 2,
    is_sea_view BOOLEAN NOT NULL DEFAULT false,
    is_mountain_view BOOLEAN NOT NULL DEFAULT false,
    is_extendible BOOLEAN NOT NULL DEFAULT false,
    PRIMARY KEY(room_id, hotel_id),
    UNIQUE(room_id), -- TODO: Remove unique constraint, replaced by PK constraint
    FOREIGN KEY(hotel_id) REFERENCES hotel(hotel_id) ON DELETE CASCADE
);

CREATE TABLE room_amenities (
    room_id INT,
    amenity_type INT CONSTRAINT room_amenity_above_zero CHECK (amenity_type >= 0),
    PRIMARY KEY(room_id, amenity_type), -- This PK remains the same
    FOREIGN KEY(room_id) REFERENCES room(room_id) ON DELETE CASCADE
);

CREATE TABLE customer (
    customer_id SERIAL PRIMARY KEY,
    address_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    middle_initial VARCHAR(3),
    last_name VARCHAR(50) NOT NULL,
    sin VARCHAR(9) NOT NULL,
    registration_date DATE NOT NULL DEFAULT CURRENT_DATE,
    FOREIGN KEY(address_id) REFERENCES address(address_id) ON DELETE RESTRICT
);

CREATE TABLE booking (
    booking_id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    room_id INT NOT NULL, -- TODO: Add hotel_id? (Not necessary after room_id becomes PK)
    booking_date DATE NOT NULL DEFAULT CURRENT_DATE,
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL,
    number_of_occupants INT,
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id) ON DELETE RESTRICT,
    FOREIGN KEY(room_id) REFERENCES room(room_id) ON DELETE RESTRICT
);

CREATE TABLE hotel_phone (
    hotel_id INT,
    phone_number VARCHAR(12),
    PRIMARY KEY(hotel_id, phone_number),
    FOREIGN KEY(hotel_id) REFERENCES hotel(hotel_id) ON DELETE CASCADE
);

CREATE TABLE brand_phone (
    brand_id INT,
    phone_number VARCHAR(12),
    PRIMARY KEY(brand_id, phone_number),
    FOREIGN KEY(brand_id) REFERENCES hotel_brand(brand_id) ON DELETE CASCADE
);

CREATE TABLE employee_phone (
    employee_id INT,
    phone_number VARCHAR(12),
    PRIMARY KEY(employee_id, phone_number),
    FOREIGN KEY(employee_id) REFERENCES employee(employee_id) ON DELETE CASCADE
);

CREATE TABLE hotel_email (
    hotel_id INT,
    email_address VARCHAR(50),
    PRIMARY KEY(hotel_id, email_address),
    FOREIGN KEY(hotel_id) REFERENCES hotel(hotel_id) ON DELETE CASCADE
);

CREATE TABLE brand_email (
    brand_id INT,
    email_address VARCHAR(50),
    PRIMARY KEY(brand_id, email_address),
    FOREIGN KEY(brand_id) REFERENCES hotel_brand(brand_id) ON DELETE CASCADE
);

CREATE TABLE employee_email (
    employee_id INT,
    email_address VARCHAR(50),
    PRIMARY KEY(employee_id, email_address),
    FOREIGN KEY(employee_id) REFERENCES employee(employee_id) ON DELETE CASCADE
);
CREATE TABLE customer_phone (
    customer_id INT,
    phone_number VARCHAR(12),
    PRIMARY KEY(customer_id, phone_number),
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE
    

-- Creating a separate table to store login/account information (adding account_id FK to Customer and Employee). 
-- NOTE: This table will not be secured at all, NO ACTUAL PASSWORDS SHOULD BE STORED in it.
CREATE TABLE account (
    account_id SERIAL PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50),
    role INT CHECK (role >= 1 and role <= 3), -- 1 = admin, 2 = employee, 3 = customer
    UNIQUE(username) -- TODO: Change to use username as PK and remove account_id
);
 -- TODO: Modify the account_id columns to store username instead
ALTER TABLE customer
ADD COLUMN account_id INT NOT NULL;

ALTER TABLE customer
ADD CONSTRAINT fk_customer_account
FOREIGN KEY(account_id) REFERENCES account(account_id) ON DELETE CASCADE;

ALTER TABLE employee
ADD COLUMN account_id INT NOT NULL;

ALTER TABLE employee
ADD CONSTRAINT fk_employee_account
FOREIGN KEY(account_id) REFERENCES account(account_id) ON DELETE CASCADE;
