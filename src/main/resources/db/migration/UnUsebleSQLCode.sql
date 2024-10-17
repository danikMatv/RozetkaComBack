--  calculate the total order price.
CREATE FUNCTION calculate_total_order_price(order_id INT)
    RETURNS DECIMAL(10, 2)
    LANGUAGE plpgsql
AS $$
DECLARE
total_price DECIMAL(10, 2);
BEGIN
SELECT unit_price * quantity INTO total_price
FROM orders
WHERE id = order_id;
RETURN total_price;
END;
$$;

-- get the stock quantity of a specific product
CREATE FUNCTION get_stock_quantity(product_id INT)
    RETURNS INT
    LANGUAGE plpgsql
AS $$
DECLARE
stock INT;
BEGIN
SELECT stock_quantity INTO stock
FROM product
WHERE id = product_id;
RETURN stock;
END;
$$;

--update the stock quantity after an order
CREATE PROCEDURE update_stock(product_id INT, quantity INT)
    LANGUAGE plpgsql
AS $$
BEGIN
UPDATE product
SET stock_quantity = stock_quantity - quantity
WHERE id = product_id;
END;
$$;