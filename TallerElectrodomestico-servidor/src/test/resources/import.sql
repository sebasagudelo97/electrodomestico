INSERT INTO tipo_electrodomestico(id, marca, descripcion) VALUES ( 1, 'ccc', 'Licuadora');

INSERT INTO tipo_electrodomestico(id, marca, descripcion) VALUES ( 2, 'ccc', 'lavadora');

INSERT INTO tipo_electrodomestico(id, marca, descripcion) VALUES ( 3, 'ccc', 'sanduchera');

INSERT INTO tipo_electrodomestico(id, marca, descripcion) VALUES ( 4, 'fff', 'Licuadora' );

INSERT INTO tipo_electrodomestico(id, marca, descripcion) VALUES ( 5, 'fff', 'sanduchera');

INSERT INTO registro(id, cedula_cliente, estado_factura, estado_registro, fecha_ingreso, fecha_salida, nombre_cliente, telefono, valor_pagar,entidad_tipo_electrodomestico_id) VALUES(1, '1036960221', false, false, '2020-05-27', null, 'sebastian', '5321133', 0, 1)

INSERT INTO registro(id, cedula_cliente, estado_factura, estado_registro, fecha_ingreso, fecha_salida, nombre_cliente, telefono, valor_pagar,entidad_tipo_electrodomestico_id) VALUES(2, '1036960221', false, false, '2020-05-27', null, 'sebastian', '5321133', 0, 2)

INSERT INTO registro(id, cedula_cliente, estado_factura, estado_registro, fecha_ingreso, fecha_salida, nombre_cliente, telefono, valor_pagar,entidad_tipo_electrodomestico_id) VALUES(3, '1036960221', false, false, '2020-05-27', null, 'sebastian', '5321133', 0, 3)

INSERT INTO registro(id, cedula_cliente, estado_factura, estado_registro, fecha_ingreso, fecha_salida, nombre_cliente, telefono, valor_pagar,entidad_tipo_electrodomestico_id) VALUES(4, '1036960221', false, true, '2020-05-27', '2020-05-30', 'sebastian', '5321133', 1000, 1)

INSERT INTO registro(id, cedula_cliente, estado_factura, estado_registro, fecha_ingreso, fecha_salida, nombre_cliente, telefono, valor_pagar,entidad_tipo_electrodomestico_id) VALUES(5, '1036960221', false, true, '2020-05-27', '2020-05-30', 'sebastian', '5321133', 2000, 2)

INSERT INTO registro(id, cedula_cliente, estado_factura, estado_registro, fecha_ingreso, fecha_salida, nombre_cliente, telefono, valor_pagar,entidad_tipo_electrodomestico_id) VALUES(6, '1036960221', false, true, '2020-05-27', '2020-05-30', 'sebastian', '5321133', 3000, 3)

INSERT INTO factura(in_codigo, fecha_actual, valorapagar, valor_adicional, entidad_registro_id) VALUES ( 11, '2020-10-1', 5000, 100, 1);

INSERT INTO factura(in_codigo, fecha_actual, valorapagar, valor_adicional, entidad_registro_id) VALUES ( 22, '2020-10-1', 5000, 100, 2);