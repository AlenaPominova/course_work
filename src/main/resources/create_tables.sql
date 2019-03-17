CREATE TABLE public."user"
(
  user_id integer NOT NULL,
  fio character varying,
  email character varying,
  password character varying,
  description character varying(400),
  role_id integer,
  CONSTRAINT user_id PRIMARY KEY (user_id),
  CONSTRAINT fk_user_role FOREIGN KEY (role_id)
      REFERENCES public.roles (role_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.roles
(
  role_id integer NOT NULL,
  name character varying(20),
  CONSTRAINT role_id PRIMARY KEY (role_id)
);

CREATE TABLE public.parcking_place
(
  place_id integer NOT NULL,
  is_paid boolean,
  open_time timestamp with time zone,
  close_time timestamp with time zone,
  num_of_free_spots integer,
  address character varying(100),
  description character varying(200),
  longitude double precision,
  latitude double precision,
  CONSTRAINT "PK_place_id" PRIMARY KEY (place_id)
);

CREATE TABLE public.favorite_places
(
  user_id integer NOT NULL,
  place_id integer NOT NULL,
  CONSTRAINT pk_user_place_id PRIMARY KEY (user_id, place_id),
  CONSTRAINT fk_place FOREIGN KEY (place_id)
      REFERENCES public.parcking_place (place_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_user FOREIGN KEY (user_id)
      REFERENCES public."user" (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

