-- Table: public.survey_data
-- DROP TABLE IF EXISTS public.survey_data;
CREATE TABLE IF NOT EXISTS public.survey_data(
 	survey_data_id bigserial NOT NULL, 
   	branch_name bigint NOT NULL,
   	district_name bigint NOT NULL,
   	block_name bigint NOT NULL,
   	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
   	created_user bigint NOT NULL,
   	modified_user bigint NOT NULL,
   	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    	active smallint NOT NULL DEFAULT 1,
    	CONSTRAINT survey_data_pkey PRIMARY KEY (survey_data_id),
    	FOREIGN KEY (created_user) REFERENCES public.users(id),
    	FOREIGN KEY (modified_user) REFERENCES public.users(id),
    	FOREIGN KEY (branch_name) REFERENCES public.branch(id),
    	FOREIGN KEY (district_name) REFERENCES public.district(id),
    	FOREIGN KEY (block_name) REFERENCES public.mandal(id)
);  

-- Table: public.branch_operation_area
-- DROP TABLE IF EXISTS public.branch_operation_area;
CREATE TABLE IF NOT EXISTS public.branch_operation_area(
    	branch_operation_area_id bigserial NOT NULL,
    	state_id character varying(255) NOT NULL,
    	district_id character varying(255) NOT NULL,
    	blocks_id character varying(255) NOT NULL,
    	pincode character varying(255) NOT NULL,
    	question bigint,
    	value character varying(255),
    	branch_operation_area_information_id bigint,
    	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    	created_user bigint NOT NULL,
    	modified_user bigint NOT NULL,
    	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    	active smallint NOT NULL DEFAULT 1,
    	CONSTRAINT branch_operation_area_pkey PRIMARY KEY (branch_operation_area_id),
    	FOREIGN KEY (created_user) REFERENCES public.users(id),
    	FOREIGN KEY (modified_user) REFERENCES public.users(id),
    	FOREIGN KEY (question) REFERENCES public.question(id),
    	FOREIGN KEY (branch_operation_area_information_id) REFERENCES public.survey_data(survey_data_id)
);

--Table: public.visited_institutions
-- DROP TABLE IF EXISTS public.visited_institutions;
CREATE TABLE IF NOT EXISTS public.visited_institutions(
	visited_institutions_id bigserial NOT NULL,
	type bigint,
	institution_name bigint NOT NULL,
	contact_person character varying(225) NOT NULL,
	contact_number bigint NOT NULL,
	coordinates character varying(225) NOT NULL,
	operating_since Date NOT NULL ,
	visited_institutions_information_id bigint,
	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
        created_user bigint NOT NULL,
        modified_user bigint NOT NULL,
        modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
        active smallint NOT NULL DEFAULT 1,
	CONSTRAINT visited_institutions_pkey PRIMARY KEY (visited_institutions_id),
	FOREIGN KEY (type) REFERENCES public.financial_institutions(id),
	FOREIGN KEY (institution_name) REFERENCES public.financial_institutions(id),
	FOREIGN KEY (created_user) REFERENCES public.users(id),
	FOREIGN KEY (modified_user) REFERENCES public.users(id),
	FOREIGN KEY (visited_institutions_information_id) REFERENCES public.survey_data(survey_data_id)
);

--Table: public.visited_villages
-- DROP TABLE IF EXISTS public.visited_villages;
CREATE TABLE IF NOT EXISTS public.visited_villages(
	visited_villages_id bigserial NOT NULL,
	village_id bigint NOT NULL,
 	district_id bigint NOT NULL,
  	block_id bigint NOT NULL,
  	pincode bigint,
  	coordinates character varying(255) NOT NULL,
   	present_time timestamp with time zone NOT NULL DEFAULT ('now'::text)::timestamp with time zone,
   	contact_person character varying(255) NOT NULL,
	contact_number bigint NOT NULL,
	number_of_households bigint NOT NULL,
	number_of_milk_centers bigint NOT NULL,
	number_of_kirana_shops bigint NOT NULL,
	number_of_cosmetics_shops bigint NOT NULL,
	number_of_teaeastries bigint NOT NULL,
	number_of_other_shops bigint NOT NULL,
	primary_activity bigint NOT NULL,
    	secondary_activity bigint NOT NULL,
    	other_activity character varying(255) NOT NULL,
	question bigint,
	value character varying(255),
	number_of_clients bigint,
	visited_villages_information_id bigint,
	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_user bigint NOT NULL,
	modified_user bigint NOT NULL,
	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	active smallint NOT NULL DEFAULT 1,
	CONSTRAINT visited_villages_pkey PRIMARY KEY (visited_villages_id),
	FOREIGN KEY (created_user) REFERENCES public.users(id),
	FOREIGN KEY (modified_user) REFERENCES public.users(id),
	FOREIGN KEY (village_id) REFERENCES public.village(id),
	FOREIGN KEY (district_id) REFERENCES public.district(id),
	FOREIGN KEY (block_id) REFERENCES public.mandal(id),
	FOREIGN KEY (question) REFERENCES public.question(id),
	FOREIGN KEY (primary_activity) REFERENCES public.activity(id),
	FOREIGN KEY (secondary_activity) REFERENCES public.activity(id),
	FOREIGN KEY (visited_villages_information_id) REFERENCES public.survey_data(survey_data_id)
);

-- Table: public.negative_area
-- DROP TABLE IF EXISTS public.negative_area;
CREATE TABLE IF NOT EXISTS public.negative_area (
    	negative_area_id bigserial NOT NULL,
    	negative_area bigint NOT NULL,
    	negative_area_infromation_id bigint,
    	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_user bigint NOT NULL,
	modified_user bigint NOT NULL,
	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	active smallint NOT NULL DEFAULT 1,
    	CONSTRAINT negative_area_pkey PRIMARY KEY (negative_area_id),
    	FOREIGN KEY (created_user) REFERENCES public.users(id),
	FOREIGN KEY (modified_user) REFERENCES public.users(id),
    	FOREIGN KEY (negative_area) REFERENCES public.negative_areas(id),
    	FOREIGN KEY (negative_area_infromation_id) REFERENCES public.survey_data(survey_data_id)
);

--Table: public.negative_occupations
-- DROP TABLE IF EXISTS public.negative_occupations;
CREATE TABLE IF NOT EXISTS public.negative_occupations(
	negative_occupations_id bigserial NOT NULL,
	other_information character varying(200),
	assessed_risk character varying(200),
	negative_occupations_information_id bigint,
	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_user bigint NOT NULL,
	modified_user bigint NOT NULL,
	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	active smallint NOT NULL DEFAULT 1,
	CONSTRAINT negative_occupations_pkey PRIMARY KEY (negative_occupations_id),
	FOREIGN KEY (created_user) REFERENCES public.users(id),
	FOREIGN KEY (modified_user) REFERENCES public.users(id),
	FOREIGN KEY (negative_occupations_information_id) REFERENCES public.survey_data(survey_data_id)
);

--Table: public.rating
-- DROP TABLE IF EXISTS public.rating;
CREATE TABLE IF NOT EXISTS public.rating(
	rating_id bigserial NOT NULL,
	question bigint,
	business_enviorment_rating character varying(255),
	rms_rating character varying(50),
	rms_recommendations character varying(50),
	rating_information_id bigint,
	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_user bigint NOT NULL,
	modified_user bigint NOT NULL,
	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	active smallint NOT NULL DEFAULT 1,
	CONSTRAINT rating_pkey PRIMARY KEY (rating_id),
	FOREIGN KEY (created_user) REFERENCES public.users(id),
	FOREIGN KEY (modified_user) REFERENCES public.users(id),
	FOREIGN KEY (rating_information_id) REFERENCES public.survey_data(survey_data_id),
	FOREIGN KEY (question) REFERENCES public.question(id)
);


--Table: public.recommendations
-- DROP TABLE IF EXISTS public.recommendations;
CREATE TABLE IF NOT EXISTS public.recommendations(
	recommendations_id bigserial NOT NULL,
	option1 character varying(200),
	block1 bigint,
	option2 character varying(200),
	block2 bigint,
	final_recommendations character varying(200),
	final_recommendations_by_surveyor character varying(200),
	final_recommendations_by_rm character varying(200),
	recommendations_information_id bigint,
	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_user bigint NOT NULL,
	modified_user bigint NOT NULL,
	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	active smallint NOT NULL DEFAULT 1,
	CONSTRAINT recommendations_pkey PRIMARY KEY (recommendations_id),
	FOREIGN KEY (created_user) REFERENCES public.users(id),
	FOREIGN KEY (modified_user) REFERENCES public.users(id),
	FOREIGN KEY (block1) REFERENCES public.mandal(id),
	FOREIGN KEY (block2) REFERENCES public.mandal(id),
	FOREIGN KEY (recommendations_information_id) REFERENCES public.survey_data(survey_data_id)
);


-- Table: public.operational_details
-- DROP TABLE IF EXISTS public.operational_details;
create table if not exists public.operational_details(
	operational_details_id bigserial not null,
	client_detail bigint not null,
	pos numeric not null,
	par numeric not null,
	amt_par numeric not null,
	operational_details_information_id bigint,
	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_user bigint NOT NULL,
	modified_user bigint NOT NULL,
	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	active smallint NOT NULL DEFAULT 1,
	CONSTRAINT operational_details_pkey PRIMARY KEY (operational_details_id),
	foreign key (created_user) references public.users(id),
	foreign key (modified_user) references public.users(id),
	foreign key (operational_details_information_id) references public.visited_institutions(visited_institutions_id)
); 

-- Table: public.major_par_villages
-- DROP TABLE IF EXISTS public.major_par_villages;
CREATE TABLE IF NOT EXISTS public.major_par_villages(
	major_par_villages_id bigserial NOT NULL,
	name character varying(255) NOT NULL,
	clients character varying(255) NOT NULL,
	reasons character varying(255) NOT NULL,
	major_par_villages_information_id bigint,
	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_user bigint NOT NULL,
	modified_user bigint NOT NULL,
	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	active smallint NOT NULL DEFAULT 1,
	CONSTRAINT major_par_villages_pkey PRIMARY KEY (major_par_villages_id),
	FOREIGN KEY (created_user) REFERENCES public.users(id),
	FOREIGN KEY (modified_user) REFERENCES public.users(id),
	FOREIGN KEY (major_par_villages_information_id) REFERENCES public.visited_institutions(visited_institutions_id)
);

--Table: public.negative_villages
-- DROP TABLE IF EXISTS public.negative_villages;
CREATE TABLE IF NOT EXISTS public.negative_villages(
	negative_villages_id bigserial NOT NULL,
	village_name character varying(255) NOT NULL,
	negative_reason character varying(255) NOT NULL,
	negative_villages_information_id bigint,
	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_user bigint NOT NULL,
	modified_user bigint NOT NULL,
	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	active smallint NOT NULL DEFAULT 1,
	CONSTRAINT negative_villages_pkey PRIMARY KEY (negative_villages_id),
	FOREIGN KEY (created_user) REFERENCES public.users(id),
	FOREIGN KEY (modified_user) REFERENCES public.users(id),
	FOREIGN KEY (negative_villages_information_id) REFERENCES public.visited_institutions(visited_institutions_id)
);

--Table: public.bank_and_lending_institutions
-- DROP TABLE IF EXISTS public.bank_and_lending_institutions;
CREATE TABLE IF NOT EXISTS public.bank_and_lending_institutions(
	bank_and_lending_institutions_id bigserial NOT NULL,
	bank_name character varying(255) NOT NULL,
	type character varying(255) NOT NULL,
	bank_clients character varying(255) NOT NULL,
	bank_and_lending_institutions_information_id bigint,
	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_user bigint NOT NULL,
	modified_user bigint NOT NULL,
	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	active smallint NOT NULL DEFAULT 1,
	CONSTRAINT bank_and_lending_institutions_pkey PRIMARY KEY (bank_and_lending_institutions_id),
	FOREIGN KEY (created_user) REFERENCES public.users(id),
	FOREIGN KEY (modified_user) REFERENCES public.users(id),
	FOREIGN KEY (bank_and_lending_institutions_information_id) REFERENCES public.visited_villages(visited_villages_id)
);

-- Table: public.ring_leaders
-- DROP TABLE IF EXISTS public.ring_leaders;
CREATE TABLE IF NOT EXISTS public.ring_leaders(
    	ring_leaders_id bigserial NOT NULL,
    	ring_leader character varying(255),
    	identifier1 character varying(255),
    	identifier2 character varying(255),
    	ring_leaders_information_id bigint,
    	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    	created_user bigint NOT NULL,
    	modified_user bigint NOT NULL,
    	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    	active smallint NOT NULL DEFAULT 1,
    	CONSTRAINT ring_leaders_pkey PRIMARY KEY (ring_leaders_id),
    	FOREIGN KEY (created_user) REFERENCES public.users(id),
    	FOREIGN KEY (modified_user) REFERENCES public.users(id),
    	FOREIGN KEY (ring_leaders_information_id) REFERENCES public.negative_area(negative_area_id)
);

-- Table: public.negative_occupation_information
-- DROP TABLE IF EXISTS public.negative_occupation_information;
CREATE TABLE IF NOT EXISTS public.negative_occupation_information(
    	negative_occupation_information_id bigserial NOT NULL,
    	negative_occupation character varying(255),
    	area character varying(50),
    	negative_occupation_id bigint,
    	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    	created_user bigint NOT NULL,
    	modified_user bigint NOT NULL,
    	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    	active smallint NOT NULL DEFAULT 1,
    	CONSTRAINT negative_occupation_information_pkey PRIMARY KEY (negative_occupation_information_id),
    	FOREIGN KEY (created_user) REFERENCES public.users(id),
    	FOREIGN KEY (modified_user) REFERENCES public.users(id),
    	FOREIGN KEY (negative_occupation_id) REFERENCES public.negative_occupations(negative_occupations_id)
);


-- Table: public.key_findings
-- DROP TABLE IF EXISTS public.key_findings;
CREATE TABLE IF NOT EXISTS public.key_findings(
    	key_findings_id bigserial NOT NULL,
    	parameters character varying(255),
    	expected_value bigint,
    	key_findings_information_id bigint,
    	created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    	created_user bigint NOT NULL,
    	modified_user bigint NOT NULL,
    	modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    	active smallint NOT NULL DEFAULT 1,
    	CONSTRAINT key_findings_pkey PRIMARY KEY (key_findings_id),
    	FOREIGN KEY (created_user) REFERENCES public.users(id),
    	FOREIGN KEY (modified_user) REFERENCES public.users(id),
    	FOREIGN KEY (key_findings_information_id) REFERENCES public.recommendations(recommendations_id)
);




