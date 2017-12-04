-- ---
-- Table 'notebook'
-- 
-- ---

DROP TABLE IF EXISTS `notebook`;
		
CREATE TABLE `notebook` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `user_id` INTEGER NULL DEFAULT NULL,
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
  `type` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
