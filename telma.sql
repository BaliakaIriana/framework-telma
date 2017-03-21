/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     03/03/2017 11:50:26                          */
/*==============================================================*/


drop index SOLDE_CARTE_FK;

drop index CARTE_CREDIT_PK;

drop table CARTE_CREDIT CASCADE;

drop index FORFAIT_PK;

drop table FORFAIT CASCADE;

drop index FORFAIT_TYPE2_FK;

drop index FORFAIT_TYPE_FK;

drop index FORFAIT_TYPE_PK;

drop table FORFAIT_TYPE CASCADE;

drop index SIM_PK;

drop table SIM CASCADE;

drop index SIM_UTILISATEUR2_FK;

drop index SIM_UTILISATEUR_FK;

drop index SIM_UTILISATEUR_PK;

drop table SIM_UTILISATEUR CASCADE;

drop index TRANSACTION_TYPE_FK;

drop index SOLDE_SIM_FK;

drop index TRANSACTION_PK;

drop table TRANSACTION;

drop index TYPE_CARTE_PK;

drop table TYPE_CARTE CASCADE;

drop index TYPE_FORFAIT_PK;

drop table TYPE_FORFAIT CASCADE;

drop index TYPE_TRANSACTION_PK;

drop table TYPE_TRANSACTION;

drop index UTILISATEUR_PK;

drop table UTILISATEUR CASCADE;

/*==============================================================*/
/* Table: CARTE_CREDIT                                          */
/*==============================================================*/
create table CARTE_CREDIT (
   IDCARTE_CREDIT       SERIAL               not null,
   IDTYPE_CARTE         INT4                 not null,
   CODE_CREDIT          CHAR(15)             not null,
   DATE_PEREMPTION      DATE                 not null,
   constraint PK_CARTE_CREDIT primary key (IDCARTE_CREDIT)
);

/*==============================================================*/
/* Index: CARTE_CREDIT_PK                                       */
/*==============================================================*/
create unique index CARTE_CREDIT_PK on CARTE_CREDIT (
IDCARTE_CREDIT
);

/*==============================================================*/
/* Index: SOLDE_CARTE_FK                                        */
/*==============================================================*/
create  index SOLDE_CARTE_FK on CARTE_CREDIT (
IDTYPE_CARTE
);

/*==============================================================*/
/* Table: FORFAIT                                               */
/*==============================================================*/
create table FORFAIT (
   IDFORFAIT            SERIAL               not null,
   NOM_FORFAIT          VARCHAR(255)         not null,
   constraint PK_FORFAIT primary key (IDFORFAIT)
);

/*==============================================================*/
/* Index: FORFAIT_PK                                            */
/*==============================================================*/
create unique index FORFAIT_PK on FORFAIT (
IDFORFAIT
);

/*==============================================================*/
/* Table: FORFAIT_TYPE                                          */
/*==============================================================*/
create table FORFAIT_TYPE (
   IDFORFAIT            INT4                 not null,
   IDTYPE_FORFAIT       INT4                 not null,
   QUANTITE_OFFRE       INT4                 not null,
   constraint PK_FORFAIT_TYPE primary key (IDFORFAIT, IDTYPE_FORFAIT)
);

/*==============================================================*/
/* Index: FORFAIT_TYPE_PK                                       */
/*==============================================================*/
create unique index FORFAIT_TYPE_PK on FORFAIT_TYPE (
IDFORFAIT,
IDTYPE_FORFAIT
);

/*==============================================================*/
/* Index: FORFAIT_TYPE_FK                                       */
/*==============================================================*/
create  index FORFAIT_TYPE_FK on FORFAIT_TYPE (
IDFORFAIT
);

/*==============================================================*/
/* Index: FORFAIT_TYPE2_FK                                      */
/*==============================================================*/
create  index FORFAIT_TYPE2_FK on FORFAIT_TYPE (
IDTYPE_FORFAIT
);

/*==============================================================*/
/* Table: SIM                                                   */
/*==============================================================*/
create table SIM (
   IDSIM                SERIAL               not null,
   NUMERO               CHAR(10)             not null,
   PIN                  CHAR(4)              not null,
   PUK                  CHAR(7)              not null,
   constraint PK_SIM primary key (IDSIM)
);

/*==============================================================*/
/* Index: SIM_PK                                                */
/*==============================================================*/
create unique index SIM_PK on SIM (
IDSIM
);

/*==============================================================*/
/* Table: SIM_UTILISATEUR                                       */
/*==============================================================*/
create table SIM_UTILISATEUR (
   IDUTILISATEUR        INT4                 not null,
   IDSIM                INT4                 not null,
   constraint PK_SIM_UTILISATEUR primary key (IDUTILISATEUR, IDSIM)
);

/*==============================================================*/
/* Index: SIM_UTILISATEUR_PK                                    */
/*==============================================================*/
create unique index SIM_UTILISATEUR_PK on SIM_UTILISATEUR (
IDUTILISATEUR,
IDSIM
);

/*==============================================================*/
/* Index: SIM_UTILISATEUR_FK                                    */
/*==============================================================*/
create  index SIM_UTILISATEUR_FK on SIM_UTILISATEUR (
IDUTILISATEUR
);

/*==============================================================*/
/* Index: SIM_UTILISATEUR2_FK                                   */
/*==============================================================*/
create  index SIM_UTILISATEUR2_FK on SIM_UTILISATEUR (
IDSIM
);

/*==============================================================*/
/* Table: TRANSACTION                                           */
/*==============================================================*/
create table TRANSACTION (
   IDTRANSACTION        SERIAL               not null,
   IDSIM                INT4                 not null,
   IDTYPE_TRANSACTION   INT4                 not null,
   SOLDE                DECIMAL              not null,
   TIME_TRANSACTION     DATE                 not null,
   constraint PK_TRANSACTION primary key (IDTRANSACTION)
);

/*==============================================================*/
/* Index: TRANSACTION_PK                                        */
/*==============================================================*/
create unique index TRANSACTION_PK on TRANSACTION (
IDTRANSACTION
);

/*==============================================================*/
/* Index: SOLDE_SIM_FK                                          */
/*==============================================================*/
create  index SOLDE_SIM_FK on TRANSACTION (
IDSIM
);

/*==============================================================*/
/* Index: TRANSACTION_TYPE_FK                                   */
/*==============================================================*/
create  index TRANSACTION_TYPE_FK on TRANSACTION (
IDTYPE_TRANSACTION
);

/*==============================================================*/
/* Table: TYPE_CARTE                                            */
/*==============================================================*/
create table TYPE_CARTE (
   IDTYPE_CARTE         SERIAL               not null,
   SOLDE_CARTE          INT4                 not null,
   constraint PK_TYPE_CARTE primary key (IDTYPE_CARTE)
);

/*==============================================================*/
/* Index: TYPE_CARTE_PK                                         */
/*==============================================================*/
create unique index TYPE_CARTE_PK on TYPE_CARTE (
IDTYPE_CARTE
);

/*==============================================================*/
/* Table: TYPE_FORFAIT                                          */
/*==============================================================*/
create table TYPE_FORFAIT (
   IDTYPE_FORFAIT       SERIAL               not null,
   NOM_TYPE_FORFAIT     VARCHAR(255)         not null,
   constraint PK_TYPE_FORFAIT primary key (IDTYPE_FORFAIT)
);

/*==============================================================*/
/* Index: TYPE_FORFAIT_PK                                       */
/*==============================================================*/
create unique index TYPE_FORFAIT_PK on TYPE_FORFAIT (
IDTYPE_FORFAIT
);

/*==============================================================*/
/* Table: TYPE_TRANSACTION                                      */
/*==============================================================*/
create table TYPE_TRANSACTION (
   IDTYPE_TRANSACTION   SERIAL               not null,
   NOM_TYPE_TRANSACTION VARCHAR(255)         not null,
   constraint PK_TYPE_TRANSACTION primary key (IDTYPE_TRANSACTION)
);

/*==============================================================*/
/* Index: TYPE_TRANSACTION_PK                                   */
/*==============================================================*/
create unique index TYPE_TRANSACTION_PK on TYPE_TRANSACTION (
IDTYPE_TRANSACTION
);

/*==============================================================*/
/* Table: UTILISATEUR                                           */
/*==============================================================*/
create table UTILISATEUR (
   IDUTILISATEUR        SERIAL               not null,
   NOM                  VARCHAR(255)         null,
   PRENOM               VARCHAR(255)         null,
   CIN                  CHAR(12)             null,
   constraint PK_UTILISATEUR primary key (IDUTILISATEUR)
);

/*==============================================================*/
/* Index: UTILISATEUR_PK                                        */
/*==============================================================*/
create unique index UTILISATEUR_PK on UTILISATEUR (
IDUTILISATEUR
);

alter table CARTE_CREDIT
   add constraint FK_CARTE_CR_SOLDE_CAR_TYPE_CAR foreign key (IDTYPE_CARTE)
      references TYPE_CARTE (IDTYPE_CARTE)
      on delete restrict on update restrict;

alter table FORFAIT_TYPE
   add constraint FK_FORFAIT__FORFAIT_T_FORFAIT foreign key (IDFORFAIT)
      references FORFAIT (IDFORFAIT)
      on delete restrict on update restrict;

alter table FORFAIT_TYPE
   add constraint FK_FORFAIT__FORFAIT_T_TYPE_FOR foreign key (IDTYPE_FORFAIT)
      references TYPE_FORFAIT (IDTYPE_FORFAIT)
      on delete restrict on update restrict;

alter table SIM_UTILISATEUR
   add constraint FK_SIM_UTIL_SIM_UTILI_UTILISAT foreign key (IDUTILISATEUR)
      references UTILISATEUR (IDUTILISATEUR)
      on delete restrict on update restrict;

alter table SIM_UTILISATEUR
   add constraint FK_SIM_UTIL_SIM_UTILI_SIM foreign key (IDSIM)
      references SIM (IDSIM)
      on delete restrict on update restrict;

alter table TRANSACTION
   add constraint FK_TRANSACT_SOLDE_SIM_SIM foreign key (IDSIM)
      references SIM (IDSIM)
      on delete restrict on update restrict;

alter table TRANSACTION
   add constraint FK_TRANSACT_TRANSACTI_TYPE_TRA foreign key (IDTYPE_TRANSACTION)
      references TYPE_TRANSACTION (IDTYPE_TRANSACTION)
      on delete restrict on update restrict;

