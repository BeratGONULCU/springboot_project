CREATE TABLE IF NOT EXISTS school
(
    school_id INT  PRİMARY KEY,
    school_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS family
(
    family_id INT  PRIMARY KEY,
    surname VARCHAR(25) NOT NULL
);

CREATE TABLE IF NOT EXISTS lesson
(
    lesson_id INT  PRİMARY KEY,
    surname VARCHAR(25) NOT NULL
);

CREATE TABLE IF NOT EXISTS student
(
    student_id INT  PRİMARY KEY,
    student_name VARCHAR(25) NOT NULL,
    school_id INT,
    FOREIGN KEY (school_id) REFERENCES school(school_id),
    family_id INT UNIQUE,
    FOREIGN KEY (family_id) REFERENCES family(family_id)
);

CREATE TABLE IF NOT EXISTS studentLesson
(
    student_id INT,
    lesson_id INT,
    PRIMARY KEY(student_id,lesson_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (lesson_id) REFERENCES lesson(lesson_id)
);


SELECT * FROM school_entity
