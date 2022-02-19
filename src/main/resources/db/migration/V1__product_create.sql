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