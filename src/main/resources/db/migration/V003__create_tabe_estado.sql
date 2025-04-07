CREATE SEQUENCE estado_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE estado (
  id BIGSERIAL PRIMARY KEY,
  nome VARCHAR(80) NOT NULL
);

INSERT INTO estado (nome) SELECT DISTINCT nome_estado FROM cidade;

ALTER TABLE cidade ADD COLUMN estado_id BIGINT;

UPDATE cidade SET estado_id = e.id FROM estado e WHERE cidade.nome_estado = e.nome;

ALTER TABLE cidade ADD CONSTRAINT fk_cidade_estado
FOREIGN KEY (estado_id) REFERENCES estado (id) ON DELETE CASCADE;

ALTER TABLE cidade DROP COLUMN nome_estado;

ALTER TABLE cidade RENAME COLUMN nome_cidade TO nome;
ALTER TABLE cidade ALTER COLUMN nome SET DATA TYPE VARCHAR(80);
ALTER TABLE cidade ALTER COLUMN nome SET NOT NULL;