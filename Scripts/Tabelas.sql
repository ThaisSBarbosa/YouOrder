-----------------------------------------------------------------------------------------------
--DROPS
-----------------------------------------------------------------------------------------------
DROP TABLE "TIPO_AJUDA";
DROP TABLE "MESA";
DROP TABLE "ITEM_RESTRICAO";
DROP TABLE "ITENS_PEDIDO"; --Devido a mudança de nome da tabela, mantido para deletar a com nome antigo
DROP TABLE "ITEM_PEDIDO";
DROP TABLE "ITEM";
DROP TABLE "PEDIDO";

DROP TABLE "CLIENTE";
DROP TABLE "FUNCIONARIO";
DROP TABLE "GERENTE";
DROP TABLE "USUARIO";
-----------------------------------------------------------------------------------------------
--CREATES
-----------------------------------------------------------------------------------------------
CREATE TABLE "USUARIO"
(    
   "ID_USUARIO" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),   
   "NOME" VARCHAR(100),     
   "USERNAME" VARCHAR(20),
   "SENHA" VARCHAR(100),
   "PERGUNTA_REC" VARCHAR(100),
   "RESPOSTA_REC" VARCHAR(100),
   "ULT_ACESSO" DATE,
   "DATA_NASC" DATE,  
   "ENDERECO" VARCHAR(250)  
);

CREATE TABLE "CLIENTE"
(    
   "ID_CLIENTE" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
   "ID_USUARIO" INT,
   "REST_ALIMENTAR" INT,     
   "QTD_PED_FIDELIDADE" INT,

    FOREIGN KEY (ID_USUARIO)
        REFERENCES USUARIO(ID_USUARIO)
        ON DELETE CASCADE
);

CREATE TABLE "FUNCIONARIO"
(    
   "ID_FUNCIONARIO" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
   "ID_USUARIO" INT,
   "DATA_CONTRATACAO" DATE,  

    FOREIGN KEY (ID_USUARIO)
        REFERENCES USUARIO(ID_USUARIO)
        ON DELETE CASCADE
);

CREATE TABLE "GERENTE"
(    
   "ID_GERENTE" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
   "ID_USUARIO" INT,

    FOREIGN KEY (ID_USUARIO)
        REFERENCES USUARIO(ID_USUARIO)
        ON DELETE CASCADE
);

CREATE TABLE "ITEM"
(    
   "ID_ITEM" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
   "TIPO_ITEM" INT,
   "PRECO" DOUBLE,
   "DESCRICAO" VARCHAR(100),
   "ATIVO_CARDAPIO" CHAR,
   "TEMPO_ESTIMADO" DOUBLE
);

CREATE TABLE "ITEM_RESTRICAO"
(    
   "ID_ITEM_RESTRICAO" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
   "ID_ITEM" INT,
   "RESTRICAO" INT,

    FOREIGN KEY (ID_ITEM)
        REFERENCES ITEM(ID_ITEM)
        ON DELETE CASCADE
);

CREATE TABLE "PEDIDO"
(    
   "ID_PEDIDO" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
   "ID_CLIENTE" INT,
   "INICIO" TIMESTAMP,
   "FIM" TIMESTAMP,
   "NUM_MESA" INT,
   "STATUS" INT,
   "VALOR" DECIMAL,

    FOREIGN KEY (ID_CLIENTE)
        REFERENCES CLIENTE(ID_CLIENTE)
        ON DELETE CASCADE
);

CREATE TABLE "ITEM_PEDIDO"
(    
   "ID_ITEM_PEDIDO" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
   "ID_PEDIDO" INT,
   "ID_ITEM" INT,
   "QTD_ITEM" INT,
   "OBSERVACAO" VARCHAR(200),

    FOREIGN KEY (ID_PEDIDO)
        REFERENCES PEDIDO(ID_PEDIDO)
        ON DELETE CASCADE,

    FOREIGN KEY (ID_ITEM)
        REFERENCES ITEM(ID_ITEM)
        ON DELETE CASCADE
);

CREATE TABLE "MESA"
(    
   "ID_MESA" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),   
   "STATUS" VARCHAR(10)    
);

CREATE TABLE "TIPO_AJUDA"
(    
   "ID_AJUDA" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),   
   "DESC_AJUDA" VARCHAR(200)    
);

-----------------------------------------------------------------------------------------------
--INSERTS
-----------------------------------------------------------------------------------------------
INSERT INTO USUARIO (NOME, USERNAME, SENHA, PERGUNTA_REC, RESPOSTA_REC, ULT_ACESSO, DATA_NASC, ENDERECO) 
	VALUES ('Thais', 'thaisb', '1111', 'Qual o nome do seu gato?', 'Kovu', '2022-05-21', '1995-04-26', 'Rua A,33')
               ,('Ana', 'Anab', '2222', 'Qual o nome da sua primeira professora?','Cida','2022-05-21', '1995-04-27', 'Rua B,33')
               ,('João', 'JoaoP', '3333', 'Qual o nome do seu melhor amigo(a)?','Jean', '2022-05-21', '1995-04-26', 'Rua C,33')
               ,('Luiz', 'luizz', '4444', 'Qual o seu jogo favorito?','Skyrim', '2022-05-21', '1995-04-29', 'Rua D,33');

INSERT INTO CLIENTE (ID_USUARIO, REST_ALIMENTAR, QTD_PED_FIDELIDADE) 
	VALUES (1, 3, 5) ,(2, 1, 1);

INSERT INTO FUNCIONARIO (ID_USUARIO, DATA_CONTRATACAO) VALUES (3, '2021-05-21');

INSERT INTO GERENTE (ID_USUARIO) VALUES (4);

INSERT INTO ITEM (TIPO_ITEM, PRECO, DESCRICAO, ATIVO_CARDAPIO, TEMPO_ESTIMADO)
    VALUES 
            --PRATO PRINCIPAL
            (1, 41.90, 'Baião de dois', 'S', 30)
           ,(1, 37.90, 'Tilápia Grelhada', 'S', 30)
           ,(1, 41.90, 'Feijão Tropeiro', 'S', 30)
           ,(1, 34.90, 'Galinhada', 'S', 30)
           ,(1, 43.90, 'Feijoada', 'S', 30)
           ,(1, 40.90, 'Arroz Carreteiro', 'S', 30)
           ,(1, 33.90, 'Escondidinho de Frango', 'S', 30)
           ,(1, 43.90, 'Escondidinho de Carne Seca', 'S', 30)
           ,(1, 31.90, 'Parmegiana de Berinjela', 'S', 30)
           ,(1, 35.90, 'Parmegiana de Frango', 'S', 30)
           ,(1, 32.90, 'Bowl Salada de Tofu', 'S', 30)
           ,(1, 38.90, 'Moqueca Vegana de Couve Flor', 'S', 30)
           ,(1, 38.90, 'Strogonoff Vegano', 'S', 30)
            --APERITIVOS
           ,(0, 49.90, 'Porção de Calabresa com Fritas', 'S', 30)
           ,(0, 49.90, 'Porção de Calabresa com Mandioca Frita', 'S', 30)
           ,(0, 30.00, 'Porção de Batata Frita', 'S', 30)
           ,(0, 30.00, 'Porção de Batata Frita com Mandioca Frita', 'S', 30)
           ,(0, 30.00, 'Porção de Polenta Frita', 'S', 30)
           ,(0, 60.00, 'Porção de Contrafilé com Fritas', 'S', 30)
            --SOBREMESAS
           ,(3, 9.00, 'Brigadeirão', 'S', 30)
           ,(3, 8.00, 'Mousse de Limão', 'S', 30)
           ,(3, 8.00, 'Mousse de Maracujá', 'S', 30)
           ,(3, 9.00, 'Pudim', 'S', 30)
           ,(3, 15.00, 'Salada de Frutas', 'S', 30)
           ,(3, 10.00, 'Brigadeiro de Colher com Paçoca', 'S', 30)
           ,(3, 10.00, 'Pavê Vegano', 'S', 30)
           --BEBIDAS
           ,(2, 10.90, 'Suco de Laranja 500ml', 'S', 30)
           ,(2, 10.90, 'Suco de Laranja 300ml', 'S', 30)
           ,(2, 7.90, 'Coca-Cola lata', 'S', 30)
           ,(2, 7.90, 'Sprite', 'S', 30)
           ,(2, 7.90, 'Fanta Laranja', 'S', 30)
           ,(2, 7.90, 'Fanta Uva', 'S', 30)
           ,(2, 7.90, 'Del Valle Maracujá', 'S', 30)
           ,(2, 4.90, 'Água sem Gás 500ml', 'S', 30)
           ,(2, 4.90, 'Água com Gás 500ml', 'S', 30);

INSERT INTO MESA (STATUS) VALUES ('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('MANUTENÇÃO')
		,('ATIVA')
		,('ATIVA')
		,('MANUTENÇÃO')
		,('MANUTENÇÃO')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('MANUTENÇÃO')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('MANUTENÇÃO')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA')
		,('MANUTENÇÃO')
		,('ATIVA')
		,('ATIVA')
		,('ATIVA');

INSERT INTO TIPO_AJUDA (DESC_AJUDA) VALUES ('O meu pedido está atrasado!')
                ,('Quero adicionar uma observação ao meu pedido!')
                ,('Quero falar com um atendente!')
                ,('Não estou conseguindo criar um cadastro!')
                ,('Não estou conseguindo fazer um pedido!')
                ,('Não me lembro da minha senha!')
                ,('Quero dar uma gorjeta para os desenvolvedores desse software perfeito!');

