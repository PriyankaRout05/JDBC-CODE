-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users(
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
    CONSTRAINT effective_expiry_date_check CHECK (expiry_date IS NULL OR expiry_date >= effective_date)
);


-- Table: public.state
-- DROP TABLE IF EXISTS public.state;
CREATE TABLE IF NOT EXISTS public.state (
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT state_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id)
);

CREATE UNIQUE INDEX if not exists c_state_name_unique ON public.state (name);

-- Table: public.district
-- DROP TABLE IF EXISTS public.district;
CREATE TABLE IF NOT EXISTS public.district (
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    state bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT district_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (state) references public.state(id)
);
CREATE UNIQUE INDEX if not exists c_district_name_unique ON public.district (name);

-- Table: public.mandal
-- DROP TABLE IF EXISTS public.mandal;
CREATE TABLE IF NOT EXISTS public.mandal (
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    district bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT mandal_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (district) references public.district(id)
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
    foreign key (mandal) references public.mandal(id)
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
-- Table: public.survey
-- DROP TABLE IF EXISTS public.survey;
CREATE TABLE IF NOT EXISTS public.survey (
    id bigserial NOT NULL,
    name character varying(200) NOT NULL,
    village bigint,
    status character varying(20) NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT survey_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (village) references public.village(id)
);
-- Table: public.village_photos
-- DROP TABLE IF EXISTS public.village_photos;
CREATE TABLE IF NOT EXISTS public.village_photos (
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    village bigint,
    survey bigint,
    s3_url character varying(500) NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT village_photos_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (village) references public.village(id),
    foreign key (survey) references public.survey(id)
);
-- Table: public.branch
-- DROP TABLE IF EXISTS public.branch;
CREATE TABLE IF NOT EXISTS public.branch (
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    mandal bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT branch_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (mandal) references public.mandal(id)
);
-- Table: public.branch_villages
-- DROP TABLE IF EXISTS public.branch_villages;
CREATE TABLE IF NOT EXISTS public.branch_villages (
    id bigserial NOT NULL,
    village bigint,
    branch bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT branch_villages_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (village) references public.village(id),
    foreign key (branch) references public.branch(id)
);

-- Table: public.negative_areas

-- DROP TABLE IF EXISTS public.negative_areas;

CREATE TABLE IF NOT EXISTS public.negative_areas (
    id bigserial NOT NULL,
    branch_id bigint NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT negative_areas_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    CONSTRAINT negative_areas_branch_id_fkey FOREIGN KEY (branch_id)
        REFERENCES public.branch (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


-- Table: public.activity
-- DROP TABLE IF EXISTS public.activity;
CREATE TABLE IF NOT EXISTS public.activity
(
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT activity_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id)
);

-- Table: public.financial_institutions
-- DROP TABLE IF EXISTS public.financial_institutions;
CREATE TABLE IF NOT EXISTS public.financial_institutions(
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    type character varying(50) NOT NULL,
    contact_person character varying(50) NOT NULL,
    mobile_number numeric NOT NULL,
    address character varying(100) NOT NULL,
    operating_since date NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT financial_institutions_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id)
);

