/*
  CREATE DATABASE enote;

  CREATE USER 'enote_user'@'localhost' IDENTIFIED BY 'admin';
  GRANT ALL PRIVILEGES ON `enote` TO 'enote_user'@'localhost';
*/

-- ---
-- Table 'user'
--
-- ---

DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `user` (
  `id` int AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `registration_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE (`email`, `password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'notebook'
--
-- ---

DROP TABLE IF EXISTS `notebook`;

CREATE TABLE `notebook` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  FOREIGN KEY (user_id) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'attachment'
--
-- ---

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE IF NOT EXISTS `attachment` (
  `id` int AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'note'
--
-- ---

DROP TABLE IF EXISTS `note`;

CREATE TABLE IF NOT EXISTS `note` (
  `id` int AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `notebook_id` int NOT NULL,
  `attachment_id` int,
  `text` varchar(255) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  FOREIGN KEY( `user_id` ) REFERENCES user( `id` ),
  FOREIGN KEY( `notebook_id` ) REFERENCES notebook( `id` ),
  FOREIGN KEY( `attachment_id` ) REFERENCES attachment( `id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'label'
--
-- ---

DROP TABLE IF EXISTS `label`;

CREATE TABLE `label` (
  `id` int NOT NULL AUTO_INCREMENT,
  `color` int NOT NULL,
  `name` varchar(255) NOT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'note_label'
--
-- ---

DROP TABLE IF EXISTS `note_label`;

CREATE TABLE IF NOT EXISTS `note_label` (
  `id` int AUTO_INCREMENT,
  `note_id` int NOT NULL,
  `label_id` int,

  PRIMARY KEY (`id`),
  FOREIGN KEY( `note_id` ) REFERENCES note( `id` ),
  FOREIGN KEY( `label_id` ) REFERENCES label( `id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'note_attachment'
--
-- ---

DROP TABLE IF EXISTS `note_attachment`;

CREATE TABLE IF NOT EXISTS `note_attachment` (
  `id` int AUTO_INCREMENT,
  `note_id` int NOT NULL,
  `attachment_id` int,

  PRIMARY KEY (`id`),
  FOREIGN KEY( `note_id` ) REFERENCES note( `id` ),
  FOREIGN KEY( `attachment_id` ) REFERENCES attachment( `id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
