-- ---
-- Table 'user'
--
-- ---

DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id int AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  surname varchar(255) NOT NULL,
  registration_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (id),
  UNIQUE (email)
);


-- ---
-- Table 'notebook'
--
-- ---

DROP TABLE IF EXISTS notebook;

CREATE TABLE notebook (
  id int NOT NULL AUTO_INCREMENT,
  user_id int NOT NULL,
  date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
);


-- ---
-- Table 'attachment'
--
-- ---

DROP TABLE IF EXISTS attachment;

CREATE TABLE attachment (
  id int AUTO_INCREMENT,
  type varchar(255) NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (type)
);


-- ---
-- Table 'note'
--
-- ---

DROP TABLE IF EXISTS note;

CREATE TABLE note (
  id int AUTO_INCREMENT,
  notebook_id int NOT NULL,
  text varchar(255) NOT NULL,
  date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (id),
  FOREIGN KEY(notebook_id) REFERENCES notebook(id)
);


-- ---
-- Table 'label'
--
-- ---

DROP TABLE IF EXISTS label;

CREATE TABLE label (
  id int NOT NULL AUTO_INCREMENT,
  color int NOT NULL,
  name varchar(255) NOT NULL,

  PRIMARY KEY (id)
);


-- ---
-- Table 'note_label'
--
-- ---

DROP TABLE IF EXISTS note_label;

CREATE TABLE note_label (
  id int AUTO_INCREMENT,
  note_id int NOT NULL,
  label_id int,

  PRIMARY KEY (id),
  FOREIGN KEY(note_id) REFERENCES note(id),
  FOREIGN KEY(label_id) REFERENCES label(id)
);


-- ---
-- Table 'note_attachment'
--
-- ---

DROP TABLE IF EXISTS note_attachment;

CREATE TABLE note_attachment (
  id int AUTO_INCREMENT,
  note_id int NOT NULL,
  attachment_id int,

  PRIMARY KEY (id),
  FOREIGN KEY(note_id) REFERENCES note(id),
  FOREIGN KEY(attachment_id) REFERENCES attachment(id)
);
