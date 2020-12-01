CREATE TABLE test.student
(
	student_id VARCHAR(6) NOT NULL,
	student_name VARCHAR(50) NOT NULL,
	degree_scheme VARCHAR(100) NOT NULL CHECK (degree_scheme IN ('BSc Computer Science', 'BSc Electronic Engineering', 'BSc Mathematics')),
	PRIMARY KEY(student_id)
);

CREATE TABLE test.staff
(
	staff_id VARCHAR(6) NOT NULL,
	staff_name VARCHAR(50) NOT NULL,
	staff_grade VARCHAR(50) NOT NULL CHECK (staff_grade IN ('Senior Lecturer', 'Reader', 'Lecturer')),
	PRIMARY KEY(staff_id)
);

CREATE TABLE test.module
(
	module_id VARCHAR(10) NOT NULL,
	module_name VARCHAR(100) NOT NULL,
	credits SMALLINT NOT NULL,
	PRIMARY KEY(module_id)
);

CREATE TABLE test.registered
(
	student_id VARCHAR(6) NOT NULL,
	module_id VARCHAR(10) NOT NULL,
	PRIMARY KEY(student_id, module_id)
);

CREATE TABLE test.teaches
(
	staff_Id VARCHAR(6) NOT NULL, 
	module_Id VARCHAR(10) NOT NULL,
	PRIMARY KEY(staff_id, module_id)
);