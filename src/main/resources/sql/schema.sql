CREATE TABLE "produit_fini"
(
    "id"           SERIAL  NOT NULL,
    "id_produit"   INTEGER NOT NULL,
    "id_categorie" INTEGER NOT NULL
);
ALTER TABLE
    "produit_fini"
    ADD PRIMARY KEY ("id");
CREATE TABLE "ingredient"
(
    "id"         SERIAL  NOT NULL,
    "id_produit" INTEGER NOT NULL
);
ALTER TABLE
    "ingredient"
    ADD PRIMARY KEY ("id");
CREATE TABLE "produit"
(
    "id"              SERIAL         NOT NULL,
    "nom"             VARCHAR(255)   NOT NULL,
    "id_type_produit" INTEGER        NOT NULL,
    "prix_achat"      DECIMAL(15, 2) NOT NULL,
    "prix_vente"      DECIMAL(15, 2) NOT NULL,
    "id_unite"        INT            NOT NULL
);
ALTER TABLE
    "produit"
    ADD PRIMARY KEY ("id");
CREATE TABLE "recette"
(
    "id"              SERIAL         NOT NULL,
    "id_produit_fini" INTEGER        NOT NULL,
    "id_ingredient"   INTEGER        NOT NULL,
    "quantite"        DECIMAL(15, 2) NOT NULL
);
ALTER TABLE
    "recette"
    ADD PRIMARY KEY ("id");
CREATE TABLE "mvt_stock"
(
    "id"         SERIAL                         NOT NULL,
    "date_heure" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);
ALTER TABLE
    "mvt_stock"
    ADD PRIMARY KEY ("id");
CREATE TABLE "mvt_stock_fille"
(
    "id"              SERIAL         NOT NULL,
    "id_mvt_stock"    INTEGER        NOT NULL,
    "id_produit"      INTEGER        NOT NULL,
    "entree"          DECIMAL(15, 2) NOT NULL DEFAULT 0,
    "sortie"          DECIMAL(15, 2) NOT NULL DEFAULT 0,
    "d_prix_unitaire" DECIMAL(15, 2) NOT NULL
);
ALTER TABLE
    "mvt_stock_fille"
    ADD PRIMARY KEY ("id");
CREATE TABLE "vente"
(
    "id"         SERIAL                         NOT NULL,
    "date_heure" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    "id_client"  INTEGER                        NULL
);
ALTER TABLE
    "vente"
    ADD PRIMARY KEY ("id");
CREATE TABLE "vente_details"
(
    "id"              SERIAL         NOT NULL,
    "id_vente"        INTEGER        NOT NULL,
    "id_produit_fini" INTEGER        NOT NULL,
    "quantie"         DECIMAL(15, 2) NOT NULL,
    "d_prix_unitaire" DECIMAL(15, 2) NOT NULL
);
ALTER TABLE
    "vente_details"
    ADD PRIMARY KEY ("id");
CREATE TABLE "client"
(
    "id"           SERIAL       NOT NULL,
    "nom"          VARCHAR(255) NOT NULL,
    "dateCreation" DATE         NOT NULL DEFAULT NOW()
);
ALTER TABLE
    "client"
    ADD PRIMARY KEY ("id");
CREATE TABLE "fournisseur"
(
    "id"           SERIAL       NOT NULL,
    "nom"          VARCHAR(255) NOT NULL,
    "dateCreation" DATE         NOT NULL DEFAULT NOW()
);
ALTER TABLE
    "fournisseur"
    ADD PRIMARY KEY ("id");
CREATE TABLE "achat"
(
    "id"             SERIAL                         NOT NULL,
    "date_heure"     TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    "id_fournisseur" INTEGER                        NULL
);
ALTER TABLE
    "achat"
    ADD PRIMARY KEY ("id");
CREATE TABLE "achat_details"
(
    "id"              SERIAL         NOT NULL,
    "id_achat"        INTEGER        NOT NULL,
    "id_ingredient"   INTEGER        NOT NULL,
    "quantite"        DECIMAL(15, 2) NOT NULL,
    "d_prix_unitaire" DECIMAL(15, 2) NOT NULL
);
ALTER TABLE
    "achat_details"
    ADD PRIMARY KEY ("id");
CREATE TABLE "type_produit"
(
    "id"   SERIAL       NOT NULL,
    "code" VARCHAR(20)  NOT NULL,
    "nom"  VARCHAR(255) NOT NULL
);
ALTER TABLE
    "type_produit"
    ADD PRIMARY KEY ("id");
CREATE TABLE "categorie_produit"
(
    "id"  SERIAL       NOT NULL,
    "nom" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "categorie_produit"
    ADD PRIMARY KEY ("id");
CREATE TABLE "employe"
(
    "id"           SERIAL       NOT NULL,
    "nom"          VARCHAR(255) NOT NULL,
    "dateEmbauche" DATE         NOT NULL DEFAULT NOW()
);
CREATE TABLE "unite"
(
    "id"   SERIAL      NOT NULL PRIMARY KEY,
    "code" VARCHAR(10) NOT NULL,
    "nom"  VARCHAR(50) NOT NULL
);

CREATE TABLE "production"
(
    "id" SERIAL NOT NULL PRIMARY KEY,
    "id_produit_fini" INTEGER NOT NULL REFERENCES produit_fini(id),
    "qte" DECIMAL(15, 2),
    "d_prix_unitaire" DECIMAL(15, 2),
    "date_production" timestamp default now()
);
ALTER TABLE
    "employe"
    ADD PRIMARY KEY ("id");
ALTER TABLE
    "vente_details"
    ADD CONSTRAINT "vente_details_id_produit_fini_foreign" FOREIGN KEY ("id_produit_fini") REFERENCES "produit_fini" ("id");
ALTER TABLE
    "achat_details"
    ADD CONSTRAINT "achat_details_id_achat_foreign" FOREIGN KEY ("id_achat") REFERENCES "achat" ("id");
ALTER TABLE
    "recette"
    ADD CONSTRAINT "recette_id_produit_fini_foreign" FOREIGN KEY ("id_produit_fini") REFERENCES "produit_fini" ("id");
ALTER TABLE
    "vente"
    ADD CONSTRAINT "vente_id_client_foreign" FOREIGN KEY ("id_client") REFERENCES "client" ("id");
ALTER TABLE
    "recette"
    ADD CONSTRAINT "recette_id_ingredient_foreign" FOREIGN KEY ("id_ingredient") REFERENCES "ingredient" ("id");
ALTER TABLE
    "mvt_stock_fille"
    ADD CONSTRAINT "mvt_stock_fille_id_mvt_stock_foreign" FOREIGN KEY ("id_mvt_stock") REFERENCES "mvt_stock" ("id");
ALTER TABLE
    "ingredient"
    ADD CONSTRAINT "ingredient_id_produit_foreign" FOREIGN KEY ("id_produit") REFERENCES "produit" ("id");
ALTER TABLE
    "vente_details"
    ADD CONSTRAINT "vente_details_id_vente_foreign" FOREIGN KEY ("id_vente") REFERENCES "vente" ("id");
ALTER TABLE
    "produit_fini"
    ADD CONSTRAINT "produit_fini_id_produit_foreign" FOREIGN KEY ("id_produit") REFERENCES "produit" ("id");
ALTER TABLE
    "produit"
    ADD CONSTRAINT "produit_id_type_produit_foreign" FOREIGN KEY ("id_type_produit") REFERENCES "type_produit" ("id");
ALTER TABLE
    "produit"
    ADD CONSTRAINT "produit_id_unite_foreign" FOREIGN KEY ("id_unite") REFERENCES "unite" ("id");
ALTER TABLE
    "mvt_stock_fille"
    ADD CONSTRAINT "mvt_stock_fille_id_produit_foreign" FOREIGN KEY ("id_produit") REFERENCES "produit" ("id");
ALTER TABLE
    "achat"
    ADD CONSTRAINT "achat_id_fournisseur_foreign" FOREIGN KEY ("id_fournisseur") REFERENCES "fournisseur" ("id");
ALTER TABLE
    "produit_fini"
    ADD CONSTRAINT "produit_fini_id_categorie_foreign" FOREIGN KEY ("id_categorie") REFERENCES "categorie_produit" ("id");
ALTER TABLE
    "achat_details"
    ADD CONSTRAINT "achat_details_id_ingredient_foreign" FOREIGN KEY ("id_ingredient") REFERENCES "ingredient" ("id");