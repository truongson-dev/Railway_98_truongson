-- BÀI 3 — Final Exam 1  Case when
-- 1) Tạo bảng + dữ liệu
CREATE DATABASE IF NOT EXISTS Exam1;
USE Exam1;

CREATE TABLE Student(
    ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT,
    Gender TINYINT    -- 0: Male, 1: Female, NULL: Unknown
);

CREATE TABLE Subject(
    ID INT PRIMARY KEY,
    Name VARCHAR(50)
);

CREATE TABLE StudentSubject(
    StudentID INT,
    SubjectID INT,
    Mark INT,
    Date DATE,
    PRIMARY KEY(StudentID, SubjectID),
    FOREIGN KEY(StudentID) REFERENCES Student(ID),
    FOREIGN KEY(SubjectID) REFERENCES Subject(ID)
);

-- INSERT DATA
INSERT INTO Student VALUES
(1,'Nam',18,0),
(2,'Mai',19,1),
(3,'Khoa',18,NULL);

INSERT INTO Subject VALUES
(10,'Math'),(20,'English'),(30,'Physics');

INSERT INTO StudentSubject VALUES
(1,10,9,'2025-01-01'),
(1,20,6,'2025-01-10'),
(2,10,8,'2025-02-01');

-- 2) Truy vấn
-- a) Lấy tất cả môn không có điểm
SELECT s.*
FROM Subject s
LEFT JOIN StudentSubject ss ON s.ID = ss.SubjectID
WHERE ss.SubjectID IS NULL;
-- b) Môn có ít nhất 2 điểm
SELECT s.ID, s.Name
FROM Subject s
JOIN StudentSubject ss ON s.ID = ss.SubjectID
GROUP BY s.ID
HAVING COUNT(ss.Mark) >= 2;
-- 3) VIEW: StudentInfo
CREATE VIEW StudentInfo AS
SELECT 
    st.ID AS StudentID,
    sb.ID AS SubjectID,
    st.Name AS StudentName,
    st.Age AS StudentAge,
    CASE 
        WHEN st.Gender = 0 THEN 'Male'
        WHEN st.Gender = 1 THEN 'Female'
        ELSE 'Unknown'
    END AS StudentGender,
    sb.Name AS SubjectName,
    ss.Mark,
    ss.Date
FROM Student st
JOIN StudentSubject ss ON st.ID = ss.StudentID
JOIN Subject sb ON ss.SubjectID = sb.ID;

-- 4) Trigger
-- a) Trigger UPDATE ID subject
DELIMITER $$

CREATE TRIGGER SubjectUpdateID
AFTER UPDATE ON Subject
FOR EACH ROW
BEGIN
    UPDATE StudentSubject
    SET SubjectID = NEW.ID
    WHERE SubjectID = OLD.ID;
END$$

DELIMITER ;


-- b) Trigger xóa Student → xóa StudentSubject
DELIMITER $$

CREATE TRIGGER StudentDeleteID
AFTER DELETE ON Student
FOR EACH ROW
BEGIN
    DELETE FROM StudentSubject
    WHERE StudentID = OLD.ID;
END$$

DELIMITER ;

-- 5) Procedure xóa theo tên
DELIMITER $$

CREATE PROCEDURE DeleteStudentByName(IN pName VARCHAR(50))
BEGIN
    IF pName = '*' THEN
        DELETE FROM StudentSubject;
        DELETE FROM Student;
    ELSE
        DELETE ss FROM StudentSubject ss
        JOIN Student st ON ss.StudentID = st.ID
        WHERE st.Name = pName;

        DELETE FROM Student
        WHERE Name = pName;
    END IF;
END$$

DELIMITER ;


-- Test:

CALL DeleteStudentByName('Nam');
CALL DeleteStudentByName('*');






