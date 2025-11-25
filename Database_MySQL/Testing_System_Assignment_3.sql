-- ======================TẠO DATABASE==================================
DROP DATABASE Testing_System_Assignment_3;
CREATE DATABASE Testing_System_Assignment_3;
USE Testing_System_Assignment_3;

-- ===========================TẠO BẢNG==================================

-- Tạo bảng Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
    DepartmentID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 		NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- Tạo bảng Position
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
    PositionID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName 		ENUM('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE KEY
);

-- Tạo bảng Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
    AccountID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email 			VARCHAR(50) NOT NULL UNIQUE KEY,
    Username 		VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName 		NVARCHAR(50) NOT NULL,
    DepartmentID 	TINYINT UNSIGNED NOT NULL,
    PositionID 		TINYINT UNSIGNED NOT NULL,
    CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);

-- Tạo bảng Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
    GroupID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName 		NVARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID 		TINYINT UNSIGNED,
    CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- Tạo bảng GroupAccount
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
    GroupID 		TINYINT UNSIGNED NOT NULL,
    AccountID 		TINYINT UNSIGNED NOT NULL,
    JoinDate 		DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID, AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
);

-- Tạo bảng TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName 	ENUM('Essay','Multiple-Choice') NOT NULL UNIQUE KEY
);

-- Tạo bảng CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
    CategoryID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName 	NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- Tạo bảng Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
    QuestionID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content 		NVARCHAR(100) NOT NULL,
    CategoryID 		TINYINT UNSIGNED NOT NULL,
    TypeID 			TINYINT UNSIGNED NOT NULL,
    CreatorID 		TINYINT UNSIGNED NOT NULL,
    CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- Tạo bảng Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
    AnswerID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content NVARCHAR(100) NOT NULL,
    QuestionID TINYINT UNSIGNED NOT NULL,
    isCorrect BIT DEFAULT 1,
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

-- Tạo bảng Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
    ExamID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` 		CHAR(10) NOT NULL,
    Title 		NVARCHAR(50) NOT NULL,
    CategoryID 	TINYINT UNSIGNED NOT NULL,
    Duration 	TINYINT UNSIGNED NOT NULL,
    CreatorID 	TINYINT UNSIGNED NOT NULL,
    CreateDate 	DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- Tạo bảng ExamQuestion
DROP TABLE IF EXISTS ExamQuestion; 
CREATE TABLE ExamQuestion( 
    ExamID 	 	 	 	TINYINT UNSIGNED NOT NULL, 
 	QuestionID 	 	 	TINYINT UNSIGNED NOT NULL, 
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID), 
FOREIGN KEY(ExamID) REFERENCES Exam(ExamID) , 
PRIMARY KEY (ExamID,QuestionID) 
); 


-- -------------------------------------------
-- Cách 1: Thêm dữ liệu vào bảng Department riêng lẻ từng câu lệnh
-- INSERT INTO department(DepartmentName) 
-- VALUE				('Sale');
-- INSERT INTO department(DepartmentName) 
-- VALUE				('Maketing');

-- Cách 2: Thêm dữ liệu vào bảng Department với 1 câu lệnh
-- INSERT INTO department(DepartmentName) 
-- VALUES				('Maketing'),
-- 					('Sale'),
--                     ('BOD');
                    
-- ========================THÊM DỮ LIỆU VÀO BẢNG===================================
-- Chèn dữ liệu Department
INSERT INTO Department(DepartmentName) VALUES
						(N'Marketing'),
						(N'Kinh doanh'),
						(N'An ninh'),
						(N'Nhân sự'),
						(N'Kỹ thuật'),
						(N'Tài chính'),
						(N'Phó giám đốc'),
						(N'Giám đốc'),
						(N'Thư ký'),
						(N'Hành chính'),
						(N'Bán hàng');

-- Chèn dữ liệu Position
INSERT INTO `Position`(PositionName) VALUES
						('Dev'),
						('Test'),
						('Scrum Master'),
						('PM');

-- Chèn dữ liệu Account
INSERT INTO `Account`(Email, 						Username		, FullName			, DepartmentID, PositionID, CreateDate) VALUES
					('nguyen.van.a@company.com'		, 'nguyenvana'	, N'Nguyễn Văn A'	, 5, 1, '2024-01-15'),
					('tran.thi.b@company.com'		, 'tranthib'	, N'Trần Thị B'		, 1, 2, '2024-01-16'),
					('le.van.c@company.com'			, 'levanc'		, N'Lê Văn C'		, 2, 2, '2024-01-17'),
					('pham.thi.d@company.com'		, 'phamthid'	, N'Phạm Thị D'		, 3, 4, '2024-01-18'),
					('hoang.van.e@company.com'		, 'hoangvane'	, N'Hoàng Văn E'	, 4, 4, '2024-01-20'),
					('vu.thi.f@company.com'			, 'vuthif'		, N'Vũ Thị F'		, 6, 3, '2024-02-05'),
					('dang.van.g@company.com'		, 'dangvang'	, N'Đặng Văn G'		, 2, 2, '2024-02-06'),
					('bui.thi.h@company.com'		, 'buithih'		, N'Bùi Thị H'		, 8, 1, '2024-02-07'),
					('do.van.i@company.com'			, 'dovani'		, N'Đỗ Văn I'		, 2, 2, '2024-02-07'),
					('ly.thi.k@company.com'			, 'lythik'		, N'Lý Thị K'		, 10, 1, '2024-02-09'),
					('mai.van.l@company.com'		, 'maivanl'		, N'Mai Văn L'		, 10, 1, DEFAULT),
					('cao.thi.m@company.com'		, 'caothim'		, N'Cao Thị M'		, 10, 1, DEFAULT);

-- Chèn dữ liệu Group
INSERT INTO `Group`(GroupName				, CreatorID, CreateDate) VALUES
					(N'Hệ thống Kiểm thử'	, 5, '2024-01-15'),
					(N'Phát triển Phần mềm'	, 1, '2024-01-17'),
					(N'Đội Bán hàng 01'		, 2, '2024-01-19'),
					(N'Đội Bán hàng 02'		, 3, '2024-01-20'),
					(N'Đội Bán hàng 03'		, 4, '2024-02-05'),
					(N'Đội Sáng tạo'		, 6, '2024-02-06'),
					(N'Đội Marketing 01'	, 7, '2024-02-07'),
					(N'Quản lý Dự án'		, 8, '2024-02-08'),
					(N'Hỗ trợ Khách hàng'	, 9, '2024-02-09'),
					(N'Nghiên cứu AI'		, 10, '2024-02-10');

-- Chèn dữ liệu GroupAccount
INSERT INTO GroupAccount(GroupID, AccountID, JoinDate) VALUES
						(1, 1, '2024-01-15'),
						(1, 2, '2024-01-17'),
						(3, 3, '2024-01-19'),
						(3, 4, '2024-01-20'),
						(5, 5, '2024-02-05'),
						(1, 3, '2024-02-06'),
						(1, 7, '2024-02-07'),
						(8, 3, '2024-02-08'),
						(1, 9, '2024-02-09'),
						(10, 10, '2024-02-10');

-- Chèn dữ liệu TypeQuestion
INSERT INTO TypeQuestion(TypeName) VALUES
						('Essay'),
						('Multiple-Choice');

-- Chèn dữ liệu CategoryQuestion
INSERT INTO CategoryQuestion(CategoryName) VALUES
							(N'Lập trình Java'),
							(N'ASP.NET'),
							(N'ADO.NET'),
							(N'Cơ sở dữ liệu SQL'),
							(N'Kiểm thử API'),
							(N'Ruby on Rails'),
							(N'Python'),
							(N'C++'),
							(N'C#'),
							(N'PHP');

-- Chèn dữ liệu Question
INSERT INTO Question(Content									, CategoryID, TypeID, CreatorID, CreateDate) VALUES
	(N'Các đặc điểm chính của Java là gì?'						, 1, 1, 2, '2024-02-05'),
	(N'Cách quản lý session trong PHP như thế nào?'				, 10, 2, 2, '2024-02-05'),
	(N'Delegates trong C# được sử dụng để làm gì?'				, 9, 2, 3, '2024-02-06'),
	(N'Ruby xử lý phương thức không tồn tại như thế nào?'		, 6, 1, 4, '2024-02-06'),
	(N'Postman được sử dụng chủ yếu cho mục đích gì?'			, 5, 1, 5, '2024-02-06'),
	(N'Connection pooling trong ADO.NET hoạt động ra sao?'		, 3, 2, 6, '2024-02-06'),
	(N'Mô hình MVC trong ASP.NET có những thành phần nào?'		, 2, 1, 7, '2024-02-06'),
	(N'Smart pointers trong C++ có ưu điểm gì?'					, 8, 1, 8, '2024-02-07'),
	(N'Các mức độ isolation trong SQL transaction?'				, 4, 2, 9, '2024-02-07'),
	(N'Decorators trong Python dùng để làm gì?'					, 7, 1, 10, '2024-02-07');

-- Chèn dữ liệu Answer
INSERT INTO Answer(Content								, QuestionID, isCorrect) VALUES
(N'Java có tính độc lập nền tảng và hướng đối tượng'				, 1, 1),
(N'Java quản lý bộ nhớ tự động'										, 1, 1),
(N'Sử dụng session_start() và biến $_SESSION'						, 2, 1),
(N'Delegates là con trỏ hàm an toàn kiểu'							, 3, 1),
(N'Phương thức method_missing được gọi tự động'						, 4, 1),
(N'Kiểm thử API và tạo tài liệu API'								, 5, 1),
(N'Quản lý kết nối cơ sở dữ liệu hiệu quả'							, 6, 1),
(N'Model, View, Controller'											, 7, 1),
(N'Tự động giải phóng bộ nhớ'										, 8, 1),
(N'Read Uncommitted, Read Committed, Repeatable Read, Serializable'	, 9, 1);

-- Chèn dữ liệu Exam
INSERT INTO Exam(`Code`, Title, CategoryID, Duration, CreatorID, CreateDate) VALUES
('EXAM202401', N'Đề thi Lập trình C#'		, 9, 60, 5, '2024-02-05'),
('EXAM202402', N'Đề thi PHP'				, 10, 60, 2, '2024-02-05'),
('EXAM202403', N'Đề thi C++ Nâng cao'		, 8, 120, 2, '2024-02-07'),
('EXAM202404', N'Đề thi Java OOP'			, 1, 60, 3, '2024-02-08'),
('EXAM202405', N'Đề thi Ruby'				, 6, 120, 4, '2024-02-10'),
('EXAM202406', N'Đề thi Postman'			, 5, 60, 6, '2024-02-05'),
('EXAM202407', N'Đề thi SQL'				, 4, 60, 7, '2024-02-05'),
('EXAM202408', N'Đề thi Python'				, 7, 60, 8, '2024-02-07'),
('EXAM202409', N'Đề thi ADO.NET'			, 3, 90, 9, '2024-02-07'),
('EXAM202410', N'Đề thi ASP.NET'			, 2, 90, 10, '2024-02-08');

-- Chèn dữ liệu ExamQuestion
INSERT INTO ExamQuestion(ExamID 	, QuestionID 	)  
VALUES  	 	 	 	 	( 	1 	, 	 	5 	 	), 
							( 	2 	, 	 	10 	 	),  
							( 	3 	, 	 	4 	 	),  
							( 	4 	, 	 	3 	 	),  
							( 	5 	, 	 	7 	 	),  
							( 	6 	, 	 	10 	 	),  
							( 	7 	, 	 	2 	 	),  
							( 	8 	, 	 	10 	 	),  
							( 	9 	, 	 	9 	 	),  
							( 	10 	, 	 	8 	 	); 
                            
-- =================Testing_System_Assignment_3===================
-- File: Testing_System_Assignment_3.sql
-- Exercise 1: Join
-- Question 1: Lấy danh sách nhân viên và thông tin phòng ban
SELECT 
    A.Email, 
    A.Username, 
    A.FullName, 
    D.DepartmentName 
FROM `Account` A  
INNER JOIN Department D ON A.DepartmentID = D.DepartmentID;

-- Question 2: Lấy account tạo sau ngày 20/12/2010
SELECT *FROM `Account`
WHERE CreateDate > '2010-12-20';

-- Question 3: Lấy tất cả các developer
SELECT 
    A.FullName, 
    A.Email, 
    P.PositionName
FROM `Account` A  
INNER JOIN Position P ON A.PositionID = P.PositionID
WHERE P.PositionName = 'Dev';

-- Question 4: Phòng ban có >2 nhân viên
SELECT 
    D.DepartmentID,
    D.DepartmentName, 
    COUNT(A.DepartmentID) AS NumberOfEmployees
FROM `Account` A
INNER JOIN Department D ON A.DepartmentID = D.DepartmentID
GROUP BY A.DepartmentID
HAVING COUNT(A.DepartmentID) > 2;

-- Question 5: Câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 
    Q.QuestionID, 
    Q.Content,
    COUNT(EQ.ExamID) AS NumberOfExams
FROM 
    ExamQuestion EQ
INNER JOIN 
    Question Q ON Q.QuestionID = EQ.QuestionID
GROUP BY 
    EQ.QuestionID
HAVING 
    COUNT(EQ.QuestionID) = (SELECT MAX(CountQues) 
        FROM (
            SELECT COUNT(QuestionID) AS CountQues 
            FROM ExamQuestion 
            GROUP BY QuestionID
        ) AS countTable
    );

-- Question 6: Thống kê mỗi Category Question được sử dụng trong bao nhiêu Question
SELECT 
    CQ.CategoryID, 
    CQ.CategoryName, 
    COUNT(Q.CategoryID) AS NumberOfQuestions
FROM CategoryQuestion CQ  
LEFT JOIN Question Q ON CQ.CategoryID = Q.CategoryID
GROUP BY CQ.CategoryID;

-- Question 7: Thống kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT 
    Q.QuestionID, 
    Q.Content,
    COUNT(EQ.QuestionID) AS NumberOfExams
FROM Question Q
LEFT JOIN ExamQuestion EQ ON Q.QuestionID = EQ.QuestionID
GROUP BY Q.QuestionID
ORDER BY NumberOfExams DESC;

-- Question 8: Question có nhiều câu trả lời nhất
SELECT 
    Q.QuestionID, 
    Q.Content, 
    COUNT(A.QuestionID) AS NumberOfAnswers
FROM Answer A
INNER JOIN Question Q ON Q.QuestionID = A.QuestionID
GROUP BY A.QuestionID
HAVING COUNT(A.QuestionID) = (
	SELECT MAX(countQues) 
        FROM (
            SELECT COUNT(QuestionID) AS countQues 
            FROM Answer 
            GROUP BY QuestionID
        ) AS countAnsw
    );

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT 
    G.GroupID,
    G.GroupName,
    COUNT(GA.AccountID) AS NumberOfAccounts
FROM `Group` G
LEFT JOIN 
    GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY 
    G.GroupID
ORDER BY 
    G.GroupID ASC;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT 
    P.PositionID, 
    P.PositionName, 
    COUNT(A.PositionID) AS NumberOfEmployees
FROM Position P
LEFT JOIN `Account` A ON P.PositionID = A.PositionID
GROUP BY P.PositionID
HAVING 
    COUNT(A.PositionID) = (
        SELECT MIN(CountP) 
        FROM (
            SELECT COUNT(PositionID) AS CountP 
            FROM `Account` 
            GROUP BY PositionID
        ) AS MinCountP
    );

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT 
    D.DepartmentID,
    D.DepartmentName, 
    P.PositionName, 
    COUNT(P.PositionName) AS NumberOfEmployees
FROM `Account` A
INNER JOIN Department D ON A.DepartmentID = D.DepartmentID
INNER JOIN Position P ON A.PositionID = P.PositionID
GROUP BY D.DepartmentID, P.PositionID
ORDER BY D.DepartmentID, P.PositionID;

-- Question 12: Thông tin chi tiết của câu hỏi
SELECT 
    Q.QuestionID, 
    Q.Content AS QuestionContent,
    TQ.TypeName,
    A.FullName AS CreatorName,
    ANS.Content AS AnswerContent,
    ANS.isCorrect
FROM 
    Question Q
INNER JOIN 
    TypeQuestion TQ ON Q.TypeID = TQ.TypeID
INNER JOIN 
    `Account` A ON A.AccountID = Q.CreatorID
LEFT JOIN 
    Answer ANS ON Q.QuestionID = ANS.QuestionID
ORDER BY 
    Q.QuestionID ASC;

-- Question 13: Số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT 
    TQ.TypeID, 
    TQ.TypeName, 
    COUNT(Q.TypeID) AS NumberOfQuestions
FROM 
    TypeQuestion TQ
LEFT JOIN 
    Question Q ON TQ.TypeID = Q.TypeID
GROUP BY 
    TQ.TypeID;

-- Question 14: Group không có account nào (Sử dụng LEFT JOIN)
SELECT G.* 
FROM `Group` G
LEFT JOIN GroupAccount GA ON G.GroupID = GA.GroupID
WHERE GA.AccountID IS NULL;

-- Question 15: Group không có account nào (Sử dụng SUBQUERY)
SELECT * FROM `Group`  
WHERE 
    GroupID NOT IN (
        SELECT GroupID 
        FROM GroupAccount
    );

-- Question 16: Question không có answer nào
SELECT Q.* FROM Question Q
LEFT JOIN Answer A ON Q.QuestionID = A.QuestionID
WHERE A.AnswerID IS NULL;

-- Exercise 2: Union
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT 
    A.AccountID,
    A.FullName 
FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GA.GroupID = 1;

-- b) Lấy các account thuộc nhóm thứ 2
SELECT 
    A.AccountID,
    A.FullName 
FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GA.GroupID = 2;

-- c) Ghép 2 kết quả không trùng nhau
SELECT 
    A.AccountID,
    A.FullName 
FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GA.GroupID = 1
UNION
SELECT 
    A.AccountID,
    A.FullName 
FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GA.GroupID = 2;

-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
SELECT 
    G.GroupID,
    G.GroupName, 
    COUNT(GA.AccountID) AS NumberOfMembers
FROM `Group` G
JOIN GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY G.GroupID
HAVING COUNT(GA.AccountID) > 3;

-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT 
    G.GroupID,
    G.GroupName, 
    COUNT(GA.AccountID) AS NumberOfMembers
FROM `Group` G
JOIN GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY G.GroupID
HAVING COUNT(GA.AccountID) < 7;

-- c) Ghép 2 kết quả
SELECT 
    G.GroupID,
    G.GroupName, 
    COUNT(GA.AccountID) AS NumberOfMembers
FROM `Group` G
JOIN GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY G.GroupID
HAVING COUNT(GA.AccountID) > 5
UNION
SELECT 
    G.GroupID,
    G.GroupName, 
    COUNT(GA.AccountID) AS NumberOfMembers
FROM `Group` G
JOIN GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY G.GroupID
HAVING COUNT(GA.AccountID) < 7;