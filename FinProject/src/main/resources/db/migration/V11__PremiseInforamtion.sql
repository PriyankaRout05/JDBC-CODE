--Table : public.question
--Drop Table If Exists public.question;
create table if not exists public.question(
	id bigint not null,
	question character varying(200) not null,
	type character varying(200) not null,
	created_on timestamp without time zone not null default current_timestamp,
	created_user bigint not null,
	modified_user bigint not null,
	modified_on timestamp without time zone not null default current_timestamp,
	active smallint not null default 1,
	constraint question_pkey primary key (id)
);

-- Table: public.question_option
-- DROP TABLE IF EXISTS public.question_option;
CREATE TABLE IF NOT EXISTS public.question_option(
    id bigserial NOT NULL,
    option text,
    value text,
    question bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT question_option_pkey PRIMARY KEY (id),
    foreign key (question) references public.question(id)
);


-- Table: public.branch_premise_survey
-- DROP TABLE IF EXISTS public.branch_premise_survey;
create table if not exists public.branch_premise_survey(
	branch_premise_survey_id bigserial  not null,
	branch_name int,
	branch_location int,
    	constraint branch_premise_survey_pkey primary key (branch_premise_survey_id),
    	foreign key (branch_name) references public.branch(branch_id),
    	foreign key (branch_location) references public.branch(branch_id)
);

-- Table: public.premise_information
-- DROP TABLE IF EXISTS public.premise_information;
create table if not exists public.premise_information(
	premise_information_id bigserial not null,
	area_name character varying(200),
	area_size DOUBLE PRECISION,
	coordinates character varying(200),
	adress varchar,
	typeofpermise varchar,
	comment character varying(200),
	premise_informationid bigint,
	constraint premise_information_pkey primary key (premise_information_id),
    	foreign key (premise_informationid) references public.branch_premise_survey(branch_premise_survey_id)
);

-- Table: public.rent_and_deposites
-- DROP TABLE IF EXISTS public.rent_and_deposites;
create table if not exists public.rent_and_deposites(
	rent_and_deposites_id bigserial not null,
	rent_amount_inr DOUBLE PRECISION,
	advances_or_deposits DOUBLE PRECISION,
	comment  character varying(200),
	rentand_depositesid bigint,
	constraint rent_and_deposites_pkey primary key (rent_and_deposites_id),
    	foreign key (rentand_depositesid) references public.branch_premise_survey(branch_premise_survey_id)
);


-- Table: public.owner_information
-- DROP TABLE IF EXISTS public.owner_information;
create table if not exists public.owner_information(
	owner_information_id bigserial not null,
	owners_name character varying(50),
	contact_number bigint,
	occupation character varying(100),
	previous_occupant character varying(100),
	comment character varying(200),
	owner_informationid bigint,
	constraint owner_information_pkey primary key (owner_information_id),
    	foreign key (owner_informationid) references public.branch_premise_survey(branch_premise_survey_id)
);

-- Table: public.hyegiene_and_safety
-- DROP TABLE IF EXISTS public.hyegiene_and_safety;
create table if not exists public.hyegiene_and_safety(
	hyegiene_and_safety_id bigserial not null,
	question character varying(200) not null,
	type character varying(200) not null,
	value text,
	comment character varying(200),
	hyegieneand_safetyid bigint,
	constraint hyegiene_and_safety_pkey primary key (hyegiene_and_safety_id),
    	foreign key (hyegieneand_safetyid) references public.branch_premise_survey(branch_premise_survey_id)
);

-- Table: public.premise_checklist
-- DROP TABLE IF EXISTS public.premise_checklist;
create table if not exists public.premise_checklist(
	premise_checklist_id bigserial not null,
	question character varying(200) not null,
	value text,
	comment character varying(200),
	premisechecklist_id bigint,
	constraint premise_checklist_pkey primary key (premise_checklist_id),
    	foreign key (premisechecklist_id) references public.branch_premise_survey(branch_premise_survey_id)
);

-- Table: public.premise_photographs
-- DROP TABLE IF EXISTS public.premise_photographs;
create table if not exists public.premise_photographs(
	premise_photographs_id bigserial not null,
	capture_internal_photographs BYTEA,
	capture_external_photographs BYTEA,
	Premise_photographsid bigint,
	foreign key (Premise_photographsid) references public.branch_premise_survey(branch_premise_survey_id)
);

	
