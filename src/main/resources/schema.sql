DROP TABLE IF EXISTS TBL_EMPLOYEES;
 
CREATE TABLE LIB_BOOKS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  type   VARCHAR(250) DEFAULT NULL,
  num_of_pages INT NOT NULL, 
  language VARCHAR(50) NOT NULL
);