CREATE TABLE categoria_do_cardapio (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(255) DEFAULT NULL,
  cardapio_id bigint NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cardapio_id) REFERENCES cardapio(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
