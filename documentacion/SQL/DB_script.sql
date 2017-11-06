--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.4
-- Dumped by pg_dump version 9.6.4

-- Started on 2017-11-05 23:05:43 -05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 10 (class 2615 OID 33317)
-- Name: polla_software; Type: SCHEMA; Schema: -; Owner: sergio
--

CREATE SCHEMA polla_software;


ALTER SCHEMA polla_software OWNER TO sergio;

--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 10
-- Name: SCHEMA polla_software; Type: COMMENT; Schema: -; Owner: sergio
--

COMMENT ON SCHEMA polla_software IS 'Esquema de base de datos para la administración de la polla de ingeniería de software 2';


SET search_path = polla_software, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 223 (class 1259 OID 33346)
-- Name: apuesta; Type: TABLE; Schema: polla_software; Owner: sergio
--

CREATE TABLE apuesta (
    id_jugador character varying NOT NULL,
    id_partido integer NOT NULL,
    marcador_local numeric NOT NULL,
    marcador_visitante numeric NOT NULL
);


ALTER TABLE apuesta OWNER TO sergio;

--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 223
-- Name: TABLE apuesta; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON TABLE apuesta IS 'Maestra de apuestas';


--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN apuesta.id_jugador; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN apuesta.id_jugador IS 'Identificador del jugador que realiza la apuesta';


--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN apuesta.id_partido; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN apuesta.id_partido IS 'Identificador del partido por el que se desea apostar';


--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN apuesta.marcador_local; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN apuesta.marcador_local IS 'Marcador del equipo local';


--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN apuesta.marcador_visitante; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN apuesta.marcador_visitante IS 'Marcador del equipo visitante';


--
-- TOC entry 221 (class 1259 OID 33342)
-- Name: apuesta_id_jugador_seq; Type: SEQUENCE; Schema: polla_software; Owner: sergio
--

CREATE SEQUENCE apuesta_id_jugador_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE apuesta_id_jugador_seq OWNER TO sergio;

--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 221
-- Name: apuesta_id_jugador_seq; Type: SEQUENCE OWNED BY; Schema: polla_software; Owner: sergio
--

ALTER SEQUENCE apuesta_id_jugador_seq OWNED BY apuesta.id_jugador;


--
-- TOC entry 222 (class 1259 OID 33344)
-- Name: apuesta_id_partido_seq; Type: SEQUENCE; Schema: polla_software; Owner: sergio
--

CREATE SEQUENCE apuesta_id_partido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE apuesta_id_partido_seq OWNER TO sergio;

--
-- TOC entry 2867 (class 0 OID 0)
-- Dependencies: 222
-- Name: apuesta_id_partido_seq; Type: SEQUENCE OWNED BY; Schema: polla_software; Owner: sergio
--

ALTER SEQUENCE apuesta_id_partido_seq OWNED BY apuesta.id_partido;


--
-- TOC entry 217 (class 1259 OID 33320)
-- Name: equipo; Type: TABLE; Schema: polla_software; Owner: sergio
--

CREATE TABLE equipo (
    id_equipo integer NOT NULL,
    nombre character varying(200) NOT NULL
);


ALTER TABLE equipo OWNER TO sergio;

--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 217
-- Name: TABLE equipo; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON TABLE equipo IS 'Maestra de equipos';


--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN equipo.id_equipo; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN equipo.id_equipo IS 'Id del equipo';


--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN equipo.nombre; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN equipo.nombre IS 'Nombre del equipo';


--
-- TOC entry 216 (class 1259 OID 33318)
-- Name: equipo_id_equipo_seq; Type: SEQUENCE; Schema: polla_software; Owner: sergio
--

CREATE SEQUENCE equipo_id_equipo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE equipo_id_equipo_seq OWNER TO sergio;

--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 216
-- Name: equipo_id_equipo_seq; Type: SEQUENCE OWNED BY; Schema: polla_software; Owner: sergio
--

ALTER SEQUENCE equipo_id_equipo_seq OWNED BY equipo.id_equipo;


--
-- TOC entry 218 (class 1259 OID 33326)
-- Name: jugador; Type: TABLE; Schema: polla_software; Owner: sergio
--

CREATE TABLE jugador (
    id_jugador character varying(50) NOT NULL,
    alias character varying(200) NOT NULL,
    password character varying(200) NOT NULL,
    administrador boolean NOT NULL
);


ALTER TABLE jugador OWNER TO sergio;

--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE jugador; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON TABLE jugador IS 'Maestra de jugadores';


--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN jugador.id_jugador; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN jugador.id_jugador IS 'Identificador del jugador';


--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN jugador.alias; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN jugador.alias IS 'Alias del jugador';


--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN jugador.password; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN jugador.password IS 'Contraseña del jugador';


--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN jugador.administrador; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN jugador.administrador IS 'Indica si el usuario es un Administrador del sistema';


--
-- TOC entry 220 (class 1259 OID 33333)
-- Name: partido; Type: TABLE; Schema: polla_software; Owner: sergio
--

CREATE TABLE partido (
    id_partido integer NOT NULL,
    id_equipo_local integer NOT NULL,
    id_equipo_visitante integer NOT NULL,
    hora timestamp without time zone NOT NULL,
    marcador_local_final numeric,
    marcador_visitante_final numeric
);


ALTER TABLE partido OWNER TO sergio;

--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE partido; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON TABLE partido IS 'Maestra de partidos';


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN partido.id_partido; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN partido.id_partido IS 'Identificador del partido';


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN partido.id_equipo_local; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN partido.id_equipo_local IS 'Identificador del equipo local';


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN partido.id_equipo_visitante; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN partido.id_equipo_visitante IS 'Identificador del equipo visitante';


--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN partido.hora; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN partido.hora IS 'Hora de inicio del partido';


--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN partido.marcador_local_final; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN partido.marcador_local_final IS 'Marcador final equipo local';


--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN partido.marcador_visitante_final; Type: COMMENT; Schema: polla_software; Owner: sergio
--

COMMENT ON COLUMN partido.marcador_visitante_final IS 'Marcador final equipo visitante';


--
-- TOC entry 219 (class 1259 OID 33331)
-- Name: partido_id_partido_seq; Type: SEQUENCE; Schema: polla_software; Owner: sergio
--

CREATE SEQUENCE partido_id_partido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE partido_id_partido_seq OWNER TO sergio;

--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 219
-- Name: partido_id_partido_seq; Type: SEQUENCE OWNED BY; Schema: polla_software; Owner: sergio
--

ALTER SEQUENCE partido_id_partido_seq OWNED BY partido.id_partido;


--
-- TOC entry 2717 (class 2604 OID 33356)
-- Name: apuesta id_jugador; Type: DEFAULT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY apuesta ALTER COLUMN id_jugador SET DEFAULT nextval('apuesta_id_jugador_seq'::regclass);


--
-- TOC entry 2718 (class 2604 OID 33381)
-- Name: apuesta id_partido; Type: DEFAULT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY apuesta ALTER COLUMN id_partido SET DEFAULT nextval('apuesta_id_partido_seq'::regclass);


--
-- TOC entry 2715 (class 2604 OID 33323)
-- Name: equipo id_equipo; Type: DEFAULT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY equipo ALTER COLUMN id_equipo SET DEFAULT nextval('equipo_id_equipo_seq'::regclass);


--
-- TOC entry 2716 (class 2604 OID 33336)
-- Name: partido id_partido; Type: DEFAULT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY partido ALTER COLUMN id_partido SET DEFAULT nextval('partido_id_partido_seq'::regclass);


--
-- TOC entry 2855 (class 0 OID 33346)
-- Dependencies: 223
-- Data for Name: apuesta; Type: TABLE DATA; Schema: polla_software; Owner: sergio
--

COPY apuesta (id_jugador, id_partido, marcador_local, marcador_visitante) FROM stdin;
\.


--
-- TOC entry 2885 (class 0 OID 0)
-- Dependencies: 221
-- Name: apuesta_id_jugador_seq; Type: SEQUENCE SET; Schema: polla_software; Owner: sergio
--

SELECT pg_catalog.setval('apuesta_id_jugador_seq', 1, false);


--
-- TOC entry 2886 (class 0 OID 0)
-- Dependencies: 222
-- Name: apuesta_id_partido_seq; Type: SEQUENCE SET; Schema: polla_software; Owner: sergio
--

SELECT pg_catalog.setval('apuesta_id_partido_seq', 1, false);


--
-- TOC entry 2849 (class 0 OID 33320)
-- Dependencies: 217
-- Data for Name: equipo; Type: TABLE DATA; Schema: polla_software; Owner: sergio
--

COPY equipo (id_equipo, nombre) FROM stdin;
\.


--
-- TOC entry 2887 (class 0 OID 0)
-- Dependencies: 216
-- Name: equipo_id_equipo_seq; Type: SEQUENCE SET; Schema: polla_software; Owner: sergio
--

SELECT pg_catalog.setval('equipo_id_equipo_seq', 1, false);


--
-- TOC entry 2850 (class 0 OID 33326)
-- Dependencies: 218
-- Data for Name: jugador; Type: TABLE DATA; Schema: polla_software; Owner: sergio
--

COPY jugador (id_jugador, alias, password, administrador) FROM stdin;
\.


--
-- TOC entry 2852 (class 0 OID 33333)
-- Dependencies: 220
-- Data for Name: partido; Type: TABLE DATA; Schema: polla_software; Owner: sergio
--

COPY partido (id_partido, id_equipo_local, id_equipo_visitante, hora, marcador_local_final, marcador_visitante_final) FROM stdin;
\.


--
-- TOC entry 2888 (class 0 OID 0)
-- Dependencies: 219
-- Name: partido_id_partido_seq; Type: SEQUENCE SET; Schema: polla_software; Owner: sergio
--

SELECT pg_catalog.setval('partido_id_partido_seq', 1, false);


--
-- TOC entry 2726 (class 2606 OID 33383)
-- Name: apuesta apuesta_pkey; Type: CONSTRAINT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY apuesta
    ADD CONSTRAINT apuesta_pkey PRIMARY KEY (id_jugador, id_partido);


--
-- TOC entry 2720 (class 2606 OID 33325)
-- Name: equipo equipo_pkey; Type: CONSTRAINT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT equipo_pkey PRIMARY KEY (id_equipo);


--
-- TOC entry 2722 (class 2606 OID 33330)
-- Name: jugador jugador_pkey; Type: CONSTRAINT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT jugador_pkey PRIMARY KEY (id_jugador);


--
-- TOC entry 2724 (class 2606 OID 33341)
-- Name: partido partido_pkey; Type: CONSTRAINT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY partido
    ADD CONSTRAINT partido_pkey PRIMARY KEY (id_partido);


--
-- TOC entry 2729 (class 2606 OID 33376)
-- Name: apuesta apuesta_id_jugador_fkey; Type: FK CONSTRAINT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY apuesta
    ADD CONSTRAINT apuesta_id_jugador_fkey FOREIGN KEY (id_jugador) REFERENCES jugador(id_jugador) ON DELETE RESTRICT;


--
-- TOC entry 2730 (class 2606 OID 33391)
-- Name: apuesta apuesta_id_partido_fkey; Type: FK CONSTRAINT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY apuesta
    ADD CONSTRAINT apuesta_id_partido_fkey FOREIGN KEY (id_partido) REFERENCES partido(id_partido) ON DELETE RESTRICT;


--
-- TOC entry 2727 (class 2606 OID 33410)
-- Name: partido partido_id_equipo_local_fkey; Type: FK CONSTRAINT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY partido
    ADD CONSTRAINT partido_id_equipo_local_fkey FOREIGN KEY (id_equipo_local) REFERENCES equipo(id_equipo) ON DELETE RESTRICT;


--
-- TOC entry 2728 (class 2606 OID 33415)
-- Name: partido partido_id_equipo_visitante_fkey; Type: FK CONSTRAINT; Schema: polla_software; Owner: sergio
--

ALTER TABLE ONLY partido
    ADD CONSTRAINT partido_id_equipo_visitante_fkey FOREIGN KEY (id_equipo_visitante) REFERENCES equipo(id_equipo) ON DELETE RESTRICT;


-- Completed on 2017-11-05 23:05:43 -05

--
-- PostgreSQL database dump complete
--

