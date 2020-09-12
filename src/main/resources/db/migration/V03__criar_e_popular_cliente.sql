CREATE TABLE cliente (
    codigo INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
    nome_completo VARCHAR (100) NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    data_nasc DATE NOT NULL,
    idade INTEGER,
    cidade_codigo INTEGER NOT NULL
);

ALTER TABLE cliente
        ADD CONSTRAINT cliente_fk_1
    FOREIGN KEY (cidade_codigo)
 REFERENCES cidade(codigo)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;

INSERT INTO cliente (nome_completo, sexo, data_nasc, idade, cidade_codigo) VALUES('Alcione', 'F', '1973-10-19', 47, 6);
INSERT INTO cliente (nome_completo, sexo, data_nasc, idade, cidade_codigo) VALUES('Tom Jobim', 'M', '1950-10-10', 69, 38);
INSERT INTO cliente (nome_completo, sexo, data_nasc, idade, cidade_codigo) VALUES('Cássia Eller', 'F', '1967-08-29', 53, 19);
INSERT INTO cliente (nome_completo, sexo, data_nasc, idade, cidade_codigo) VALUES('Paula Toller', 'F', '1970-05-03', 49, 100);
INSERT INTO cliente (nome_completo, sexo, data_nasc, idade, cidade_codigo) VALUES('Fábio Júnior', 'M', '1984-12-13', 35, 170);
INSERT INTO cliente (nome_completo, sexo, data_nasc, idade, cidade_codigo) VALUES('Bel Marques', 'M', '1973-10-19', 47, 67);
INSERT INTO cliente (nome_completo, sexo, data_nasc, idade, cidade_codigo) VALUES('Zezé di Camargo e Luciano', 'M', '1973-10-19', 47, 90);
INSERT INTO cliente (nome_completo, sexo, data_nasc, idade, cidade_codigo) VALUES('Xitãozinho e Xororó', 'M', '1960-09-03', 60, 81);
INSERT INTO cliente (nome_completo, sexo, data_nasc, idade, cidade_codigo) VALUES('Roberto Carlos', 'M', '1943-06-03', 77, 73);
INSERT INTO cliente (nome_completo, sexo, data_nasc, idade, cidade_codigo) VALUES('Marília Mendonça', 'F', '1990-01-13', 47, 22);
