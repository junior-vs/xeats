CREATE TABLE pedido (
  id bigint NOT NULL AUTO_INCREMENT,
  data_hora datetime NOT NULL,
  status varchar(255) NOT NULL,
  restaurante_id bigint NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (restaurante_id) REFERENCES restaurante(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
