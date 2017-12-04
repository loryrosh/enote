-- ---
-- Table 'notebook'
-- 
-- ---

DROP TABLE IF EXISTS `notebook`;
		
CREATE TABLE `notebook` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `user_id` INTEGER NOT NULL,
  `date` DATE NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Table 'label'
-- 
-- ---

DROP TABLE IF EXISTS `label`;
		
CREATE TABLE `label` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `color` varchar(6) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `notebook` ADD FOREIGN KEY (user_id) REFERENCES `user` (`id`);