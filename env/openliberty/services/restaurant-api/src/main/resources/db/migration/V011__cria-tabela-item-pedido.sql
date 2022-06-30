CREATE TABLE item_do_pedido (
  id bigint NOT NULL AUTO_INCREMENT,
  observacao varchar(255) DEFAULT NULL,
  quantidade int NOT NULL,
  item_do_cardapio_id bigint NOT NULL,
  pedido_id bigint NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (item_do_cardapio_id) REFERENCES item_do_cardapio(id),
  FOREIGN KEY (pedido_id) REFERENCES pedido(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
