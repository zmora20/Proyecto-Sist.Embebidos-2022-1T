-- drop user 'DFl'@'localhost';
flush privileges;
CREATE USER 'TesterDF'@'localhost' IDENTIFIED BY '1002';
GRANT ALL PRIVILEGES ON * . * TO 'TesterDF'@'localhost';
FLUSH PRIVILEGES;