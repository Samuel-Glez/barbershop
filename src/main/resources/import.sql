INSERT INTO rol	(rol, descripcion) VALUES ('admin', 'persona que tiene permisos totales');
INSERT INTO rol	(rol, descripcion) VALUES ('cliente', 'persona que tiene permisos limitados');
INSERT INTO rol	(rol, descripcion) VALUES ('peluquero', 'persona que tiene permisos parciales');
INSERT INTO usuarios (nombre, apellidos, email, telefono, password, fkidrol) VALUES('David', 'González', 'david@gmail.com', '637112233', 'david', '1');
INSERT INTO usuarios (nombre, apellidos, email, telefono, password, fkidrol) VALUES('Miguel Alfredo', 'Armas Chávez', 'miguelarmas@gmail.com', '637112244', 'miguelarmas', '2');
INSERT INTO usuarios (nombre, apellidos, email, telefono, password, fkidrol) VALUES('Nicolás', 'Darmanin Casariego', 'nicolasdarmanin@gmail.com', '637223344', 'nicolas', '2');
INSERT INTO usuarios (nombre, apellidos, email, telefono, password, fkidrol) VALUES('Rafael Eduardo', 'Delgado Rocca', 'rafaeldelgado@gmail.com', '637334455', 'rafael', '2');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('Difuminar laterales', '8.0', '15');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('Barba', '5.0', '15');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('Corte de niño', '8.0', '30');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('Corte difuminado ', '9.0', '30');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('Corte clasico', '8.0', '30');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('Corte + barba', '11.0', '30');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('Corte + cejas', '11.0', '30');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('Corte + barba + cejas', '13.0', '45');
INSERT INTO servicio (servicio, precio, tiempo) VALUES ('Decoloración', '30.0', '45');
INSERT INTO review (estrellas, opiniones, fkidusuario) VALUES ('5', 'recomendable, gran profecional', '2');
INSERT INTO review (estrellas, opiniones, fkidusuario) VALUES ('3', 'nada profecional', '1');
INSERT INTO review (estrellas, opiniones, fkidusuario) VALUES ('5', 'muy amable, gran profecional', '3');


