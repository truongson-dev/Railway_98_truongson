-- BÀI 2 — Final Exam 3 
-- 1) Tạo bảng + dữ liệu

CREATE DATABASE IF NOT EXISTS ThucTap;
USE ThucTap;

CREATE TABLE Country(
    country_id INT PRIMARY KEY,
    country_name VARCHAR(50) NOT NULL
);

CREATE TABLE Location(
    location_id INT PRIMARY KEY,
    street_address VARCHAR(100),
    postal_code VARCHAR(20),
    country_id INT,
    FOREIGN KEY(country_id) REFERENCES Country(country_id)
);

CREATE TABLE Employee(
    employee_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    email VARCHAR(100),
    location_id INT,
    FOREIGN KEY(location_id) REFERENCES Location(location_id)
);

-- INSERT DATA
INSERT INTO Country VALUES
(1,'Vietnam'), (2,'Japan'), (3,'USA');

INSERT INTO Location VALUES
(10,'Lê Lợi','55000',1),
(20,'Nguyễn Văn Linh','11111',1),
(30,'Tokyo Street','22222',2);

INSERT INTO Employee VALUES
(100,'Nguyen Nam','nn01@gmail.com',10),
(101,'Nguyen Hai','nn02@gmail.com',10),
(102,'Nguyen Long','nn03@gmail.com',30);

-- 2) Truy vấn
-- a) Lấy tất cả nhân viên thuộc Việt Nam
SELECT e.*
FROM Employee e
JOIN Location l ON e.location_id = l.location_id
JOIN Country c ON l.country_id = c.country_id
WHERE c.country_name = 'Vietnam';

-- b) Lấy tên quốc gia của employee có email = "nn03@gmail.com"
SELECT c.country_name
FROM Employee e
JOIN Location l ON e.location_id = l.location_id
JOIN Country c ON l.country_id = c.country_id
WHERE e.email = 'nn03@gmail.com';

-- c) Thống kê mỗi country, mỗi location có bao nhiêu employee
SELECT 
    c.country_name,
    l.location_id,
    COUNT(e.employee_id) AS total_employee
FROM Country c
LEFT JOIN Location l ON c.country_id = l.country_id
LEFT JOIN Employee e ON l.location_id = e.location_id
GROUP BY c.country_id, l.location_id;
-- 3) Trigger: mỗi quốc gia tối đa 10 employee
DELIMITER $$

CREATE TRIGGER trg_CheckLimit
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
    DECLARE emp_count INT;

    SELECT COUNT(*)
    INTO emp_count
    FROM Employee e
    JOIN Location l ON e.location_id = l.location_id
    WHERE l.country_id = (SELECT country_id FROM Location WHERE location_id = NEW.location_id);

    IF emp_count >= 10 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Country already has 10 employees';
    END IF;
END$$

DELIMITER ;

-- 4) Khi xóa Location → Employee.location_id = NULL
ALTER TABLE Employee
DROP FOREIGN KEY employee_ibfk_1;

ALTER TABLE Employee
ADD CONSTRAINT fk_location
FOREIGN KEY(location_id) REFERENCES Location(location_id)
ON DELETE SET NULL;











