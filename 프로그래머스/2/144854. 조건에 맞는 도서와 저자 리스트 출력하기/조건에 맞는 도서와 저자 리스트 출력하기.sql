-- 코드를 입력하세요
SELECT a.book_id, b.author_name, DATE_FORMAT(a.published_date, '%Y-%m-%d')
FROM book AS a
JOIN author AS b ON a.author_id = b.author_id
WHERE a.category = '경제'
ORDER BY a.published_date ASC;