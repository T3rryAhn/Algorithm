SELECT a.user_id AS USER_ID, a.nickname AS NICKNAME, CONCAT(a.city, ' ', a.street_address1, ' ', a.street_address2) AS 전체주소, CONCAT(SUBSTR(a.tlno, 1, 3), '-', SUBSTR(a.tlno, 4, 4), '-', SUBSTR(a.tlno, 8, 4)) AS TLNO
FROM used_goods_user AS a
JOIN (
    SELECT writer_id AS user_id, COUNT(*) AS count
    FROM used_goods_board
    GROUP BY user_id
    HAVING count >= 3
) AS b ON a.user_id = b.user_id
ORDER BY a.user_id DESC;