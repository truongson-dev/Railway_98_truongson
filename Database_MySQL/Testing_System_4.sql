/*============================== CREATE DATABASE =======================================*/
DROP DATABASE IF EXISTS Testing_System_4;
CREATE DATABASE Testing_System_4;
USE Testing_System_4;

/*============================== CREATE TABLE==========================================*/

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
                            
-- =================Testing_System_Assignment_3===================
-- File: Testing_System_Assignment_3.sql
-- Exercise 1: Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 		A.Email, A.Username	, A.FullName, D.DepartmentName
FROM 		`Account` A 
INNER JOIN 	Department D	ON 	A.DepartmentID = D.DepartmentID;

-- Question 2: Lấy account tạo sau ngày 20/12/2010
SELECT	* FROM		`Account`
WHERE		CreateDate < '2020-12-20';

-- Question 3: Lấy tất cả các developer
SELECT		A.FullName, A.Email, P.PositionName
FROM		`Account` A 
INNER JOIN 	Position P ON A.PositionID = P.PositionID
WHERE		P.PositionName = 'Dev';

-- Question 4: Phòng ban có >2 nhân viên
SELECT 		D.DepartmentName, count(a.DepartmentID) AS SL  FROM account A
INNER JOIN 	department D ON a.DepartmentID = D.DepartmentID
GROUP BY 	A.DepartmentID
HAVING COUNT(A.DepartmentID) >3;


-- Question 5: Câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT E.QuestionID, Q.Content FROM examquestion E
INNER JOIN question Q ON Q.QuestionID = E.QuestionID
GROUP BY E.QuestionID
HAVING count(E.QuestionID) = (SELECT MAX(countQues) as maxcountQues FROM (
SELECT COUNT(E.QuestionID) AS countQues FROM examquestion E
	GROUP BY E.QuestionID) AS countTable);

WITH cte_SL AS(
SELECT count(1) as SL FROM examquestion GROUP BY QuestionID)
SELECT 			q.QuestionID, q.Content, count(1) FROM examquestion ex
INNER JOIN		question q ON q.QuestionID = ex.QuestionID
GROUP BY 		QuestionID
HAVING count(1) = (SELECT max(SL) FROM cte_SL);


-- Question 6: Thống kê mỗi Category Question được sử dụng trong bao nhiêu Question
SELECT cq.CategoryID, cq.CategoryName, count(q.CategoryID) FROM categoryquestion cq 
JOIN 	question q ON cq.CategoryID = q.CategoryID
GROUP BY q.CategoryID;

SELECT 		q.CategoryID,cq.CategoryName ,COUNT(q.CategoryID) FROM question q 
INNER JOIN 	categoryquestion cq ON cq.CategoryID = q.CategoryID
GROUP BY 	q.CategoryID;


-- Question 7: Thống kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT 		q.QuestionID, q.Content , count(eq.QuestionID) FROM examquestion eq
RIGHT JOIN 	question q ON q.QuestionID = eq.QuestionID
GROUP BY 	q.QuestionID;


-- Question 8: Question có nhiều câu trả lời nhất
-- cách 1: 
WITH cte_Max_Answer_Question AS (
	SELECT COUNT(*) AS Max_Answer_Question FROM Answer GROUP BY QuestionID
)
SELECT q.QuestionID, q.Content, COUNT(*) AS Answer_Question FROM Question q
INNER JOIN Answer a ON q.QuestionID = a.QuestionID
GROUP BY QuestionID
HAVING COUNT(*) = (SELECT MAX(Max_Answer_Question) FROM cte_Max_Answer_Question);


-- cách 2:
SELECT 		Q.QuestionID, Q.Content, count(A.QuestionID) FROM answer A
INNER JOIN 	question Q ON Q.QuestionID = A.QuestionID
GROUP BY 	A.QuestionID
HAVING count(A.QuestionID) = (SELECT max(countQues) FROM
(SELECT count(B.QuestionID) AS countQues FROM answer B
GROUP BY 	B.QuestionID) AS countAnsw);

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT		G.GroupID, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		GroupAccount GA 
JOIN 		`Group` G ON GA.GroupID = G.GroupID
GROUP BY	G.GroupID
ORDER BY	G.GroupID ASC;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT P.PositionID, P.PositionName, count( A.PositionID) AS SL FROM account A
INNER JOIN position P ON A.PositionID = P.PositionID
GROUP BY A.PositionID
HAVING count(A.PositionID)= (SELECT MIN(minP) FROM(
SELECT count(B.PositionID) AS minP FROM account B
GROUP BY B.PositionID) AS minPA);

SELECT 		P.PositionID, P.PositionName, COUNT(A.PositionID) AS 'SO LUONG'
FROM		Position P 
INNER JOIN 	`Account` A ON P.PositionID = A.PositionID
GROUP BY 	P.PositionID
HAVING		COUNT(A.PositionID)	=	(SELECT MIN(CountP)
FROM		(SELECT 	COUNT(P.PositionID) AS CountP
FROM		Position P 
INNER JOIN 	`Account` A ON P.PositionID = A.PositionID		
GROUP BY	P.PositionID) AS MinCountP);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT d.DepartmentID,d.DepartmentName, p.PositionName, count(p.PositionName) FROM `account` a
INNER JOIN department d ON a.DepartmentID = d.DepartmentID
INNER JOIN position p ON a.PositionID = p.PositionID
GROUP BY d.DepartmentID, p.PositionID;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, … 
SELECT 
    Q.QuestionID, Q.Content AS QuestionContent,
    TQ.TypeName, A.FullName AS CreatorName,
    ANS.Content AS AnswerContent
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
SELECT TQ.TypeID, TQ.TypeName, COUNT(Q.TypeID) AS SL FROM question Q
INNER JOIN typequestion TQ ON Q.TypeID = TQ.TypeID
GROUP BY Q.TypeID;

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
SELECT q.QuestionID FROM answer a
RIGHT JOIN question q on a.QuestionID = q.QuestionID 
WHERE a.AnswerID IS NULL;

-- Exercise 2: Union
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT A.FullName FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GA.GroupID = 1;

-- b) Lấy các account thuộc nhóm thứ 2
SELECT A.FullName FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GA.GroupID = 2;

-- c) Ghép 2 kết quả không trùng nhau
SELECT 		A.FullName
FROM 		`Account` A
JOIN 		GroupAccount GA ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 1
UNION
SELECT 		A.FullName
FROM 		`Account` A
JOIN 		GroupAccount GA ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 2;
-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
SELECT 		g.GroupName, COUNT(ga.GroupID) AS SL
FROM 		 GroupAccount ga
JOIN 		`Group` g ON ga.GroupID = g.GroupID
GROUP BY	g.GroupID
HAVING 		COUNT(ga.GroupID) >= 5;

-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT 		g.GroupName, COUNT(ga.GroupID) AS SL
FROM 		 GroupAccount ga
JOIN 		`Group` g ON ga.GroupID = g.GroupID
GROUP BY	g.GroupID
HAVING 		COUNT(ga.GroupID) <= 7;

-- c) Ghép 2 kết quả
SELECT 		g.GroupName, COUNT(ga.GroupID) AS SL
FROM 		 GroupAccount ga
JOIN 		`Group` g ON ga.GroupID = g.GroupID
GROUP BY	g.GroupID
HAVING 		COUNT(ga.GroupID) >= 5
UNION
SELECT 		g.GroupName, COUNT(ga.GroupID) AS SL
FROM 		 GroupAccount ga
JOIN 		`Group` g ON ga.GroupID = g.GroupID
GROUP BY	g.GroupID
HAVING 		COUNT(ga.GroupID) <= 7;
-- =============================BAI TAP TREN LOP=====================================
-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất

CREATE OR REPLACE VIEW vw_groupAccount AS
WITH cte_maxAccount AS(
SELECT count(*) AS Amount FROM groupaccount ga
GROUP BY ga.AccountID
)
SELECT ga.AccountID, a.FullName, COUNT(*) Amount FROM groupaccount ga
INNER JOIN account a ON a.AccountID = ga.AccountID
GROUP BY ga.AccountID
HAVING COUNT(*) = (SELECT max(Amount) FROM cte_maxAccount);


-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW vw_ContenTren18Tu AS
 	SELECT *FROM Question
 	WHERE LENGTH(Content) > 18;
    
SELECT *FROM  vw_ContenTren18Tu;

DROP VIEW vw_ContenTren18Tu;

-- Stored Procedure
-- Tạo 1 sp lấy danh sách account
DROP PROCEDURE IF EXISTS sp_getListAccount;
DELIMITER $$
CREATE PROCEDURE sp_getListAccount()
	BEGIN
		 SELECT * FROM account;
	END$$
DELIMITER ;

CALL sp_getListAccount();

-- Tạo 1 sp lấy account có id = 2
DROP PROCEDURE IF EXISTS sp_getAccountByAccountID;
DELIMITER $$
CREATE PROCEDURE sp_getAccountByAccountID(IN in_AccountID TINYINT)
	BEGIN
		 SELECT * FROM account WHERE AccountID = in_AccountID;
	END$$
DELIMITER ;

CALL sp_getAccountByAccountID(2);

-- Viết SP để INSERT dữ liệu vào bảng Account với thông tin đầu vào qua các tham số
DROP PROCEDURE IF EXISTS sp_InsertAccount;
DELIMITER $$
CREATE PROCEDURE sp_InsertAccount(
    IN p_Email        VARCHAR(50),
    IN p_Username     VARCHAR(50),
    IN p_FullName     NVARCHAR(50),
    IN p_DepartmentID TINYINT UNSIGNED,
    IN p_PositionID   TINYINT UNSIGNED
)
BEGIN
    INSERT INTO Account (
        Email,
        Username,
        FullName,
        DepartmentID,
        PositionID
    ) VALUES (
        p_Email,
        p_Username,
        p_FullName,
        p_DepartmentID,
        p_PositionID
    );
    SELECT LAST_INSERT_ID() AS AccountID;
END$$
DELIMITER ;

CALL sp_insertAccount(
    'nguyenvana@gmail.com',
    'nguyenvanb',
    'Truong Thanh Son',
    2,   
    1    
);

SELECT * FROM account;

-- Xóa tài khoản người dùng theo ID
DROP PROCEDURE IF EXISTS sp_DeleteAccountByID;
DELIMITER $$
CREATE PROCEDURE sp_DeleteAccountByID(
    IN p_AccountID TINYINT UNSIGNED
)
BEGIN
    DELETE FROM account WHERE AccountID =p_AccountID;
END$$
DELIMITER ;
CALL sp_DeleteAccountByID(5);



-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS sp_GetAccFromDep;
DELIMITER $$
CREATE PROCEDURE sp_GetAccFromDep(IN in_dep_name NVARCHAR(50))
BEGIN
	SELECT A.AccountID, A.FullName, D.DepartmentName FROM `account` A
	INNER JOIN department D ON D.DepartmentID = A.DepartmentID
	WHERE D.DepartmentName = in_dep_name;
END$$
DELIMITER ;

Call sp_GetAccFromDep('Dev');


 