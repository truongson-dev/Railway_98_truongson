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
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ 
SELECT 
    a.AccountID,
    a.Email,
    a.Username,
    a.FullName,
    d.DepartmentName,
    a.CreateDate
FROM `Account` a
INNER JOIN Department d ON a.DepartmentID = d.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010  
SELECT 
    AccountID,
    Email,
    Username,
    FullName,
    CreateDate
FROM `Account`
WHERE CreateDate > '2010-12-20';