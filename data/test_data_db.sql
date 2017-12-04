use enote;

LOCK TABLES `attachment` WRITE;
INSERT INTO `attachment` VALUES
  (1,'web-page'),
  (2,'photo'),
  (3,'audio'),
  (4,'video');
UNLOCK TABLES;