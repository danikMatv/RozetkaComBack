--  Customers
CREATE TABLE customer
(
    id           INT generated always as identity,
    first_name   VARCHAR(255)        NOT NULL,
    last_name    VARCHAR(255)        NOT NULL,
    email        VARCHAR(255) UNIQUE not null,
    phone_number VARCHAR(20),
    password     VARCHAR(50),

    constraint customers_pk primary key (id)
);
--  category
CREATE TABLE category
(
    id            INT generated always as identity,
    category_name VARCHAR(255) UNIQUE NOT NULL,

    constraint categories_pk primary key (id)
);
--  product
CREATE TABLE product
(
    id             INT generated always as identity,
    product_name   VARCHAR(255),
    category_id    INT,
    price          DECIMAL(10, 2),
    stock_quantity INT,


    constraint products_pk primary key (id),
    constraint products_category_fk foreign key (category_id) references category
);

CREATE TABLE supplier_product
(
    supplier_id INT NOT NULL,
    product_id  INT NOT NULL,
    PRIMARY KEY (supplier_id, product_id),
    FOREIGN KEY (supplier_id) REFERENCES supplier (id),
    FOREIGN KEY (product_id) REFERENCES product (id)
);


--  Suppliers
CREATE TABLE supplier
(
    id            INT generated always as identity,
    supplier_name VARCHAR(255) NOT NULL,
    contact_email VARCHAR(255),
    contact_phone VARCHAR(20),

    constraint suppliers_pk primary key (id)

);

--  orders
CREATE TABLE orders
(
    id          INT generated always as identity,
    unit_price  DECIMAL(10, 2) NOT NULL,
    quantity    INT            NOT NULL,
    description VARCHAR(255),
    customer_id INT,
    product_id  INT,

    constraint orders_pk primary key (id),
    constraint order_product_fk foreign key (product_id) references product,
    constraint order_customer_fk foreign key (customer_id) references customer
);

--  ProductSupplier
CREATE TABLE product_supplier
(
    id          INT generated always as identity,
    product_id  INT,
    supplier_id INT,

    constraint product_suppliers_pk primary key (id),
    constraint product_suppliers_product_fk foreign key (product_id) references product,
    constraint product_suppliers_supplier_fk foreign key (supplier_id) references supplier
);

CREATE TABLE admin
(
    id       INT generated always as identity,
    name     varchar(20) NOT NULL,
    password varchar(30) NOT NULL,

    constraint admin_pk primary key (id)
);

CREATE TABLE shipping
(
    id          INT generated always as identity,
    start_place VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    duration    INT          NOT NULL,
    order_id    INT          NOT NULL,
    customer_id INT          NOT NULL,

    constraint shipping_pf primary key (id),
    constraint shipping_order_fk foreign key (order_id) references orders,
    constraint shipping_customer_fk foreign key (customer_id) references customer
)
