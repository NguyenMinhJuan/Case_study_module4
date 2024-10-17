use casec05;
CREATE PROCEDURE GetCouponsByProduct(IN productId BIGINT)
BEGIN
    SELECT
        c.code AS code,
        c.discount_value AS discountValue,
        c.expiry_date AS expiryDate
    FROM
        product_coupon pc
            JOIN
        coupons c ON pc.coupon_id = c.coupon_id
    WHERE
        pc.product_id = productId;
END;

