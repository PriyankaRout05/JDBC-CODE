
-- Table: public.risk_and_recco
-- Drop table if exists risk_and_recco;
create table if not exists risk_and_recco( 
	riskandrecco_id bigserial not null,
	branch_id int,
	rr_id bigint,
	constraint risk_and_recco_pkey primary key(riskandrecco_id),
	foreign key (branch_id) references public.branch(branch_id),
	foreign key (rr_id) references public.survey_forms(survey_forms_id)
);

-- Table: public.risk_recommendation
-- Drop table if exists risk_recommendation;
create table if not exists risk_recommendation(
	riskrecom_id bigserial not null,
	branch_id int,
	coverage_ofmfis character varying,
	business_enviorment_rating character varying,
	rms_recommendation character varying,
	risk_recommendation_id bigint,
	constraint risk_recommendation_pkey primary key (riskrecom_id),
	foreign key (branch_id) references public.branch (branch_id),
	foreign key (risk_recommendation_id) references public.risk_and_recco(riskandrecco_id)
);

-- Table: public.riskrelated_information
-- Drop table if exists riskrelated_information;
create table if not exists riskrelated_information(
	riskrelatedinfo_id bigserial not null,
	branch_id int,
	negativeareas character varying,
	ringleaders character varying,
	negativeoccupation character varying,
	other character varying,
	riskrelated_information_id bigint,
	constraint riskrelated_information_pkey primary key (riskrelatedinfo_id),
	foreign key (branch_id) references public.branch (branch_id),
	foreign key (riskrelated_information_id) references public.risk_and_recco(riskandrecco_id)
);


-- Table: public.final_recommendations
-- Drop table if exists final_recommendations;
create table if not exists final_recommendations(
	final_recom_id bigserial not null,
	branch_id int,
	byserveyor character varying,
	byrm character varying,
	final_recommendations_id bigint,
	constraint final_recommendations_pkey primary key(final_recom_id),
	foreign key (branch_id) references public.branch(branch_id),
	foreign key (final_recommendations_id) references public.risk_and_recco(riskandrecco_id)
);
