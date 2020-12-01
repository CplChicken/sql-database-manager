ALTER TABLE test.registered
ADD CONSTRAINT FK_StudentRegistered
FOREIGN KEY (student_id) REFERENCES test.student(student_id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE test.registered
ADD CONSTRAINT FK_ModuleRegistered
FOREIGN KEY (module_id) REFERENCES test.module(module_id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE test.teaches
ADD CONSTRAINT FK_StaffTeaches
FOREIGN KEY (staff_id) REFERENCES test.staff(staff_id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE test.teaches
ADD CONSTRAINT FK_ModuleTeaches
FOREIGN KEY (module_id) REFERENCES test.module(module_id) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO test.student VALUES ('S10345', 'John Smith', 'BSc Computer Science');
INSERT INTO test.student VALUES ('S10346', 'Sian Evans', 'BSc Computer Science');
INSERT INTO test.student VALUES ('S10347', 'Sean Crossan', 'BSc Electronic Engineering');
INSERT INTO test.student VALUES ('S10348', 'Jamie McDonald', 'BSc Mathematics');

INSERT INTO test.module VALUES ('CS101', 'Introduction to Computing', '10');
INSERT INTO test.module VALUES ('CS203', 'Data Structures and Algorithms', '10');
INSERT INTO test.module VALUES ('CS204', 'Computer Architecture', '10');
INSERT INTO test.module VALUES ('M101', 'Foundation Mathematics', '20');

INSERT INTO test.staff VALUES ('E10010', 'Alan Turing', 'Senior Lecturer');
INSERT INTO test.staff VALUES ('E10011', 'Tony Hoare', 'Reader');
INSERT INTO test.staff VALUES ('E10012', 'Alan Turing', 'Lecturer');

INSERT INTO test.registered VALUES ('S10345', 'CS101');
INSERT INTO test.registered VALUES ('S10346', 'CS203');
INSERT INTO test.registered VALUES ('S10346', 'CS204');
INSERT INTO test.registered VALUES ('S10347', 'CS204');
INSERT INTO test.registered VALUES ('S10348', 'M101');
INSERT INTO test.registered VALUES ('S10348', 'CS101');

INSERT INTO test.teaches VALUES ('E10010', 'CS101');
INSERT INTO test.teaches VALUES ('E10011', 'CS203');
INSERT INTO test.teaches VALUES ('E10012', 'CS204');
INSERT INTO test.teaches VALUES ('E10010', 'CS204');
INSERT INTO test.teaches VALUES ('E10011', 'M101');
INSERT INTO test.teaches VALUES ('E10011', 'CS101');