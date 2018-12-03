CREATE TABLE public.partners (
	email varchar(255) NOT NULL,
	created_date timestamp NULL,
	last_modified_date timestamp NULL,
	country_id varchar(255) NULL,
	password varchar(255) NULL,
	CONSTRAINT partners_pkey PRIMARY KEY (email)
);

CREATE TABLE public.brands (
	id varchar(255) NOT NULL,
	brand_name varchar(255) NULL,
	CONSTRAINT brands_pkey PRIMARY KEY (id)
);

CREATE TABLE public.stores (
	store_id varchar(255) NOT NULL,
	created_date timestamp NULL,
	last_modified_date timestamp NULL,
	brand_id varchar(255) NOT NULL,
	CONSTRAINT stores_pkey PRIMARY KEY (store_id),
	CONSTRAINT stores_brands_fkey FOREIGN KEY (brand_id) REFERENCES brands(id)
);

CREATE TABLE public.partner_stores (
	store_store_id varchar(255) NOT NULL,
	partner_email varchar(255) NOT NULL,
	CONSTRAINT partner_stores_pkey PRIMARY KEY (partner_email, store_store_id),
	CONSTRAINT partner_stores_partners_fkey FOREIGN KEY (partner_email) REFERENCES partners(email),
	CONSTRAINT partner_stores_stores_fkey FOREIGN KEY (store_store_id) REFERENCES stores(store_id)
);

CREATE TABLE public.groupings (
  id bigserial NOT NULL,
  name varchar(255) NOT NULL,
  created_date timestamp NULL,
  last_modified_date timestamp NULL,
  CONSTRAINT groupings_pkey PRIMARY KEY (id)
);

CREATE TABLE public.partner_store_groupings (
  grouping_id bigint NOT NULL,
  partner_store_store_id varchar(255) NOT NULL,
  partner_store_partner_email varchar(255) NOT NULL,
  CONSTRAINT partner_stores_groupings_pkey
    PRIMARY KEY (grouping_id, partner_store_store_id, partner_store_partner_email),
  CONSTRAINT partner_store_groupings_groupings_fkey
    FOREIGN KEY (grouping_id) REFERENCES groupings(id),
  CONSTRAINT partner_store_groupings_partner_stores_fkey
    FOREIGN KEY (partner_store_store_id, partner_store_partner_email)
    REFERENCES partner_stores(store_store_id, partner_email)
);

CREATE INDEX created_date_partner_idx ON public.partners (created_date);
CREATE INDEX created_date_stores_idx ON public.stores (created_date);
CREATE INDEX partner_email_idx ON public.partner_stores (partner_email);
CREATE INDEX created_date_groupings_idx ON public.groupings (created_date);

CREATE SEQUENCE hibernate_sequence START 3 INCREMENT BY 1;



