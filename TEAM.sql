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

--속성이름 변경
ALTER TABLE TEAMW 
RENAME COLUMN MOM_NAME TO MEM_NAME;

--속성 추가
ALTER TABLE TEAMW
ADD ROLL VARCHAR2(20);

-- 필드 변경
UPDATE TEAMZ SET TEAM_ID = 'CTEAM'
WHERE TEAM_ID LIKE 'CTHAM';

UPDATE TEAMW SET MEM_NAME = '태형'
WHERE MEM_NAME LIKE '태영';

--UPDATE문에서 CASE WHEN사용하여 전체 업데이트
UPDATE TEAMW SET ROLL =
    CASE
        WHEN mem_name IN ('형준', '혜리', '최정훈', '승호') THEN '팀장'
        ELSE '팀원'
    END
WHERE ROLL IS NULL
;

INSERT INTO TEAMZ VALUES('ATEAM', '저스티스');
INSERT INTO TEAMZ VALUES('HTEAM', '아마조네스');
INSERT INTO TEAMZ VALUES('CTEAM', '가오갤');
INSERT INTO TEAMZ VALUES('STEAM', '어벤저스');

INSERT INTO TEAMW VALUES('A1', 'ATEAM', '형준', 34);
INSERT INTO TEAMW VALUES('A2', 'ATEAM', '세인', 35);
INSERT INTO TEAMW VALUES('A3', 'ATEAM', '희태', 21);
INSERT INTO TEAMW VALUES('A4', 'ATEAM', '상훈', 29);
INSERT INTO TEAMW VALUES('A5', 'ATEAM', '태형', 25);
INSERT INTO TEAMW VALUES('H1', 'HTEAM', '혜리', 26);
INSERT INTO TEAMW VALUES('H2', 'HTEAM', '지은', 26);
INSERT INTO TEAMW VALUES('H3', 'HTEAM', '준', 27);
INSERT INTO TEAMW VALUES('H4', 'HTEAM', '재경', 30);
INSERT INTO TEAMW VALUES('H5', 'HTEAM', '단아', 26);
INSERT INTO TEAMW VALUES('C1', 'CTEAM', '최정훈', 32);
INSERT INTO TEAMW VALUES('C2', 'CTEAM', '윤호', 31);
INSERT INTO TEAMW VALUES('C3', 'CTEAM', '가은', 29);
INSERT INTO TEAMW VALUES('C4', 'CTEAM', '정훈', 23);
INSERT INTO TEAMW VALUES('C5', 'CTEAM', '승태', 30);
INSERT INTO TEAMW VALUES('S1', 'STEAM', '승호', 27);
INSERT INTO TEAMW VALUES('S2', 'STEAM', '소진', 26);
INSERT INTO TEAMW VALUES('S3', 'STEAM', '이슬', 29);
INSERT INTO TEAMW VALUES('S4', 'STEAM', '진태', 26);
INSERT INTO TEAMW VALUES('S5', 'STEAM', '누리', 30);

--COUNT() 팀원수
SELECT z.team_name 팀명, count(mem_name) 팀원수
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
;

--SUM() 팀원 나이합
SELECT z.team_name, SUM(w.mem_age)
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
;

--MAX() 팀원 나이최대치
SELECT z.team_name, MAX(w.mem_age)
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
;

--MIN() 팀원 나이최소치
SELECT z.team_name, MIN(w.mem_age)
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
;

--AVG() 팀원 나이평균
SELECT z.team_name, AVG(w.mem_age)
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
;

SELECT 
(SELECT  COUNT(*) FROM TEAMW W WHERE W.MEM_ID LIKE W.MEM_ID)"명수",
(SELECT SUM(W.MEM_AGE) FROM TEAMW W WHERE W.MEM_ID LIKE W.MEM_ID)"나이합",
(SELECT MAX(W.MEM_AGE) FROM TEAMW W WHERE W.MEM_ID LIKE W.MEM_ID)"나이최대치",
(SELECT MIN(W.MEM_AGE) FROM TEAMW W WHERE W.MEM_ID LIKE W.MEM_ID)"나이최소치",
(SELECT AVG(W.MEM_AGE) FROM TEAMW W WHERE W.MEM_ID LIKE W.MEM_ID)"나이평균"
FROM TEAMZ Z
WHERE W.TEAM_ID LIKE Z.TEAM_ID
;

SELECT 
    z.team_name 팀명,
    count(mem_name) 팀원수,
    SUM(w.mem_age) 나이합,
    MAX(w.mem_age) 나이최대치,
    MIN(w.mem_age) 나이최소치,
    AVG(w.mem_age) 나이평균
FROM teamw w
    JOIN teamz z
    ON w.team_id LIKE z.team_id
GROUP BY z.team_name
ORDER BY z.team_name
;

SELECT 
    (SELECT z.team_name 
     FROM teamz z
     WHERE w.team_id LIKE z.team_id) 팀명,
    count(mem_name) 팀원수,
    SUM(w.mem_age) 나이합,
    MAX(w.mem_age) 나이최대치,
    MIN(w.mem_age) 나이최소치,
    AVG(w.mem_age) 나이평균
FROM teamw w
GROUP BY w.team_id
;

SELECT 
    (SELECT z.team_name 
     FROM teamz z
     WHERE w.team_id LIKE z.team_id) 팀명,
    count(mem_name) 팀원수,
    SUM(w.mem_age) 나이합,
    MAX(w.mem_age) 나이최대치,
    MIN(w.mem_age) 나이최소치,
    AVG(w.mem_age) 나이평균
FROM teamw w
GROUP BY w.team_id 
HAVING AVG(w.mem_age) >= 28
ORDER BY w.team_id
;
