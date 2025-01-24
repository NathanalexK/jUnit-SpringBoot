--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: achat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.achat (
    id integer NOT NULL,
    date_heure timestamp(0) without time zone DEFAULT now() NOT NULL,
    id_fournisseur integer,
    d_prix_total numeric(15,2)
);


ALTER TABLE public.achat OWNER TO postgres;

--
-- Name: achat_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.achat_details (
    id integer NOT NULL,
    id_achat integer NOT NULL,
    id_ingredient integer NOT NULL,
    quantite numeric(15,2) NOT NULL,
    d_prix_unitaire numeric(15,2) NOT NULL
);


ALTER TABLE public.achat_details OWNER TO postgres;

--
-- Name: achat_details_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.achat_details_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.achat_details_id_seq OWNER TO postgres;

--
-- Name: achat_details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.achat_details_id_seq OWNED BY public.achat_details.id;


--
-- Name: achat_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.achat_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.achat_id_seq OWNER TO postgres;

--
-- Name: achat_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.achat_id_seq OWNED BY public.achat.id;


--
-- Name: categorie_produit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categorie_produit (
    id integer NOT NULL,
    nom character varying(255) NOT NULL
);


ALTER TABLE public.categorie_produit OWNER TO postgres;

--
-- Name: categorie_produit_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categorie_produit_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categorie_produit_id_seq OWNER TO postgres;

--
-- Name: categorie_produit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categorie_produit_id_seq OWNED BY public.categorie_produit.id;


--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    date_creation date DEFAULT now() NOT NULL
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.client_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.client_id_seq OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.client_id_seq OWNED BY public.client.id;


--
-- Name: employe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employe (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    "dateEmbauche" date DEFAULT now() NOT NULL
);


ALTER TABLE public.employe OWNER TO postgres;

--
-- Name: employe_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employe_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employe_id_seq OWNER TO postgres;

--
-- Name: employe_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employe_id_seq OWNED BY public.employe.id;


--
-- Name: fournisseur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fournisseur (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    date_creation date DEFAULT now() NOT NULL
);


ALTER TABLE public.fournisseur OWNER TO postgres;

--
-- Name: fournisseur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fournisseur_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fournisseur_id_seq OWNER TO postgres;

--
-- Name: fournisseur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fournisseur_id_seq OWNED BY public.fournisseur.id;


--
-- Name: ingredient; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingredient (
    id integer NOT NULL,
    id_produit integer NOT NULL
);


ALTER TABLE public.ingredient OWNER TO postgres;

--
-- Name: ingredient_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ingredient_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ingredient_id_seq OWNER TO postgres;

--
-- Name: ingredient_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ingredient_id_seq OWNED BY public.ingredient.id;


--
-- Name: mvt_stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mvt_stock (
    id integer NOT NULL,
    id_produit integer NOT NULL,
    entree numeric(15,2) DEFAULT 0 NOT NULL,
    sortie numeric(15,2) DEFAULT 0 NOT NULL,
    d_prix_unitaire numeric(15,2) NOT NULL,
    date timestamp without time zone DEFAULT now()
);


ALTER TABLE public.mvt_stock OWNER TO postgres;

--
-- Name: mvt_stock_fille_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mvt_stock_fille_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mvt_stock_fille_id_seq OWNER TO postgres;

--
-- Name: mvt_stock_fille_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mvt_stock_fille_id_seq OWNED BY public.mvt_stock.id;


--
-- Name: parfum; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.parfum (
    id integer NOT NULL,
    nom character varying(50)
);


ALTER TABLE public.parfum OWNER TO postgres;

--
-- Name: parfum_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.parfum_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.parfum_id_seq OWNER TO postgres;

--
-- Name: parfum_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.parfum_id_seq OWNED BY public.parfum.id;


--
-- Name: production; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.production (
    id integer NOT NULL,
    id_produit_fini integer NOT NULL,
    qte numeric(15,2),
    d_prix_unitaire numeric(15,2),
    date_production timestamp without time zone DEFAULT now()
);


ALTER TABLE public.production OWNER TO postgres;

--
-- Name: production_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.production_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.production_id_seq OWNER TO postgres;

--
-- Name: production_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.production_id_seq OWNED BY public.production.id;


--
-- Name: produit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produit (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    id_type_produit integer NOT NULL,
    prix_achat numeric(15,2),
    prix_vente numeric(15,2),
    id_unite integer DEFAULT 1 NOT NULL
);


ALTER TABLE public.produit OWNER TO postgres;

--
-- Name: produit_fini; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produit_fini (
    id integer NOT NULL,
    id_produit integer NOT NULL,
    id_categorie integer NOT NULL,
    id_parfum integer
);


ALTER TABLE public.produit_fini OWNER TO postgres;

--
-- Name: produit_fini_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produit_fini_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produit_fini_id_seq OWNER TO postgres;

--
-- Name: produit_fini_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produit_fini_id_seq OWNED BY public.produit_fini.id;


--
-- Name: produit_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produit_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produit_id_seq OWNER TO postgres;

--
-- Name: produit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produit_id_seq OWNED BY public.produit.id;


--
-- Name: recette; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.recette (
    id integer NOT NULL,
    id_produit_fini integer NOT NULL,
    id_ingredient integer NOT NULL,
    quantite numeric(15,2) NOT NULL
);


ALTER TABLE public.recette OWNER TO postgres;

--
-- Name: recette_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.recette_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.recette_id_seq OWNER TO postgres;

--
-- Name: recette_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.recette_id_seq OWNED BY public.recette.id;


--
-- Name: stock; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.stock AS
 SELECT mvt_stock.id_produit,
    sum((mvt_stock.entree - mvt_stock.sortie)) AS qte,
    avg(mvt_stock.d_prix_unitaire) AS prix_unitaire
   FROM public.mvt_stock
  GROUP BY mvt_stock.id_produit;


ALTER TABLE public.stock OWNER TO postgres;

--
-- Name: type_produit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_produit (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    code character varying(20) DEFAULT 'PRD'::character varying NOT NULL
);


ALTER TABLE public.type_produit OWNER TO postgres;

--
-- Name: type_produit_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_produit_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_produit_id_seq OWNER TO postgres;

--
-- Name: type_produit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.type_produit_id_seq OWNED BY public.type_produit.id;


--
-- Name: unite; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.unite (
    id integer NOT NULL,
    code character varying(10) NOT NULL,
    nom character varying(50) NOT NULL
);


ALTER TABLE public.unite OWNER TO postgres;

--
-- Name: unite_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.unite_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.unite_id_seq OWNER TO postgres;

--
-- Name: unite_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.unite_id_seq OWNED BY public.unite.id;


--
-- Name: v_stock_simple; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.v_stock_simple AS
 SELECT mvt_stock.id_produit,
    sum((mvt_stock.entree - mvt_stock.sortie)) AS qte
   FROM public.mvt_stock
  GROUP BY mvt_stock.id_produit;


ALTER TABLE public.v_stock_simple OWNER TO postgres;

--
-- Name: v_stock; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.v_stock AS
 SELECT row_number() OVER () AS id,
    produit.id AS id_produit,
    COALESCE(vss.qte, (0)::numeric) AS qte
   FROM (public.produit
     LEFT JOIN public.v_stock_simple vss ON ((produit.id = vss.id_produit)));


ALTER TABLE public.v_stock OWNER TO postgres;

--
-- Name: vente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vente (
    id integer NOT NULL,
    date_heure timestamp(0) without time zone DEFAULT now() NOT NULL,
    id_client integer
);


ALTER TABLE public.vente OWNER TO postgres;

--
-- Name: vente_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vente_details (
    id integer NOT NULL,
    id_vente integer NOT NULL,
    id_produit_fini integer NOT NULL,
    quantie numeric(15,2) NOT NULL,
    d_prix_unitaire numeric(15,2) NOT NULL
);


ALTER TABLE public.vente_details OWNER TO postgres;

--
-- Name: v_vente_details_cpl; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.v_vente_details_cpl AS
 SELECT vd.id,
    vd.id_vente,
    vd.id_produit_fini,
    vd.quantie,
    vd.d_prix_unitaire,
    v.date_heure,
    v.id_client
   FROM (public.vente_details vd
     JOIN public.vente v ON ((vd.id_vente = v.id)));


ALTER TABLE public.v_vente_details_cpl OWNER TO postgres;

--
-- Name: vente_details_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vente_details_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vente_details_id_seq OWNER TO postgres;

--
-- Name: vente_details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vente_details_id_seq OWNED BY public.vente_details.id;


--
-- Name: vente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vente_id_seq OWNER TO postgres;

--
-- Name: vente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vente_id_seq OWNED BY public.vente.id;


--
-- Name: achat id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat ALTER COLUMN id SET DEFAULT nextval('public.achat_id_seq'::regclass);


--
-- Name: achat_details id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat_details ALTER COLUMN id SET DEFAULT nextval('public.achat_details_id_seq'::regclass);


--
-- Name: categorie_produit id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie_produit ALTER COLUMN id SET DEFAULT nextval('public.categorie_produit_id_seq'::regclass);


--
-- Name: client id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client ALTER COLUMN id SET DEFAULT nextval('public.client_id_seq'::regclass);


--
-- Name: employe id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employe ALTER COLUMN id SET DEFAULT nextval('public.employe_id_seq'::regclass);


--
-- Name: fournisseur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fournisseur ALTER COLUMN id SET DEFAULT nextval('public.fournisseur_id_seq'::regclass);


--
-- Name: ingredient id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingredient ALTER COLUMN id SET DEFAULT nextval('public.ingredient_id_seq'::regclass);


--
-- Name: mvt_stock id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mvt_stock ALTER COLUMN id SET DEFAULT nextval('public.mvt_stock_fille_id_seq'::regclass);


--
-- Name: parfum id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parfum ALTER COLUMN id SET DEFAULT nextval('public.parfum_id_seq'::regclass);


--
-- Name: production id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.production ALTER COLUMN id SET DEFAULT nextval('public.production_id_seq'::regclass);


--
-- Name: produit id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit ALTER COLUMN id SET DEFAULT nextval('public.produit_id_seq'::regclass);


--
-- Name: produit_fini id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit_fini ALTER COLUMN id SET DEFAULT nextval('public.produit_fini_id_seq'::regclass);


--
-- Name: recette id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recette ALTER COLUMN id SET DEFAULT nextval('public.recette_id_seq'::regclass);


--
-- Name: type_produit id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_produit ALTER COLUMN id SET DEFAULT nextval('public.type_produit_id_seq'::regclass);


--
-- Name: unite id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.unite ALTER COLUMN id SET DEFAULT nextval('public.unite_id_seq'::regclass);


--
-- Name: vente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente ALTER COLUMN id SET DEFAULT nextval('public.vente_id_seq'::regclass);


--
-- Name: vente_details id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente_details ALTER COLUMN id SET DEFAULT nextval('public.vente_details_id_seq'::regclass);


--
-- Data for Name: achat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.achat (id, date_heure, id_fournisseur, d_prix_total) FROM stdin;
2	2025-01-09 00:00:00	\N	\N
3	2025-01-09 00:00:00	1	\N
4	2025-01-09 00:00:00	1	\N
5	2025-01-09 00:00:00	1	24000.00
6	2025-01-09 00:00:00	1	29000.00
7	2025-01-09 00:00:00	1	8700.00
8	2025-01-11 00:00:00	\N	16000.00
9	2025-01-12 00:00:00	1	99100.00
10	2025-01-12 00:00:00	\N	40000.00
\.


--
-- Data for Name: achat_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.achat_details (id, id_achat, id_ingredient, quantite, d_prix_unitaire) FROM stdin;
1	2	2	4.00	800.00
2	3	3	2.00	500.00
3	3	4	3.00	4000.00
4	4	9	2.00	2900.00
5	5	6	6.00	4000.00
6	6	9	10.00	2900.00
7	7	9	3.00	2900.00
8	8	2	5.00	800.00
9	8	4	3.00	4000.00
10	9	5	50.00	200.00
11	9	3	30.00	500.00
12	9	1	15.00	3200.00
13	9	9	9.00	2900.00
14	10	2	50.00	800.00
\.


--
-- Data for Name: categorie_produit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categorie_produit (id, nom) FROM stdin;
1	Patisserie
2	Viennoiserie
3	Pain
4	Produits salés
\.


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (id, nom, date_creation) FROM stdin;
1	Client A	2025-01-04
\.


--
-- Data for Name: employe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employe (id, nom, "dateEmbauche") FROM stdin;
\.


--
-- Data for Name: fournisseur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fournisseur (id, nom, date_creation) FROM stdin;
1	Fournisseur A	2025-01-04
\.


--
-- Data for Name: ingredient; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ingredient (id, id_produit) FROM stdin;
2	2
3	3
4	11
5	12
6	13
7	14
8	15
9	16
1	1
11	26
12	29
13	30
\.


--
-- Data for Name: mvt_stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mvt_stock (id, id_produit, entree, sortie, d_prix_unitaire, date) FROM stdin;
6	1	0.00	12.00	3200.00	2025-01-08 00:00:00
7	2	0.00	18.00	800.00	2025-01-08 00:00:00
8	3	0.00	15.00	500.00	2025-01-08 00:00:00
9	9	3.00	0.00	20000.00	2025-01-08 00:00:00
10	2	4.00	0.00	800.00	2025-01-09 00:00:00
11	3	2.00	0.00	500.00	2025-01-09 00:00:00
12	11	3.00	0.00	4000.00	2025-01-09 00:00:00
13	16	2.00	0.00	2900.00	2025-01-09 00:00:00
14	13	6.00	0.00	4000.00	2025-01-09 00:00:00
15	16	10.00	0.00	2900.00	2025-01-09 00:00:00
16	16	3.00	0.00	2900.00	2025-01-09 00:00:00
17	9	0.00	3.00	20000.00	2025-01-09 00:00:00
18	31	0.00	45.00	3500.00	2025-01-09 00:00:00
19	32	0.00	50.00	3500.00	2025-01-09 00:00:00
20	31	0.00	30.00	3500.00	2025-01-09 00:00:00
21	31	0.00	7.00	3500.00	2025-01-09 00:00:00
22	2	5.00	0.00	800.00	2025-01-11 00:00:00
23	11	3.00	0.00	4000.00	2025-01-11 00:00:00
24	12	50.00	0.00	200.00	2025-01-12 00:00:00
25	3	30.00	0.00	500.00	2025-01-12 00:00:00
26	1	15.00	0.00	3200.00	2025-01-12 00:00:00
27	16	9.00	0.00	2900.00	2025-01-12 00:00:00
28	2	50.00	0.00	800.00	2025-01-12 00:00:00
\.


--
-- Data for Name: parfum; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.parfum (id, nom) FROM stdin;
1	Nature
2	Fromage
3	Vanille
4	Chocolat
\.


--
-- Data for Name: production; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.production (id, id_produit_fini, qte, d_prix_unitaire, date_production) FROM stdin;
3	5	3.00	\N	2025-01-08 00:00:00
\.


--
-- Data for Name: produit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produit (id, nom, id_type_produit, prix_achat, prix_vente, id_unite) FROM stdin;
2	Oeuf	1	800.00	\N	1
9	Simple Gateau	2	\N	20000.00	1
10	Baguette de Pain	2	\N	1000.00	1
3	Sucre	1	500.00	\N	3
11	Lait	1	4000.00	\N	2
12	Eau	1	200.00	\N	2
13	Beurre	1	4000.00	\N	3
14	Huile	1	3500.00	\N	2
15	Levure	1	900.00	\N	3
16	Chocolat	1	2900.00	\N	3
1	Farine	1	3200.00	\N	3
26	Sel	1	1400.00	\N	3
27	Gateau gourmand	2	\N	90000.00	1
25	Produit A	2	\N	900.00	1
28	Pain B	2	\N	3000.00	1
29	Fromage	1	10500.00	\N	3
30	Vanille	1	20000.00	\N	3
31	Croissant au Fromage	2	\N	3500.00	1
32	Croissant au Chocolat	2	\N	3500.00	1
\.


--
-- Data for Name: produit_fini; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produit_fini (id, id_produit, id_categorie, id_parfum) FROM stdin;
6	10	3	\N
9	25	3	\N
10	27	1	\N
11	28	3	\N
5	9	1	1
12	31	2	2
13	32	2	4
\.


--
-- Data for Name: recette; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.recette (id, id_produit_fini, id_ingredient, quantite) FROM stdin;
1	5	1	4.00
2	5	2	6.00
3	5	3	5.00
4	6	1	4.00
5	6	2	1.00
6	9	4	0.50
7	9	1	1.20
8	9	7	0.50
9	10	2	6.00
10	10	4	0.80
11	10	6	0.50
12	10	1	1.20
13	10	3	0.50
14	10	5	0.10
15	11	4	3.00
16	11	6	0.50
17	12	1	0.70
18	12	8	0.10
19	12	6	0.20
20	12	12	0.40
21	13	1	0.60
22	13	9	0.20
23	13	8	0.10
24	13	6	0.20
\.


--
-- Data for Name: type_produit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.type_produit (id, nom, code) FROM stdin;
2	Produit Fini	PF
1	Ingredient	INGR
\.


--
-- Data for Name: unite; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.unite (id, code, nom) FROM stdin;
1	u	Unité
2	L	Litre
3	KG	Kilogramme
\.


--
-- Data for Name: vente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vente (id, date_heure, id_client) FROM stdin;
1	2025-01-09 00:00:00	\N
2	2025-01-09 00:00:00	1
3	2025-01-09 00:00:00	1
4	2025-01-09 00:00:00	1
5	2025-01-11 00:00:00	1
\.


--
-- Data for Name: vente_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vente_details (id, id_vente, id_produit_fini, quantie, d_prix_unitaire) FROM stdin;
1	1	5	3.00	20000.00
2	2	12	45.00	3500.00
3	3	13	50.00	3500.00
4	3	12	30.00	3500.00
5	4	12	7.00	3500.00
6	5	12	2.00	3500.00
\.


--
-- Name: achat_details_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.achat_details_id_seq', 14, true);


--
-- Name: achat_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.achat_id_seq', 10, true);


--
-- Name: categorie_produit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categorie_produit_id_seq', 4, true);


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.client_id_seq', 1, true);


--
-- Name: employe_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employe_id_seq', 1, false);


--
-- Name: fournisseur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fournisseur_id_seq', 1, true);


--
-- Name: ingredient_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ingredient_id_seq', 13, true);


--
-- Name: mvt_stock_fille_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mvt_stock_fille_id_seq', 28, true);


--
-- Name: parfum_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.parfum_id_seq', 4, true);


--
-- Name: production_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.production_id_seq', 3, true);


--
-- Name: produit_fini_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produit_fini_id_seq', 13, true);


--
-- Name: produit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produit_id_seq', 32, true);


--
-- Name: recette_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.recette_id_seq', 24, true);


--
-- Name: type_produit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_produit_id_seq', 2, true);


--
-- Name: unite_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.unite_id_seq', 3, true);


--
-- Name: vente_details_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vente_details_id_seq', 6, true);


--
-- Name: vente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vente_id_seq', 5, true);


--
-- Name: achat_details achat_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat_details
    ADD CONSTRAINT achat_details_pkey PRIMARY KEY (id);


--
-- Name: achat achat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat
    ADD CONSTRAINT achat_pkey PRIMARY KEY (id);


--
-- Name: categorie_produit categorie_produit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie_produit
    ADD CONSTRAINT categorie_produit_pkey PRIMARY KEY (id);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- Name: employe employe_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employe
    ADD CONSTRAINT employe_pkey PRIMARY KEY (id);


--
-- Name: fournisseur fournisseur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fournisseur
    ADD CONSTRAINT fournisseur_pkey PRIMARY KEY (id);


--
-- Name: ingredient ingredient_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingredient
    ADD CONSTRAINT ingredient_pkey PRIMARY KEY (id);


--
-- Name: mvt_stock mvt_stock_fille_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mvt_stock
    ADD CONSTRAINT mvt_stock_fille_pkey PRIMARY KEY (id);


--
-- Name: parfum parfum_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parfum
    ADD CONSTRAINT parfum_pkey PRIMARY KEY (id);


--
-- Name: production production_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.production
    ADD CONSTRAINT production_pkey PRIMARY KEY (id);


--
-- Name: produit_fini produit_fini_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit_fini
    ADD CONSTRAINT produit_fini_pkey PRIMARY KEY (id);


--
-- Name: produit produit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit
    ADD CONSTRAINT produit_pkey PRIMARY KEY (id);


--
-- Name: recette recette_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recette
    ADD CONSTRAINT recette_pkey PRIMARY KEY (id);


--
-- Name: type_produit type_produit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_produit
    ADD CONSTRAINT type_produit_pkey PRIMARY KEY (id);


--
-- Name: unite unite_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.unite
    ADD CONSTRAINT unite_pkey PRIMARY KEY (id);


--
-- Name: vente_details vente_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente_details
    ADD CONSTRAINT vente_details_pkey PRIMARY KEY (id);


--
-- Name: vente vente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente
    ADD CONSTRAINT vente_pkey PRIMARY KEY (id);


--
-- Name: achat_details achat_details_id_achat_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat_details
    ADD CONSTRAINT achat_details_id_achat_foreign FOREIGN KEY (id_achat) REFERENCES public.achat(id);


--
-- Name: achat_details achat_details_id_ingredient_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat_details
    ADD CONSTRAINT achat_details_id_ingredient_foreign FOREIGN KEY (id_ingredient) REFERENCES public.ingredient(id);


--
-- Name: achat achat_id_fournisseur_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat
    ADD CONSTRAINT achat_id_fournisseur_foreign FOREIGN KEY (id_fournisseur) REFERENCES public.fournisseur(id);


--
-- Name: ingredient ingredient_id_produit_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingredient
    ADD CONSTRAINT ingredient_id_produit_foreign FOREIGN KEY (id_produit) REFERENCES public.produit(id);


--
-- Name: mvt_stock mvt_stock_fille_id_produit_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mvt_stock
    ADD CONSTRAINT mvt_stock_fille_id_produit_foreign FOREIGN KEY (id_produit) REFERENCES public.produit(id);


--
-- Name: production production_id_produit_fini_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.production
    ADD CONSTRAINT production_id_produit_fini_fkey FOREIGN KEY (id_produit_fini) REFERENCES public.produit_fini(id);


--
-- Name: produit_fini produit_fini_id_categorie_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit_fini
    ADD CONSTRAINT produit_fini_id_categorie_foreign FOREIGN KEY (id_categorie) REFERENCES public.categorie_produit(id);


--
-- Name: produit_fini produit_fini_id_parfum_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit_fini
    ADD CONSTRAINT produit_fini_id_parfum_fkey FOREIGN KEY (id_parfum) REFERENCES public.parfum(id);


--
-- Name: produit_fini produit_fini_id_produit_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit_fini
    ADD CONSTRAINT produit_fini_id_produit_foreign FOREIGN KEY (id_produit) REFERENCES public.produit(id);


--
-- Name: produit produit_id_type_produit_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit
    ADD CONSTRAINT produit_id_type_produit_foreign FOREIGN KEY (id_type_produit) REFERENCES public.type_produit(id);


--
-- Name: produit produit_id_unite_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produit
    ADD CONSTRAINT produit_id_unite_fkey FOREIGN KEY (id_unite) REFERENCES public.unite(id);


--
-- Name: recette recette_id_ingredient_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recette
    ADD CONSTRAINT recette_id_ingredient_foreign FOREIGN KEY (id_ingredient) REFERENCES public.ingredient(id);


--
-- Name: recette recette_id_produit_fini_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recette
    ADD CONSTRAINT recette_id_produit_fini_foreign FOREIGN KEY (id_produit_fini) REFERENCES public.produit_fini(id);


--
-- Name: vente_details vente_details_id_produit_fini_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente_details
    ADD CONSTRAINT vente_details_id_produit_fini_foreign FOREIGN KEY (id_produit_fini) REFERENCES public.produit_fini(id);


--
-- Name: vente_details vente_details_id_vente_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente_details
    ADD CONSTRAINT vente_details_id_vente_foreign FOREIGN KEY (id_vente) REFERENCES public.vente(id);


--
-- Name: vente vente_id_client_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente
    ADD CONSTRAINT vente_id_client_foreign FOREIGN KEY (id_client) REFERENCES public.client(id);


--
-- PostgreSQL database dump complete
--

