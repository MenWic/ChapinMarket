CREATE DATABASE chapin_market;
\c chapin_market

CREATE SCHEMA c_bodega;
CREATE SCHEMA c_inventario;
CREATE SCHEMA c_ventas;
CREATE SCHEMA c_personal;
CREATE SCHEMA c_sucursales;

CREATE TABLE c_ventas.tarjeta (
	tipo VARCHAR(15) NOT NULL,
	acreditacion INTEGER NOT NULL,
	PRIMARY KEY(tipo)
	);

CREATE TABLE c_ventas.cliente (
	nit VARCHAR(12) NOT NULL,
	nombre VARCHAR(60) NOT NULL,
	telefono INTEGER NOT NULL,
	fecha_nacimiento DATE,
	pts_acumulados INTEGER NOT NULL,
	PRIMARY KEY(nit)
	);

CREATE TABLE c_ventas.membresia (
	cliente VARCHAR(12) NOT NULL,
	tarjeta VARCHAR(10),
	dinero_gastado DECIMAL(5,2) NOT NULL,
	FOREIGN KEY(cliente) REFERENCES c_ventas.cliente(nit),
	FOREIGN KEY(tarjeta) REFERENCES c_ventas.tarjeta(tipo),
	PRIMARY KEY(cliente)
	);

CREATE TABLE c_sucursales.sucursal (
	nombre VARCHAR(30) NOT NULL,
	direccion VARCHAR(60) NOT NULL,
	PRIMARY KEY(nombre)
	);

CREATE TABLE c_personal.empleado (
	usuario VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	nombre VARCHAR(60) NOT NULL,
	sucursal VARCHAR(30) NOT NULL,
	rol VARCHAR(15) NOT NULL,
	estado BOOL NOT NULL,
	FOREIGN KEY(sucursal) REFERENCES c_sucursales.sucursal(nombre),
	PRIMARY KEY(usuario)
	);

CREATE TABLE c_ventas.caja (
	numero INTEGER NOT NULL,
	empleado VARCHAR(20) NOT NULL,
	FOREIGN KEY(empleado) REFERENCES c_personal.empleado(usuario),
	PRIMARY KEY(numero,empleado)
	);

CREATE TABLE c_bodega.producto (
	nombre VARCHAR(70) NOT NULL,
	precio DECIMAL(5,2) NOT NULL,
	PRIMARY KEY(nombre)
	);

CREATE TABLE c_bodega.bodega (
	sucursal VARCHAR(30) NOT NULL,
	producto VARCHAR(70) NOT NULL,
	cantidad INTEGER NOT NULL,
	FOREIGN KEY(sucursal) REFERENCES c_sucursales.sucursal(nombre),
	FOREIGN KEY(producto) REFERENCES c_bodega.producto(nombre),
	PRIMARY KEY(sucursal,producto)
	);



CREATE TABLE c_inventario.tienda (
	estante INTEGER NOT NULL,
	sucursal VARCHAR(30) NOT NULL,
	producto VARCHAR(70) NOT NULL,
	cantidad INTEGER NOT NULL,
	FOREIGN KEY(sucursal,producto) REFERENCES c_bodega.bodega(sucursal,producto),
	PRIMARY KEY(estante,sucursal,producto)
	);

CREATE TABLE c_ventas.factura (
	num_factura INTEGER NOT NULL,
	cliente VARCHAR(12),
	empleado VARCHAR(20) NOT NULL,
	sucursal VARCHAR(30) NOT NULL,
	fecha DATE NOT NULL,
	subtotal DECIMAL(5,2) NOT NULL,
	total DECIMAL(5,2) NOT NULL,
	FOREIGN KEY(cliente) REFERENCES c_ventas.cliente(nit),
	FOREIGN KEY(empleado) REFERENCES c_personal.empleado(usuario),
	FOREIGN KEY(sucursal) REFERENCES c_sucursales.sucursal(nombre),
	PRIMARY KEY(num_factura)
	);

CREATE TABLE c_ventas.detalle_factura (
	num_factura INTEGER NOT NULL,
	producto VARCHAR(70) NOT NULL,
	estante INTEGER NOT NULL,
	sucursal VARCHAR(30) NOT NULL,
	cantidad INTEGER NOT NULL,
	FOREIGN KEY(num_factura) REFERENCES c_ventas.factura(num_factura),
	FOREIGN KEY(producto,estante,sucursal) REFERENCES c_inventario.tienda(producto,estante,sucursal),
	PRIMARY KEY(num_factura,producto)
	);

CREATE ROLE admin;
CREATE ROLE caja;
CREATE ROLE inventario;
CREATE ROLE bodega;

GRANT CONNECT ON DATABASE chapin_market TO admin;
GRANT CONNECT ON DATABASE chapin_market TO caja;
GRANT CONNECT ON DATABASE chapin_market TO inventario;
GRANT CONNECT ON DATABASE chapin_market TO bodega;

GRANT USAGE ON SCHEMA c_personal,c_ventas,c_sucursales TO admin;
GRANT USAGE ON SCHEMA c_ventas TO caja;
GRANT USAGE ON SCHEMA c_inventario,c_bodega TO inventario;
GRANT USAGE ON SCHEMA c_bodega TO inventario;
GRANT USAGE ON SCHEMA c_bodega TO bodega;

GRANT SELECT,INSERT,UPDATE ON TABLE c_personal.empleado TO admin;
GRANT SELECT ON TABLE c_ventas.factura TO admin;
GRANT SELECT ON TABLE c_ventas.detalle_factura TO admin;

GRANT SELECT,INSERT,UPDATE ON TABLE c_ventas.caja TO admin;
GRANT SELECT,UPDATE ON TABLE c_ventas.tarjeta TO admin;
GRANT SELECT,INSERT,UPDATE ON TABLE c_sucursales.sucursal TO admin;

GRANT SELECT,INSERT,UPDATE ON TABLE c_ventas.cliente TO caja;
GRANT SELECT,INSERT,UPDATE ON TABLE c_ventas.membresia TO caja;
GRANT INSERT ON TABLE c_ventas.factura TO caja;
GRANT INSERT ON TABLE c_ventas.detalle_factura TO caja;

GRANT SELECT,INSERT,UPDATE,DELETE ON TABLE c_inventario.tienda TO inventario;
GRANT SELECT,UPDATE ON TABLE c_bodega.bodega TO inventario;

GRANT SELECT,INSERT,UPDATE ON TABLE c_bodega.producto TO bodega;

CREATE USER u_admin WITH PASSWORD 'admin';
GRANT admin TO u_admin;

CREATE USER u_caja WITH PASSWORD 'caja';
GRANT caja TO u_caja;

CREATE USER u_inventario WITH PASSWORD 'inventario';
GRANT inventario TO u_inventario;

CREATE USER u_bodega WITH PASSWORD 'bodega';
GRANT bodega TO u_bodega;

/* Inserciones iniciales */

/* Sucursales */
INSERT INTO c_sucursales.sucursal VALUES
('Norte','4 Avenida 1-16 zona 1, Flores, Peten'),
('Central','6 Calle 8-36 zona 2, Cantel, Quetzaltenango'),
('Sur','7 Avenida 0-22 zona 3, Palin, Escuintla');

/* Empleados */
INSERT INTO c_personal.empleado (usuario, password, nombre, sucursal, rol, estado) VALUES
('cajero1', 'cajero', 'Juan García', 'Norte', 'caja', true),
('cajero2', 'cajero', 'María Rodríguez', 'Norte', 'caja', true),
('cajero3', 'cajero', 'Federico Benitez', 'Norte', 'caja', true),
('cajero4', 'cajero', 'Ana Martinez', 'Norte', 'caja', true),
('cajero5', 'cajero', 'Pedro Gonzalez', 'Norte', 'caja', true),
('cajero6', 'cajero', 'Laura Fernandez', 'Norte', 'caja', true);
INSERT INTO c_personal.empleado VALUES
('cajero7', 'cajero', 'Sergio Perez', 'Central', 'caja', true),
('cajero8', 'cajero', 'Marta Sanchez', 'Central', 'caja', true),
('cajero9', 'cajero', 'Luis Torres', 'Central', 'caja', true),
('cajero10', 'cajero', 'Carmen Herrera', 'Central', 'caja', true),
('cajero11', 'cajero', 'Alejandro Ortiz', 'Central', 'caja', true),
('cajero12', 'cajero', 'Isabel Morales', 'Central', 'caja', true);
INSERT INTO c_personal.empleado VALUES
('cajero13', 'cajero', 'Paula Castro', 'Sur', 'caja', true),
('cajero14', 'cajero', 'Javier Ruiz', 'Sur', 'caja', true),
('cajero15', 'cajero', 'Elena Ramírez', 'Sur', 'caja', true),
('cajero16', 'cajero', 'Carlos Lopez', 'Sur', 'caja', true),
('cajero17', 'cajero', 'Alma Perez', 'Sur', 'caja', true),
('cajero18', 'cajero', 'Jose Mendez', 'Sur', 'caja', true);

INSERT INTO c_personal.empleado VALUES
('inventario1', 'inventario', 'Manuel Yoxom', 'Norte', 'inventario', true),
('inventario2', 'inventario', 'Ramiro Conde', 'Norte', 'inventario', true),
('inventario3', 'inventario', 'Janeth Castro', 'Norte', 'inventario', true),
('inventario4', 'inventario', 'Isabel Padilla', 'Norte', 'inventario', true);
INSERT INTO c_personal.empleado VALUES
('inventario5', 'inventario', 'Jorge Gómez', 'Central', 'inventario', true),
('inventario6', 'inventario', 'Marta Rivera', 'Central', 'inventario', true),
('inventario7', 'inventario', 'Pedro Rodríguez', 'Central', 'inventario', true),
('inventario8', 'inventario', 'Cristina Ogaldez', 'Central', 'inventario', true);
INSERT INTO c_personal.empleado VALUES
('inventario9', 'inventario', 'Luisa García', 'Sur', 'inventario', true),
('inventario10', 'inventario', 'Juan Urrutia', 'Sur', 'inventario', true),
('inventario11', 'inventario', 'Sofía del Hoyo', 'Sur', 'inventario', true),
('inventario12', 'inventario', 'Ronald Tipaz', 'Sur', 'inventario', true);

INSERT INTO c_personal.empleado VALUES
('bodega1', 'bodega','Raul Godinez', 'Norte', 'bodega', true);
INSERT INTO c_personal.empleado VALUES
('bodega2', 'bodega', 'Isela Pereira', 'Central', 'bodega', true);
INSERT INTO c_personal.empleado VALUES
('bodega3', 'bodega', 'Salvador Alvarado', 'Sur','bodega', true);

INSERT INTO c_personal.empleado VALUES
('admin', 'admin', 'Luis Mendez', 'Central', 'admin', true);

/* Caja */

/*/8 Clientes registrados*/
/* Clientes */

/* Producto */
/*Ciclo que crea Productos aleatorios*/

/* Bodega */

/* Tienda */

/*5 Ventas/Sucursal*/
/* Factura */

/* ListaProductos */



/*Nota: Se deben haber realizado al menos 5 ventas en cada sucursal.
Nota: Debe haber registrados al menos 8 clientes en el sistema.*/