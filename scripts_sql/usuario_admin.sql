INSERT INTO javaleros.usuario (apellido, contrasenia, dni, email, nombre, nombre_usuario)
VALUES ('user', 'Test1234.', 12345, 'user@user.com', 'user', 'testuser');

INSERT INTO javaleros.rol (id, nombre)
VALUES (1, 'ADMIN');

INSERT INTO javaleros.usuario_roles (usuario_id, roles_id)
VALUES (1, 1);

