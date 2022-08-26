-- Table:public.village_survey_from
-- Drop table if exists public.village_survey_from;
create table if not exists public.village_survey_from(
	village_survey_from_id bigserial not null,
	villaeg_id int, 
	no_of_households bigint,
	constraint village_survey_from_pkey primary key(village_survey_from_id),
	foreign key(villaeg_id) references public.village(id)
);

-- Table:public.village_information
-- Drop table if exsits public.village_information;
create table if not exists public.village_information(
	village_information_id bigserial not null,
	villaeg_id int,
	district_id int,
	block_id int,
	panchayath_id int,
	route varchar,
	pincode int,
	village_classification_id int,
	s3Url varchar,
	villageinformation_id bigint,
	constraint village_information_pkey primary key(village_information_id),
	foreign key(villageinformation_id) references public.village_survey_from(village_survey_from_id),
	foreign key(villaeg_id) references public.village(id),
	foreign key(district_id) references public.district(id),
	foreign key(block_id) references public.mandal(id),
	foreign key(panchayath_id) references public.panchayath(id),
	foreign key(village_classification_id) references public.village_classification(id)
);

-- Table:public.village_survey
-- Drop table if exists public.village_survey;
create table if not exists public.village_survey(
	village_survey_id bigserial not null,
	question int,
	value text,
	option varchar,
	villagesurvey_id bigint,
	constraint village_survey_pkey primary key(village_survey_id),
	foreign key(villagesurvey_id) references public.village_survey_from(village_survey_from_id),
	foreign key(question) references public.question(id)
);
