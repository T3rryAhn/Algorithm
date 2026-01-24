# 목표
## max price food의 id, name, code, category, price (결국 전부 *)

# 해결 전략
## 가격 컬럼을 내림차순후 상위 1개만 출력

SELECT *
FROM food_product
ORDER BY price DESC
LIMIT 1;