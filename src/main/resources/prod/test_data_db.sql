use enote;

LOCK TABLES `attachment` WRITE;
INSERT IGNORE INTO `attachment` VALUES
  (1,'web-page'),
  (2,'photo'),
  (3,'audio'),
  (4,'video');
UNLOCK TABLES;

LOCK TABLES `user` WRITE;
INSERT IGNORE INTO `user` (email, password, name, surname) VALUES
  ('John@mail.ru', md5('password'), 'John', 'Smith'),
  ('Andy@mail.ru', md5('password'), 'Andy', 'Black'),
  ('Mary@mail.ru', md5('password'), 'Mary', 'Green'),
  ('Joan@mail.ru', md5('password'), 'Joan', 'Cat'),
  ('Ann@mail.ru', md5('password'), 'Ann', 'Do');
UNLOCK TABLES;

