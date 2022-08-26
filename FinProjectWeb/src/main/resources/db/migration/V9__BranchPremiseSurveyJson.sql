--Table: public.branch_premisesurvey_json
--Drop table if exists public.branch_premisesurvey_json;
create table if not exists public.branch_premisesurvey_json(
	branch_premise_survey_id bigserial not null,
	branch_name int,
	branch_location varchar,
	premise_survey_json varchar,
	coordinates varchar,
	s3Url varchar,
	constraint branch_premisesurvey_json_pkey primary key(branch_premise_survey_id),
	foreign key (branch_name) references public.branch(id)
);

