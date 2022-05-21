
DROP TABLE "USUARIO"
CREATE TABLE "USUARIO"
(    
   "ID_USUARIO" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),   
   "NOME" VARCHAR(100),     
   "USERNAME" VARCHAR(20),
   "SENHA" VARCHAR(100),
   "ULT_ACESSO" DATE,
   "DATA_NASC" DATE,  
   "ENDERECO" VARCHAR(250)  
);

INSERT INTO USUARIO (NOME, USERNAME, SENHA, ULT_ACESSO, DATA_NASC, ENDERECO) 
	VALUES ('Thais', 'thaisb', '1111', '2022-05-21', '1995-04-26', 'Rua A,33')
               ,('Ana', 'Anab', '2222', '2022-05-21', '1995-04-27', 'Rua B,33')
               ,('João', 'JoaoP', '3333', '2022-05-21', '1995-04-26', 'Rua C,33')
               ,('Luiz', 'luizz', '4444', '2022-05-21', '1995-04-29', 'Rua D,33')

-----------------------------------------------------------------------------------------------
DROP TABLE "CLIENTE"
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

INSERT INTO CLIENTE (ID_USUARIO, REST_ALIMENTAR, QTD_PED_FIDELIDADE) 
	VALUES (1, 3, 5) ,(2, 1, 1)

-----------------------------------------------------------------------------------------------
DROP TABLE "FUNCIONARIO"
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

INSERT INTO FUNCIONARIO VALUES (4, '2021-05-21')

-----------------------------------------------------------------------------------------------
DROP TABLE "GERENTE"
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

INSERT INTO GERENTE VALUES (5)