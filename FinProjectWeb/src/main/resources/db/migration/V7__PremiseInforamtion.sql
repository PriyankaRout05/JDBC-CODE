-- Table: public.branch_premise_survey
-- DROP TABLE IF EXISTS public.branch_premise_survey;
create table if not exists public.branch_premise_survey(
	branch_premise_survey_id bigserial  not null,
	branch_name int,
	branch_location varchar,
    	constraint branch_premise_survey_pkey primary key (branch_premise_survey_id),
  	foreign key (branch_name) references public.branch(id)
);

-- Table: public.premise_information
-- DROP TABLE IF EXISTS public.premise_information;
create table if not exists public.premise_information(
	premise_information_id bigserial not null,
	question int,
	value text,
	type character varying(200),
	comment character varying(200),
	adress varchar,
	s3Url  varchar,
	premise_informationid bigint,
	constraint premise_information_pkey primary key(premise_information_id),
    	foreign key (question) references public.question(id),
    	foreign key (premise_informationid) references public.branch_premise_survey(branch_premise_survey_id)
);


    	
