create database if not exists multidominio_bd;

use multidominio_bd;

#########################################################################################################
-- DOMINIO DE VIDEOJUEGOS -------------------------------------------------------------------------------
#########################################################################################################
-- crea la tabla de estudios creadores de videojuegos
create table estudio(
                        id int primary key auto_increment,
                        nombre varchar(50) not null,
                        fundacion date,
                        pais varchar(100) not null
);
INSERT INTO estudio (id, nombre, fundacion, pais) VALUES
                                                      (1, 'Nintendo', '1889-09-23', 'Japón'),
                                                      (2, 'Rockstar Games', '1998-12-01', 'Estados Unidos'),
                                                      (3, 'CD Projekt Red', '2002-07-01', 'Polonia'),
                                                      (4, 'Mojang Studios', '2009-05-17', 'Suecia'),
                                                      (5, 'Valve Corporation', '1996-08-24', 'Estados Unidos'),
                                                      (6, 'Epic Games', '1991-01-01', 'Estados Unidos'),
                                                      (7, 'Blizzard Entertainment', '1991-02-08', 'Estados Unidos'),
                                                      (8, 'Bungie', '1991-05-01', 'Estados Unidos'),
                                                      (9, 'FromSoftware', '1986-11-01', 'Japón'),
                                                      (10, 'Capcom', '1979-05-30', 'Japón'),
                                                      (11, 'Square Enix', '2003-04-01', 'Japón'),
                                                      (12, 'Sega', '1940-06-03', 'Japón'),
                                                      (13, 'Ubisoft', '1986-03-28', 'Francia'),
                                                      (14, 'Game Freak', '1989-04-26', 'Japón'),
                                                      (15, 'Infinity Ward', '2002-05-01', 'Estados Unidos'),
                                                      (16, 'Bethesda Game Studios', '2001-08-01', 'Estados Unidos'),
                                                      (17, 'Treyarch', '1996-01-01', 'Estados Unidos'),
                                                      (18, 'Insomniac Games', '1994-02-28', 'Estados Unidos'),
                                                      (19, 'Rare', '1985-01-01', 'Reino Unido'),
                                                      (20, 'id Software', '1991-02-01', 'Estados Unidos');
-- crea la tabla de videojuegos registrados
create table videojuego(
                           id int primary key auto_increment,
                           nombre varchar(50) not null,
                           genero varchar(50) not null,
                           lanzamiento date not null,
                           estudio_id int,
                           constraint fk_videojuegos_estudios
                               foreign key (estudio_id) references estudio(id)
                                   on delete cascade
                                   on update cascade
);
INSERT INTO videojuego (id, nombre, genero, lanzamiento, estudio_id) VALUES
                                                                         (1, 'The Legend of Zelda: Ocarina of Time', 'Aventura', '1998-11-21', 1),
                                                                         (2, 'Super Mario 64', 'Plataformas', '1996-06-23', 1),
                                                                         (3, 'Grand Theft Auto V', 'Acción', '2013-09-17', 2),
                                                                         (4, 'Minecraft', 'Sandbox', '2011-11-18', 4),
                                                                         (5, 'The Witcher 3: Wild Hunt', 'RPG', '2015-05-19', 3),
                                                                         (6, 'Half-Life 2', 'Disparos', '2004-11-16', 5),
                                                                         (7, 'Fortnite', 'Battle Royale', '2017-07-25', 6),
                                                                         (8, 'World of Warcraft', 'MMORPG', '2004-11-23', 7),
                                                                         (9, 'Halo: Combat Evolved', 'Disparos', '2001-11-15', 8),
                                                                         (10, 'Dark Souls', 'RPG', '2011-09-22', 9),
                                                                         (11, 'Resident Evil 4', 'Survival Horror', '2005-01-11', 10),
                                                                         (12, 'Final Fantasy VII', 'RPG', '1997-01-31', 11),
                                                                         (13, 'Sonic the Hedgehog', 'Plataformas', '1991-06-23', 12),
                                                                         (14, 'Assassin’s Creed II', 'Acción', '2009-11-17', 13),
                                                                         (15, 'Pokémon Red/Blue', 'RPG', '1996-02-27', 14),
                                                                         (16, 'Call of Duty: Modern Warfare', 'Disparos', '2007-11-05', 15),
                                                                         (17, 'The Elder Scrolls V: Skyrim', 'RPG', '2011-11-11', 16),
                                                                         (18, 'Call of Duty: Black Ops', 'Disparos', '2010-11-09', 17),
                                                                         (19, 'Spider-Man (2018)', 'Acción', '2018-09-07', 18),
                                                                         (20, 'Banjo-Kazooie', 'Plataformas', '1998-06-29', 19),
                                                                         (21, 'Doom (1993)', 'Disparos', '1993-12-10', 20),
                                                                         (22, 'Portal 2', 'Puzzle', '2011-04-19', 5),
                                                                         (23, 'Overwatch', 'Disparos', '2016-05-24', 7),
                                                                         (24, 'Bloodborne', 'RPG', '2015-03-24', 9),
                                                                         (25, 'Super Smash Bros. Ultimate', 'Peleas', '2018-12-07', 1),
                                                                         (26, 'The Legend of Zelda: Breath of the Wild', 'Aventura', '2017-03-03', 1),
                                                                         (27, 'Red Dead Redemption 2', 'Acción', '2018-10-26', 2),
                                                                         (28, 'Cyberpunk 2077', 'RPG', '2020-12-10', 3),
                                                                         (29, 'Left 4 Dead 2', 'Disparos', '2009-11-17', 5),
                                                                         (30, 'Uncharted 4: A Thief’s End', 'Aventura', '2016-05-10', 18),
                                                                         (31, 'Metroid Prime', 'Aventura', '2002-11-18', 1),
                                                                         (32, 'Persona 5', 'RPG', '2016-09-15', 11),
                                                                         (33, 'Super Mario Odyssey', 'Plataformas', '2017-10-27', 1),
                                                                         (34, 'Hollow Knight', 'Metroidvania', '2017-02-24', 4),
                                                                         (35, 'Animal Crossing: New Horizons', 'Simulación', '2020-03-20', 1),
                                                                         (36, 'Destiny 2', 'Disparos', '2017-09-06', 8),
                                                                         (37, 'Sekiro: Shadows Die Twice', 'RPG', '2019-03-22', 9),
                                                                         (38, 'Diablo II', 'RPG', '2000-06-29', 7),
                                                                         (39, 'Mega Man X', 'Plataformas', '1993-12-17', 10),
                                                                         (40, 'Chrono Trigger', 'RPG', '1995-03-11', 11),
                                                                         (41, 'Pac-Man', 'Arcade', '1980-05-22', 12),
                                                                         (42, 'Street Fighter II', 'Peleas', '1991-02-06', 10),
                                                                         (43, 'Shadow of the Colossus', 'Aventura', '2005-10-18', 9),
                                                                         (44, 'Tetris', 'Puzzle', '1984-06-06', 19),
                                                                         (45, 'League of Legends', 'MOBA', '2009-10-27', 6),
                                                                         (46, 'StarCraft', 'Estrategia', '1998-03-31', 7),
                                                                         (47, 'Gears of War', 'Disparos', '2006-11-07', 6),
                                                                         (48, 'The Last of Us', 'Aventura', '2013-06-14', 18),
                                                                         (49, 'Cuphead', 'Plataformas', '2017-09-29', 19),
                                                                         (50, 'Elden Ring', 'RPG', '2022-02-25', 9);

#####################################################################################################
-- DOMINIO DE TURISMO -------------------------------------------------------------------------------
#####################################################################################################
-- Crear la tabla informacion_ciudad
CREATE TABLE informacion_ciudad (
                                    id INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único
                                    ciudad VARCHAR(100) NOT NULL,      -- Nombre de la ciudad
                                    hora TIME NOT NULL,                -- Hora local en formato HH:MM:SS
                                    clima VARCHAR(50)                  -- Clima (por ejemplo, soleado, lluvioso)
);
-- Crear la tabla divisas
CREATE TABLE divisas (
                         id INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único
                         divisaO  VARCHAR(3) NOT NULL,      -- Código de la moneda de origen (Ej: USD)
                         divisaD VARCHAR(3) NOT NULL,                 -- Código de la moneda de destino (Ej: EUR)
                         factorEX DECIMAL(10, 4) NOT NULL             -- Factor de cambio (Ej: 1.2345)
);
INSERT INTO informacion_ciudad (ciudad, hora, clima)
VALUES
    ('Roma', '19:30:00', 'Soleado'),
    ('Bangkok', '02:45:00', 'Húmedo'),
    ('Estambul', '23:15:00', 'Despejado'),
    ('Moscú', '01:00:00', 'Nevado'),
    ('Sao Paulo', '15:00:00', 'Lluvioso'),
    ('Seúl', '09:15:00', 'Niebla'),
    ('Johannesburgo', '18:45:00', 'Tormenta'),
    ('Dubái', '22:30:00', 'Caluroso'),
    ('Singapur', '03:00:00', 'Húmedo'),
    ('Atenas', '20:20:00', 'Ventoso');
-- Insertar conversiones con el Peso Mexicano como origen y destino
INSERT INTO divisas (divisaO, divisaD, factorEX)
VALUES
    ('MXN', 'USD', 0.0578),   -- De Peso Mexicano a Dólar
    ('USD', 'MXN', 17.3000),  -- De Dólar a Peso Mexicano
    ('MXN', 'EUR', 0.0528),   -- De Peso Mexicano a Euro
    ('EUR', 'MXN', 18.9500),  -- De Euro a Peso Mexicano
    ('MXN', 'JPY', 8.5600),   -- De Peso Mexicano a Yen
    ('JPY', 'MXN', 0.1170),   -- De Yen a Peso Mexicano
    ('MXN', 'GBP', 0.0452),   -- De Peso Mexicano a Libra Esterlina
    ('GBP', 'MXN', 22.1500),  -- De Libra Esterlina a Peso Mexicano
    ('MXN', 'CAD', 0.0774),   -- De Peso Mexicano a Dólar Canadiense
    ('CAD', 'MXN', 12.9200);  -- De Dólar Canadiense a Peso Mexicano


#########################################################################################################
-- DOMINIO DE Entretenimiento -------------------------------------------------------------------------------
#########################################################################################################
CREATE TABLE Cines (
                       id_cine INT AUTO_INCREMENT PRIMARY KEY,
                       nom_cine VARCHAR(255) NOT NULL,
                       dir_cine VARCHAR(255) NOT NULL
);

CREATE TABLE Peliculas (
                           id_pelicula INT AUTO_INCREMENT PRIMARY KEY,
                           titulo_pel VARCHAR(255) NOT NULL,
                           duracion_pel INT NOT NULL,
                           clasificacion_pel VARCHAR(20) NOT NULL
);

CREATE TABLE Exhibiciones (
                              id_exh INT AUTO_INCREMENT PRIMARY KEY,
                              id_cine INT NOT NULL,
                              id_pelicula INT NOT NULL,
                              fecha DATE NOT NULL,
                              hora TIME NOT NULL,
                              FOREIGN KEY (id_cine) REFERENCES Cines(id_cine),
                              FOREIGN KEY (id_pelicula) REFERENCES Peliculas(id_pelicula)
);

INSERT INTO Cines (nom_cine, dir_cine) VALUES
                                           ('Cinepolis Perisur', 'Av. Periférico Sur 4690, Ciudad de México'),
                                           ('Cinemex Interlomas', 'Av. de los Acueductos 50, Ciudad de México'),
                                           ('Cinepolis Satélite', 'Blvd. Manuel Ávila Camacho, Ciudad de México'),
                                           ('Cinemex Reforma', 'Av. Paseo de la Reforma 42, Ciudad de México'),
                                           ('Cinepolis Insurgentes', 'Av. Insurgentes Sur 123, Ciudad de México');

INSERT INTO Peliculas (titulo_pel, duracion_pel, clasificacion_pel) VALUES
                                                                        ('Avengers: Endgame', 181, 'B'),
                                                                        ('Spider-Man: No Way Home', 148, 'B'),
                                                                        ('The Batman', 155, 'B'),
                                                                        ('Jurassic World: Dominion', 146, 'B'),
                                                                        ('Dune', 155, 'B');

INSERT INTO Exhibiciones (id_cine, id_pelicula, fecha, hora) VALUES
                                                                 (1, 1, '2024-12-07', '19:30:00'),
                                                                 (1, 2, '2024-12-07', '22:00:00'),
                                                                 (1, 3, '2024-12-07', '16:45:00'),
                                                                 (1, 4, '2024-12-07', '18:15:00'),
                                                                 (1, 5, '2024-12-07', '20:30:00'),
                                                                 (2, 1, '2024-12-07', '15:00:00'),
                                                                 (2, 2, '2024-12-07', '17:30:00'),
                                                                 (2, 3, '2024-12-07', '20:00:00'),
                                                                 (2, 4, '2024-12-07', '22:30:00'),
                                                                 (2, 5, '2024-12-07', '13:00:00'),
                                                                 (3, 1, '2024-12-07', '14:00:00'),
                                                                 (3, 2, '2024-12-07', '16:00:00'),
                                                                 (3, 3, '2024-12-07', '18:00:00'),
                                                                 (3, 4, '2024-12-07', '20:00:00'),
                                                                 (3, 5, '2024-12-07', '22:00:00'),
                                                                 (4, 1, '2024-12-07', '12:30:00'),
                                                                 (4, 2, '2024-12-07', '15:00:00'),
                                                                 (4, 3, '2024-12-07', '17:45:00'),
                                                                 (4, 4, '2024-12-07', '20:15:00'),
                                                                 (4, 5, '2024-12-07', '22:45:00'),
                                                                 (5, 1, '2024-12-07', '13:15:00'),
                                                                 (5, 2, '2024-12-07', '15:45:00'),
                                                                 (5, 3, '2024-12-07', '18:15:00'),
                                                                 (5, 4, '2024-12-07', '20:45:00'),
                                                                 (5, 5, '2024-12-07', '23:15:00');


CREATE TABLE Museos (
                        id_museo INT AUTO_INCREMENT PRIMARY KEY,
                        nombre_museo VARCHAR(255) NOT NULL,
                        direccion_museo VARCHAR(255) NOT NULL
);

CREATE TABLE Horarios (
                          horario_id INT AUTO_INCREMENT PRIMARY KEY,
                          id_museo INT NOT NULL,
                          dias_servicio VARCHAR(30) NOT NULL,
                          hora_apertura TIME NOT NULL,
                          hora_cierre TIME NOT NULL,
                          FOREIGN KEY (id_museo) REFERENCES Museos(id_museo)
);

INSERT INTO Museos (nombre_museo, direccion_museo) VALUES
                                                       ('Museo Nacional de Antropología', 'Av. Paseo de la Reforma & Calzada Gandhi s/n, Polanco, Ciudad de México'),
                                                       ('Museo Soumaya', 'Blvd. Miguel de Cervantes Saavedra 303, Granada, Ciudad de México'),
                                                       ('Museo Frida Kahlo', 'Londres 247, Del Carmen, Ciudad de México'),
                                                       ('Palacio de Bellas Artes', 'Av. Juárez, Centro Histórico, Ciudad de México'),
                                                       ('Museo del Templo Mayor', 'Seminario 8, Centro Histórico, Ciudad de México'),
                                                       ('Museo de Arte Moderno', 'Av. Paseo de la Reforma 51, Bosque de Chapultepec, Ciudad de México'),
                                                       ('Museo Tamayo', 'Av. Paseo de la Reforma 51-B, Bosque de Chapultepec, Ciudad de México'),
                                                       ('Museo de Historia Natural', 'Av. Paseo de la Reforma y Calzada Gandhi s/n, Chapultepec, Ciudad de México'),
                                                       ('Museo Dolores Olmedo', 'Av. México 5843, La Noria, Ciudad de México'),
                                                       ('Museo Universitario Arte Contemporáneo (MUAC)', 'Insurgentes Sur 3000, C.U., Ciudad de México');

INSERT INTO Horarios (id_museo, dias_servicio, hora_apertura, hora_cierre) VALUES
                                                                               (1, 'Lunes a Domingo', '09:00:00', '19:00:00'),
                                                                               (2, 'Lunes a Domingo', '10:30:00', '18:30:00'),
                                                                               (3, 'Martes a Domingo', '10:00:00', '17:45:00'),
                                                                               (4, 'Martes a Domingo', '11:00:00', '17:00:00'),
                                                                               (5, 'Martes a Domingo', '09:00:00', '17:00:00'),
                                                                               (6, 'Martes a Domingo', '10:15:00', '17:30:00'),
                                                                               (7, 'Martes a Domingo', '10:00:00', '18:00:00'),
                                                                               (8, 'Martes a Domingo', '10:00:00', '17:00:00'),
                                                                               (9, 'Miércoles a Domingo', '10:00:00', '18:00:00'),
                                                                               (10, 'Miércoles a Domingo', '10:00:00', '18:00:00');


CREATE TABLE Teatros (
                         id_teatro INT AUTO_INCREMENT PRIMARY KEY,
                         nombre_teatro VARCHAR(255) NOT NULL,
                         direccion_teatro VARCHAR(255) NOT NULL
);

CREATE TABLE Obras (
                       id_obra INT AUTO_INCREMENT PRIMARY KEY,
                       titulo_obra VARCHAR(255) NOT NULL,
                       genero_obra VARCHAR(50),  -- Ejemplo: "Comedia", "Drama", etc.
                       duracion_obra INT NOT NULL  -- Duración en minutos
);

CREATE TABLE Funciones (
                           id_funcion INT AUTO_INCREMENT PRIMARY KEY,
                           id_teatro INT NOT NULL,
                           id_obra INT NOT NULL,
                           fecha DATE NOT NULL,
                           hora TIME NOT NULL,
                           costo DECIMAL(10, 2) NOT NULL,  -- Costo de la entrada
                           FOREIGN KEY (id_teatro) REFERENCES Teatros(id_teatro),
                           FOREIGN KEY (id_obra) REFERENCES Obras(id_obra)
);

INSERT INTO Teatros (nombre_teatro, direccion_teatro) VALUES
                                                          ('Teatro Insurgentes', 'Av. Insurgentes Sur 1587, San José Insurgentes, Ciudad de México'),
                                                          ('Teatro de los Insurgentes', 'Av. Insurgentes Sur 1587, Ciudad de México'),
                                                          ('Teatro Metropolitan', 'Av. Independencia 90, Centro Histórico, Ciudad de México'),
                                                          ('Teatro Helénico', 'Av. Revolución 1500, Guadalupe Inn, Ciudad de México'),
                                                          ('Teatro de la Ciudad Esperanza Iris', 'Donceles 36, Centro Histórico, Ciudad de México'),
                                                          ('Foro Shakespeare', 'Zamora 7, Condesa, Ciudad de México');

INSERT INTO Obras (titulo_obra, genero_obra, duracion_obra) VALUES
                                                                ('El Lago de los Cisnes', 'Drama', 120),
                                                                ('La Dama de Negro', 'Terror', 100),
                                                                ('Mentiras: El Musical', 'Comedia Musical', 130),
                                                                ('Cats', 'Comedia Musical', 140),
                                                                ('La Casa de Bernarda Alba', 'Drama', 90),
                                                                ('El Rey León', 'Familiar', 160);

INSERT INTO Funciones (id_teatro, id_obra, fecha, hora, costo) VALUES
                                                                   (1, 1, '2024-12-10', '19:00:00', 450.00),
                                                                   (1, 2, '2024-12-11', '20:30:00', 500.00),
                                                                   (2, 3, '2024-12-12', '18:00:00', 600.00),
                                                                   (2, 4, '2024-12-13', '19:30:00', 650.00),
                                                                   (3, 5, '2024-12-14', '20:00:00', 700.00),
                                                                   (3, 6, '2024-12-15', '21:00:00', 750.00),
                                                                   (4, 1, '2024-12-16', '17:30:00', 480.00),
                                                                   (4, 3, '2024-12-17', '19:00:00', 520.00),
                                                                   (5, 4, '2024-12-18', '20:00:00', 550.00),
                                                                   (5, 6, '2024-12-19', '21:30:00', 600.00),
                                                                   (6, 2, '2024-12-20', '18:30:00', 500.00),
                                                                   (6, 5, '2024-12-21', '20:00:00', 450.00);
