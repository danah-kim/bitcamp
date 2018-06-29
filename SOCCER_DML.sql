-- SOCCER_SQL_001
-- ���̺��� ��
SELECT COUNT(*) ���̺��Ǽ�
FROM tab;


-- SOCCER_SQL_002
-- ��ü �౸�� ���
SELECT team_name "��ü �౸�� ���"
FROM team
ORDER BY team_name desc
;


-- SOCCER_SQL_003 : ����������(�ߺ�����, ������ �������� ����)
-- NVL2(����, ��, ����)
SELECT DISTINCT NVL2(position, position, '����') "������"
FROM player;


-- SOCCER_SQL_004
-- ������(ID: K02) ��Ű��
SELECT player_name
FROM player
WHERE team_id = 'K02'
    AND position = 'GK'
ORDER BY player_name
;

SELECT p.player_name
FROM player p
WHERE P.team_id LIKE((
    SELECT t.team_id
    FROM team t
    WHERE team_name LIKE('�Ｚ�������')))
    AND position = 'GK'
ORDER BY player_name
;


-- SOCCER_SQL_005
-- ������(ID: K02) && Ű�� 170 �̻� ���� && ���� ��
-- substr(���ڿ�, ������ġ, ��Ÿ������)
-- '��__' // 3�ڸ� �� ù��° ���ڰ� '��'�ΰ��
-- '��%' // '��'�� �����ϴ� ��� ��
-- '%��' // '��'�� ������ ��� ��
SELECT position ������, player_name �̸�
FROM player
WHERE team_id LIKE 'K02'
    AND height >= 170
    --AND SUBSTR(player_name, 0, 1) LIKE '��'
    AND player_name LIKE '%��%'
;

SELECT p.position ������, player_name �̸�
FROM player p
WHERE P.team_id LIKE((
    SELECT t.team_id
    FROM team t
    WHERE team_name LIKE('�Ｚ�������')))
    AND height >= 170
    --AND SUBSTR(player_name, 0, 1) LIKE '��'
    AND player_name LIKE '%��%'
;
 

 -- SOCCER_SQL_006
-- ������(ID: K02) ������ �̸�,
-- Ű�� ������ ����Ʈ (���� cm �� kg ����)
-- Ű�� �����԰� ������ "0" ǥ��
-- Ű ��������
-- CONCAT(1,2) // '12' ǥ��
SELECT player_name || '����' �̸�, NVL2(height, height, 0) || 'cm' Ű, NVL2(weight, weight, 0 ) || 'kg' ������
--CONCAT(player_name, '����') �̸�, CONCAT(NVL2(height, height, 0),'cm') Ű, CONCAT(NVL2(weight, weight, 0),'kg') ������
FROM player
WHERE team_id LIKE 'K02'
ORDER BY height desc
;

SELECT p.player_name || '����' �̸�, NVL2(height, height, 0) || 'cm' Ű, NVL2(weight, weight, 0 ) || 'kg' ������
--CONCAT(player_name, '����') �̸�, CONCAT(NVL2(height, height, 0),'cm') Ű, CONCAT(NVL2(weight, weight, 0),'kg') ������
FROM player p
WHERE P.team_id LIKE((
    SELECT t.team_id
    FROM team t
    WHERE team_name LIKE('�Ｚ�������')))
    AND p.position LIKE 'GK'
ORDER BY height desc
;


-- SOCCER_SQL_007
-- ������(ID: K02) ������ �̸�,
-- Ű�� ������ ����Ʈ (���� cm �� kg ����)
-- Ű�� �����԰� ������ "0" ǥ��
-- BMI���� 
-- Ű ��������BMI = ������ / Ű�� �μ�, ���⼭ �����Դ� kg, Ű�� m �����̴�. ���� ���ڸ�, ������ 55kg�� Ű 1.68m�� ����� BMI�� 55kg/(1.68m)^2 = 19.4�̴�
SELECT player_name || '����' �̸�, NVL2(height, height, 0) || 'cm' Ű, NVL2(weight, weight, 0 ) || 'kg' ������, ROUND((weight/((height*height)/10000)),2) BMI������
FROM player
WHERE team_id LIKE 'K02'
ORDER BY height desc
;

SELECT P.player_name || '����' �̸�, NVL2(height, height, 0) || 'cm' Ű, NVL2(weight, weight, 0 ) || 'kg' ������, ROUND((weight/((height*height)/10000)),2) BMI������
FROM player P
WHERE P.team_id LIKE((
    SELECT t.team_id
    FROM team t
    WHERE team_name LIKE('�Ｚ�������')))
    AND p.position LIKE 'GK'
ORDER BY height desc
;

-- SOCCER_SQL_008
-- ������(ID: K02) �� ������(ID: K10)������ �� ��
-- MF �������� ����
-- ���� ��������
 SELECT t.team_name, p.position, p.player_name
 FROM team t, player p
 WHERE t.team_id LIKE p.team_id
    AND t.team_id IN('K10', 'K02')
    AND p.position LIKE 'GK'
ORDER BY t.team_name, p.player_name
;

SELECT t.team_name, p.position, p.player_name
FROM player p -- �ְ� �Ǵ� table
    INNER JOIN team t
    ON t.team_id LIKE p.team_id
WHERE t.team_id IN('K10', 'K02')
    AND p.position LIKE 'GK'
ORDER BY t.team_name, p.player_name
;

SELECT t.team_name, p.position, p.player_name
FROM player p -- �ְ� �Ǵ� table
    JOIN team t
    ON t.team_id LIKE p.team_id
WHERE t.team_id IN((
    SELECT t.team_id
    FROM team t
    WHERE team_name IN('�Ｚ�������','��Ƽ��')))
    AND p.position LIKE 'GK'
ORDER BY t.team_name, p.player_name
;


-- SOCCER_SQL_009
-- ������(ID: K02) �� ������(ID: K10)������ �� ��
-- Ű�� 180 �̻� 183 ������ ������
-- ����, ����� ��������
SELECT p.height || 'cm' Ű, t.team_name ����, p.player_name �̸�
FROM team t, player p
WHERE t.team_id LIKE p.team_id
    AND t.team_id IN ('K02', 'K10')
    AND p.height BETWEEN 180 AND 183
ORDER BY p.height, p.player_name, t.team_name
;

SELECT p.height || 'cm' Ű, t.team_name ����, p.player_name �̸�
FROM player p
    JOIN team t
    ON t.team_id LIKE p.team_id
WHERE t.team_id IN ('K02', 'K10')
    AND p.height BETWEEN 180 AND 183
ORDER BY p.height, p.player_name, t.team_name
;

SELECT p.height || 'cm' Ű, t.team_name ����, p.player_name �̸�
FROM player p
    JOIN team t
    ON t.team_id LIKE p.team_id
WHERE t.team_id IN ((
    SELECT t.team_id
    FROM team t
    WHERE t.team_name IN('�Ｚ�������','��Ƽ��')
))
    AND p.height BETWEEN 180 AND 183
ORDER BY p.height, p.player_name, t.team_name
;


--SOCCER_SQL_010
-- ��� ������ ��
-- �������� �������� ���� �������� ���� �̸�
-- ����, ����� ��������
SELECT t.team_name, p.player_name, p.position
FROM player p
    JOIN team t
    ON p.team_id LIKE t.team_id
WHERE p.position IS NULL
ORDER BY t.team_name, p.player_name
;


-- SOCCER_SQL_011
-- SOCCER_SQL_011
--  ���� ��Ÿ����� �����Ͽ�
-- ���̸�, ��Ÿ��� �̸� ���
SELECT t.team_name ����, s.stadium_name ��Ÿ���
FROM stadium s
    JOIN team t
    ON s.stadium_id LIKE t.stadium_id
ORDER BY t.team_name, s.stadium_name
;


-- SOCCER_SQL_012
--  ���� ��Ÿ���, �������� �����Ͽ�
-- 2012�� 3�� 17�Ͽ� ���� �� ����� 
-- ���̸�, ��Ÿ���, ������� �̸� ���
-- �������̺� join �� ã�Ƽ� �ذ��Ͻÿ�.
SELECT t.team_name ����, d.stadium_name ��Ÿ���, s.awayteam_id ������ID, s.sche_date �����쳯¥
FROM team t
    JOIN stadium d
    ON t.stadium_id LIKE d.stadium_id
        JOIN schedule s
        ON d.stadium_id LIKE s.stadium_id
WHERE s.sche_date LIKE '20120317'
ORDER BY t.team_name
;


-- SOCCER_SQL_013
-- 2012�� 3�� 17�� ��⿡ 
-- ���� ��ƿ���� �Ҽ� ��Ű��(GK)
-- ����, ������,���� (����������), 
-- ��Ÿ���, ��⳯¥�� ���Ͻÿ�
-- �������� ���̸��� ������ ���ÿ�
SELECT p.player_name ������, p.position ������, t.region_name || ' ' || t.team_name ����, d.stadium_name ��Ÿ���, s.sche_date �����ٳ�¥
FROM player p
    JOIN team t
    ON p.team_id LIKE t.team_id
        JOIN stadium d
        ON t.stadium_id LIKE d.stadium_id
            JOIN schedule s 
            ON d.stadium_id LIKE s.stadium_id

WHERE t.team_id LIKE 'K03'
    AND p.position LIKE 'GK'
    AND s.sche_date LIKE '20120317'
ORDER BY p.player_name
;

SELECT p.player_name ������, p.position ������, t.region_name || ' ' || t.team_name ����, d.stadium_name ��Ÿ���, s.sche_date �����ٳ�¥
FROM player p
    JOIN team t
    ON p.team_id LIKE t.team_id
        JOIN stadium d
        ON t.stadium_id LIKE d.stadium_id
            JOIN schedule s 
            ON d.stadium_id LIKE s.stadium_id

WHERE t.team_id LIKE (
    SELECT t.team_id
    FROM team t
    WHERE t.team_name LIKE '��ƿ����')
    AND p.position LIKE 'GK'
    AND s.sche_date LIKE '20120317'
ORDER BY p.player_name
;


-- SOCCER_SQL_014
-- Ȩ���� 3���̻� ���̷� �¸��� ����� 
-- ����� �̸�, ��� ����
-- Ȩ�� �̸��� ������ �̸���
-- ���Ͻÿ�
SELECT s.stadium_name ��Ÿ���, 
    k.sche_date ��⳯¥, 
    ht.region_name || ' ' || ht.team_name Ȩ��, 
    at.region_name || ' ' || at.team_name ������, 
    k.home_score "Ȩ�� ����", 
    k.away_score"������ ����"
FROM schedule k
    JOIN stadium s
    ON k.stadium_id LIKE s.stadium_id
        JOIN team ht
        ON k.hometeam_id LIKE ht.team_id
        JOIN team at
        on k.awayteam_id like at.team_id
WHERE k.home_score >= k.away_score +3
ORDER BY k.sche_date
;


-- SOCCER_SQL_015
-- STADIUM �� ��ϵ� ��� �߿���
-- Ȩ���� ���� �������� ���� ��������
-- ī��Ʈ ���� 20 , �ϻ� �ؿ� ����, �Ⱦ絵 ����
SELECT d.stadium_name, t.stadium_id, d.seat_count, d.hometeam_id, t.e_team_name
FROM stadium d
    LEFT JOIN team t
    ON d.stadium_id LIKE t.stadium_id
ORDER BY d.hometeam_id
;


-- SOCCER_SQL_016
-- �Ҽ��� �Ｚ������� ���� �������
-- �巡�������� �������� ���� ����
SELECT 
    T.TEAM_NAME ����,
    P.PLAYER_NAME ������,
    P.POSITION ������,
    P.BACK_NO ��ѹ�,
    P.HEIGHT Ű
FROM player p
JOIN team t
ON t.team_id LIKE p.team_id
WHERE t.team_id IN('K02', 'K07')
;
-- IN VERSION
SELECT
    ROWNUM "No.",
    T.TEAM_NAME ����,
    P.PLAYER_NAME ������,
    P.POSITION ������,
    P.BACK_NO ��ѹ�,
    P.HEIGHT Ű
FROM player p
JOIN team t
ON t.team_id LIKE p.team_id
WHERE t.team_id IN(
    (SELECT t.team_id
     FROM team t
     WHERE t.team_name IN ('�Ｚ�������')
    ))
ORDER BY p.height
;

--ROWNUM : ����� ������ �� ���ڵ忡 ���� ������ ��Ÿ���� ��ȣ�� ��ȯ
SELECT ROWNUM "No.", A.*
FROM(
SELECT
    T.TEAM_NAME ����,
    P.PLAYER_NAME ������,
    P.POSITION ������,
    P.BACK_NO ��ѹ�,
    P.HEIGHT Ű
FROM player p
JOIN team t
ON t.team_id LIKE p.team_id
WHERE t.team_id IN(
    (SELECT t.team_id
     FROM team t
     WHERE t.team_name IN ('�Ｚ�������')
    ))
AND p.height IS NOT NULL
ORDER BY p.height DESC
) A
;


-- SOCCER_SQL_017
-- �Ҽ��� �Ｚ������� ���� �������
-- �巡�������� �������� ���� ����
SELECT 
    T.TEAM_NAME ����,
    P.PLAYER_NAME ������,
    P.POSITION ������,
    P.BACK_NO ��ѹ�,
    P.HEIGHT Ű
FROM PLAYER P
    JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE 
    T.TEAM_id IN(
    SELECT t.team_id
     FROM team t
     WHERE t.team_name 
     IN ('�Ｚ�������' , '�巡����'))
;


-- SOCCER_SQL_018
-- ��ȣ�� ������ �Ҽ����� ������, ��ѹ�
SELECT 
    p.player_name ������, 
    t.team_name �Ҽ���, 
    p.position ������, 
    p.back_no ��ѹ�
FROM player p
    JOIN team t
    ON p.team_id LIKE t.team_id
WHERE p.player_name LIKE '��ȣ��'
;


-- SOCCER_SQL_019
-- ������Ƽ���� MF ��� Ű
SELECT ROUND(AVG(P.height),2) ���Ű
FROM player p
WHERE P.team_id LIKE(
SELECT t.team_id
FROM team t
WHERE t.team_name LIKE '��Ƽ��'
)
AND p.position LIKE 'MF'
;

SELECT ROUND(avg(P.height)) ���Ű
FROM player p
    JOIN team t
    ON p.team_id LIKE t.team_id
WHERE t.team_id LIKE(
SELECT t2.team_id
FROM team t2
WHERE t2.team_name LIKE '��Ƽ��'
)
AND p.position LIKE 'MF'
;


-- SOCCER_SQL_020
-- 2012�� ���� ������ ���Ͻÿ�
SELECT 
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201201%') "2012�� 01�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201202%') "2012�� 02�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201203%') "2012�� 03�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201204%') "2012�� 04�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201205%') "2012�� 05�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201206%') "2012�� 06�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201207%') "2012�� 07�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201208%') "2012�� 08�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201209%') "2012�� 09�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201210%') "2012�� 10�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201211%') "2012�� 11�� ����",
    (SELECT COUNT(K.sche_date) FROM schedule k WHERE K.sche_date LIKE '201212%') "2012�� 12�� ����"
FROM DUAL schedule
;

SELECT 
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201201%') "2012�� 01�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201202%') "2012�� 02�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201203%') "2012�� 03�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201204%') "2012�� 04�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201205%') "2012�� 05�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201206%') "2012�� 06�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201207%') "2012�� 07�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201208%') "2012�� 08�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201209%') "2012�� 09�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201210%') "2012�� 10�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201211%') "2012�� 11�� ����",
    (SELECT COUNT(*) FROM schedule k WHERE K.sche_date LIKE '201212%') "2012�� 12�� ����"
FROM DUAL schedule
;

SELECT SUBSTR(sche_date,1,6),
COUNT(gubun) 
FROM schedule 
GROUP BY SUBSTR(sche_date,1,6)
ORDER BY SUBSTR(sche_date,1,6)
;


-- 021
-- 2012�� ���� ����� ����(GUBUN IS YES)�� ���Ͻÿ�
-- ����� 1��:20��� �̷�������...
SELECT SUBSTR(sche_date,1,6) �������,
COUNT(gubun) ����
FROM schedule 
WHERE gubun LIKE 'Y'
GROUP BY SUBSTR(sche_date,1,6)
ORDER BY SUBSTR(sche_date,1,6)
;


-- 022
-- 2012�� 9�� 14�Ͽ� ������ ���� ���� ����Դϱ�
-- Ȩ��: ?   ������: ? �� ���
SELECT ht.team_name Ȩ��, at.team_name ������
FROM schedule k
    JOIN stadium s
    ON k.stadium_id LIKE s.stadium_id
        JOIN team ht
        ON k.hometeam_id LIKE ht.team_id
        JOIN team at
        on k.awayteam_id like at.team_id
WHERE k.sche_date LIKE '20120914'
;


-- 023
-- GROUP BY ���
-- ���� ������ ��
-- ������ũ *��
-- �巡���� *��
SELECT 
    t.team_name, COUNT(p.player_id) �����Ǽ�
FROM player P
    JOIN team t
    ON p.team_id LIKE t.team_id
GROUP BY t.team_name
ORDER BY t.team_name
;


-- 024
-- ���� ��Ű���� ��� Ű
-- ������ũ *cm
-- �巡���� *cm
SELECT
    (SELECT t.team_name FROM team t WHERE t.team_id LIKE p.team_id) ����,
    AVG(p.height) || 'cm' ���Ű
FROM player p
WHERE p.position LIKE 'GK'
GROUP BY team_id
;

SELECT
    player_name,
    position,
    CASE
        WHEN position IS NULL THEN '����'
        WHEN position LIKE 'GK' THEN '��Ű��'
        WHEN position LIKE 'MK' THEN '�̵��ʵ�'
        WHEN position LIKE 'DF'THEN '�����'
        
        ELSE position
    END ������
FROM
    player
WHERE
    team_id = 'K08'
;

-- 025
-- �Ｚ�������� Ű������ ž 10 ���
SELECT ROWNUM "No.", A.*
FROM(
SELECT
    T.TEAM_NAME ����,
    P.PLAYER_NAME ������,
    P.POSITION ������,
    P.BACK_NO ��ѹ�,
    P.HEIGHT Ű
FROM player p
JOIN team t
ON t.team_id LIKE p.team_id
WHERE t.team_id IN(
    (SELECT t2.team_id
     FROM team t2
     WHERE t2.team_name LIKE '�Ｚ�������'
    ))
AND p.height IS NOT NULL
ORDER BY p.height DESC
) A
WHERE ROWNUM > 10
;
-- �Ｚ�������� Ű������ ž 11~20 ���
SELECT ROWNUM "NO", B.*
FROM(
SELECT ROWNUM "NUM" , A.*
FROM(
SELECT
    T.TEAM_NAME ����,
    P.PLAYER_NAME ������,
    P.POSITION ������,
    P.BACK_NO ��ѹ�,
    P.HEIGHT Ű
FROM player p
JOIN team t
ON t.team_id LIKE p.team_id
WHERE t.team_id IN(
    (SELECT t.team_id
     FROM team t
     WHERE t.team_name IN ('�Ｚ�������')
    ))
AND p.height IS NOT NULL
ORDER BY p.height DESC)A)B
WHERE B.NUM BETWEEN 10 AND 20;
;

-- 026
-- ���� ��Ű���� ��� Ű����
-- ���� ���Ű�� ū ������
SELECT ROWNUM NO, A.*
FROM
    (SELECT t.team_name ����, ROUND(AVG(p.height),2) ���Ű
     FROM player p
        JOIN team t
        ON p.team_id LIKE t.team_id
     WHERE p.position LIKE 'GK'
     GROUP BY t.team_name
     ORDER BY ���Ű DESC) A
WHERE ROWNUM <2
;


-- 027
-- �� ���ܺ� ������ ���Ű�� �Ｚ �����������
-- ���Ű���� ���� ���� �̸��� �ش� ���� ���Ű�� 
-- ���Ͻÿ�
SELECT ROWNUM NO, A.*
FROM(
    SELECT t.team_name ����, ROUND(AVG(p.height),2)���Ű
    FROM player p
    JOIN team t
    ON p.team_id LIKE t.team_id
    GROUP BY t.team_name
    HAVING AVG(p.height) < (SELECT AVG(p2.height) 
                   FROM player p2 
                        JOIN team t2 
                        ON p2.team_id LIKE t2.team_id
                   WHERE t2.team_name LIKE '�Ｚ�������')
    ORDER BY ���Ű DESC) A
;


-- 028
-- 2012�� ��� �߿��� �������� ���� ū ��� ����
SELECT A.��¥, A.������
FROM(
    SELECT
        k.sche_date ��¥, 
        ABS(k.home_score - k.away_score) ������
    FROM schedule k
    WHERE k.sche_date LIKE '2012%'
        AND k.gubun LIKE 'Y'
    ORDER BY ������ DESC) A
WHERE ROWNUM = 1
;

SELECT ROWNUM NO, A.*
FROM(
    SELECT
        k.sche_date ��¥,
        CASE
            WHEN K.HOME_SCORE >= K.AWAY_SCORE THEN (K.HOME_SCORE - K.AWAY_SCORE)
            ELSE K.AWAY_SCORE - K.HOME_SCORE
        END ������
    FROM schedule k
    WHERE k.sche_date LIKE '2012%'
        AND k.gubun LIKE 'Y'
    ORDER BY ������ DESC) A
WHERE ROWNUM = 1
;


-- 029
-- �¼������ ��Ÿ��� ���� �ű��
SELECT ROWNUM No, A.*
FROM(
    SELECT s.stadium_name �����
    FROM stadium s
    ORDER BY s.seat_count DESC) A
;


-- 030
-- 2012�� ���� �¸� ������ �����ű��
SELECT A.����, COUNT(A.GUBUN) �¸���
FROM(
    SELECT
        t.team_name ����, k.gubun
    FROM team t
        JOIN schedule k
        ON t.team_id LIKE k.hometeam_id
    WHERE k.home_score - k.away_score > 0
        AND k.sche_date LIKE '2012%'
UNION ALL
    SELECT
        t2.team_name ����, k2.gubun
    FROM team t2
        JOIN schedule k2
        ON t2.team_id LIKE k2.awayteam_id
    WHERE k2.home_score - k2.away_score < 0
        AND k2.sche_date LIKE '2012%') A  
GROUP BY A.����
ORDER BY A.����
;

SELECT
    A.����, 
    COUNT(A.����) �¸���
FROM(
    SELECT
        CASE
            WHEN k.home_score > k.away_score THEN ht.team_name
            WHEN k.home_score < k.away_score THEN at.team_name
            ELSE '���º�'
        END ����
    FROM schedule k
        JOIN team ht
        ON k.hometeam_id LIKE ht.team_id
        JOIN team at
        ON k.awayteam_id LIKE at.team_id) A
WHERE A.���� NOT LIKE '���º�'
GROUP BY A.����
ORDER BY �¸��� DESC
;
