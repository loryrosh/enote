use enote;

INSERT IGNORE INTO `attachment` (`type`) VALUES
  ('audio'),
  ('page'),
  ('photo'),
  ('video');

INSERT IGNORE INTO `user` (email, password, name, surname) VALUES
  ('John@mail.ru', md5('password'), 'John', 'Smith'),
  ('Andy@mail.ru', md5('password'), 'Andy', 'Black'),
  ('Mary@mail.ru', md5('password'), 'Mary', 'Green'),
  ('Joan@mail.ru', md5('password'), 'Joan', 'Cat'),
  ('Ann@mail.ru', md5('password'), 'Ann', 'Do');

INSERT IGNORE INTO notebook (title, user_id) VALUES
  ('New Notebook', 1),
  ('My Notebook', 2),
  ('Another Notebook', 2);

INSERT IGNORE INTO `note` (notebook_id, title, text) VALUES
  (1, 'Note about weather on Monday', 'Such a wonderful weather!!!'),
  (1, 'About sun', 'Sun is shining');

INSERT IGNORE INTO `label` (color, name) VALUES
  (123456, 'task'),
  (123789, 'daily');

INSERT IGNORE INTO note_label (note_id, label_id) VALUES
  (1, 1),
  (1, 2),
  (2, 1);
