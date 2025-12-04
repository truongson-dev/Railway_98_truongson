-- Tạo database
CREATE DATABASE IF NOT EXISTS CompanyDB;
USE CompanyDB;

-- Bảng CUSTOMER
CREATE TABLE CUSTOMER (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    Name       VARCHAR(100) NOT NULL,
    Phone      VARCHAR(20),
    Email      VARCHAR(100),
    Address    VARCHAR(255),
    Note       VARCHAR(255)
);

-- Bảng CAR
CREATE TABLE CAR (
    CarID   INT PRIMARY KEY,
    Maker   ENUM('HONDA','TOYOTA','NISSAN') NOT NULL,
    Model   VARCHAR(100),
    Year    INT,
    Color   VARCHAR(20),
    Note    VARCHAR(255)
);

-- Bảng CAR_ORDER
CREATE TABLE CAR_ORDER (
    OrderID         INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID      INT,
    CarID           INT,
    Amount          INT DEFAULT 1,
    SalePrice       DECIMAL(12,2),
    OrderDate       DATE,
    DeliveryDate    DATE,
    DeliveryAddress VARCHAR(255),
    Status          TINYINT DEFAULT 0,   -- 0: ordered, 1: delivered, 2: canceled
    Note            VARCHAR(255),
    FOREIGN KEY (CustomerID) REFERENCES CUSTOMER(CustomerID),
    FOREIGN KEY (CarID) REFERENCES CAR(CarID)
);

-- ===== INSERT DỮ LIỆU =====
INSERT INTO CUSTOMER(Name, Phone, Email, Address, Note) VALUES
('Sơn', '0901123456', 'son@gmail.com', 'Da Nang', ''),
('Bình', '0902234567', 'binh@gmail.com', 'Hue', ''),
('Chi', '0903345678', 'chi@gmail.com', 'Ha Noi', ''),
('Phong', '0904456789', 'phong@gmail.com', 'Da Nang', ''),
('Linh', '0905567890', 'linh@gmail.com', 'HCM', '');

INSERT INTO CAR(CarID, Maker, Model, Year, Color) VALUES
(1,'HONDA','Civic',2022,'Black'),
(2,'TOYOTA','Camry',2023,'White'),
(3,'NISSAN','Sunny',2021,'Yellow'),
(4,'HONDA','Accord',2023,'Red'),
(5,'TOYOTA','Vios',2022,'Blue');

INSERT INTO CAR_ORDER(CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, Status)
VALUES
(1,1,1,30000,'2025-01-10','2025-02-01','Da Nang',1),
(1,2,1,28000,'2025-03-12','2025-04-02','Da Nang',0),
(2,5,2,45000,'2025-03-10','2025-04-15','Hue',1),
(3,3,1,18000,'2024-09-20','2024-10-10','Ha Noi',2),
(4,4,3,90000,'2025-04-10','2025-05-05','Da Nang',1);


-- Requirement 2: Lấy tên khách + tổng xe đã mua (sắp tăng)
SELECT 
    c.Name,
    SUM(co.Amount) AS TotalCars
FROM CUSTOMER c
JOIN CAR_ORDER co ON c.CustomerID = co.CustomerID
GROUP BY c.CustomerID
ORDER BY TotalCars ASC;

-- Requirement 3: Function trả về hãng bán nhiều nhất năm nay
DELIMITER $$

CREATE FUNCTION F_BestMakerThisYear()
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE bestMaker VARCHAR(20);

    SELECT Maker
    INTO bestMaker
    FROM CAR c
    JOIN CAR_ORDER co ON c.CarID = co.CarID
    WHERE YEAR(co.OrderDate) = YEAR(CURDATE())
    GROUP BY Maker
    ORDER BY SUM(co.Amount) DESC
    LIMIT 1;

    RETURN bestMaker;
END$$

DELIMITER ;

SELECT F_BestMakerThisYear();
-- Requirement 4: Procedure xóa các đơn hàng bị hủy của năm trước
DELIMITER $$

CREATE PROCEDURE P_DeleteOldCanceledOrders()
BEGIN
    DECLARE deletedCount INT;

    DELETE FROM CAR_ORDER
    WHERE Status = 2
    AND YEAR(OrderDate) < YEAR(CURDATE());

    SET deletedCount = ROW_COUNT();

    SELECT CONCAT('Deleted Orders: ', deletedCount) AS Result;
END$$

DELIMITER ;

CALL P_DeleteOldCanceledOrders();
-- Requirement 5: Procedure in danh sách đơn hàng theo CustomerID 	
DELIMITER $$

CREATE PROCEDURE P_GetOrderByCustomer(IN pCustomerID INT)
BEGIN
    SELECT 
        c.Name AS CustomerName,
        co.OrderID,
        co.Amount,
        car.Maker
    FROM CUSTOMER c
    JOIN CAR_ORDER co ON c.CustomerID = co.CustomerID
    JOIN CAR car ON co.CarID = car.CarID
    WHERE c.CustomerID = pCustomerID;
END$$

DELIMITER ;

CALL P_GetOrderByCustomer(1);
-- Requirement 6: Trigger validate DeliveryDate >= 15 ngày
DELIMITER $$

CREATE TRIGGER trg_CheckDeliveryDate
BEFORE INSERT ON CAR_ORDER
FOR EACH ROW
BEGIN
    IF NEW.DeliveryDate < DATE_ADD(NEW.OrderDate, INTERVAL 15 DAY) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Delivery date must be at least 15 days after order date.';
    END IF;
END$$

DELIMITER ;






