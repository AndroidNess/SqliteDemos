CREATE TABLE User(ID INT NOT NULL, name TEXT NOT NULL, lastName TEXT NOT NULL);

CREATE TABLE Notes(ID INT NOT NULL,
                   title TEXT NOT NULL,
                   content TEXT NOT NULL,
                   userId INT NOT NULL);


INSERT INTO User(ID, name, lastName) VALUES(1, 'Forest', 'Gump');


UPDATE User SET name = 'Moshe', lastName = 'Cohen'
WHERE ID = 1;


DELETE FROM User WHERE name LIKE 'M%';

SELECT * FROM User
WHERE name LIKE 'B%'

SELECT CustomerName, OrderDate FROM Customers JOIN Orders ON Customers.CustomerID = Orders.CustomerID;

SELECT MAX(OrderDate) FROM Orders;

SELECT CustomerName, OrderDate
FROM Customers JOIN Orders ON Customers.CustomerID = Orders.CustomerID
WHERE OrderDate = '1996-07-04';

--Order By:

SELECT CustomerName, OrderDate
FROM Customers JOIN Orders ON Customers.CustomerID = Orders.CustomerID
ORDER BY OrderDate DESC