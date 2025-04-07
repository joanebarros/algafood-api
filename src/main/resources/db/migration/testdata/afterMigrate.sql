-- Desabilitar restrições de chave estrangeira temporariamente
DO $$
BEGIN
    EXECUTE 'ALTER TABLE cidade DROP CONSTRAINT IF EXISTS cidade_estado_id_fkey CASCADE';
    EXECUTE 'ALTER TABLE restaurante DROP CONSTRAINT IF EXISTS restaurante_cozinha_id_fkey CASCADE';
    EXECUTE 'ALTER TABLE restaurante DROP CONSTRAINT IF EXISTS restaurante_endereco_cidade_id_fkey CASCADE';
    EXECUTE 'ALTER TABLE restaurante_forma_pagamento DROP CONSTRAINT IF EXISTS restaurante_forma_pagamento_restaurante_id_fkey CASCADE';
    EXECUTE 'ALTER TABLE restaurante_forma_pagamento DROP CONSTRAINT IF EXISTS restaurante_forma_pagamento_forma_pagamento_id_fkey CASCADE';
    EXECUTE 'ALTER TABLE grupo_permissao DROP CONSTRAINT IF EXISTS grupo_permissao_grupo_id_fkey CASCADE';
    EXECUTE 'ALTER TABLE grupo_permissao DROP CONSTRAINT IF EXISTS grupo_permissao_permissao_id_fkey CASCADE';
    EXECUTE 'ALTER TABLE usuario_grupo DROP CONSTRAINT IF EXISTS usuario_grupo_usuario_id_fkey CASCADE';
    EXECUTE 'ALTER TABLE usuario_grupo DROP CONSTRAINT IF EXISTS usuario_grupo_grupo_id_fkey CASCADE';
END $$;

-- Deletar dados
TRUNCATE TABLE
    cidade,
    cozinha,
    estado,
    forma_pagamento,
    grupo,
    grupo_permissao,
    permissao,
    produto,
    restaurante,
    restaurante_forma_pagamento,
    usuario,
    usuario_grupo
RESTART IDENTITY CASCADE;

-- Inserts
INSERT INTO cozinha (id, nome) VALUES
(1, 'Tailandesa'),
(2, 'Indiana'),
(3, 'Argentina'),
(4, 'Brasileira');

INSERT INTO estado (id, nome) VALUES
(1, 'Minas Gerais'),
(2, 'São Paulo'),
(3, 'Ceará');

INSERT INTO cidade (id, nome, estado_id) VALUES
(1, 'Uberlândia', 1),
(2, 'Belo Horizonte', 1),
(3, 'São Paulo', 2),
(4, 'Campinas', 2),
(5, 'Fortaleza', 3);

INSERT INTO restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) VALUES
(1, 'Thai Gourmet', 10, 1, now(), now(), 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');

INSERT INTO restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) VALUES
(2, 'Thai Delivery', 9.50, 1, now(), now()),
(3, 'Tuk Tuk Comida Indiana', 15, 2, now(), now()),
(4, 'Java Steakhouse', 12, 3, now(), now()),
(5, 'Lanchonete do Tio Sam', 11, 4, now(), now()),
(6, 'Bar da Maria', 6, 4, now(), now());

INSERT INTO forma_pagamento (id, descricao) VALUES
(1, 'Cartão de crédito'),
(2, 'Cartão de débito'),
(3, 'Dinheiro');

INSERT INTO permissao (id, nome, descricao) VALUES
(1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas'),
(2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES
(1, 1), (1, 2), (1, 3),
(2, 3),
(3, 2), (3, 3),
(4, 1), (4, 2),
(5, 1), (5, 2),
(6, 3);

INSERT INTO produto (nome, descricao, preco, ativo, restaurante_id) VALUES
('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, TRUE, 1),
('Camarão tailandês', '16 camarões grandes ao molho picante', 110, TRUE, 1),
('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, TRUE, 2),
('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, TRUE, 3),
('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, TRUE, 3),
('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, TRUE, 4),
('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, TRUE, 4),
('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, TRUE, 5),
('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, TRUE, 6);