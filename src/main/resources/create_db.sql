-- Table: public.cities

-- DROP TABLE IF EXISTS public.cities;

CREATE TABLE IF NOT EXISTS public.cities
(
    city_id bigint NOT NULL DEFAULT nextval('cities_city_id_seq'::regclass),
    city_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    citycode character varying(3) COLLATE pg_catalog."default" NOT NULL DEFAULT 'NA'::character varying,
    country_id integer NOT NULL DEFAULT 0,
    CONSTRAINT cities_pkey PRIMARY KEY (city_id),
    CONSTRAINT fko5ux2xn0amoletnl6trftlwnp FOREIGN KEY (country_id)
        REFERENCES public.country (country_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cities
    OWNER to postgres;


-- Table: public.country

-- DROP TABLE IF EXISTS public.country;

CREATE TABLE IF NOT EXISTS public.country
(
    country_id integer NOT NULL DEFAULT nextval('country_country_id_seq'::regclass),
    country_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT country_pkey PRIMARY KEY (country_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.country
    OWNER to postgres;


-- Table: public.course

-- DROP TABLE IF EXISTS public.course;

CREATE TABLE IF NOT EXISTS public.course
(
    course_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    course_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT course_pkey PRIMARY KEY (course_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.course
    OWNER to postgres;

-- Table: public.course_coursecontents_mapping

-- DROP TABLE IF EXISTS public.course_coursecontents_mapping;

CREATE TABLE IF NOT EXISTS public.course_coursecontents_mapping
(
    course_id integer NOT NULL,
    content_id integer NOT NULL,
    CONSTRAINT fk_content_id_coursecontents FOREIGN KEY (content_id)
        REFERENCES public.coursecontents (content_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_course_id_courses FOREIGN KEY (course_id)
        REFERENCES public.course (course_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.course_coursecontents_mapping
    OWNER to postgres;

-- Table: public.coursecontents

-- DROP TABLE IF EXISTS public.coursecontents;

CREATE TABLE IF NOT EXISTS public.coursecontents
(
    content_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    content character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT coursecontents_pkey PRIMARY KEY (content_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.coursecontents
    OWNER to postgres;