INSERT INTO attachment (type) VALUES ('audio');
INSERT INTO attachment (type) VALUES ('page');
INSERT INTO attachment (type) VALUES ('photo');
INSERT INTO attachment (type) VALUES ('video');

INSERT INTO user (email, password, name, surname) VALUES ('John@mail.ru', HASH('SHA256', STRINGTOUTF8('Password'),1000), 'John', 'Smith');
INSERT INTO user (email, password, name, surname) VALUES ('Andy@mail.ru', HASH('SHA256', STRINGTOUTF8('Password'),1000), 'Andy', 'Black');
INSERT INTO user (email, password, name, surname) VALUES ('Mary@mail.ru', HASH('SHA256', STRINGTOUTF8('Password'),1000), 'Mary', 'Green');
INSERT INTO user (email, password, name, surname) VALUES ('Joan@mail.ru', HASH('SHA256', STRINGTOUTF8('Password'),1000), 'Joan', 'Cat');
INSERT INTO user (email, password, name, surname) VALUES ('Ann@mail.ru', HASH('SHA256', STRINGTOUTF8('Password'),1000), 'Ann', 'Do');
