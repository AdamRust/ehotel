/*
 * Script to populate tables for the ehotel application database,
 * for the CSI 2132 final project of the Winter term 2021.
 * 
 * This script creates:
 * - 6 Hotel Chains
 * - 5 Hotels for each chain (3 in Ottawa)
 * - 5 Rooms for each Hotel
 * - 5 Employees
 * - 5 Customers (These can be created within the app)
 *
 * Section: A07
 * Group: 27
 */

-- Create Addresses for Hotels and Hotel Brands
INSERT INTO ehotel.address (street_name, street_number, unit_number, postal_code, city, state, country) VALUES
('Matheson Boulevard East', '2425', '100', 'L4W5K4', 'Mississauga', 'Ontario', 'Canada'), -- Westin HQ
('Colonel By Drive', '11', NULL, 'K1N9H4', 'Ottawa', 'Ontario', 'Canada'), -- The Westin Ottawa
('Harbour Square', '1', NULL, 'M5J1A6', 'Toronto', 'Ontario', 'Canada'), -- The Westin Harbour Castle, Toronto
('Bayshore Drive', '1601', NULL, 'V6G2V4', 'Vancouver', 'British Columbia', 'Canada'), -- The Westin Bayshore, Vancouver
('Hollis Street', '1181', NULL, 'B3H2P6', 'Halifax', 'Nova Scotia', 'Canada'), -- The Westin Nova Scotian, Halifax
('Saint-Antoine Ouest', '270', NULL, 'H2Y0A3', 'Montreal', 'Quebec', 'Canada'), -- The Westin Montreal
('Wellington Street West', '155', NULL, 'M5V3H6', 'Toronto', 'Ontario', 'Canada'), -- Novotel HQ
('Nicholas Street', '33', NULL, 'K1N9M7', 'Ottawa', 'Ontario', 'Canada'), -- Novotel Ottawa
('The Esplanade', '45', NULL, 'M5E1W2', 'Toronto', 'Ontario', 'Canada'), -- Novotel Toronto
('Bass Pro Mills Drive', '200', NULL, 'L4K0B9', 'Concord', 'Ontario', 'Canada'), -- Novotel Vaughan
('Rue de la Montagne', '1180', NULL, 'H3G1Z1', 'Montreal', 'Quebec', 'Canada'), -- Novotel Montreal
('Boulevard Alfred Nobel', '2599', NULL, 'H4S2G1', 'Saint-Laurent', 'Quebec', 'Canada'), -- Novotel St. Laurent
('Wellington Street West', '155', '3300', 'M5V0C3', 'Toronto', 'Ontario', 'Canada'), -- Fairmont HQ
('Rideau Street', '1', NULL, 'K1N8S7', 'Ottawa', 'Ontario', 'Canada'), -- Fairmont Chateau Laurier
('Front Street West', '100', NULL, 'M5J1E3', 'Toronto', 'Ontario', 'Canada'), -- Fairmont Royal York
('Rue des Carrieres', '1', NULL, 'G1R4P5', 'Quebec City', 'Quebec', 'Canada'), -- Fairmont Le Chateau Frontenac
('Lake Lousie Drive', '111', NULL, 'T0L1E0', 'Lake Louise', 'Alberta', 'Canada'), -- Fairmont Chateau Lake Louise
('Chateau Boulevard', '4599', NULL, 'V8E0Z5', 'Whistler', 'British Columbia', 'Canada'), -- Fairmont Chateau Whistler
('Wellington Street West', '155', NULL, 'M5V3H6', 'Toronto', 'Ontario', 'Canada'), -- Delta HQ
('4th Avenue Southeast', '209', NULL, 'T2G0C6', 'Calgary', 'Alberta', 'Canada'), -- Delta Calgary
('West Hastings Street', '550', NULL, 'V6B1L6', 'Vancouver', 'British Columbia', 'Canada'), -- Delta Vancouver
('Lower Simcoe Street', '75', NULL, 'M5J3A6', 'Toronto', 'Ontario', 'Canada'), -- Delta Toronto
('President-Kennedy Avenue', '475', NULL, 'H3A1J7', 'Montreal', 'Quebec', 'Canada'), -- Delta Montreal
('Dundas Street', '325', NULL, 'N6B1T9', 'London', 'Ontario', 'Canada'), -- Delta Armouries London
('Campus Road', '5830', '200', 'L4V1G2', 'Mississauga', 'Ontario', 'Canada'), -- Hilton HQ
('Whistler Way', '4050', NULL, 'V8E1H9', 'Whistler', 'British Columbia', 'Canada'), -- Hilton Whistler
('Robson Street', '433', NULL, 'V6B6L9', 'Vancouver', 'British Columbia', 'Canada'), -- Hilton Vancouver
('Richmond Street West', '145', NULL, 'M5H2L2', 'Toronto', 'Ontario', 'Canada'), -- Hilton Toronto
('Rene Levesque East', '1100', NULL, 'G1R4P3', 'Quebec City', 'Quebec', 'Canada'), -- Hilton Quebec
('Boulevard du Casino', '3', NULL, 'J8Y6X4', 'Gatineau', 'Quebec', 'Canada'), -- Hilton Lac-Leamy
('Wellington Street West', '155', NULL, 'M5V3H6', 'Toronto', 'Ontario', 'Canada'), -- Sheraton HQ
('Rue Daniel-Johnson Ouest', '1315', NULL, 'J2S8S4', 'Saint-Hyacinthe', 'Quebec', 'Canada'), -- Sheraton Saint-Hyacinthe
('Falls Avenue', '5875', NULL, 'L2G3K7', 'Niagara Falls', 'Ontario', 'Canada'), -- Sheraton Fallsview Niagara
('Barclay Parade Southwest', '255', NULL, 'T2P5C2', 'Calgary', 'Alberta', 'Canada'), -- Sheraton Calgary Eau Claire
('Queen Street West', '123', NULL, 'M5H2M9', 'Toronto', 'Ontario', 'Canada'), -- Sheraton Toronto
('Burrard Street', '1000', NULL, 'V6Z2R9', 'Vancouver', 'British Columbia', 'Canada'), -- Sheraton Vancouver
('Main Street', '1', '1', 'A1A1A1', 'Ottawa', 'Ontario', 'Canada'), -- Customer 1
('Rue Main', '2', '2', 'B1B1B1', 'Montreal', 'Quebec', 'Canada'), -- Customer 2
('2nd Avenue', '3', '3', 'C1C1C1', 'Toronto', 'Ontario', 'Canada'), -- Customer 3
('3rd Street', '4', '4', 'D1D1D1', 'Vancouver', 'British Columbia', 'Canada'), -- Customer 4
('4th Street', '5', '5', 'E1E1E1', 'Halifax', 'Nova Scotia', 'Canada'), -- Customer 5
('5th Avenue', '6', '6', 'F1F1F1', 'Ottawa', 'Ontario', 'Canada'), -- Employee 1
('Rue Main', '7', '7', 'G1G1G1', 'Montreal', 'Quebec', 'Canada'), -- Employee 2
('6th Street', '8', '8', 'H1H1H1', 'Toronto', 'Ontario', 'Canada'), -- Employee 3
('7th Avenue', '9', '9', 'I1I1I1', 'Vancouver', 'British Columbia', 'Canada'), -- Employee 4
('8th Avenue', '10', '10', 'J1J1J1', 'Halifax', 'Nova Scotia', 'Canada'); -- Employee 5

-- Create Hotel Brands
INSERT INTO ehotel.hotel_brand (address_id, number_of_hotels, location, brand_name) VALUES
(4 , 14, 'Mississauga', 'Westin Hotels and Resorts'), -- Westin Hotels and Resorts (Marriott)
(10 , 6, 'Toronto', 'Novotel Hotels and Resorts'), -- Novotel Hotels (Accor)
(16 , 14, 'Toronto', 'Fairmont Hotels and Resorts'), -- Fairmont HQ
(22 , 39, 'Toronto', 'Delta Hotels'), -- Delta Hotels
(28 , 14, 'Mississauga', 'Hilton'), -- Hilton Hotels
(34 , 14, 'Mississauga', 'Sheraton Hotels'); -- Sheraton Hotels

-- Create Hotel Brand Emails
INSERT INTO ehotel.brand_email (brand_id, email_address) VALUES
(1, 'westin@westinhotels.ca'),
(2, 'novotel@novotelshotels.ca'),
(3, 'fairmont@fairmonthotels.ca'),
(4, 'delta@deltahotels.ca'),
(5, 'hilton@hiltonhotels.ca'),
(6, 'sheraton@sheratonhotels.ca');

-- Create Hotel Brand Phone Numbers
INSERT INTO ehotel.brand_phone (brand_id, phone_number) VALUES
(1, '4161111111'),
(2, '4162222222'),
(3, '4163333333'),
(4, '4164444444'),
(5, '4165555555'),
(6, '4166666666');

-- Create Employee Accounts
INSERT INTO ehotel.account (username, password, role) VALUES
('Employee1', 'password', 2),
('Employee2', 'password', 2),
('Employee3', 'password', 2),
('Employee4', 'password', 2),
('Employee5', 'password', 2);

-- Create Employees
INSERT INTO ehotel.employee (hotel_id, address_id, first_name, middle_initial, last_name, sin, salary, position, username) VALUES
(1, 45, 'Employee', 'E1', 'One', 123456789, 50000, 'Manager', 'Employee1'),
(6, 46, 'Employee', 'E2', 'Two', 123456789, 50000, 'Manager', 'Employee2'),
(11, 47, 'Employee', 'E3', 'Three', 123456789, 50000, 'Manager', 'Employee3'),
(16, 48, 'Employee', 'E4', 'Four', 123456789, 50000, 'Manager', 'Employee4'),
(21, 49, 'Employee', 'E5', 'Five', 123456789, 50000, 'Manager', 'Employee5');

-- Create Employee Emails
INSERT INTO ehotel.employee_email (employee_id, email_address) VALUES
(1, 'employee1@westinhotels.ca'),
(2, 'employee1@novotelshotels.ca'),
(3, 'employee1@fairmonthotels.ca'),
(4, 'employee1@deltahotels.ca'),
(5, 'employee1@hiltonhotels.ca');

-- Create Employee Phone Numbers
INSERT INTO ehotel.employee_phone (employee_id, phone_number) VALUES
(1, '6131234567'),
(2, '5141234567'),
(3, '4161234567'),
(4, '6041234567'),
(5, '7821234567');

-- Create Hotels
INSERT INTO ehotel.hotel (brand_id, manager_id, address_id, star_category, hotel_name) VALUES
(1, NULL, 5, 4, 'The Westin Ottawa'),
(1, NULL, 6, 4, 'The Westin Harbour Castle'),
(1, NULL, 7, 4, 'The Westin Bayshore'),
(1, NULL, 8, 4, 'The Westin Nova Scotian'),
(1, NULL, 9, 4, 'The Westin Montreal'),
(2, NULL, 11, 3, 'Novotel Ottawa'),
(2, NULL, 12, 3, 'Novotel Toronto'),
(2, NULL, 13, 3, 'Novotel Vaughan'),
(2, NULL, 14, 3, 'Novotel Montreal'),
(2, NULL, 15, 3, 'Novotel St. Laurent'),
(3, NULL, 17, 5, 'Fairmont Chateau Laurier'),
(3, NULL, 18, 5, 'Fairmont Royal York'),
(3, NULL, 19, 5, 'Fairmont Le Chateau Frontenac'),
(3, NULL, 20, 5, 'Fairmont Chateau Lake Louise'),
(3, NULL, 21, 5, 'Fairmont Chateau Whistler'),
(4, NULL, 23, 3, 'Delta Calgary'),
(4, NULL, 24, 3, 'Delta Vancouver'),
(4, NULL, 25, 4, 'Delta Toronto'),
(4, NULL, 26, 3, 'Delta Montreal'),
(4, NULL, 27, 3, 'Delta Armouries London'),
(5, NULL, 29, 4, 'Hilton Whistler'),
(5, NULL, 30, 4, 'Hilton Vancouver'),
(5, NULL, 31, 3, 'Hilton Toronto'),
(5, NULL, 32, 3, 'Hilton Quebec'),
(5, NULL, 33, 4, 'Hilton Lac-Leamy'),
(6, NULL, 35, 4, 'Sheraton Saint-Hyacinthe'),
(6, NULL, 36, 4, 'Sheraton Fallsview Niagara'),
(6, NULL, 37, 3, 'Sheraton Calgary Eau Claire'),
(6, NULL, 38, 4, 'Sheraton Toronto'),
(6, NULL, 39, 4, 'Sheraton Vancouver');

-- Create Hotel Emails
INSERT INTO ehotel.hotel_email (hotel_id, email_address) VALUES
(1, 'westinottawa@westinhotels.ca'),
(2, 'westinharbourcastle@westinhotels.ca'),
(3, 'westinbayshore@westinhotels.ca'),
(4, 'westinnovascotian@westinhotels.ca'),
(5, 'westinmontreal@westinhotels.ca'),
(6, 'novotelottawa@novotelshotels.ca'),
(7, 'novoteltoronto@novotelshotels.ca'),
(8, 'novotelvaughan@novotelshotels.ca'),
(9, 'novotelmontreal@novotelshotels.ca'),
(10, 'novotelstlaurent@novotelshotels.ca'),
(11, 'fairmontlaurier@fairmonthotels.ca'),
(12, 'fairmontroyalyork@fairmonthotels.ca'),
(13, 'fairmontfrontenac@fairmonthotels.ca'),
(14, 'fairmontlakelouise@fairmonthotels.ca'),
(15, 'fairmontwhistler@fairmonthotels.ca'),
(16, 'deltacalgary@deltahotels.ca'),
(17, 'deltavancouver@deltahotels.ca'),
(18, 'deltatoronto@deltahotels.ca'),
(19, 'deltamontreal@deltahotels.ca'),
(20, 'deltalondon@deltahotels.ca'),
(21, 'hiltonwhistler@hiltonhotels.ca'),
(22, 'hiltonvancouver@hiltonhotels.ca'),
(23, 'hiltontoronto@hiltonhotels.ca'),
(24, 'hiltonquebec@hiltonhotels.ca'),
(25, 'hiltonlacleamy@hiltonhotels.ca'),
(26, 'sheratonsainthyacinthe@sheratonhotels.ca'),
(27, 'sheratonfallsview@sheratonhotels.ca'),
(28, 'sheratoncalgary@sheratonhotels.ca'),
(29, 'sheratontoronto@sheratonhotels.ca'),
(30, 'sheratonvancouver@sheratonhotels.ca');

-- Create Hotel Phone Numbers
INSERT INTO ehotel.hotel_phone (hotel_id, phone_number) VALUES
(1, '1234567891'),
(2, '1234567891'),
(3, '1234567891'),
(4, '1234567891'),
(5, '1234567891'),
(6, '1234567891'),
(7, '1234567891'),
(8, '1234567891'),
(9, '1234567891'),
(10, '1234567891'),
(11, '1234567891'),
(12, '1234567891'),
(13, '1234567891'),
(14, '1234567891'),
(15, '1234567891'),
(16, '1234567891'),
(17, '1234567891'),
(18, '1234567891'),
(19, '1234567891'),
(20, '1234567891'),
(21, '1234567891'),
(22, '1234567891'),
(23, '1234567891'),
(24, '1234567891'),
(25, '1234567891'),
(26, '1234567891'),
(27, '1234567891'),
(28, '1234567891'),
(29, '1234567891'),
(30, '1234567891');

-- Create Customer Accounts
INSERT INTO ehotel.account (username, password, role) VALUES
('Customer2', 'password', 3),
('Customer3', 'password', 3),
('Customer4', 'password', 3),
('Customer5', 'password', 3);

-- Create Customers
INSERT INTO ehotel.customer (address_id, first_name, middle_initial, last_name, sin, registration_date, username) VALUES
(40, 'Customer', 'C2', 'Two', 123456789, '2021-04-02', 'Customer2'),
(41, 'Customer', 'C3', 'Three', 123456789, '2021-04-02', 'Customer3'),
(42, 'Customer', 'C4', 'Four', 123456789, '2021-04-02', 'Customer4'),
(43, 'Customer', 'C5', 'Five', 123456789, '2021-04-02', 'Customer5');

-- Create Rooms
INSERT INTO ehotel.room (hotel_id, price, capacity, is_sea_view, is_mountain_view, is_extendible, room_name) VALUES
(1, 150, 2, FALSE, FALSE, TRUE, '1'),
(1, 150, 2, FALSE, FALSE, TRUE, '2'),
(1, 150, 2, FALSE, FALSE, TRUE, '3'),
(1, 150, 2, FALSE, FALSE, TRUE, '4'),
(1, 150, 2, FALSE, FALSE, TRUE, '5'),
(2, 125, 2, FALSE, FALSE, TRUE, '1'),
(2, 125, 2, FALSE, FALSE, TRUE, '2'),
(2, 125, 2, FALSE, FALSE, TRUE, '3'),
(2, 125, 2, FALSE, FALSE, TRUE, '4'),
(2, 125, 2, FALSE, FALSE, TRUE, '5'),
(3, 100, 2, FALSE, FALSE, TRUE, '1'),
(3, 100, 2, FALSE, FALSE, TRUE, '2'),
(3, 100, 2, FALSE, FALSE, TRUE, '3'),
(3, 100, 2, FALSE, FALSE, TRUE, '4'),
(3, 100, 2, FALSE, FALSE, TRUE, '5'),
(4, 165, 2, FALSE, FALSE, TRUE, '1'),
(4, 165, 2, FALSE, FALSE, TRUE, '2'),
(4, 165, 2, FALSE, FALSE, TRUE, '3'),
(4, 165, 2, FALSE, FALSE, TRUE, '4'),
(4, 165, 2, FALSE, FALSE, TRUE, '5'),
(5, 125, 2, TRUE, FALSE, TRUE, '1'),
(5, 125, 2, TRUE, FALSE, TRUE, '2'),
(5, 125, 2, TRUE, FALSE, TRUE, '3'),
(5, 125, 2, TRUE, FALSE, TRUE, '4'),
(5, 125, 2, TRUE, FALSE, TRUE, '5'),
(6, 95, 2, FALSE, FALSE, TRUE, '1'),
(6, 95, 2, FALSE, FALSE, TRUE, '2'),
(6, 95, 2, FALSE, FALSE, TRUE, '3'),
(6, 95, 2, FALSE, FALSE, TRUE, '4'),
(6, 95, 2, FALSE, FALSE, TRUE, '5'),
(7, 95, 2, FALSE, FALSE, TRUE, '1'),
(7, 95, 2, FALSE, FALSE, TRUE, '2'),
(7, 95, 2, FALSE, FALSE, TRUE, '3'),
(7, 95, 2, FALSE, FALSE, TRUE, '4'),
(7, 95, 2, FALSE, FALSE, TRUE, '5'),
(8, 95, 2, FALSE, FALSE, TRUE, '1'),
(8, 95, 2, FALSE, FALSE, TRUE, '2'),
(8, 95, 2, FALSE, FALSE, TRUE, '3'),
(8, 95, 2, FALSE, FALSE, TRUE, '4'),
(8, 95, 2, FALSE, FALSE, TRUE, '5'),
(9, 95, 2, FALSE, FALSE, TRUE, '1'),
(9, 95, 2, FALSE, FALSE, TRUE, '2'),
(9, 95, 2, FALSE, FALSE, TRUE, '3'),
(9, 95, 2, FALSE, FALSE, TRUE, '4'),
(9, 95, 2, FALSE, FALSE, TRUE, '5'),
(10, 95, 2, FALSE, FALSE, TRUE, '1'),
(10, 95, 2, FALSE, FALSE, TRUE, '2'),
(10, 95, 2, FALSE, FALSE, TRUE, '3'),
(10, 95, 2, FALSE, FALSE, TRUE, '4'),
(10, 95, 2, FALSE, FALSE, TRUE, '5'),
(11, 300, 2, FALSE, FALSE, TRUE, '1'),
(11, 350, 2, FALSE, FALSE, TRUE, '2'),
(11, 325, 2, FALSE, FALSE, TRUE, '3'),
(11, 300, 2, FALSE, FALSE, TRUE, '4'),
(11, 300, 2, FALSE, FALSE, TRUE, '5'),
(12, 325, 2, FALSE, FALSE, TRUE, '1'),
(12, 325, 2, FALSE, FALSE, TRUE, '2'),
(12, 325, 2, FALSE, FALSE, TRUE, '3'),
(12, 325, 2, FALSE, FALSE, TRUE, '4'),
(12, 325, 2, FALSE, FALSE, TRUE, '5'),
(13, 350, 2, FALSE, FALSE, TRUE, '1'),
(13, 350, 2, FALSE, FALSE, TRUE, '2'),
(13, 350, 2, FALSE, FALSE, TRUE, '3'),
(13, 350, 2, FALSE, FALSE, TRUE, '4'),
(13, 350, 2, FALSE, FALSE, TRUE, '5'),
(14, 300, 2, FALSE, FALSE, TRUE, '1'),
(14, 300, 2, FALSE, FALSE, TRUE, '2'),
(14, 300, 2, FALSE, FALSE, TRUE, '3'),
(14, 300, 2, FALSE, FALSE, TRUE, '4'),
(14, 300, 2, FALSE, FALSE, TRUE, '5'),
(15, 300, 2, FALSE, FALSE, TRUE, '1'),
(15, 300, 2, FALSE, FALSE, TRUE, '2'),
(15, 300, 2, FALSE, FALSE, TRUE, '3'),
(15, 300, 2, FALSE, FALSE, TRUE, '4'),
(15, 300, 2, FALSE, FALSE, TRUE, '5'),
(16, 150, 2, FALSE, FALSE, TRUE, '1'),
(16, 150, 2, FALSE, FALSE, TRUE, '2'),
(16, 150, 2, FALSE, FALSE, TRUE, '3'),
(16, 150, 2, FALSE, FALSE, TRUE, '4'),
(16, 150, 2, FALSE, FALSE, TRUE, '5'),
(17, 150, 2, FALSE, FALSE, TRUE, '1'),
(17, 150, 2, FALSE, FALSE, TRUE, '2'),
(17, 150, 2, FALSE, FALSE, TRUE, '3'),
(17, 150, 2, FALSE, FALSE, TRUE, '4'),
(17, 150, 2, FALSE, FALSE, TRUE, '5'),
(18, 150, 2, FALSE, FALSE, TRUE, '1'),
(18, 150, 2, FALSE, FALSE, TRUE, '2'),
(18, 150, 2, FALSE, FALSE, TRUE, '3'),
(18, 150, 2, FALSE, FALSE, TRUE, '4'),
(18, 150, 2, FALSE, FALSE, TRUE, '5'),
(19, 150, 2, FALSE, FALSE, TRUE, '1'),
(19, 150, 2, FALSE, FALSE, TRUE, '2'),
(19, 150, 2, FALSE, FALSE, TRUE, '3'),
(19, 150, 2, FALSE, FALSE, TRUE, '4'),
(19, 150, 2, FALSE, FALSE, TRUE, '5'),
(20, 150, 2, FALSE, FALSE, TRUE, '1'),
(20, 150, 2, FALSE, FALSE, TRUE, '2'),
(20, 150, 2, FALSE, FALSE, TRUE, '3'),
(20, 150, 2, FALSE, FALSE, TRUE, '4'),
(20, 150, 2, FALSE, FALSE, TRUE, '5'),
(21, 200, 2, FALSE, FALSE, TRUE, '1'),
(21, 200, 2, FALSE, FALSE, TRUE, '2'),
(21, 200, 2, FALSE, FALSE, TRUE, '3'),
(21, 200, 2, FALSE, FALSE, TRUE, '4'),
(21, 200, 2, FALSE, FALSE, TRUE, '5'),
(22, 200, 2, FALSE, FALSE, TRUE, '1'),
(22, 200, 2, FALSE, FALSE, TRUE, '2'),
(22, 200, 2, FALSE, FALSE, TRUE, '3'),
(22, 200, 2, FALSE, FALSE, TRUE, '4'),
(22, 200, 2, FALSE, FALSE, TRUE, '5'),
(23, 200, 2, FALSE, FALSE, TRUE, '1'),
(23, 200, 2, FALSE, FALSE, TRUE, '2'),
(23, 200, 2, FALSE, FALSE, TRUE, '3'),
(23, 200, 2, FALSE, FALSE, TRUE, '4'),
(23, 200, 2, FALSE, FALSE, TRUE, '5'),
(24, 200, 2, FALSE, FALSE, TRUE, '1'),
(24, 200, 2, FALSE, FALSE, TRUE, '2'),
(24, 200, 2, FALSE, FALSE, TRUE, '3'),
(24, 200, 2, FALSE, FALSE, TRUE, '4'),
(24, 200, 2, FALSE, FALSE, TRUE, '5'),
(25, 200, 2, FALSE, FALSE, TRUE, '1'),
(25, 200, 2, FALSE, FALSE, TRUE, '2'),
(25, 200, 2, FALSE, FALSE, TRUE, '3'),
(25, 200, 2, FALSE, FALSE, TRUE, '4'),
(25, 200, 2, FALSE, FALSE, TRUE, '5'),
(26, 200, 2, FALSE, FALSE, TRUE, '1'),
(26, 200, 2, FALSE, FALSE, TRUE, '2'),
(26, 200, 2, FALSE, FALSE, TRUE, '3'),
(26, 200, 2, FALSE, FALSE, TRUE, '4'),
(26, 200, 2, FALSE, FALSE, TRUE, '5'),
(27, 200, 2, FALSE, FALSE, TRUE, '1'),
(27, 200, 2, FALSE, FALSE, TRUE, '2'),
(27, 200, 2, FALSE, FALSE, TRUE, '3'),
(27, 200, 2, FALSE, FALSE, TRUE, '4'),
(27, 200, 2, FALSE, FALSE, TRUE, '5'),
(28, 200, 2, FALSE, FALSE, TRUE, '1'),
(28, 200, 2, FALSE, FALSE, TRUE, '2'),
(28, 200, 2, FALSE, FALSE, TRUE, '3'),
(28, 200, 2, FALSE, FALSE, TRUE, '4'),
(28, 200, 2, FALSE, FALSE, TRUE, '5'),
(29, 200, 2, FALSE, FALSE, TRUE, '1'),
(29, 200, 2, FALSE, FALSE, TRUE, '2'),
(29, 200, 2, FALSE, FALSE, TRUE, '3'),
(29, 200, 2, FALSE, FALSE, TRUE, '4'),
(29, 200, 2, FALSE, FALSE, TRUE, '5'),
(30, 200, 2, FALSE, FALSE, TRUE, '1'),
(30, 200, 2, FALSE, FALSE, TRUE, '2'),
(30, 200, 2, FALSE, FALSE, TRUE, '3'),
(30, 200, 2, FALSE, FALSE, TRUE, '4'),
(30, 200, 2, FALSE, FALSE, TRUE, '5');