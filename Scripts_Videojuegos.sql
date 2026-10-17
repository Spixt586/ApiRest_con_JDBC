CREATE TABLE videojuegos(
codigo VARCHAR(10) PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
plataforma VARCHAR(50) NOT NULL,
precio NUMERIC(6,2) NOT NULL,
disponible BOOLEAN NOT NULL,
genero VARCHAR(50)
);

SELECT * FROM videojuegos;

INSERT INTO videojuegos (codigo, nombre, plataforma, precio, disponible, genero) VALUES
('MHW-ICE-01', 'Monster Hunter World: Iceborne', 'PC', 39.99, TRUE, 'ARPG'),
('MHW-WLD-02', 'Monster Hunter Wilds', 'PlayStation 5', 69.99, TRUE, 'ARPG'),
('MHW-WLD-03', 'Monster Hunter Wilds', 'PC', 69.99, TRUE, 'ARPG'),
('MHR-SUN-04', 'Monster Hunter Rise: Sunbreak', 'Nintendo Switch', 39.99, TRUE, 'ARPG'),
('ZLD-TOTK01', 'The Legend of Zelda: Tears of the Kingdom', 'Nintendo Switch', 69.99, TRUE, 'Aventura'),
('GTA-V-COL1', 'Grand Theft Auto V (Collector''s Edition)', 'PlayStation 5', 149.99, FALSE, 'Acción / Mundo Abierto'),
('ELD-RING01', 'Elden Ring', 'PC', 59.99, TRUE, 'Soulslike'),
('CPK-207701', 'Cyberpunk 2077: Ultimate Edition', 'Xbox Series X', 59.99, TRUE, 'RPG'),
('HOLL-KN-01', 'Hollow Knight', 'PC', 14.99, TRUE, 'Metroidvania'),
('BALD-3-001', 'Baldur''s Gate 3', 'PC', 59.99, TRUE, 'RPG / Estrategia'),
('GOD-RAG-01', 'God of War Ragnarök', 'PlayStation 5', 69.99, TRUE, 'Acción / Aventura'),
('RED-DEAD02', 'Red Dead Redemption 2', 'Xbox One', 59.99, TRUE, 'Mundo Abierto'),
('STAD-VAL01', 'Stardew Valley', 'Nintendo Switch', 14.99, TRUE, 'Simulación'),
('RES-EV4-R', 'Resident Evil 4 Remake', 'PlayStation 5', 39.99, TRUE, 'Survival Horror'),
('SIL-HILL2', 'Silent Hill 2 Remake', 'PC', 69.99, TRUE, 'Survival Horror');