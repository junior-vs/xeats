CREATE TABLE forma_de_pagamento (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(100) NOT NULL,
  tipo varchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
