-----------------------------------------------------------------------------------------------
--DROPS
-----------------------------------------------------------------------------------------------
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