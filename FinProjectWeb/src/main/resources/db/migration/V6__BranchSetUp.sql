-- Table: public.branch_set_up
-- Drop Table if exists public.branch_set_up;
create table if not exists branch_set_up(
	branch_set_up_id bigserial NOT NULL,
	constraint branch_set_up_pkey primary key (branch_set_up_id)
);


-- Table: public.resource_person_detalis
-- Drop Table if exists public.resource_person_detalis;
create table if not exists resource_person_detalis(
	e_id bigserial NOT NULL,
	name character varying,
	designation character varying,
	contact_number character varying,
	resource_person_detalis_id bigint,
	constraint resource_person_detalis_pkey primary key (e_id),
    	foreign key(resource_person_detalis_id) references public.branch_set_up(branch_set_up_id)
    	);

    
-- Table: public.branch_set_up_survey
-- Drop Table if exists public.branch_set_up_survey;	
create table if not exists branch_set_up_survey(
	survey_id bigserial not null,
	title character varying,
	branch_set_up_survey_id bigint,
	constraint branch_set_up_survey_pkey primary key(survey_id),
	foreign key(branch_set_up_survey_id) references public.branch_set_up(branch_set_up_id)
);


--Table pubic.particular_records
--Drop Table if exists public.particular_records;
create table if not exists particular_records(
	particular_id bigserial not null,
	particular character varying,
	particular_records_id bigint,
	constraint particular_records_pkey primary key(particular_id),
	foreign key(particular_records_id) references public.branch_set_up_survey(survey_id)	
);


--Table pubic.records
--Drop Table if exists public.records;
create table if not exists records(
	record_id bigserial not null,
	particular character varying,
	value boolean not null,
	assetid bigint not null,
	records_id bigint,
	constraint records_pkey primary key(record_id),
	foreign key(records_id) references public.particular_records(particular_id)	
);

	
