INSERT INTO rol	(rol, descripcion) VALUES ('admin', 'persona que tiene permisos totales');
INSERT INTO rol	(rol, descripcion) VALUES ('cliente', 'persona que tiene permisos limitados');
INSERT INTO rol	(rol, descripcion) VALUES ('peluquero', 'persona que tiene permisos parciales');
INSERT INTO usuarios (nombre, apellidos, email, telefono, password, fkidrol) VALUES('Miguel Alfredo', 'Armas Chávez', 'miguelarmas@gmail.com', '637112233', 'miguelarmas', '1');
INSERT INTO usuarios (nombre, apellidos, email, telefono, password, fkidrol) VALUES('Nicolás', 'Darmanin Casariego', 'nicolasdarmanin@gmail.com', '637223344', 'nicolasdarmanin', '2');
INSERT INTO usuarios (nombre, apellidos, email, telefono, password, fkidrol) VALUES('Rafael Eduardo', 'Delgado Rocca', 'rafaeldelgaado@gmail.com', '637334455', 'rafaeldelgado', '2');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('corte de pelo', '9.0', '30');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('corte de pelo + barba', '12.0', '30');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('barba', '5.0', '15');
INSERT INTO reserva (fecha, duracion, fkidusuario, fkidservicio,fkidpeluquero, hora) VALUES ('2022-03-15', '30', '1', '1', '1', '12:00');
INSERT INTO reserva (fecha, duracion, fkidusuario, fkidservicio,fkidpeluquero, hora) VALUES ('2022-03-15', '30', '2', '2', '1', '12:30');
INSERT INTO reserva (fecha, duracion, fkidusuario, fkidservicio,fkidpeluquero, hora) VALUES ('2022-03-21', '15', '3', '3', '1', '8:00');
INSERT INTO review (estrellas, opiniones, fkidusuario) VALUES ('5', 'recomendable, gran profecional', '2');
INSERT INTO review (estrellas, opiniones, fkidusuario) VALUES ('3', 'nada profecional', '1');
INSERT INTO review (estrellas, opiniones, fkidusuario) VALUES ('5', 'muy amable, gran profecional', '3');


