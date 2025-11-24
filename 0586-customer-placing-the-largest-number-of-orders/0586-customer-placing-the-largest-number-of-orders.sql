# Write your MySQL query statement below

SELECT customer_number FROM Orders
Group By customer_number
ORDER BY COUNT(order_number) DESC
LIMIT 1;
