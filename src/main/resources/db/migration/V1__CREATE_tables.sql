CREATE TABLE tbl_clientes (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(200),
	email VARCHAR(150),
	telefone VARCHAR(30)
) WITH (
	OIDS=FALSE
);
CREATE TABLE tbl_servicos (
	id SERIAL PRIMARY KEY,
	clienteid INTEGER,
	tecnicoid INTEGER,
	tipo VARCHAR(30),
	status VARCHAR(30),
	prioridade VARCHAR(30),
	valor DOUBLE PRECISION,
	descricao VARCHAR(200)
) WITH (
	OIDS=FALSE
);

CREATE TABLE tbl_tecnicos (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(150),
	email VARCHAR(150),
	telefone VARCHAR(30),
	numatendimentos INTEGER
) WITH (
	OIDS=FALSE
);