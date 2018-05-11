CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  enabled  TINYINT     NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
);

CREATE TABLE user_roles (
  user_role_id int (11) NOT NULL AUTO_INCREMENT,
  username     varchar(50) NOT NULL,
  role         varchar(50) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY pkuni_username_role ( role, username),
  KEY          fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO users (username, password, enabled) VALUES ('ecastel', 'L1ng0t3', 1);
INSERT INTO users (username, password, enabled) VALUES ('jafrutos', 'j@frut0s', 1);
INSERT INTO users (username, password, enabled) VALUES ('luisfer', 'lu1sf3r', 1);
INSERT INTO users (username, password, enabled) VALUES ('jpablos', 'jp@bl0s', 1);


INSERT INTO user_roles (username, role) VALUES ('ecastel', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('ecastel', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES ('jafrutos', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('luisfer', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('jpablos', 'ROLE_USER');

CREATE TABLE books (
  id_books int (11) NOT NULL AUTO_INCREMENT,
  author   varchar(50)   DEFAULT NULL,
  title    varchar(65)   DEFAULT NULL,
  price    decimal(4, 2) DEFAULT NULL,
  PRIMARY KEY (id_books)
);

INSERT INTO books VALUES (null, 'John Grisham', 'The Rooster Bar', 13.00);
INSERT INTO books VALUES (null, 'Daniel Ellsberg', 'The doomsday machine', 19.49);
INSERT INTO books VALUES (null, 'Nora Roberts', 'Year One', 19.58);
INSERT INTO books VALUES (null, 'Katherine Arden', 'The Girl in the Tower', 17.70);
