-- Created by Kamran Rana & Shahmir Ahmed
-- 03/28/2016

--Table of Users
CREATE TABLE User(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	firstName VARCHAR(64) NOT NULL,
	lastName VARCHAR(64) NOT NULL,
	email VARCHAR(64) NOT NULL,
	username VARCHAR(64) NOT NULL, 
	password VARCHAR(64) NOT NULL, 
	security_question INT NOT NULL,
    security_answer VARCHAR (255) NOT NULL,
	school_year INT NOT NULL, 
	major VARCHAR(64) NOT NULL,
	category1 VARCHAR(128) NOT NULL, 
	skill1 VARCHAR(128) NOT NULL, 
	category2 VARCHAR(128) NOT NULL, 
	skill2 VARCHAR(128) NOT NULL, 
	category3 VARCHAR(128) NOT NULL, 
	skill3 VARCHAR(128) NOT NULL, 
	category4 VARCHAR(128) NOT NULL, 
	skill4 VARCHAR(128) NOT NULL, 
	category5 VARCHAR(128) NOT NULL, 
	skill5 VARCHAR(128) NOT NULL
);

--Table of skills
CREATE TABLE Skill
(
   id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
   category VARCHAR(128) NOT NULL, 
   skill_name VARCHAR(128) NOT NULL, 
   user_id INT,
   FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

INSERT INTO User (firstName, lastName, email, password, security_question, security_answer, school_year, major, category1, skill1, category2, skill2, category3, skill3, category4, skill4, category5, skill5) VALUES
('Ojas', 'Mhetar', 'ojmhetar@vt.edu', 'password', '1', 'Answer', '4', 'Computer Science', 'Test', 'Test','Test','Test','Test','Test','Test','Test','Test','Test');



