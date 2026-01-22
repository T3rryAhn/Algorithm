SELECT COUNT(*) AS COUNT
FROM ecoli_data
WHERE genotype & 5 AND genotype & 2 = 0;