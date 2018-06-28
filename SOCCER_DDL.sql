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
     WHERE t.team_name IN ('�Ｚ�������' , '�巡����')
    ))
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

SELECT t.team_name ���̸�, P.height ���Ű
FROM player p
    JOIN team t
    ON p.team_id LIKE t.team_id
WHERE t.team_id LIKE(
SELECT t.team_id
FROM team t
WHERE t.team_name LIKE '��Ƽ��'
)
AND p.position LIKE 'MF'
;


-- SOCCER_SQL_020
-- ������Ƽ���� MF ��� Ű
SELECT 
    COUNT((SELECT k.sche_date FROM schedule k WHERE k.sche_date LIKE '201201%')) "2012�� 01�� ����",
FROM schedule k
;