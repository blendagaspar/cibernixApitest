CREATE TABLE endereco(
	id serial PRIMARY KEY,
	rua varchar(255),
	numero integer,
	complemento varchar(255),
	bairro varchar(255),
	usuario_id integer,
    CONSTRAINT fk_endereco_usuario FOREIGN KEY(usuario_id) REFERENCES usuario_id