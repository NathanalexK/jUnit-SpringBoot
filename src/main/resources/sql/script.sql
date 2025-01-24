select
    id,
    nom,
    id_type_produit
from produit
;


create or replace view v_stock_simple as
select
    id_produit,
    sum(entree - sortie) as qte
from mvt_stock
group by id_produit
;


drop view v_stock;
create or replace view v_stock as
select
    row_number() over () as id,
    produit.id as id_produit,
    coalesce(qte, 0) as qte
from produit
left join v_stock_simple vss
on produit.id = vss.id_produit
;


create table parfum (
    id serial primary key not null ,
    nom varchar(50)
);

alter table produit_fini add column id_parfum integer references parfum(id);


create or replace view v_vente_details_cpl as
select
    vd.*,
    v.date_heure,
    v.id_client
from vente_details vd
join vente v
on vd.id_vente = v.id;


WITH interval AS(
SELECT
    generate_series(
            (SELECT MIN(date_heure) FROM v_vente_details_cpl),
            (SELECT MAX(date_heure) FROM v_vente_details_cpl),
            INTERVAL '1 days'
    ) AS start_date
)
SELECT
    i.start_date,
    i.start_date + interval '1 days' as end_date,
    v.id_produit_fini,
    COALESCE(SUM(v.quantie), 0) as total
FROM interval i
LEFT JOIN v_vente_details_cpl v
ON v.date_heure >= i.start_date AND v.date_heure < i.start_date + INTERVAL '1 days'
WHERE i.start_date between '2020-01-01' and '2026-01-01'
GROUP BY i.start_date, v.id_produit_fini
ORDER BY i.start_date


select
    *
from vente_details;

create table recommendation_produit (
    id serial primary key,
    id_produit_fini int references produit_fini(id),
    mois int,
    annee int
);

create table vendeur (
     id serial primary key,
     nom varchar(50)
);

create table configuration(
    key varchar(50),
    value varchar(255)
);


create table commission (
    id serial primary key,
    id_vente integer references vente(id),
    id_vendeur integer references vendeur(id),
    montant numeric(15, 2)
);

alter table vente add column id_vendeur integer references vendeur(id);
alter table vente add column commission numeric(15, 2);



create or replace view v_commission_client as;



select
    v.id,
    v.nom,
    genre.id as id_genre,
    genre.nom as genre,
    total
from (
select
    id_vendeur,
    sum(coalesce(commission, 0)) as total
from vente
where true
and date_heure between '2024-01-01' and  '2026-01-01'
group by id_vendeur ) as v1
join vendeur v
on v1.id_vendeur = v.id
join genre
on v.id_genre = genre.id
order by total DESC;



select
    *
from vente
joi
join genre
;

create table genre (
    id integer primary key,
    nom varchar(20)
);

alter table vendeur add column id_genre integer references genre(id);


select






