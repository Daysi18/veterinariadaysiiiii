-- ==PostgreSQL
CREATE DATABASE veterinariadb;
CREATE USER veterinaria WITH PASSWORD 'clave123';
GRANT ALL PRIVILEGES ON DATABASE veterinariadb TO veterinaria;

-- Ejecuta los INSERT después de arrancar la aplicación y crear las tablas
INSERT INTO duenio (nombre, apellido, cedula, telefono, email) VALUES
('Ana', 'Pérez', '1711111111', '0991111111', 'ana@mail.com'),
('Luis', 'Gómez', '1722222222', '0992222222', 'luis@mail.com'),
('Carla', 'Ruiz', '1733333333', '0993333333', 'carla@mail.com'),
('Pedro', 'Salas', '1744444444', '0994444444', 'pedro@mail.com'),
('María', 'Vera', '1755555555', '0995555555', 'maria@mail.com');

INSERT INTO mascota (nombre, edad, especie, duenio) VALUES
('Firulais', 4, 'perro', 'Ana Pérez'),
('Michi', 2, 'gato', 'Luis Gómez'),
('Rocky', 6, 'perro', 'Carla Ruiz'),
('Luna', 1, 'gato', 'Pedro Salas'),
('Coco', 3, 'perro', 'María Vera');