/*
  CREATE DATABASE enote;

  CREATE USER 'enote_user'@'localhost' IDENTIFIED BY 'admin';
  GRANT ALL PRIVILEGES ON `enote` TO 'enote_user'@'localhost';
*/

-- ---
-- Table 'user'
--
-- ---

CREATE TABLE IF NOT EXISTS `user` (
  `id` int AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `registration_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_active` boolean DEFAULT TRUE,

  PRIMARY KEY (`id`),
  UNIQUE (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'notebook'
--
-- ---

CREATE TABLE IF NOT EXISTS `notebook` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `user_id` int NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE (`title`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'attachment'
--
-- ---

CREATE TABLE IF NOT EXISTS `attachment` (
  `id` int AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'note'
--
-- ---

CREATE TABLE IF NOT EXISTS `note` (
  `id` int AUTO_INCREMENT,
  `notebook_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `text` varchar(255) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE (`title`),
  FOREIGN KEY( `notebook_id` ) REFERENCES notebook( `id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'label'
--
-- ---

CREATE TABLE IF NOT EXISTS `label` (
  `id` int NOT NULL AUTO_INCREMENT,
  `color` int NOT NULL,
  `name` varchar(255) NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'note_label'
--
-- ---

CREATE TABLE IF NOT EXISTS `note_label` (
  `id` int AUTO_INCREMENT,
  `note_id` int NOT NULL,
  `label_id` int,

  PRIMARY KEY (`id`),
  UNIQUE (`note_id`, `label_id`),
  FOREIGN KEY( `note_id` ) REFERENCES note( `id` ),
  FOREIGN KEY( `label_id` ) REFERENCES label( `id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Table 'note_attachment'
--
-- ---

CREATE TABLE IF NOT EXISTS `note_attachment` (
  `id` int AUTO_INCREMENT,
  `note_id` int NOT NULL,
  `attachment_id` int,

  PRIMARY KEY (`id`),
  UNIQUE (`note_id`, `attachment_id`),
  FOREIGN KEY( `note_id` ) REFERENCES note( `id` ),
  FOREIGN KEY( `attachment_id` ) REFERENCES attachment( `id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
