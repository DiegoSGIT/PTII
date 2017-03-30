use RFIDSystemDB;

insert into AREAS (NOMBRE)
			values ('Infantil'),
				   ('Agua'),
                   ('Juegos mecanicos'),
                   ('Shows'),
                   ('Recreativos');
                   
insert into EMPLEADOS (NOMBRE,APELLIDO,PASSWORD,GERENTE)
				values('Benito','Lopez','1234qwer',false),
					  ('Roberto','Perez','1234qwer',false),
                      ('Laura','Cruz','1234qwer',false),
                      ('Diana','Palomino','1234qwer',true);
insert into GRUPOS (NOMBRE)
			values ('Familia Huerta'),
				   ('Los amigos'),
                   ('Brothers');
insert into VISITANTES (TAG_VISITANTE,NOMBRE,APELLIDO,CORREO,SALDO,NIP,GRUPO_IDGRUPO,AREA_IDAREA,EMPLEADO_IDEMPLEADO)
				values (1,'Diego','Sanchez','diego@mail.com',500.0,AES_ENCRYPT('1234', 'UPIITA'),1,4,1),
					   (3454,'Marcos','Estrada','mEstrada@mail.com',500.0,AES_ENCRYPT('1234', 'UPIITA'),1,4,1),
					   (678,'Miriam','Lopez','miriam@mail.com',500.0,AES_ENCRYPT('1234', 'UPIITA'),3,1,1),
                       (2,'Gabriel','Gimenez','Ggimenez@mail.com',500.0,AES_ENCRYPT('1234', 'UPIITA'),2,3,2),
                       (96,'Susana','Perez','susanaP@mail.com',500.0,AES_ENCRYPT('1234', 'UPIITA'),2,1,3),
                       (237,'Oscar','Ortega','ortegaO@mail.com',500.0,AES_ENCRYPT('1234', 'UPIITA'),1,3,3),
                       (58,'Fabian','Almanza','aFabian@mail.com',500.0,AES_ENCRYPT('1234', 'UPIITA'),3,5,2),
                       (93,'Edgar','Solis','SEdgar@mail.com',500.0,AES_ENCRYPT('1234', 'UPIITA'),1,3,1);
                       
insert into ESTABLECIMIENTOS (NOMBRE) values ('Fuente de sodas'),('Souvenirs'),('Cafeteria'),('Pizzeria'),('Tacos');

insert into VENDEDORES (NOMBRE,APELLIDO,PASSWORD,ESTABLECIMIENTO_IDESTABLECIMIENTO)
				values ('Jorge','Pena','1234',1),
					   ('Adrian','Guzman','1234',2),
                       ('Luis','Avat','1234',3),
                       ('Aaron','Aguilera','1234',4),
                       ('Monica','Ruiz','1234',5);
                       
insert into ARTICULOS (DESCRIPCION,COSTO)
			   values ('Gorra Batman', 199),
					  ('Pizza Grande', 249),
                      ('Cafe amaericano', 40),
                      ('Sudaderas heroes', 550),
                      ('Orden tacos', 120),
                      ('Jugos tropicales', 35),
                      ('Pizza mediana', 199),
                      ('Llavero heroes', 55),
                      ('Vaso de Fruta', 55),
                      ('Parrillada familiar', 399),
                      ('Desayuno cafe', 99);
               
