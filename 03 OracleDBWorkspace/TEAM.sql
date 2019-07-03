SELECT * FROM TAB;
SELECT * FROM TEAMZ;
SELECT * FROM TEAMW;

CREATE TABLE TEAMZ(
TEAM_ID VARCHAR2(20) PRIMARY KEY,
TEAM_NAME VARCHAR2(20)
);

CREATE TABLE TEAMW(
MEM_ID VARCHAR2(20) PRIMARY KEY,
TEAM_ID VARCHAR2(20), 
MEM_NAME VARCHAR2(20),
mem_age DECIMAL
);

--�Ӽ��̸� ����
ALTER TABLE TEAMW 
RENAME COLUMN MOM_NAME TO MEM_NAME;

--�Ӽ� �߰�
ALTER TABLE TEAMW
ADD ROLL VARCHAR2(20);

-- �ʵ� ����
UPDATE TEAMZ SET TEAM_ID = 'CTEAM'
WHERE TEAM_ID LIKE 'CTHAM';

UPDATE TEAMW SET MEM_NAME = '����'
WHERE MEM_NAME LIKE '�¿�';

--UPDATE������ CASE WHEN����Ͽ� ��ü ������Ʈ
UPDATE TEAMW SET ROLL =
    CASE
        WHEN mem_name IN ('����', '����', '������', '��ȣ') THEN '����'
        ELSE '����'
    END
WHERE ROLL IS NULL
;

INSERT INTO TEAMZ VALUES('ATEAM', '����Ƽ��');
INSERT INTO TEAMZ VALUES('HTEAM', '�Ƹ����׽�');
INSERT INTO TEAMZ VALUES('CTEAM', '������');
INSERT INTO TEAMZ VALUES('STEAM', '�����');

INSERT INTO TEAMW VALUES('A1', 'ATEAM', '����', 34);
INSERT INTO TEAMW VALUES('A2', 'ATEAM', '����', 35);
INSERT INTO TEAMW VALUES('A3', 'ATEAM', '����', 21);
INSERT INTO TEAMW VALUES('A4', 'ATEAM', '����', 29);
INSERT INTO TEAMW VALUES('A5', 'ATEAM', '����', 25);
INSERT INTO TEAMW VALUES('H1', 'HTEAM', '����', 26);
INSERT INTO TEAMW VALUES('H2', 'HTEAM', '����', 26);
INSERT INTO TEAMW VALUES('H3', 'HTEAM', '��', 27);
INSERT INTO TEAMW VALUES('H4', 'HTEAM', '���', 30);
INSERT INTO TEAMW VALUES('H5', 'HTEAM', '�ܾ�', 26);
INSERT INTO TEAMW VALUES('C1', 'CTEAM', '������', 32);
INSERT INTO TEAMW VALUES('C2', 'CTEAM', '��ȣ', 31);
INSERT INTO TEAMW VALUES('C3', 'CTEAM', '����', 29);
INSERT INTO TEAMW VALUES('C4', 'CTEAM', '����', 23);
INSERT INTO TEAMW VALUES('C5', 'CTEAM', '����', 30);
INSERT INTO TEAMW VALUES('S1', 'STEAM', '��ȣ', 27);
INSERT INTO TEAMW VALUES('S2', 'STEAM', '����', 26);
INSERT INTO TEAMW VALUES('S3', 'STEAM', '�̽�', 29);
INSERT INTO TEAMW VALUES('S4', 'STEAM', '����', 26);
INSERT INTO TEAMW VALUES('S5', 'STEAM', '����', 30);

--COUNT() ������
SELECT z.team_name ����, count(mem_name) ������
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
;

--SUM() ���� ������
SELECT z.team_name, SUM(w.mem_age)
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
;

--MAX() ���� �����ִ�ġ
SELECT z.team_name, MAX(w.mem_age)
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
;

--MIN() ���� �����ּ�ġ
SELECT z.team_name, MIN(w.mem_age)
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
;

--AVG() ���� �������
SELECT z.team_name, AVG(w.mem_age)
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
;

SELECT 
(SELECT  COUNT(*) FROM TEAMW W WHERE W.MEM_ID LIKE W.MEM_ID)"���",
(SELECT SUM(W.MEM_AGE) FROM TEAMW W WHERE W.MEM_ID LIKE W.MEM_ID)"������",
(SELECT MAX(W.MEM_AGE) FROM TEAMW W WHERE W.MEM_ID LIKE W.MEM_ID)"�����ִ�ġ",
(SELECT MIN(W.MEM_AGE) FROM TEAMW W WHERE W.MEM_ID LIKE W.MEM_ID)"�����ּ�ġ",
(SELECT AVG(W.MEM_AGE) FROM TEAMW W WHERE W.MEM_ID LIKE W.MEM_ID)"�������"
FROM TEAMZ Z
WHERE W.TEAM_ID LIKE Z.TEAM_ID
;

SELECT 
    z.team_name ����,
    count(mem_name) ������,
    SUM(w.mem_age) ������,
    MAX(w.mem_age) �����ִ�ġ,
    MIN(w.mem_age) �����ּ�ġ,
    AVG(w.mem_age) �������
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
ORDER BY z.team_name
;

SELECT 
    (SELECT z.team_name 
     FROM teamz z
     WHERE w.team_id LIKE z.team_id) ����,
    count(mem_name) ������,
    SUM(w.mem_age) ������,
    MAX(w.mem_age) �����ִ�ġ,
    MIN(w.mem_age) �����ּ�ġ,
    AVG(w.mem_age) �������
FROM teamw w
GROUP BY w.team_id
;

SELECT 
    (SELECT z.team_name 
     FROM teamz z
     WHERE w.team_id LIKE z.team_id) ����,
    count(mem_name) ������,
    SUM(w.mem_age) ������,
    MAX(w.mem_age) �����ִ�ġ,
    MIN(w.mem_age) �����ּ�ġ,
    AVG(w.mem_age) �������
FROM teamw w
GROUP BY w.team_id 
HAVING AVG(w.mem_age) >= 28
ORDER BY w.team_id
;
