CREATE TABLE cardapio (
  id bigint NOT NULL AUTO_INCREMENT,
  restaurante_id bigint NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (restaurante_id) REFERENCES restaurante(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
