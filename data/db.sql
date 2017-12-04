-- ---
-- Table 'notebook'
-- 
-- ---

DROP TABLE IF EXISTS `notebook`;
		
CREATE TABLE `notebook` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `user_id` INTEGER NOT NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'label'
-- 
-- ---

DROP TABLE IF EXISTS `label`;
		
CREATE TABLE `label` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `type` VARCHAR NULL DEFAULT NULL,
  `name` VARCHAR NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `notebook` ADD FOREIGN KEY (user_id) REFERENCES `user` (`id`);
