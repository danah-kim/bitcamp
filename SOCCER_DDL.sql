-- SOCCER_SQL_001
-- 테이블의 수
SELECT COUNT(*) 테이블의수
FROM tab;


-- SOCCER_SQL_002
-- 전체 축구팀 목록
SELECT team_name "전체 축구팀 목록"
FROM team
ORDER BY team_name desc
;


-- SOCCER_SQL_003 : 포지션종류(중복제거, 없으면 신입으로 기재)
-- NVL2(조건, 참, 거짓)
SELECT DISTINCT NVL2(position, position, '신입') "포지션"
FROM player;


-- SOCCER_SQL_004
-- 수원팀(ID: K02) 골키퍼
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
    WHERE team_name LIKE('삼성블루윙즈')))
    AND position = 'GK'
ORDER BY player_name
;


-- SOCCER_SQL_005
-- 수원팀(ID: K02) && 키가 170 이상 선수 && 성이 고씨
-- substr(문자열, 시작위치, 나타낼개수)
-- '고__' // 3자리 중 첫번째 글자가 '고'인경우
-- '고%' // '고'로 시작하는 모든 값
-- '%고' // '고'로 끝나는 모든 값
SELECT position 포지션, player_name 이름
FROM player
WHERE team_id LIKE 'K02'
    AND height >= 170
    --AND SUBSTR(player_name, 0, 1) LIKE '고'
    AND player_name LIKE '%고%'
;

SELECT p.position 포지션, player_name 이름
FROM player p
WHERE P.team_id LIKE((
    SELECT t.team_id
    FROM team t
    WHERE team_name LIKE('삼성블루윙즈')))
    AND height >= 170
    --AND SUBSTR(player_name, 0, 1) LIKE '고'
    AND player_name LIKE '%고%'
;
 

 -- SOCCER_SQL_006
-- 수원팀(ID: K02) 선수들 이름,
-- 키와 몸무게 리스트 (단위 cm 와 kg 삽입)
-- 키와 몸무게가 없으면 "0" 표시
-- 키 내림차순
-- CONCAT(1,2) // '12' 표시
SELECT player_name || '선수' 이름, NVL2(height, height, 0) || 'cm' 키, NVL2(weight, weight, 0 ) || 'kg' 몸무게
--CONCAT(player_name, '선수') 이름, CONCAT(NVL2(height, height, 0),'cm') 키, CONCAT(NVL2(weight, weight, 0),'kg') 몸무게
FROM player
WHERE team_id LIKE 'K02'
ORDER BY height desc
;

SELECT p.player_name || '선수' 이름, NVL2(height, height, 0) || 'cm' 키, NVL2(weight, weight, 0 ) || 'kg' 몸무게
--CONCAT(player_name, '선수') 이름, CONCAT(NVL2(height, height, 0),'cm') 키, CONCAT(NVL2(weight, weight, 0),'kg') 몸무게
FROM player p
WHERE P.team_id LIKE((
    SELECT t.team_id
    FROM team t
    WHERE team_name LIKE('삼성블루윙즈')))
    AND p.position LIKE 'GK'
ORDER BY height desc
;


-- SOCCER_SQL_007
-- 수원팀(ID: K02) 선수들 이름,
-- 키와 몸무게 리스트 (단위 cm 와 kg 삽입)
-- 키와 몸무게가 없으면 "0" 표시
-- BMI지수 
-- 키 내림차순BMI = 몸무게 / 키² 로서, 여기서 몸무게는 kg, 키는 m 단위이다. 예를 들자면, 몸무게 55kg에 키 1.68m인 사람의 BMI는 55kg/(1.68m)^2 = 19.4이다
SELECT player_name || '선수' 이름, NVL2(height, height, 0) || 'cm' 키, NVL2(weight, weight, 0 ) || 'kg' 몸무게, ROUND((weight/((height*height)/10000)),2) BMI비만지수
FROM player
WHERE team_id LIKE 'K02'
ORDER BY height desc
;

SELECT P.player_name || '선수' 이름, NVL2(height, height, 0) || 'cm' 키, NVL2(weight, weight, 0 ) || 'kg' 몸무게, ROUND((weight/((height*height)/10000)),2) BMI비만지수
FROM player P
WHERE P.team_id LIKE((
    SELECT t.team_id
    FROM team t
    WHERE team_name LIKE('삼성블루윙즈')))
    AND p.position LIKE 'GK'
ORDER BY height desc
;

-- SOCCER_SQL_008
-- 수원팀(ID: K02) 과 대전팀(ID: K10)선수들 중 이
-- MF 포지션인 선수
-- 팀명 오름차순
 SELECT t.team_name, p.position, p.player_name
 FROM team t, player p
 WHERE t.team_id LIKE p.team_id
    AND t.team_id IN('K10', 'K02')
    AND p.position LIKE 'GK'
ORDER BY t.team_name, p.player_name
;

SELECT t.team_name, p.position, p.player_name
FROM player p -- 주가 되는 table
    INNER JOIN team t
    ON t.team_id LIKE p.team_id
WHERE t.team_id IN('K10', 'K02')
    AND p.position LIKE 'GK'
ORDER BY t.team_name, p.player_name
;

SELECT t.team_name, p.position, p.player_name
FROM player p -- 주가 되는 table
    JOIN team t
    ON t.team_id LIKE p.team_id
WHERE t.team_id IN((
    SELECT t.team_id
    FROM team t
    WHERE team_name IN('삼성블루윙즈','시티즌')))
    AND p.position LIKE 'GK'
ORDER BY t.team_name, p.player_name
;


-- SOCCER_SQL_009
-- 수원팀(ID: K02) 과 대전팀(ID: K10)선수들 중 이
-- 키가 180 이상 183 이하인 선수들
-- 팀명, 사람명 오름차순
SELECT p.height || 'cm' 키, t.team_name 팀명, p.player_name 이름
FROM team t, player p
WHERE t.team_id LIKE p.team_id
    AND t.team_id IN ('K02', 'K10')
    AND p.height BETWEEN 180 AND 183
ORDER BY p.height, p.player_name, t.team_name
;

SELECT p.height || 'cm' 키, t.team_name 팀명, p.player_name 이름
FROM player p
    JOIN team t
    ON t.team_id LIKE p.team_id
WHERE t.team_id IN ('K02', 'K10')
    AND p.height BETWEEN 180 AND 183
ORDER BY p.height, p.player_name, t.team_name
;

SELECT p.height || 'cm' 키, t.team_name 팀명, p.player_name 이름
FROM player p
    JOIN team t
    ON t.team_id LIKE p.team_id
WHERE t.team_id IN ((
    SELECT t.team_id
    FROM team t
    WHERE t.team_name IN('삼성블루윙즈','시티즌')
))
    AND p.height BETWEEN 180 AND 183
ORDER BY p.height, p.player_name, t.team_name
;


--SOCCER_SQL_010
-- 모든 선수들 중
-- 포지션을 배정받지 못한 선수들의 팀과 이름
-- 팀명, 사람명 오름차순
SELECT t.team_name, p.player_name, p.position
FROM player p
    JOIN team t
    ON p.team_id LIKE t.team_id
WHERE p.position IS NULL
ORDER BY t.team_name, p.player_name
;


-- SOCCER_SQL_011
-- SOCCER_SQL_011
--  팀과 스타디움을 조인하여
-- 팀이름, 스타디움 이름 출력
SELECT t.team_name 팀명, s.stadium_name 스타디움
FROM stadium s
    JOIN team t
    ON s.stadium_id LIKE t.stadium_id
ORDER BY t.team_name, s.stadium_name
;


-- SOCCER_SQL_012
--  팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의 
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.
SELECT t.team_name 팀명, d.stadium_name 스타디움, s.awayteam_id 원정팀ID, s.sche_date 스케쥴날짜
FROM team t
    JOIN stadium d
    ON t.stadium_id LIKE d.stadium_id
        JOIN schedule s
        ON d.stadium_id LIKE s.stadium_id
WHERE s.sche_date LIKE '20120317'
ORDER BY t.team_name
;


-- SOCCER_SQL_013
-- 2012년 3월 17일 경기에 
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함), 
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오
SELECT p.player_name 선수명, p.position 포지션, t.region_name || ' ' || t.team_name 팀명, d.stadium_name 스타디움, s.sche_date 스케줄날짜
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

SELECT p.player_name 선수명, p.position 포지션, t.region_name || ' ' || t.team_name 팀명, d.stadium_name 스타디움, s.sche_date 스케줄날짜
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
    WHERE t.team_name LIKE '스틸러스')
    AND p.position LIKE 'GK'
    AND s.sche_date LIKE '20120317'
ORDER BY p.player_name
;


-- SOCCER_SQL_014
-- 홈팀이 3점이상 차이로 승리한 경기의 
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오
SELECT s.stadium_name 스타디움, 
    k.sche_date 경기날짜, 
    ht.region_name || ' ' || ht.team_name 홈팀, 
    at.region_name || ' ' || at.team_name 원정팀, 
    k.home_score "홈팀 점수", 
    k.away_score"원정팀 점수"
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
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 20 , 일산 밑에 마산, 안양도 있음
SELECT d.stadium_name, t.stadium_id, d.seat_count, d.hometeam_id, t.e_team_name
FROM stadium d
    LEFT JOIN team t
    ON d.stadium_id LIKE t.stadium_id
ORDER BY d.hometeam_id
;


-- SOCCER_SQL_016
-- 소속이 삼성블루윙즈 팀인 선수들과
-- 드래곤즈팀인 선수들의 선수 정보
SELECT 
    T.TEAM_NAME 팀명,
    P.PLAYER_NAME 선수명,
    P.POSITION 포지션,
    P.BACK_NO 백넘버,
    P.HEIGHT 키
FROM player p
JOIN team t
ON t.team_id LIKE p.team_id
WHERE t.team_id IN('K02', 'K07')
;

SELECT 
    T.TEAM_NAME 팀명,
    P.PLAYER_NAME 선수명,
    P.POSITION 포지션,
    P.BACK_NO 백넘버,
    P.HEIGHT 키
FROM player p
JOIN team t
ON t.team_id LIKE p.team_id
WHERE t.team_id IN(
    (SELECT t.team_id
     FROM team t
     WHERE t.team_name IN ('삼성블루윙즈' , '드래곤즈')
    ))
;

-- SOCCER_SQL_017
-- 소속이 삼성블루윙즈 팀인 선수들과
-- 드래곤즈팀인 선수들의 선수 정보
SELECT 
    T.TEAM_NAME 팀명,
    P.PLAYER_NAME 선수명,
    P.POSITION 포지션,
    P.BACK_NO 백넘버,
    P.HEIGHT 키
FROM PLAYER P
    JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE 
    T.TEAM_id IN(
    SELECT t.team_id
     FROM team t
     WHERE t.team_name 
     IN ('삼성블루윙즈' , '드래곤즈'))
;


-- SOCCER_SQL_018
-- 최호진 선수의 소속팀과 포지션, 백넘버
SELECT 
    p.player_name 선수명, 
    t.team_name 소속팀, 
    p.position 포지션, 
    p.back_no 백넘버
FROM player p
    JOIN team t
    ON p.team_id LIKE t.team_id
WHERE p.player_name LIKE '최호진'
;


-- SOCCER_SQL_019
-- 대전시티즌의 MF 평균 키
SELECT ROUND(AVG(P.height),2) 평균키
FROM player p
WHERE P.team_id LIKE(
SELECT t.team_id
FROM team t
WHERE t.team_name LIKE '시티즌'
)
AND p.position LIKE 'MF'
;

SELECT t.team_name 팀이름, P.height 평균키
FROM player p
    JOIN team t
    ON p.team_id LIKE t.team_id
WHERE t.team_id LIKE(
SELECT t.team_id
FROM team t
WHERE t.team_name LIKE '시티즌'
)
AND p.position LIKE 'MF'
;


-- SOCCER_SQL_020
-- 대전시티즌의 MF 평균 키
SELECT 
    COUNT((SELECT k.sche_date FROM schedule k WHERE k.sche_date LIKE '201201%')) "2012년 01월 경기수",
FROM schedule k
;