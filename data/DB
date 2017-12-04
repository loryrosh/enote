-- ---
-- Table 'notebook'
-- 
-- ---

DROP TABLE IF EXISTS `notebook`;
		
CREATE TABLE `notebook` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `date` date NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`)
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
-- Foreign Keys 
-- ---

ALTER TABLE `notebook` ADD FOREIGN KEY (user_id) REFERENCES `user` (`id`);