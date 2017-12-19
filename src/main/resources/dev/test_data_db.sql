INSERT INTO attachment (type) VALUES ('audio');
INSERT INTO attachment (type) VALUES ('page');
INSERT INTO attachment (type) VALUES ('photo');
INSERT INTO attachment (type) VALUES ('video');

INSERT INTO user (email, password, name, surname) VALUES ('John@mail.ru', HASH('SHA256', STRINGTOUTF8('Password'),1000), 'John', 'Smith');
INSERT INTO user (email, password, name, surname) VALUES ('Andy@mail.ru', HASH('SHA256', STRINGTOUTF8('Password'),1000), 'Andy', 'Black');
INSERT INTO user (email, password, name, surname) VALUES ('Mary@mail.ru', HASH('SHA256', STRINGTOUTF8('Password'),1000), 'Mary', 'Green');
INSERT INTO user (email, password, name, surname) VALUES ('Joan@mail.ru', HASH('SHA256', STRINGTOUTF8('Password'),1000), 'Joan', 'Cat');
INSERT INTO user (email, password, name, surname) VALUES ('Ann@mail.ru', HASH('SHA256', STRINGTOUTF8('Password'),1000), 'Ann', 'Do');

INSERT INTO notebook (title, user_id) VALUES ('New Notebook', 1);
INSERT INTO notebook (title, user_id) VALUES ('My Notebook', 2);
INSERT INTO notebook (title, user_id) VALUES ('Another Notebook', 2);

INSERT INTO note (notebook_id, title, text) VALUES (1, 'Note about weather on Monday', 'Such a wonderful weather!!!');
INSERT INTO note (notebook_id, title, text) VALUES (1, 'About sun', 'Sun is shining');

INSERT INTO label (color, name) VALUES (123456, 'task');
INSERT INTO label (color, name) VALUES (123789, 'daily');

INSERT INTO note_label (note_id, label_id) VALUES (1, 1);
INSERT INTO note_label (note_id, label_id) VALUES (1, 2);
INSERT INTO note_label (note_id, label_id) VALUES (2, 1);
