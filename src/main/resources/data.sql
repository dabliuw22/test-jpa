INSERT INTO partners(email, created_date, last_modified_date, country_id, password)
	VALUES('wleylop22@gmail.com', now(), NULL, 'CO', 'password1');

INSERT INTO partners(email, created_date, last_modified_date, country_id, password)
	VALUES('erlicodina@gmail.com', now(), NULL, 'CO', 'password2');
	
INSERT INTO brands(id, brand_name)
	VALUES('brandId', 'Brand1');
	
INSERT INTO stores(store_id, created_date, last_modified_date, brand_id)
	VALUES('CO1234567', now(), NULL, 'brandId');
	
INSERT INTO stores(store_id, created_date, last_modified_date, brand_id)
	VALUES('CO8888867', now(), NULL, 'brandId');
	
INSERT INTO stores(store_id, created_date, last_modified_date, brand_id)
	VALUES('CO8888869', now(), NULL, 'brandId');
	
INSERT INTO partner_stores(store_store_id, partner_email)
	VALUES('CO1234567', 'wleylop22@gmail.com');

INSERT INTO partner_stores(store_store_id, partner_email)
	VALUES('CO8888867', 'erlicodina@gmail.com');
	
INSERT INTO partner_stores(store_store_id, partner_email)
	VALUES('CO8888869', 'erlicodina@gmail.com');
	
INSERT INTO groupings(id, name, created_date, last_modified_date)
	VALUES(1, 'Groupin1', now(), NULL);

INSERT INTO groupings(id, name, created_date, last_modified_date)
	VALUES(2, 'Groupin2', now(), NULL);
	
INSERT INTO partner_store_groupings(grouping_id, partner_store_store_id, partner_store_partner_email)
	VALUES(1, 'CO1234567', 'wleylop22@gmail.com');

INSERT INTO partner_store_groupings(grouping_id, partner_store_store_id, partner_store_partner_email)
	VALUES(2, 'CO1234567', 'wleylop22@gmail.com');