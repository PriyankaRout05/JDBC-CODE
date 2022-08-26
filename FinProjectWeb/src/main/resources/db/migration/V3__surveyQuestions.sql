-- Table: public.question
-- DROP TABLE IF EXISTS public.question;
CREATE TABLE IF NOT EXISTS public.question (
    id bigserial NOT NULL,
    question character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT question_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id)
);

-- Table: public.survey_question
-- DROP TABLE IF EXISTS public.survey_question;
CREATE TABLE IF NOT EXISTS public.survey_question (
    id bigserial NOT NULL,
    question bigint,
    survey bigint,
    section_number integer NOT NULL,
    order_number integer NOT NULL,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT survey_question_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (question) references public.question(id),
    foreign key (survey) references public.survey(id)
);

-- Table: public.question_option
-- DROP TABLE IF EXISTS public.question_option;
CREATE TABLE IF NOT EXISTS public.question_option (
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
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (question) references public.question(id)
);

-- Table: public.survey_response
-- DROP TABLE IF EXISTS public.survey_response;
CREATE TABLE IF NOT EXISTS public.survey_response (
    id bigserial NOT NULL,
    survey_question bigint,
    option bigint,
    created_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user bigint NOT NULL,
    modified_user bigint NOT NULL,
    modified_on timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active smallint NOT NULL DEFAULT 1,
    CONSTRAINT survey_response_pkey PRIMARY KEY (id),
    foreign key (created_user) references public.users(id),
    foreign key (modified_user) references public.users(id),
    foreign key (survey_question) references public.survey_question(id),
    foreign key (option) references public.question_option(id)
);




