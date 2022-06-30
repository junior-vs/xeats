CREATE TABLE avaliacao (
  id bigint NOT NULL AUTO_INCREMENT,
  comentario varchar(255) DEFAULT NULL,
  nota int NOT NULL,
  pedido_id bigint NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pedido_id) REFERENCES pedido(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
