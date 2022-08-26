-- Table: public.state
-- DROP TABLE IF EXISTS public.state;
CREATE TABLE IF NOT EXISTS public.state (
    state_id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT state_pkey PRIMARY KEY (state_id)
);

-- Table: public.district
-- DROP TABLE IF EXISTS public.district;
CREATE TABLE IF NOT EXISTS public.district (
    district_id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    state bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT district_pkey PRIMARY KEY (district_id),
    foreign key (state) references public.state(state_id)
);


-- Table: public.mandal
-- DROP TABLE IF EXISTS public.mandal;
CREATE TABLE IF NOT EXISTS public.mandal (
    mandal_id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    district bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT mandal_pkey PRIMARY KEY (mandal_id),
    foreign key (district) references public.district(district_id)
);


-- Table: public.branch
-- DROP TABLE IF EXISTS public.branch;
CREATE TABLE IF NOT EXISTS public.branch (
    branch_id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    mandal bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT branch_pkey PRIMARY KEY (branch_id),
    foreign key (mandal) references public.mandal(mandal_id)
);

-- Table: public.users

-- DROP TABLE IF EXISTS public."users";

CREATE TABLE IF NOT EXISTS public."users"
(
    id bigserial NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    middle_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default",
    password character varying(100) NOT NULL,
    screen_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    internal_user boolean,
    created_user bigint NOT NULL,
    created_on timestamp with time zone NOT NULL DEFAULT ('now'::text)::timestamp with time zone,
    modified_user bigint,
    modified_on timestamp with time zone,
    effective_date date NOT NULL DEFAULT CURRENT_DATE,
    expiry_date date NOT NULL DEFAULT '9999-12-31'::date,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT users_email UNIQUE (email),
    CONSTRAINT effective_expiry_date_check CHECK (expiry_date IS NULL OR expiry_date >= effective_date)
);


-- Table: public.survey_forms
-- Drop table if exists public.survey_forms;
create table if not exists survey_forms(
	survey_forms_id bigserial not null,
	branch_id int,
	foreign key (branch_id) references public.branch(branch_id),
	constraint survey_forms_pkey primary key (survey_forms_id)
);

-- Table: public.panchayath
-- DROP TABLE IF EXISTS public.panchayath;
CREATE TABLE IF NOT EXISTS public.panchayath (
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    mandal bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT panchayath_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (mandal) references public.mandal(mandal_id)
);

-- Table: public.village_classification
-- DROP TABLE IF EXISTS public.village_classification;
-- Possible values Panchayat, Nagar Panchayat, muncipality
CREATE TABLE IF NOT EXISTS public.village_classification (
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT village_classification_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id)
);
-- Table: public.village
-- DROP TABLE IF EXISTS public.village;
CREATE TABLE IF NOT EXISTS public.village (
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    panchayath bigint,
    classification bigint,
    no_of_households bigint,
    route text,
    pincode bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT village_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (panchayath) references public.panchayath(id),
    foreign key (classification) references public.village_classification(id)
);


--Table: public.branchOperation_area
-- Drop Table if exists branchOperation_area;
create table if not exists branch_operation_area(
	branch_operation_area_id bigserial not null,
	state_id bigint not null,
	district_id bigint not null,
	mandal_id bigint not null,
	pincode varchar,
	question bigint,
	value character varying,
	branchoperationarea_id bigint,
	constraint branch_operation_area_pkey primary key(branch_operation_area_id),
	foreign key (state_id) references public.state(state_id),
	foreign key (district_id) references public.district(district_id),
	foreign key (mandal_id) references public.mandal(mandal_id),
	foreign key (branchoperationarea_id) references public.survey_forms(survey_forms_id)
);

-- Table: public.visited_institutions
-- Drop table if exists public.visited_institutions;
create table if not exists visited_institutions(
	visited_institutions_id bigserial not null,
	type character varying,
	contact_person character varying,
	contact_number bigint,
	operatig_since date,
	visitedinstitutions_id int,
	constraint visited_institutions_pkey primary key (visited_institutions_id),
	foreign key(visitedinstitutions_id) references public.survey_forms(survey_forms_id)
	);
	
-- Table: public.village_visited
-- Drop table if exsits public.village_visited;
create table if not exists village_visited(
	visited_id bigserial not null,
	suitable_for_pragati_operations character varying,
	number_of_clients int not null,
	village_visited_id int,
	constraint village_visited_pkey primary key(visited_id),
	foreign key(village_visited_id) references public.survey_forms(survey_forms_id)
);
-- Table: public.negative_areas
-- Drop Table if exists negative_areas;
create table if not exists negative_areas(
	negative_id bigserial NOT NULL,
        branch_id int,
        name character varying(50) not null,
        created_on timestamp without time zone not null DEFAULT CURRENT_TIMESTAMP,
        created_user bigint not null,
        modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
        modified_user bigint not null,
        active smallint NOT NULL DEFAULT 1,
        negativeareas_id bigint,
	constraint negative_areas_pkey primary key (negative_id),
        foreign key (branch_id) references public.branch(branch_id),
        foreign key (negativeareas_id) references public.survey_forms(survey_forms_id)	
);

--Table: public.negative_occupation
-- Drop Table if exists negative_occupation;
create table if not exists negative_occupation(
	negative_occupation_id bigserial not null,
	branch_id int,
	negative_occupation_name character varying(50),
	area character varying(50),
	other_information character varying(50),
	assessed_risk character varying(50),
	negativeoccupation_id int,
	constraint negative_occupation_pkey primary key(negative_occupation_id),
	foreign key (branch_id) references public.branch(branch_id),
	foreign key(negativeoccupation_id) references public.survey_forms(survey_forms_id)
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
	FOREIGN KEY (rating_information_id) REFERENCES public.survey_forms(survey_forms_id),
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
	FOREIGN KEY (block1) REFERENCES public.mandal(mandal_id),
	FOREIGN KEY (block2) REFERENCES public.mandal(mandal_id),
	FOREIGN KEY (recommendations_information_id) REFERENCES public.survey_forms(survey_forms_id)
);


-- Table: public.operational_details
-- DROP TABLE IF EXISTS public.operational_details;
CREATE TABLE IF NOT EXISTS public.operational_details (
    id bigserial NOT NULL,
    client_detail bigint NOT NULL,
    pos numeric NOT NULL,
    par numeric NOT NULL,
    amt_par numeric NOT NULL,
    operational_details bigint,
    CONSTRAINT operational_details_pkey PRIMARY KEY (id),
    foreign key(operational_details) references public.visited_institutions(visited_institutions_id)  
);



-- Table: public.major_village
-- DROP TABLE IF EXISTS public.major_village;
create table if not exists public.major_village(
	id bigserial NOT NULL,
	name character varying(200) NOT NULL,
	clients character varying(200) NOT NULL,
	reasons character varying(200) NOT NULL,
	major_par_village bigint,
	CONSTRAINT major_village_pkey PRIMARY KEY(id),
	foreign key(major_par_village) references public.visited_institutions(visited_institutions_id)
);


-- Table: public.negative_village
-- DROP TABLE IF EXISTS public.negative_village;
create table if not exists public.negative_village(
	id bigserial NOT NULL,
	name character varying(200) NOT NULL,
	reasons character varying(200) NOT NULL,
	negative_village bigint,
	CONSTRAINT negative_village_pkey PRIMARY KEY(id),
        foreign key(negative_village) references public.visited_institutions(visited_institutions_id)
);


-- Table: public.economic_and_financialinfo
-- DROP TABLE IF EXISTS public.economic_and_financialinfo;
create table if not exists economic_and_financialinfo(
	econmic_id bigserial NOT NULL,
	village character varying(200) NOT NULL,
	district character varying(200) NOT NULL,
	block character varying(200) NOT NULL,
	pincode bigint,
	coordinates character varying(200) NOT NULL,
	time timestamp without time zone not null default current_timestamp,
	economicfinancial_id bigint,
    	CONSTRAINT economic_and_financialinfo_pkey PRIMARY KEY (econmic_id),
    	foreign key(economicfinancial_id) references public.village_visited(visited_id)
);

-- Table: public.other_details
-- DROP TABLE IF EXISTS public.other_details;
create table if not exists other_details(
	other_id bigserial NOT NULL,
	contact_person character varying(200) NOT NULL,
	contact_number bigint NOT NULL,
	no_of_households smallint,
	no_of_kirana_shops smallint,
	no_of_cosmetic_shops smallint,
	no_of_small_eatries smallint,
	no_of_other_shops smallint,
	no_ofmilk_coll_center smallint,
	otherdetails_id bigint,
	CONSTRAINT other_details_pkey PRIMARY KEY (other_id),
	foreign key(otherdetails_id) references public.village_visited(visited_id)
);

-- Table: public.activity
-- DROP TABLE IF EXISTS public.activity;
CREATE TABLE IF NOT EXISTS public.activity(
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT activity_pkey PRIMARY KEY (id),
    activity_id int,
    foreign key (activity_id)references public.village_visited(visited_id)
);

-- Table: public.banking_lending_institutions
-- DROP TABLE IF EXISTS public.banking_lending_institutions;
create table if not exists banking_lending_institutions(
	bankinglending_id  bigserial NOT NULL,
	name character varying,
	type character varying,
	clients bigint not null,
	bankinglending_institutions_id bigint,
	CONSTRAINT banking_lending_institutions_pkey PRIMARY KEY (bankinglending_id ),
	foreign key(bankinglending_institutions_id) references public.village_visited(visited_id)
);


-- Table: public.ring_leaders
-- DROP TABLE IF EXISTS public.ring_leaders;
create table if not exists ring_leaders(
	ring_leaders_id  bigserial NOT NULL,
	branch_id int,
	ring_leader character varying(50),
	identifier1 bigint,
	identifier2 character varying,
	ring_leaders bigint,
	CONSTRAINT ring_leaders_pkey PRIMARY KEY (ring_leaders_id),
	foreign key (ring_leaders)references public.negative_areas(negative_id),
	foreign key (branch_id) references public.branch(branch_id)
);



-- Table: public.negativeoccupation_info
-- DROP TABLE IF EXISTS public.negativeoccupation_info;
create table if not exists negativeoccupation_info(
	negative_occupation_info_id bigserial not null,
	branch_id int,
	other_information character varying,
	assessed_risk character varying,
	negativeoccupationinfo_id bigint,
	CONSTRAINT negativeoccupation_info_pkey PRIMARY KEY (negative_occupation_info_id),
	foreign key (negativeoccupationinfo_id)references public.negative_occupation(negative_occupation_id),
	foreign key (branch_id) references public.branch(branch_id)
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

-- Table: public.proposedbranch_location
-- Drop table if exists proposedbranch_location;
create table if not exists proposedbranch_location(
	prop_branch_location_id bigserial not null,
	branch_id int,
	option1 character varying,
	option2 character varying, 
	mandal_id int,
	recommendations_id int,
	proposed_branch_location_id bigint,
	constraint proposedbranch_location_pkey primary key(prop_branch_location_id),
	foreign key(branch_id) references public.branch(branch_id),
	foreign key(mandal_id) references public.mandal(mandal_id),
	foreign key(proposed_branch_location_id) references public.recommendations(recommend_id)	
);



-- Table: public.risk_and_recco
-- Drop table if exists risk_and_recco;
create table if not exists risk_and_recco(
	riskAndRecco_id bigserial not null,
	branch_id int,
	rr_id bigint,
	constraint risk_and_recco_pkey primary key(riskAndRecco_id),
	foreign key (branch_id) references public.branch(branch_id),
	foreign key (rr_id) references public.survey_forms(survey_forms_id)
);

-- Table: public.risk_recommendation
-- Drop table if exists risk_recommendation;
create table if not exists risk_recommendation(
	riskRecom_id bigserial not null,
	branch_id int,
	coverage_ofMFIs character varying,
	business_enviorment_rating character varying,
	rms_recommendation character varying,
	rrm_id bigint,
	constraint risk_recommendation_pkey primary key (riskRecom_id),
	foreign key (rrm_id) references public.risk_and_recco (riskAndRecco_id),
	foreign key (branch_id) references public.branch (branch_id),
	foreign key (rrm_id) references public.survey_forms (survey_forms_id)
);

-- Table: public.risk_related_information
-- Drop table if exists risk_related_information;
create table if not exists risk_related_information(
	rrelated_info_id bigserial not null,
	branch_id int,
	negativeareas character varying,
	ringleaders character varying,
	negativeoccupation character varying,
	other character varying,
	rri_id bigint,
	constraint rrelated_info_id_pkey primary key (rrelated_info_id),
	foreign key (rri_id) references public.risk_and_recco (riskAndRecco_id),
	foreign key (branch_id) references public.branch (branch_id),
	foreign key (rri_id) references public.survey_forms (survey_forms_id)
);


-- Table: public.final_recommendations
-- Drop table if exists final_recommendations;
create table if not exists final_recommendations(
	final_recom_id bigserial not null,
	branch_id int,
	byserveyor character varying,
	byrm character varying,
	fr_id bigint,
	constraint final_recom_id_pkey primary key (final_recom_id),
	foreign key (fr_id) references public.risk_and_recco(riskAndRecco_id),
	foreign key (branch_id) references public.branch(branch_id),
	foreign key (fr_id) references public.survey_forms (survey_forms_id)
);










	
	

