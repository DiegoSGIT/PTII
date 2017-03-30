use RFIDSystemDB;
call getLocations(58);

UPDATE VISITANTES SET SALDO = 1000 WHERE TAG_VISITANTE=1;
INSERT INTO COMPRAS (MONTO,VISITANTE_IDVISITANTE,VENDEDOR_IDVENDEDOR)VALUE(700,1,2);

SELECT max(IDCOMPRA) from COMPRAS where VISITANTE_IDVISITANTE = 1;
INSERT INTO COMPRA_ARTICULOS (ARTICULO_IDARTICULO,COMPRA_IDCOMPRA)VALUE(1,1);
                
select *from GRUPOS;
select *from AREAS;
select *from EMPLEADOS;
select *from ESTABLECIMIENTOS;
select *from VISITANTES;
select *from VENDEDORES;
select *from ARTICULOS;

select *from VISITANTES;

select *from COMPRAS;
select *from COMPRA_ARTICULOS;
select *from ARTICULOS;
INSERT INTO COMPRAS (MONTO,VISITANTE_IDVISITANTE,VENDEDOR_IDVENDEDOR)VALUE(200,1,1);
UPDATE EMPLEADOS SET NOMBRE='GERONIMO', APELLIDO = 'VARGAS', PASSWORD='QWERTY', GERENTE = TRUE WHERE IDEMPLEADO=4;
select DESCRIPCION, count(*) as CANTIDAD FROM (ARTICULOS AS A JOIN COMPRA_ARTICULOS AS C ON A.SKU = C.ARTICULO_IDARTICULO) where C.COMPRA_IDCOMPRA = 1 group by DESCRIPCION; 				
-- Obetner las localizaciones.
-- http://localhost:8080/RFIDSystem/rest/Locations/get?id=58
-- Actualizar ubicacion.
-- http://localhost:8080/RFIDSystem/rest/Locations/set?idvis=1&idarea=3

-- Pagos
-- http://localhost:8080/RFIDSystem/rest/Payment/Validate
-- {
--  "id": 93,
--  "costo": 200,
--  "nip": 1234,
--  "vendedorId": 1,
--  "compras": {
--    "articlesId": [
--      {
--        "articleID": 1,
--        "cantidad": 5
--      },
--      {
--        "articleID": 2,
--        "cantidad": 4
--      },
--      {
--        "articleID": 3,
--        "cantidad": 2
--      }
--    ]
--  }
-- }

-- Insertar Visitante.
-- http://localhost:8080/RFIDSystem/rest/Visitantes/insert
-- {
--  "visitantes": {
--    "tag": 7,
-- "nombre": "Danahe",
--    "apellido": "Percastegui",
--    "correo": "dana@mail.com",
--    "saldo": 1000,
--    "nip": "1234",
--    "idArea": 1,
--    "idGrupo": 1,
--    "idEmpleado": 1
--  }
-- }
-- Deletete Visitantes
-- http://localhost:8080/RFIDSystem/rest/Visitantes/delete?id=7

-- Insert Empleados
-- http://localhost:8080/RFIDSystem/rest/Empleados/insert
-- {
--   "empleados": {
--     "nombre": "Danahe",
--     "apellido": "Percastegui",
--     "password": "1234",
--     "gerente": 0
--   }
-- }

-- Insert Vendedores
-- http://localhost:8080/RFIDSystem/rest/Vendedores/insert
-- {
--  "vendedores": {
--    "nombre": "Danahe",
--    "apellido": "Percastegui",
--    "password": "1234",
--    "idEstablecimiento": 1
--  }
-- }

-- Insert grupos
-- http://localhost:8080/RFIDSystem/rest/Grupos/insert?nombre=MIKES 

-- Insert Areas
-- http://localhost:8080/RFIDSystem/rest/Areas/insert?nombre=Escuela

-- Insert Establecimientos
-- http://localhost:8080/RFIDSystem/rest/Establecimientos/insert?nombre=Jugueteria

-- Update Visitantes
-- http://localhost:8080/RFIDSystem/rest/Visitantes/update
-- {
--  "visitantes": {
--    "tag": 1,
-- "nombre": "Danahe",
--    "apellido": "Percastegui",
--    "correo": "dana@mail.com",
--    "saldo": 1000,
--    "nip": "1234",
--    "idArea": 1,
--    "idGrupo": 1,
--    "idEmpleado": 1
--  }
-- }

-- Update Vendedores
-- http://localhost:8080/RFIDSystem/rest/Vendedores/update
-- {
-- "vendedores": {
-- 	"idVendedor":1,
--   "nombre": "Danahe",
--   "apellido": "Percastegui",
--   "password": "1234",
--   "idEstablecimiento": 2 	
--  }
-- }
-- Update Empleados
-- http://localhost:8080/RFIDSystem/rest/Empleados/update
-- {
--  "empleados": {
--  	"idEmpleado":1,
--    "nombre": "Fabritzio",
--  "apellido": "Sanchez",
--  "password": "576",
--   "gerente": 0
--   }
-- }

-- Obtener el historial de compras.
-- http://localhost:8080/RFIDSystem/rest/Compras/getAll
-- Respuesta.-
-- {
--  "historialCompras": [
--    {
--      "id": 1,
--      "monto": 200,
--      "visitante": 93,
--      "vendedor": 1,
--      "articulos": {
--        "articulos": [
--          {
--            "descripcion": "Cafe amaericano",
--            "cantidad": 2
--          },
--          {
--            "descripcion": "Gorra Batman",
--            "cantidad": 5
--          },
--          {
--            "descripcion": "Pizza Grande",
--            "cantidad": 4
--          }
--        ]
--      }
--    },
--   {
--      "id": 2,
--      "monto": 200,
--      "visitante": 1,
--      "vendedor": 1,
--      "articulos": {
--        "articulos": [
--          {
--            "descripcion": "Cafe amaericano",
--            "cantidad": 2
--          },
--          {
--            "descripcion": "Pizza Grande",
--            "cantidad": 1
--          },
--          {
--            "descripcion": "Sudaderas heroes",
--            "cantidad": 1
--          }
--        ]
--      }
--    }
--  ]
-- }
