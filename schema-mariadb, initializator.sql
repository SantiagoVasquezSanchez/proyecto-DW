drop table if exists book;
drop table if exists editorial;

create table book (
    id int primary key auto_increment,
    name varchar(200) not null,
    description varchar(3000),
    image_url varchar(500)
);


insert into book 
(id,    name,                    description,                                                                                                                                                                                                                           image_url) values
(1,     'El Siconalista',       'Frederick Starks, psicoanalista de larga experiencia y vida tranquila, recibe una amenaza anónima. Tendrá que emplear toda su astucia para averiguar quién es el autor de esa misiva que promete hacerle la existencia imposible.',    'https://images-na.ssl-images-amazon.com/images/I/41Zc7DRsnoL._SX327_BO1,204,203,200_.jpg'),
(2,     'Billy Summers',        'Novela sobre un buen tipo con un trabajo muy malo.',                                                                                                                                                                                   'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1618151020l/56852407.jpg'),
(3,     'Los Ilusionistas',     'Cuenta la historia de un golpe militar en Chile.',                                                                                                                                                                                     'https://images-na.ssl-images-amazon.com/images/I/61887EOsA0L.jpg'),
(4,     'Cien Años de Soledad', 'El único premio novel de literatura de Colombia.',                                                                                                                                                                                     'https://images-na.ssl-images-amazon.com/images/I/51g1mv8VEnL._SX322_BO1,204,203,200_.jpg');

create table editorial (
    id int primary key auto_increment,
    name varchar(200) not null,
    web_site varchar(500)
);

insert into editorial
(id,    name,                           web_site) values
(1,     'Ballard & Tighe, Publishers',  'https://ballard-tighe.com/home/'),
(2,     'Bilingual Review Press',       'https://bilingualpress.clas.asu.edu/'),
(3,     'Ediciones Baquiana',           'https://baquiana.com/'),
(4,     'Unknown',                      null);

alter table book
add column editorial_id int,
add foreign key (editorial_id) references editorial(id);

update book set editorial_id = 1 where id in (1, 2);
update book set editorial_id = 2 where id in (3);
update book set editorial_id = 3 where id in (4);

alter table book
modify editorial_id int not null;