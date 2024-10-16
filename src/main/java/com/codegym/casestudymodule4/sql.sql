use casec05;
create
    definer = root@localhost procedure GetTop8MostPurchasedProducts()
BEGIN
    SELECT
        p.product_id AS productId,
        p.name AS name,
        p.description AS description,
        p.price AS price,
        p.image_url AS imageUrl,
        p.status AS status,
        p.is_promoted AS isPromoted
    FROM
        products p
            JOIN
        order_product op ON p.product_id = op.product_id
    GROUP BY
        p.product_id
    ORDER BY
        COUNT(op.order_id) DESC
    LIMIT 8;
END;