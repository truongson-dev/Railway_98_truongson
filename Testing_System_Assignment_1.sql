-- ======================TẠO DATABASE==================================

DROP DATABASE IF EXISTS testing_system_assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;
-- UNIQUE: không trùng
-- AUTO_INCREMENT: Tự động tăng
-- TINYINT UNSIGNED: Số nguyên dương 

-- ===========================TẠO BẢNG==================================

-- Bảng 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
    DepartmentID     TINYINT UNSIGNED AUTO_INCREMENT,
    DepartmentName   VARCHAR(50) NOT NULL UNIQUE KEY,
    PRIMARY KEY (DepartmentID)
);

-- Bảng 2: Position
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
    PositionID      TINYINT UNSIGNED AUTO_INCREMENT,
    PositionName    ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL UNIQUE KEY,
    PRIMARY KEY (PositionID)
);

-- Bảng 3: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
    AccountID       TINYINT UNSIGNED AUTO_INCREMENT,
    Email           VARCHAR(50) NOT NULL UNIQUE,
    Username        NVARCHAR(50) NOT NULL,
    FullName        NVARCHAR(100) NOT NULL,
    DepartmentID    TINYINT UNSIGNED NOT NULL,
    PositionID      TINYINT UNSIGNED NOT NULL,
    CreateDate      DATETIME DEFAULT NOW(),
    PRIMARY KEY (AccountID),
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);

-- Bảng 4: Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
    GroupID         TINYINT UNSIGNED AUTO_INCREMENT,
    GroupName       NVARCHAR(30) NOT NULL,
    CreatorID       TINYINT UNSIGNED NOT NULL,
    CreateDate      DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID),
    UNIQUE KEY (GroupName),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- Bảng 5: GroupAccount
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount (
    GroupID         TINYINT UNSIGNED,
    AccountID       TINYINT UNSIGNED,
    JoinDate        DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID, AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
);

-- Bảng 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID          INT AUTO_INCREMENT,
    TypeName        ENUM('Essay', 'Multiple-Choice') NOT NULL,
    PRIMARY KEY (TypeID)
);

-- Bảng 7: CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion (
    CategoryID      INT AUTO_INCREMENT,
    CategoryName    VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (CategoryID)
);

-- Bảng 8: Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question (
    QuestionID      INT AUTO_INCREMENT,
    Content         TEXT NOT NULL,
    CategoryID      INT,
    TypeID          INT,
    CreatorID       TINYINT UNSIGNED NOT NULL,
    CreateDate      DATETIME DEFAULT NOW(),
    PRIMARY KEY (QuestionID),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- Bảng 9: Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
    AnswerID        INT AUTO_INCREMENT,
    Content         TEXT NOT NULL,
    QuestionID      INT,
    isCorrect       ENUM('TRUE', 'FALSE') NOT NULL,
    PRIMARY KEY (AnswerID),
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

-- Bảng 10: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
    ExamID          INT AUTO_INCREMENT,
    Code            VARCHAR(20) NOT NULL UNIQUE,
    Title           NVARCHAR(200) NOT NULL,
    CategoryID      INT,
    Duration        INT NOT NULL,
    CreatorID       TINYINT UNSIGNED NOT NULL,
    CreateDate      DATETIME DEFAULT NOW(),
    PRIMARY KEY (ExamID),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- Bảng 11: ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
    ExamID          INT,
    QuestionID      INT,
    PRIMARY KEY (ExamID, QuestionID),
    FOREIGN KEY (ExamID) REFERENCES Exam(ExamID),
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
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
-- Department
INSERT INTO Department(DepartmentName)  
VALUES 
						(N'Marketing'),
						(N'Sale'),
						(N'Bảo vệ'),
						(N'Nhân sự'),
						(N'Kỹ thuật'),
						(N'Tài chính'),
						(N'Phó giám đốc'),
						(N'Giám đốc'),
						(N'Thư kí'),
						(N'No person'),
						(N'Bán hàng');

-- Position
INSERT INTO Position (PositionName)  
VALUES 
					('Dev'),
					('Test'),
					('Scrum Master'),
					('PM');

-- Account
INSERT INTO `Account`(Email, Username, FullName, DepartmentID, PositionID, CreateDate) 
VALUES 
					('Email1@gmail.com', 'Username1', 'Fullname1', 5, 1, '2020-03-05'),
					('Email2@gmail.com', 'Username2', 'Fullname2', 1, 2, '2020-03-05'),
					('Email3@gmail.com', 'Username3', 'Fullname3', 2, 2, '2020-03-07'),
					('Email4@gmail.com', 'Username4', 'Fullname4', 3, 4, '2020-03-08'),
					('Email5@gmail.com', 'Username5', 'Fullname5', 4, 4, '2020-03-10'),
					('Email6@gmail.com', 'Username6', 'Fullname6', 6, 3, '2020-04-05'),
					('Email7@gmail.com', 'Username7', 'Fullname7', 2, 2, NULL),
					('Email8@gmail.com', 'Username8', 'Fullname8', 8, 1, '2020-04-07'),
					('Email9@gmail.com', 'Username9', 'Fullname9', 2, 2, '2020-04-07'),
					('Email10@gmail.com', 'Username10', 'Fullname10', 10, 1, '2020-04-09'),
					('Email11@gmail.com', 'Username11', 'Fullname11', 10, 1, DEFAULT),
					('Email12@gmail.com', 'Username12', 'Fullname12', 10, 1, DEFAULT);

-- Group
INSERT INTO `Group` (GroupName, 			CreatorID, CreateDate) 
VALUES 
					(N'Testing System', 	5, '2019-03-05'),
					(N'Development', 		1, '2020-03-07'),
					(N'VTI Sale 01', 		2, '2020-03-09'),
					(N'VTI Sale 02', 		3, '2020-03-10'),
					(N'VTI Sale 03', 		4, '2020-03-28'),
					(N'VTI Creator', 		6, '2020-04-06'),
					(N'VTI Marketing 01',	7, '2020-04-07'),
					(N'Management', 		8, '2020-04-08'),
					(N'Chat with love', 	9, '2020-04-09'),
					(N'Vi Ti Ai', 			10, '2020-04-10');

-- GroupAccount
INSERT INTO GroupAccount (GroupID, AccountID, JoinDate) 
VALUES 
							(1, 1, '2019-03-05'),
							(1, 2, '2020-03-07'),
							(3, 3, '2020-03-09'),
							(3, 4, '2020-03-10'),
							(5, 5, '2020-03-28'),
							(1, 3, '2020-04-06'),
							(1, 7, '2020-04-07'),
							(8, 3, '2020-04-08'),
							(1, 9, '2020-04-09'),
							(10, 10, '2020-04-10');

-- TypeQuestion
INSERT INTO TypeQuestion (TypeName)  
VALUES 
						('Essay'),
						('Multiple-Choice');

-- CategoryQuestion
INSERT INTO CategoryQuestion (CategoryName) 
VALUES 
								('Java'),
								('ASP.NET'),
								('ADO.NET'),
								('SQL'),
								('Postman'),
								('Ruby'),
								('Python'),
								('C++'),
								('C Sharp'),
								('PHP');

-- Question
INSERT INTO Question (Content, 				CategoryID, TypeID, CreatorID, CreateDate) 
VALUES 
					(N'Câu hỏi về Java', 	1, 			1, 2, '2020-04-05'),
					(N'Câu Hỏi về PHP', 	10, 		2, 2, '2020-04-05'),
					(N'Hỏi về C#', 			9, 			2, 3, '2020-04-06'),
					(N'Hỏi về Ruby', 		6, 			1, 4, '2020-04-06'),
					(N'Hỏi về Postman', 	5, 			1, 5, '2020-04-06'),
					(N'Hỏi về ADO.NET', 	3, 			2, 6, '2020-04-06'),
					(N'Hỏi về ASP.NET', 	2, 			1, 7, '2020-04-06'),
					(N'Hỏi về C++', 		8, 			1, 8, '2020-04-07'),
					(N'Hỏi về SQL', 		4, 			2, 9, '2020-04-07'),
					(N'Hỏi về Python', 		7, 			1, 10, '2020-04-07');

-- Answer
INSERT INTO Answer (Content, QuestionID, isCorrect) 
VALUES 
					(N'Trả lời 01', 1, 'FALSE'),
					(N'Trả lời 02', 1, 'TRUE'),
					(N'Trả lời 03', 1, 'FALSE'),
					(N'Trả lời 04', 1, 'TRUE'),
					(N'Trả lời 05', 2, 'TRUE'),
					(N'Trả lời 06', 3, 'TRUE'),
					(N'Trả lời 07', 4, 'FALSE'),
					(N'Trả lời 08', 8, 'FALSE'),
					(N'Trả lời 09', 9, 'TRUE'),
					(N'Trả lời 10', 10, 'TRUE');

-- Exam
INSERT INTO Exam	(Code, 		Title, 				CategoryID, Duration, 	CreatorID, 	CreateDate) 
VALUES 
					('VTIQ001', N'Đề thi C#',    	1, 			60, 		5, 			'2019-04-05'),
					('VTIQ002', N'Đề thi PHP',   	10, 		60, 		2, 			'2019-04-05'),
					('VTIQ003', N'Đề thi C++',   	9, 			120, 		2, 			'2019-04-07'),
					('VTIQ004', N'Đề thi Java',  	6, 			60, 		3,			'2020-04-08'),
					('VTIQ005', N'Đề thi Ruby',  	5, 			120, 		4, 			'2020-04-10'),
					('VTIQ006', N'Đề thi Postman', 	3, 			60, 		6, 			'2020-04-05'),
					('VTIQ007', N'Đề thi SQL', 		2, 			60, 		7, 			'2020-04-05'),
					('VTIQ008', N'Đề thi Python', 	8, 			60, 		8, 			'2020-04-07'),
					('VTIQ009', N'Đề thi ADO.NET', 	4, 			90, 		9, 			'2020-04-07'),
					('VTIQ010', N'Đề thi ASP.NET', 	7, 			90, 		10,			'2020-04-08');

-- ExamQuestion				
INSERT INTO ExamQuestion(ExamID, QuestionID)  
VALUES  	 	 	 	( 	1 	, 	 5 	 	), 
 	 	 	 	 	 	( 	2 	, 	 10 	),  
 	 	 	 	 	 	( 	3 	, 	 4 	 	),  
 	 	 	 	 	 	( 	4 	, 	 3 	 	),  
 	 	 	 	 	 	( 	5 	, 	 7 	 	),  
 	 	 	 	 	 	( 	6 	, 	 10 	),  
 	 	 	 	 	 	( 	7 	, 	 2 	 	),  
 	 	 	 	 	 	( 	8 	, 	 10 	),  
 	 	 	 	 	 	( 	9 	, 	 9 	 	),  
 	 	 	 	 	 	( 	10 	, 	 8 	 	); 
