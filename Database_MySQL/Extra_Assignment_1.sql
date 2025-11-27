-- Exercise 1: Design a table
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
DROP DATABASE IF EXISTS Extra_Assignment_1;
CREATE DATABASE Extra_Assignment_1;
USE Extra_Assignment_1;

DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee (
    TraineeID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name		NVARCHAR(50) NOT NULL,
    Birth_Date 		DATE NOT NULL,
    Gender 			ENUM('MALE', 'FEMALE', 'UNKNOWN') NOT NULL,
    ET_IQ 			TINYINT UNSIGNED NOT NULL CHECK (ET_IQ <= 20),
    ET_Gmath 		TINYINT UNSIGNED NOT NULL CHECK (ET_Gmath <= 20),
    ET_English 		TINYINT UNSIGNED NOT NULL CHECK (ET_English <= 50),
    Training_Class 	CHAR(6) NOT NULL,
    Evaluation_Notes NVARCHAR(50) NOT NULL
);
-- Question 2: Thêm ít nhất 10 bản ghi vào table
INSERT INTO Trainee (Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes) 
VALUES 
					('Nguyen Van A', '1999-01-15', 'MALE', 18, 16, 45, 'VTI001', 'DHBKHN'),
					('Tran Thi B', '2000-03-20', 'FEMALE', 15, 14, 38, 'VTI001', 'DHQGHN'),
					('Le Van C', '1998-07-11', 'MALE', 12, 13, 25, 'VTI002', 'HVBCVT'),
					('Pham Thi D', '1999-05-30', 'FEMALE', 19, 17, 42, 'VTI002', 'DHBKHN'),
					('Hoang Van E', '2000-11-25', 'MALE', 10, 11, 28, 'VTI003', 'DHQGHN'),
					('Dao Thi F', '1999-08-10', 'FEMALE', 14, 15, 35, 'VTI003', 'HVBCVT'),
					('Bui Van G', '2000-12-05', 'MALE', 17, 18, 46, 'VTI001', 'DHBKHN'),
					('Ngo Thi H', '1998-04-18', 'FEMALE', 13, 12, 32, 'VTI002', 'DHQGHN'),
					('Duong Van I', '1999-09-22', 'MALE', 16, 15, 40, 'VTI003', 'HVBCVT'),
					('Ly Thi J', '2000-06-14', 'FEMALE', 11, 13, 29, 'VTI001', 'DHBKHN');

-- Question 3: Insert 1 bản ghi mà có điểm ET_IQ =30. Sau đó xem kết quả.
INSERT INTO Trainee (Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes) 
VALUES ('Test IQ', '1999-01-01', 'MALE', 30, 15, 35, 'VTI001', 'DHBKHN');

-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào,
-- và sắp xếp theo ngày sinh. Điểm ET_IQ >=12, ET_Gmath>=12, ET_English>=20
SELECT * FROM Trainee
WHERE ET_IQ >= 12 AND ET_Gmath >= 12 AND ET_English >= 20
ORDER BY Birth_Date;

-- Question 5: Viết lệnh để lấy ra thông tin thực tập sinh có tên bắt đầu bằng chữ N và kết thúc bằng chữ C
SELECT * FROM Trainee WHERE Full_Name LIKE 'N%C';

-- Question 6: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có ký thự thứ 2 là chữ G
SELECT * FROM Trainee WHERE Full_Name LIKE '_G%';

-- Question 7: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có 10 ký tự và ký tự cuối cùng là C
SELECT * FROM Trainee WHERE Full_Name LIKE '_________C';

-- Question 8: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, lọc bỏ các tên trùng nhau.
SELECT DISTINCT Full_Name FROM Trainee;

-- Question 9: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, sắp xếp các tên này theo thứ tự từ A-Z.
SELECT Full_Name FROM Trainee 
ORDER BY Full_Name ASC;

-- Question 10: Viết lệnh để lấy ra thông tin thực tập sinh có tên dài nhất
SELECT * FROM Trainee 
WHERE LENGTH(Full_Name) = (SELECT MAX(LENGTH(Full_Name)) FROM Trainee);

-- Question 11: Viết lệnh để lấy ra ID, Fullname và Ngày sinh thực tập sinh có tên dài nhất
SELECT TraineeID, Full_Name, Birth_Date FROM Trainee 
WHERE LENGTH(Full_Name) = (SELECT MAX(LENGTH(Full_Name)) FROM Trainee);

-- Question 12: Viết lệnh để lấy ra Tên, và điểm IQ, Gmath, English thực tập sinh có tên dài nhất
SELECT Full_Name, ET_IQ, ET_Gmath, ET_English FROM Trainee 
WHERE LENGTH(Full_Name) = (SELECT MAX(LENGTH(Full_Name)) FROM Trainee);

-- Question 13 Lấy ra 5 thực tập sinh có tuổi nhỏ nhất
SELECT * FROM Trainee
ORDER BY Birth_Date DESC
LIMIT 5;

-- Question 14: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là
-- những người thỏa mãn số điểm như sau:
SELECT * FROM Trainee
WHERE (ET_IQ + ET_Gmath) >= 20 
AND ET_IQ >= 8 
AND ET_Gmath >= 8 
AND ET_English >= 18;

-- Question 15: Xóa thực tập sinh có TraineeID = 5
DELETE FROM Trainee WHERE TraineeID = 5;

-- Question 16: Xóa thực tập sinh có tổng điểm ET_IQ, ET_Gmath <=15
DELETE FROM Trainee WHERE (ET_IQ + ET_Gmath) <= 15;

-- Question 17: Xóa thực tập sinh quá 30 tuổi.
DELETE FROM Trainee 
WHERE TIMESTAMPDIFF(YEAR, Birth_Date, CURDATE()) > 30;

-- Question 18: Thực tập sinh có TraineeID = 3 được chuyển sang lớp " VTI003". Hãy cập nhật
-- thông tin vào database.
UPDATE Trainee SET Training_Class = 'VTI003' WHERE TraineeID = 3;

-- Question 19: Do có sự nhầm lẫn khi nhập liệu nên thông tin của học sinh số 10 đang bị sai, hãy cập nhật lại tên thành “LeVanA”, 
-- điểm ET_IQ =10, điểm ET_Gmath =15, điểm ET_English = 30.
UPDATE Trainee 
SET Full_Name = 'LeVanA', ET_IQ = 10, ET_Gmath = 15, ET_English = 30 
WHERE TraineeID = 10;

-- Question 20: Đếm xem trong lớp VTI001  có bao nhiêu thực tập sinh.
SELECT COUNT(*) FROM Trainee WHERE Training_Class = 'VTI001';

-- Question 21: Đếm xem trong lớp VTI001  có bao nhiêu thực tập sinh.
SELECT COUNT(*) FROM Trainee WHERE Training_Class = 'VTI001';

-- Question 22: Đếm tổng số thực tập sinh trong lớp VTI001 và VTI003 có bao nhiêu thực tập sinh.
SELECT COUNT(*) FROM Trainee 
WHERE Training_Class IN ('VTI001', 'VTI003');

-- Question 23: Lấy ra số lượng các thực tập sinh theo giới tính: Male, Female, Unknown.
SELECT Gender, COUNT(*) AS Count 
FROM Trainee 
GROUP BY Gender;

-- Question 24: Lấy ra lớp có lớn hơn 5 thực tập viên
SELECT Training_Class, COUNT(*) AS Count 
FROM Trainee 
GROUP BY Training_Class 
HAVING COUNT(*) > 5;

-- Question 25: Lấy ra lớp có lớn hơn 5 thực tập viên
SELECT Training_Class, COUNT(*) AS Count 
FROM Trainee 
GROUP BY Training_Class 
HAVING COUNT(*) > 5; 

-- Question 26: Lấy ra trường có ít hơn 4 thực tập viên tham gia khóa học
SELECT Evaluation_Notes, COUNT(*) AS Count 
FROM Trainee 
GROUP BY Evaluation_Notes 
HAVING COUNT(*) < 4;
 
-- Question 27: Bước 1: Lấy ra danh sách thông tin ID, Fullname, lớp thực tập viên có lớp 'VTI001'
-- Bước 1: Lấy thông tin lớp VTI001
SELECT TraineeID, Full_Name, Training_Class FROM Trainee WHERE Training_Class = 'VTI001';

-- Bước 2: Lấy thông tin lớp VTI002  
SELECT TraineeID, Full_Name, Training_Class FROM Trainee WHERE Training_Class = 'VTI002';

-- Bước 3: Sử dụng UNION
SELECT TraineeID, Full_Name, Training_Class FROM Trainee WHERE Training_Class = 'VTI001'
UNION
SELECT TraineeID, Full_Name, Training_Class FROM Trainee WHERE Training_Class = 'VTI002';
