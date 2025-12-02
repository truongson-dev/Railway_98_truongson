/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/
DROP DATABASE IF EXISTS testing_system_7;
CREATE DATABASE testing_system_7;
USE testing_system_7;

/*============================== CREATE TABLE=== =======================================*/
/*======================================================================================*/

-- create table 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL
);

-- create table 2: Posittion
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position` (
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev','Test','Scrum Master','PM') NOT NULL
);

-- create table 3: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				NVARCHAR(50) NOT NULL,
    DepartmentID 			TINYINT UNSIGNED NOT NULL,
    PositionID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID) ON DELETE CASCADE,
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID) ON DELETE CASCADE
);

-- create table 4: Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID				TINYINT UNSIGNED,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId) ON DELETE CASCADE
);

-- create table 5: GroupAccount
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID				TINYINT UNSIGNED NOT NULL,
    JoinDate				DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID,AccountID),
    FOREIGN KEY(GroupID) 		REFERENCES `Group`(GroupID) ON DELETE CASCADE
);

-- create table 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName 		ENUM('Essay','Multiple-Choice') NOT NULL UNIQUE KEY
);

-- create table 7: CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
    CategoryID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName			NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table 8: Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
    QuestionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    TypeID					TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY(TypeID) 		REFERENCES TypeQuestion(TypeID) ON DELETE CASCADE,
    FOREIGN KEY(CreatorID) 		REFERENCES `Account`(AccountId) ON DELETE CASCADE 
);

-- create table 9: Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
    AnswerID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    QuestionID				TINYINT UNSIGNED NOT NULL,
    isCorrect				BIT DEFAULT 1,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE
);

-- create table 10: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
    ExamID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`					CHAR(10) NOT NULL,
    Title					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    Duration				TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId) ON DELETE CASCADE
);

-- create table 11: ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
    ExamID				TINYINT UNSIGNED NOT NULL,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE,
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID) ON DELETE CASCADE,
    PRIMARY KEY (ExamID,QuestionID)
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department(DepartmentName) 
VALUES
						(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);
    
-- Add data position
INSERT INTO Position	(PositionName	) 
VALUES 					('Dev'			),
						('Test'			),
						('Scrum Master'	),
						('PM'			); 


-- Add data Account
INSERT INTO `Account`(Email								, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUES 				('Email1@gmail.com'				, 'Username1'		,'Fullname1'				,   '5'			,   '1'		,'2020-03-05'),
					('Email2@gmail.com'				, 'Username2'		,'Fullname2'				,   '1'			,   '2'		,'2020-03-05'),
                    ('Email3@gmail.com'				, 'Username3'		,'Fullname3'				,   '2'			,   '2'		,'2020-03-07'),
                    ('Email4@gmail.com'				, 'Username4'		,'Fullname4'				,   '3'			,   '4'		,'2020-03-08'),
                    ('Email5@gmail.com'				, 'Username5'		,'Fullname5'				,   '4'			,   '4'		,'2020-03-10'),
                    ('Email6@gmail.com'				, 'Username6'		,'Fullname6'				,   '6'			,   '3'		,'2020-04-05'),
                    ('Email7@gmail.com'				, 'Username7'		,'Fullname7'				,   '2'			,   '2'		, NULL		),
                    ('Email8@gmail.com'				, 'Username8'		,'Fullname8'				,   '8'			,   '1'		,'2020-04-07'),
                    ('Email9@gmail.com'				, 'Username9'		,'Fullname9'				,   '2'			,   '2'		,'2020-04-07'),
                    ('Email10@gmail.com'			, 'Username10'		,'Fullname10'				,   '10'		,   '1'		,'2020-04-09');

-- Add data Group
INSERT INTO `Group`	(  GroupName			, CreatorID		, CreateDate)
VALUES 				(N'Testing System'		,   5			,'2019-03-05'),
					(N'Development'			,   1			,'2020-03-07'),
                    (N'VTI Sale 01'			,   2			,'2020-03-09'),
                    (N'VTI Sale 02'			,   3			,'2020-03-10'),
                    (N'VTI Sale 03'			,   4			,'2020-03-28'),
                    (N'VTI Creator'			,   6			,'2020-04-06'),
                    (N'VTI Marketing 01'	,   7			,'2020-04-07'),
                    (N'Management'			,   8			,'2020-04-08'),
                    (N'Chat with love'		,   9			,'2020-04-09'),
                    (N'Vi Ti Ai'			,   10			,'2020-04-10');

-- Add data GroupAccount
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	1		,    1		,'2019-03-05'),
							(	1		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	3		,    4		,'2020-03-10'),
							(	5		,    5		,'2020-03-28'),
							(	1		,    3		,'2020-04-06'),
							(	1		,    7		,'2020-04-07'),
							(	8		,    3		,'2020-04-08'),
							(	1		,    9		,'2020-04-09'),
							(	10		,    10		,'2020-04-10');


-- Add data TypeQuestion
INSERT INTO TypeQuestion	(TypeName			) 
VALUES 						('Essay'			), 
							('Multiple-Choice'	); 


-- Add data CategoryQuestion
INSERT INTO CategoryQuestion		(CategoryName	)
VALUES 								('Java'			),
									('ASP.NET'		),
									('ADO.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('C Sharp'		),
									('PHP'			);
													
-- Add data Question
INSERT INTO Question	(Content			, CategoryID, TypeID		, CreatorID	, CreateDate )
VALUES 					(N'Câu hỏi về Java'	,	1		,   '1'			,   '2'		,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,	10		,   '2'			,   '2'		,'2020-04-05'),
						(N'Hỏi về C#'		,	9		,   '2'			,   '3'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,	6		,   '1'			,   '4'		,'2020-04-06'),
						(N'Hỏi về Postman'	,	5		,   '1'			,   '5'		,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,	3		,   '2'			,   '6'		,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,	2		,   '1'			,   '7'		,'2020-04-06'),
						(N'Hỏi về C++'		,	8		,   '1'			,   '8'		,'2020-04-07'),
						(N'Hỏi về SQL'		,	4		,   '2'			,   '9'		,'2020-04-07'),
						(N'Hỏi về Python'	,	7		,   '1'			,   '10'	,'2020-04-07');

-- Add data Answers
INSERT INTO Answer	(  Content		, QuestionID	, isCorrect	)
VALUES 				(N'Trả lời 01'	,   1			,	0		),
					(N'Trả lời 02'	,   1			,	1		),
                    (N'Trả lời 03'	,   1			,	0		),
                    (N'Trả lời 04'	,   1			,	1		),
                    (N'Trả lời 05'	,   2			,	1		),
                    (N'Trả lời 06'	,   3			,	1		),
                    (N'Trả lời 07'	,   4			,	0		),
                    (N'Trả lời 08'	,   8			,	0		),
                    (N'Trả lời 09'	,   9			,	1		),
                    (N'Trả lời 10'	,   10			,	1		);
	
-- Add data Exam
INSERT INTO Exam	(`Code`			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUES 				('VTIQ001'		, N'Đề thi C#'			,	1			,	60		,   '5'			,'2019-04-05'),
					('VTIQ002'		, N'Đề thi PHP'			,	10			,	60		,   '2'			,'2019-04-05'),
                    ('VTIQ003'		, N'Đề thi C++'			,	9			,	120		,   '2'			,'2019-04-07'),
                    ('VTIQ004'		, N'Đề thi Java'		,	6			,	60		,   '3'			,'2020-04-08'),
                    ('VTIQ005'		, N'Đề thi Ruby'		,	5			,	120		,   '4'			,'2020-04-10'),
                    ('VTIQ006'		, N'Đề thi Postman'		,	3			,	60		,   '6'			,'2020-04-05'),
                    ('VTIQ007'		, N'Đề thi SQL'			,	2			,	60		,   '7'			,'2020-04-05'),
                    ('VTIQ008'		, N'Đề thi Python'		,	8			,	60		,   '8'			,'2020-04-07'),
                    ('VTIQ009'		, N'Đề thi ADO.NET'		,	4			,	90		,   '9'			,'2020-04-07'),
                    ('VTIQ010'		, N'Đề thi ASP.NET'		,	7			,	90		,   '10'		,'2020-04-08');
                    
                    
-- Add data ExamQuestion
INSERT INTO ExamQuestion(ExamID	, QuestionID	) 
VALUES 					(	1	,		5		),
						(	2	,		10		), 
						(	3	,		4		), 
						(	4	,		3		), 
						(	5	,		7		), 
						(	6	,		10		), 
						(	7	,		2		), 
						(	8	,		10		), 
						(	9	,		9		), 
						(	10	,		8		);
                        
                        
-- QUESTION 1: TRIGGER KHÔNG CHO TẠO GROUP CÓ NGÀY TẠO TRƯỚC 1 NĂM

DROP TRIGGER IF EXISTS Trg_CheckInsertGroup;
DELIMITER $$
	CREATE TRIGGER Trg_CheckInsertGroup
	BEFORE INSERT ON `Group`
    FOR EACH ROW
    BEGIN
    DECLARE v_CreateDate DATETIME;
    SET v_CreateDate = DATE_SUB(NOW(), interval 1 year);
		IF (NEW.CreateDate <= v_CreateDate) THEN
				SIGNAL SQLSTATE '12345'
				SET MESSAGE_TEXT = 'Cant create this group';
			END IF;
    END$$
DELIMITER ;

-- Test data cho Question 1
INSERT INTO `testingsystem`.`group` (`GroupName`, `CreatorID`, `CreateDate`) 
VALUES								 ('2', '1', '2018-04-10 00:00:00');


-- QUESTION 2: TRIGGER KHÔNG CHO THÊM USER VÀO DEPARTMENT "SALE"

DROP TRIGGER IF EXISTS Trg_NotAddUserToSale;
DELIMITER $$
CREATE TRIGGER Trg_NotAddUserToSale
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
    DECLARE v_depID TINYINT;
    
    -- Lấy DepartmentID của phòng Sale từ bảng department
    SELECT d.DepartmentID INTO v_depID 
    FROM department d 
    WHERE d.DepartmentName = 'Sale';
    
    -- Kiểm tra nếu DepartmentID mới thêm bằng ID của phòng Sale
    IF (NEW.DepartmentID = v_depID) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Không thể thêm user vào phòng Sale';
    END IF;
END$$
DELIMITER ;

-- Test data cho Question 2
-- INSERT INTO `account` (`Email`, `Username`, `FullName`, `DepartmentID`, `PositionID`, `CreateDate`)
-- VALUES ('test@gmail.com', 'testuser', 'Test User', '2', '1', NOW());

-- ***********************************************************
-- QUESTION 3: TRIGGER GIỚI HẠN 5 USER TRONG 1 GROUP
-- ***********************************************************
-- Mục đích: Mỗi group chỉ được tối đa 5 user
-- Cơ chế: Đếm số user hiện có trong group trước khi thêm
-- ***********************************************************
DROP TRIGGER IF EXISTS Trg_CheckToAddAccountToGroup;
DELIMITER $$
CREATE TRIGGER Trg_CheckToAddAccountToGroup
BEFORE INSERT ON `groupaccount`
FOR EACH ROW
BEGIN
    DECLARE v_CountGroupID TINYINT;
    
    -- Đếm số user hiện có trong group
    SELECT COUNT(GA.AccountID) INTO v_CountGroupID 
    FROM groupaccount GA
    WHERE GA.GroupID = NEW.GroupID;
    
    -- Kiểm tra nếu đã có 5 user trở lên
    IF (v_CountGroupID >= 5) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Mỗi group chỉ được tối đa 5 user';
    END IF;
END$$
DELIMITER ;

-- Test data cho Question 3
-- INSERT INTO `groupaccount` (`GroupID`, `AccountID`, `JoinDate`) 
-- VALUES (1, 6, NOW());

-- QUESTION 4: TRIGGER GIỚI HẠN 10 QUESTION TRONG 1 EXAM

DROP TRIGGER IF EXISTS Trg_LimitQuesNumInExam10;
DELIMITER $$
CREATE TRIGGER Trg_LimitQuesNumInExam10
BEFORE INSERT ON `examquestion`
FOR EACH ROW
BEGIN
    DECLARE v_CountQuesInExam TINYINT;
    
    -- Đếm số question hiện có trong exam
    SELECT COUNT(EQ.QuestionID) INTO v_CountQuesInExam 
    FROM examquestion EQ
    WHERE EQ.ExamID = NEW.ExamID;
    
    -- Kiểm tra nếu đã có 10 question trở lên
    IF (v_CountQuesInExam >= 10) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Mỗi exam chỉ được tối đa 10 question';
    END IF;
END$$
DELIMITER ;

-- Test data cho Question 4
-- INSERT INTO `examquestion`(`ExamID`, `QuestionID`) VALUES (6, 2);

-- QUESTION 5: TRIGGER KHÔNG CHO XÓA TÀI KHOẢN ADMIN

DROP TRIGGER IF EXISTS Trg_DeleteAdminAccount;
DELIMITER $$
CREATE TRIGGER Trg_DeleteAdminAccount
BEFORE DELETE ON `Account`
FOR EACH ROW
BEGIN
    -- Kiểm tra nếu email là admin@gmail.com
    IF (OLD.Email = 'admin@gmail.com') THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Không thể xóa tài khoản admin';
    END IF;
END$$
DELIMITER ;

-- Test data cho Question 5
-- DELETE FROM account WHERE Email = 'admin@gmail.com';

-- QUESTION 6: TRIGGER TỰ ĐỘNG GÁN DEPARTMENT "WAITING DEPARTMENT"

DROP TRIGGER IF EXISTS Trg_SetDepWaitingRoom;
DELIMITER $$
CREATE TRIGGER Trg_SetDepWaitingRoom
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
    DECLARE v_WaitingDepartmentID TINYINT;
    
    -- Tìm ID của phòng "Waiting Department"
    SELECT D.DepartmentID INTO v_WaitingDepartmentID 
    FROM department D 
    WHERE D.DepartmentName = 'Waiting Department';
    
    -- Nếu DepartmentID là NULL, gán vào phòng chờ
    IF (NEW.DepartmentID IS NULL) THEN
        SET NEW.DepartmentID = v_WaitingDepartmentID;
    END IF;
END$$
DELIMITER ;

-- Test data cho Question 6
-- INSERT INTO `account` (`Email`, `Username`, `FullName`, `PositionID`, `CreateDate`) 
-- VALUES ('test@gmail.com', 'testuser', 'Test User', '1', NOW());


-- QUESTION 7: TRIGGER GIỚI HẠN SỐ ANSWER CHO MỖI QUESTION

DROP TRIGGER IF EXISTS Trg_SetMaxAnswer;
DELIMITER $$
CREATE TRIGGER Trg_SetMaxAnswer
BEFORE INSERT ON `answer`
FOR EACH ROW
BEGIN
    DECLARE v_CountAnsInQues TINYINT;
    DECLARE v_CountCorrectAns TINYINT;
    
    -- Đếm tổng số answers cho question này
    SELECT COUNT(A.AnswerID) INTO v_CountAnsInQues 
    FROM answer A 
    WHERE A.QuestionID = NEW.QuestionID;
    
    -- Đếm số answers đúng cho question này
    SELECT COUNT(*) INTO v_CountCorrectAns 
    FROM answer A 
    WHERE A.QuestionID = NEW.QuestionID AND A.isCorrect = 1;
    
    -- Kiểm tra giới hạn 4 answers
    IF (v_CountAnsInQues >= 4) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Mỗi question chỉ được tối đa 4 answers';
    END IF;
    
    -- Kiểm tra giới hạn 2 answers đúng
    IF (NEW.isCorrect = 1 AND v_CountCorrectAns >= 2) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Mỗi question chỉ được tối đa 2 answers đúng';
    END IF;
END$$
DELIMITER ;

-- Test data cho Question 7
-- INSERT INTO `answer` (`Content`, `QuestionID`, `isCorrect`) 
-- VALUES ('Test Answer', '1', 1);


-- QUESTION 8: TRIGGER CHUẨN HÓA GIỚI TÍNH

DROP TRIGGER IF EXISTS Trg_GenderFromInput;
DELIMITER $$
CREATE TRIGGER Trg_GenderFromInput
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
    -- Chuyển đổi từ tiếng Việt sang mã chuẩn
    IF NEW.Gender = 'Nam' THEN
        SET NEW.Gender = 'M';
    ELSEIF NEW.Gender = 'Nữ' THEN
        SET NEW.Gender = 'F';
    ELSEIF NEW.Gender = 'Chưa xác định' THEN
        SET NEW.Gender = 'U';
    END IF;
END$$
DELIMITER ;

-- QUESTION 9: TRIGGER KHÔNG CHO XÓA EXAM MỚI TẠO 2 NGÀY

DROP TRIGGER IF EXISTS Trg_CheckBefDelExam;
DELIMITER $$
CREATE TRIGGER Trg_CheckBefDelExam
BEFORE DELETE ON `exam`
FOR EACH ROW
BEGIN
    DECLARE v_TwoDaysAgo DATETIME;
    
    -- Tính thời điểm 2 ngày trước
    SET v_TwoDaysAgo = DATE_SUB(NOW(), INTERVAL 2 DAY);
    
    -- Kiểm tra nếu exam được tạo trong vòng 2 ngày gần đây
    IF (OLD.CreateDate > v_TwoDaysAgo) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Không thể xóa exam mới tạo trong 2 ngày gần đây';
    END IF;
END$$
DELIMITER ;

-- Test data cho Question 9
-- DELETE FROM exam WHERE ExamID = 1;

-- QUESTION 10: TRIGGER KHÔNG CHO UPDATE/DELETE QUESTION ĐÃ CÓ TRONG EXAM

-- Trigger cho UPDATE question
DROP TRIGGER IF EXISTS Trg_CheckBefUpdateQues;
DELIMITER $$
CREATE TRIGGER Trg_CheckBefUpdateQues
BEFORE UPDATE ON `question`
FOR EACH ROW
BEGIN
    DECLARE v_CountQuesInExam TINYINT DEFAULT 0;
    
    -- Đếm số exam có chứa question này
    SELECT COUNT(*) INTO v_CountQuesInExam 
    FROM examquestion 
    WHERE QuestionID = NEW.QuestionID;
    
    -- Nếu question đã có trong exam thì không cho update
    IF (v_CountQuesInExam > 0) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Không thể update question đã có trong exam';
    END IF;
END$$
DELIMITER ;

-- Trigger cho DELETE question
DROP TRIGGER IF EXISTS Trg_CheckBefDeleteQues;
DELIMITER $$
CREATE TRIGGER Trg_CheckBefDeleteQues
BEFORE DELETE ON `question`
FOR EACH ROW
BEGIN
    DECLARE v_CountQuesInExam TINYINT DEFAULT 0;
    
    -- Đếm số exam có chứa question này
    SELECT COUNT(*) INTO v_CountQuesInExam 
    FROM examquestion 
    WHERE QuestionID = OLD.QuestionID;
    
    -- Nếu question đã có trong exam thì không cho delete
    IF (v_CountQuesInExam > 0) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Không thể delete question đã có trong exam';
    END IF;
END$$
DELIMITER ;

-- Test data cho Question 10
-- UPDATE `question` SET `Content` = 'Updated Content' WHERE `QuestionID` = 1;
-- DELETE FROM `question` WHERE `QuestionID` = 1;

-- QUESTION 12: PHÂN LOẠI THỜI LƯỢNG EXAM

SELECT 
    e.ExamID,
    e.Code,
    e.Title,
    e.Duration AS 'Thời lượng (phút)',
    e.CreateDate AS 'Ngày tạo',
    CASE 
        WHEN e.Duration <= 30 THEN 'Short time'
        WHEN e.Duration <= 60 THEN 'Medium time'
        ELSE 'Long time'
    END AS 'Phân loại thời lượng'
FROM exam e
ORDER BY e.ExamID;

-- QUESTION 13: PHÂN LOẠI SỐ LƯỢNG USER TRONG GROUP

SELECT 
    GA.GroupID AS 'Mã Group',
    COUNT(GA.AccountID) AS 'Số lượng user',
    CASE 
        WHEN COUNT(GA.AccountID) <= 5 THEN 'few'
        WHEN COUNT(GA.AccountID) <= 20 THEN 'normal'
        ELSE 'higher'
    END AS 'the_number_user_amount'
FROM groupaccount GA
GROUP BY GA.GroupID
ORDER BY GA.GroupID;

-- QUESTION 14: THỐNG KÊ USER THEO DEPARTMENT

-- Sử dụng LEFT JOIN
SELECT 
    D.DepartmentID AS 'Mã phòng',
    D.DepartmentName AS 'Tên phòng ban',
    CASE 
        WHEN COUNT(A.AccountID) = 0 THEN 'Không có User'
        ELSE CAST(COUNT(A.AccountID) AS CHAR)
    END AS 'Số lượng user'
FROM department D
LEFT JOIN account A ON D.DepartmentID = A.DepartmentID
GROUP BY D.DepartmentID, D.DepartmentName
ORDER BY D.DepartmentID;
