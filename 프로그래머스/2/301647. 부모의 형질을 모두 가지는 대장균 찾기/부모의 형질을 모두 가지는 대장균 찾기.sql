SELECT a.id AS ID, a.genotype AS GENOTYPE, b.genotype AS PARENT_GENOTYPE
FROM ecoli_data AS a
JOIN ecoli_data AS b ON a.parent_id = b.id
WHERE b.genotype & a.genotype = b.genotype
ORDER BY id;