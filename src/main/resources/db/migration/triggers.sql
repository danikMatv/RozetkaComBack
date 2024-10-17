CREATE OR REPLACE FUNCTION add_stock_if_below_threshold()
    RETURNS TRIGGER AS $$
BEGIN
    IF NEW.stock_quantity < 10 THEN
        NEW.stock_quantity := NEW.stock_quantity + 50;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_add_stock
    BEFORE UPDATE ON product
    FOR EACH ROW
EXECUTE FUNCTION add_stock_if_below_threshold();



CREATE OR REPLACE FUNCTION set_price_if_below_threshold()
    RETURNS TRIGGER AS $$
BEGIN
    IF NEW.stock_quantity < 20 THEN
        NEW.price := (old.price + 5.00);
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_set_price
    BEFORE UPDATE ON product
    FOR EACH ROW
EXECUTE FUNCTION set_price_if_below_threshold();
