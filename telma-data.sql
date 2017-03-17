--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.4.5
-- Started on 2017-03-02 10:26:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

truncate carte_credit cascade;
truncate type_transaction cascade;
truncate type_carte cascade;
truncate forfait cascade ;
truncate type_forfait cascade ;
truncate utilisateur cascade ;
truncate type_transaction cascade ;
truncate sim cascade ;
truncate forfait_type cascade ;
truncate transactions cascade ;
truncate transaction_type cascade ;

--
-- TOC entry 2115 (class 0 OID 26647)
-- Dependencies: 184
-- Data for Name: type_carte; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO type_carte VALUES (1, 1000);
INSERT INTO type_carte VALUES (2, 2000);
INSERT INTO type_carte VALUES (3, 5000);
INSERT INTO type_carte VALUES (4, 10000);


--
-- TOC entry 2104 (class 0 OID 26582)
-- Dependencies: 173
-- Data for Name: carte_credit; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2126 (class 0 OID 0)
-- Dependencies: 172
-- Name: carte_credit_idcarte_credit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('carte_credit_idcarte_credit_seq', 1, false);


--
-- TOC entry 2106 (class 0 OID 26592)
-- Dependencies: 175
-- Data for Name: forfait; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO forfait VALUES (1, 'Be connect 10');
INSERT INTO forfait VALUES (2, 'Be connect 20');
INSERT INTO forfait VALUES (3, 'Be connect 50');


--
-- TOC entry 2127 (class 0 OID 0)
-- Dependencies: 174
-- Name: forfait_idforfait_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('forfait_idforfait_seq', 3, true);


--
-- TOC entry 2117 (class 0 OID 26656)
-- Dependencies: 186
-- Data for Name: type_forfait; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO type_forfait VALUES (1, 'SMS');
INSERT INTO type_forfait VALUES (2, 'Appel');
INSERT INTO type_forfait VALUES (3, 'Internet');


--
-- TOC entry 2107 (class 0 OID 26599)
-- Dependencies: 176
-- Data for Name: forfait_type; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2109 (class 0 OID 26609)
-- Dependencies: 178
-- Data for Name: sim; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2128 (class 0 OID 0)
-- Dependencies: 177
-- Name: sim_idsim_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sim_idsim_seq', 1, false);


--
-- TOC entry 2121 (class 0 OID 26674)
-- Dependencies: 190
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2110 (class 0 OID 26616)
-- Dependencies: 179
-- Data for Name: sim_utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2112 (class 0 OID 26626)
-- Dependencies: 181
-- Data for Name: transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2129 (class 0 OID 0)
-- Dependencies: 180
-- Name: transaction_idtransaction_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('transaction_idtransaction_seq', 1, false);


--
-- TOC entry 2119 (class 0 OID 26665)
-- Dependencies: 188
-- Data for Name: type_transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO type_transaction VALUES (1, 'recharge');
INSERT INTO type_transaction VALUES (2, 'virement');
INSERT INTO type_transaction VALUES (3, 'depense');


--
-- TOC entry 2113 (class 0 OID 26637)
-- Dependencies: 182
-- Data for Name: transaction_type; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2130 (class 0 OID 0)
-- Dependencies: 183
-- Name: type_carte_idtype_carte_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('type_carte_idtype_carte_seq', 4, true);


--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 185
-- Name: type_forfait_idtype_forfait_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('type_forfait_idtype_forfait_seq', 3, true);


--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 187
-- Name: type_transaction_idtype_transaction_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('type_transaction_idtype_transaction_seq', 3, true);


--
-- TOC entry 2133 (class 0 OID 0)
-- Dependencies: 189
-- Name: utilisateur_idutilisateur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('utilisateur_idutilisateur_seq', 1, false);


-- Completed on 2017-03-02 10:26:44

--
-- PostgreSQL database dump complete
--

