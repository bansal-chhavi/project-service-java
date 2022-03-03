CREATE TABLE product
(id               BIGINT IDENTITY NOT NULL, 
 created_at       BIGINT, 
 created_by       VARCHAR(255), 
 last_modified_by VARCHAR(255), 
 updated_at       BIGINT, 
 category         VARCHAR(255) NOT NULL, 
 description      VARCHAR(255), 
 label            VARCHAR(255) NOT NULL, 
 name             VARCHAR(255) NOT NULL, 
 price            BIGINT NOT NULL, 
 quantity         BIGINT NOT NULL, 
 PRIMARY KEY(id)
);

INSERT INTO product (category,description,label,name,price,quantity) VALUES
("transport","bus services","bus","bus 12","250000","2"),
("transport","car services","car","car 12","150000","4"),
("transport","cab services","cab","cab 12","300000","6"),
("transport","taxi services","taxi","taxi 12","120000","2"),
("transport","bike services","bike","bike 12","130000","10")