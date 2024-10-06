WITH RANKED_COLONY AS (
    SELECT
        ID,
        SIZE_OF_COLONY,
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS RANK_GROUP
    FROM
        ECOLI_DATA
)
SELECT
    ID,
    CASE 
        WHEN RANK_GROUP = 1 THEN 'CRITICAL'
        WHEN RANK_GROUP = 2 THEN 'HIGH'
        WHEN RANK_GROUP = 3 THEN 'MEDIUM'
        WHEN RANK_GROUP = 4 THEN 'LOW'
    END AS COLONY_NAME
FROM
    RANKED_COLONY
ORDER BY
    ID;