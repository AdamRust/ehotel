/*
 * Script to create triggers for the ehotel application database,
 * for the CSI 2132 final project of the Winter term 2021.
 * 
 * Section: A07
 * Group: 27
 */

-- Create trigger for credit card expiry date
CREATE TRIGGER check_credit_card_expiry
BEFORE UPDATE ON rental
FOR EACH ROW EXECUTE PROCEDURE check_credit_card_expiry();
-- Create associated function
CREATE FUNCTION check_credit_card_expiry()
RETURNS trigger AS
$BODY$
BEGIN

IF NEW.credit_card_expiry_date IS NULL THEN
    RAISE EXCEPTION 'The credit card must have an expiry date.';
END IF;

IF NEW.credit_card_expiry_date < CURRENT_DATE THEN
    RAISE EXCEPTION 'The credit card is expired.';
END IF;

RETURN NEW;

END

$BODY$ LANGUAGE plpgsql;

-- Create trigger for hotel star category
CREATE TRIGGER check_star_category
BEFORE UPDATE ON hotel
FOR EACH ROW EXECUTE PROCEDURE check_star_category();
-- Create associated function
CREATE FUNCTION check_star_category()
RETURNS trigger AS
$BODY$
BEGIN

IF NEW.star_category IS NULL THEN
    RAISE EXCEPTION 'The star category must not be null.';
END IF;

IF NEW.star_category < 1 OR NEW.star_category > 5 THEN
    RAISE EXCEPTION 'The star category must be between 1 and 5.';
END IF;

RETURN NEW;

END

$BODY$ LANGUAGE plpgsql;