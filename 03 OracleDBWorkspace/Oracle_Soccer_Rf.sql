-- SOCCER_SQL_001
SELECT 
    COUNT(*) "테이블의 수" 
FROM TAB;
-- SOCCER_SQL_002
SELECT 
    TEAM_NAME "전체 축구팀 목록" 
FROM TEAM
ORDER BY TEAM_NAME DESC
;
-- SOCCER_SQL_003
-- 포지션 종류(중복제거,없으면 신입으로 기재)
-- NVL2()
SELECT DISTINCT NVL2(POSITION,POSITION,'신입') "포지션" 
FROM PLAYER;
-- SOCCER_SQL_004
-- 수원팀(ID: K02)골키퍼
SELECT PLAYER_NAME 이름
FROM PLAYER
WHERE TEAM_ID = 'K02'
    AND POSITION = 'GK'
ORDER BY PLAYER_NAME 
;
-- SOCCER_SQL_005
-- 수원팀(ID: K02)키가 170 이상 선수
-- 이면서 성이 고씨인 선수
SELECT POSITION 포지션,PLAYER_NAME 이름
FROM PLAYER
WHERE HEIGHT >= 170
    AND TEAM_ID LIKE 'K02'
    AND SUBSTR(PLAYER_NAME,0,1) LIKE '고'
ORDER BY PLAYER_NAME 
;
-- SUBSTR('홍길동',2,2) 하면
-- 길동이 출력되는데
-- 앞2는 시작위치, 뒤2는 글자수를 뜻함
SELECT SUBSTR(PLAYER_NAME,2,2) 테스트값
FROM PLAYER
;
-- 다른 풀이(권장)
SELECT POSITION 포지션,PLAYER_NAME 이름
FROM PLAYER
WHERE HEIGHT >= 170
    AND TEAM_ID LIKE 'K02'
    AND PLAYER_NAME LIKE '고%'
ORDER BY PLAYER_NAME 
;
-- SOCCER_SQL_006
-- 수원팀(ID: K02) 선수들 이름,
-- 키와 몸무게 리스트 (단위 CM 와 KG 삽입)
-- 키와 몸무게가 없으면 "0" 표시
-- 키 내림차순
SELECT 
    PLAYER_NAME || '선수' 이름,
    NVL2(HEIGHT,HEIGHT,0) || 'CM' 키,
    NVL2(WEIGHT,WEIGHT,0) || 'KG' 몸무게
FROM PLAYER
WHERE TEAM_ID LIKE 'K02'
ORDER BY HEIGHT DESC
;
-- SOCCER_SQL_007
-- 수원팀(ID: K02) 선수들 이름,
-- 키와 몸무게 리스트 (단위 CM 와 KG 삽입)
-- 키와 몸무게가 없으면 "0" 표시
-- BMI지수 
-- 키 내림차순
SELECT 
    PLAYER_NAME || '선수' 이름,
    NVL2(HEIGHT,HEIGHT,0) || 'CM' 키,
    NVL2(WEIGHT,WEIGHT,0) || 'KG' 몸무게,
    ROUND(WEIGHT/((HEIGHT/100)*(HEIGHT/100)),2) "BMI 비만지수"
FROM PLAYER
WHERE TEAM_ID = 'K02'
ORDER BY HEIGHT DESC
;
-- SOCCER_SQL_008
-- 수원팀(ID: K02) 과 대전팀(ID: K10)선수들 중 이
-- GK 포지션인 선수
-- 팀명, 사람명 오름차순
SELECT 
    T.TEAM_NAME,
    P.POSITION,
    P.PLAYER_NAME 
FROM PLAYER P, TEAM T
WHERE T.TEAM_ID = P.TEAM_ID
    AND T.TEAM_ID IN ( 'K02', 'K10')
    AND P.POSITION LIKE 'GK'
ORDER BY T.TEAM_NAME, P.PLAYER_NAME
;
-- ANSI JOIN 사용(권장)
SELECT 
    T.TEAM_NAME,
    P.POSITION,
    P.PLAYER_NAME 
FROM PLAYER P
INNER JOIN TEAM T
ON T.TEAM_ID LIKE P.TEAM_ID
WHERE T.TEAM_ID IN ( 'K02', 'K10')
    AND P.POSITION LIKE 'GK'
ORDER BY T.TEAM_NAME, P.PLAYER_NAME
;
-- SOCCER_SQL_009
-- 수원팀(ID: K02) 과 대전팀(ID: K10)선수들 중 이
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순
SELECT 
    P.HEIGHT || 'CM' 키,
    T.TEAM_NAME 팀명,
    P.PLAYER_NAME 이름
FROM PLAYER P, TEAM T
WHERE 
    T.TEAM_ID = P.TEAM_ID
    AND T.TEAM_ID IN ( 'K02', 'K10')
    AND P.HEIGHT BETWEEN 180 AND 183
ORDER BY P.HEIGHT, T.TEAM_NAME, P.PLAYER_NAME
;
-- ANSI JOIN 사용(권장)
SELECT P.HEIGHT ||'CM' 키,
    T.TEAM_NAME 팀명, 
    P.PLAYER_NAME 이름
FROM PLAYER P
    JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE T.TEAM_ID IN ('K02', 'K10')
    AND P.HEIGHT BETWEEN 180 AND 183
ORDER BY P.HEIGHT, T.TEAM_NAME, P.PLAYER_NAME
; 
-- SOCCER_SQL_010
--  모든 선수들 중
-- 포지션을 배정받지 못한 선수들의 팀과 이름
-- 팀명, 사람명 오름차순
SELECT 
    T.TEAM_NAME,
    P.PLAYER_NAME 
FROM PLAYER P, TEAM T
WHERE  P.POSITION IS NULL
ORDER BY T.TEAM_NAME, P.PLAYER_NAME
;
-- SOCCER_SQL_011
-- 팀이름, 스타디움 이름 출력
SELECT T.TEAM_NAME 팀명,S.STADIUM_NAME 스타디움
FROM STADIUM S 
    JOIN TEAM T
    ON T.STADIUM_ID LIKE S.STADIUM_ID
ORDER BY T.TEAM_NAME     
;
-- SOCCER_SQL_012
-- 2012년 3월 17일에 열린 각 경기의 
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 재경
SELECT 
    t.team_name "팀명", 
    st.stadium_name "스타디움", 
    sc.awayteam_id "원정팀ID", 
    sc.sche_date "스케쥴날짜"
FROM stadium st
   JOIN schedule sc
   ON sc.stadium_id like st.stadium_id
   JOIN team t
   ON  t.stadium_id like st.stadium_id
where sc.sche_date like '20120317'
ORDER BY t.team_name
;


-- SOCCER_SQL_013
-- 2012년 3월 17일 경기에 
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함), 
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오
SELECT 
    P.PLAYER_NAME 선수명,
    P.POSITION 포지션,
    T.REGION_NAME || '  '||T.TEAM_NAME 팀명,
    S.STADIUM_NAME 스타디움,
    K.SCHE_DATE 스케줄날짜
FROM 
    TEAM T    
    JOIN STADIUM S
        ON T.STADIUM_ID LIKE S.STADIUM_ID
    JOIN PLAYER P     
        ON T.TEAM_ID LIKE P.TEAM_ID
    JOIN SCHEDULE K
        ON S.STADIUM_ID LIKE K.STADIUM_ID
WHERE
    K.SCHE_DATE LIKE '20120317'    
    AND P.POSITION LIKE 'GK'
    AND S.STADIUM_NAME LIKE '포항스틸야드'
ORDER BY P.PLAYER_NAME     
; 
-- SOCCER_SQL_014
-- 홈팀이 3점이상 차이로 승리한 경기의 
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오
SELECT 
    S.STADIUM_NAME 스타디움,
    K.SCHE_DATE 경기날짜,
    HT.REGION_NAME || '  '||HT.TEAM_NAME 홈팀,
    AT.REGION_NAME || '  '||AT.TEAM_NAME 원정팀,
    K.HOME_SCORE "홈팀 점수",
    K.AWAY_SCORE "원정팀 점수"
FROM 
    SCHEDULE K    
    JOIN STADIUM S
        ON K.STADIUM_ID LIKE S.STADIUM_ID
    JOIN TEAM HT     
        ON K.HOMETEAM_ID LIKE HT.TEAM_ID
    JOIN TEAM AT
        ON K.AWAYTEAM_ID LIKE AT.TEAM_ID
WHERE
    K.HOME_SCORE >= K.AWAY_SCORE +3 
ORDER BY K.SCHE_DATE     
;
-- SOCCER_SQL_015
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
SELECT 
    S.STADIUM_NAME,
    S.STADIUM_ID,
    S.SEAT_COUNT,
    S.HOMETEAM_ID,
    T.E_TEAM_NAME
FROM STADIUM S
    LEFT JOIN TEAM T
        ON S.HOMETEAM_ID LIKE T.TEAM_ID
ORDER BY S.HOMETEAM_ID
;
-- SOCCER_SQL_016
-- 소속이 삼성 블루윙즈 팀인 선수들과
-- 전남 드래곤즈팀인 선수들의 선수 정보
---- UNION VERSION
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
    T.TEAM_ID LIKE 'K02'
UNION
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
    T.TEAM_ID LIKE 'K07'
;
---- OR VERSION
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
    T.TEAM_ID LIKE 'K02' 
    OR T.TEAM_ID LIKE 'K07'
;
---- IN VERSION
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
    T.TEAM_ID IN ('K02', 'K07')
;
-- SOCCER_SQL_017
-- 소속이 삼성 블루윙즈 팀인 선수들과
-- 전남 드래곤즈팀인 선수들의 선수 정보
---- SUBQUERY VERSION
SELECT T.TEAM_NAME       팀명,
      P.PLAYER_NAME     선수명,
      P.POSITION        포지션,
      P.BACK_NO         백넘버,
      P.HEIGHT          키
 FROM PLAYER P 
    JOIN TEAM T 
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE T.TEAM_ID IN
          ((SELECT TEAM_ID
              FROM TEAM
             WHERE TEAM_NAME IN ('삼성블루윙즈', '드래곤즈')));


-- SOCCER_SQL_018
-- 최호진 선수의 소속팀과 포지션, 백넘버는 무엇입니까
SELECT
    T.TEAM_NAME 팀명,
    P.POSITION 포지션,
    P.BACK_NO 백넘버
FROM
    TEAM T 
    JOIN PLAYER P
    ON T.TEAM_ID LIKE P.TEAM_ID
WHERE
    P.PLAYER_NAME LIKE '최호진'
;
-- SOCCER_SQL_019
-- 대전시티즌의 MF 평균키는 얼마입니까? 174.87
SELECT 
    ROUND(AVG(P.HEIGHT),2) 평균키 
FROM 
    TEAM T 
    JOIN PLAYER P
    ON T.TEAM_ID LIKE P.TEAM_ID
WHERE
    T.TEAM_NAME LIKE '시티즌'
    AND P.POSITION LIKE 'MF'
;

-- SOCCER_SQL_020
-- 2012년 월별 경기수를 구하시오

SELECT 
    (SELECT COUNT(*) "1월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201201%') "1월",
    (SELECT COUNT(*) "2월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201202%') "2월",
    (SELECT COUNT(*) "3월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201203%') "3월",
    (SELECT COUNT(*) "4월" 
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201204%') "4월",
    (SELECT COUNT(*) "5월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201205%') "5월",
    (SELECT COUNT(*) "6월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201206%') "6월",
    (SELECT COUNT(*) "7월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201207%') "7월",
    (SELECT COUNT(*) "8월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201208%') "8월",
    (SELECT COUNT(*) "9월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201209%') "9월",
    (SELECT COUNT(*) "10월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201210%') "10월",
    (SELECT COUNT(*) "11월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201211%') "11월",
    (SELECT COUNT(*) "12월"
    FROM SCHEDULE
    WHERE SCHE_DATE LIKE '201212%') "12월"
FROM DUAL
;

-- SOCCER_SQL_021
-- 2012년 월별 진행된 경기수(GUBUN IS YES)를 구하시오
-- 출력은 1월:20경기 이런식으로...
SELECT SUBSTR(sche_date,1,6) 경기일자,
    COUNT(gubun) 경기수
FROM schedule 
WHERE gubun LIKE 'Y'
GROUP BY SUBSTR(sche_date,1,6)
ORDER BY SUBSTR(sche_date,1,6)
;

-- SOCCER_SQL_022
-- 2012년 9월 14일에 벌어질 경기는 어디와 어디입니까
-- 홈팀: ?   원정팀: ? 로 출력
SELECT 
    HT.TEAM_NAME 홈팀,
    AT.TEAM_NAME 원정팀
FROM 
    SCHEDULE K
    JOIN TEAM HT
        ON K.HOMETEAM_ID LIKE HT.TEAM_ID
    JOIN TEAM AT
        ON K.AWAYTEAM_ID LIKE AT.TEAM_ID
WHERE
    K.SCHE_DATE LIKE '20120914'
;
-- SOCCER_SQL_023
-- GROUP BY 사용
-- 팀별 선수의 수
-- 아이파크 20명
-- 드래곤즈 19명...
SELECT 
    COUNT(P.PLAYER_ID) 선수인원,
    (SELECT 
        A.TEAM_NAME
     FROM 
        TEAM A
     WHERE 
        A.TEAM_ID LIKE T.TEAM_ID   
 )팀명
FROM 
    TEAM T
    JOIN PLAYER P
    ON T.TEAM_ID LIKE P.TEAM_ID
GROUP BY 
    T.TEAM_ID
ORDER BY
    T.TEAM_ID
;
-- SOCCER_SQL_024
-- 선수들 포지션(한글 표시) 목록
-- 없으면 '없음'으로 표시
SELECT
   PLAYER_NAME 이름,
   CASE
       WHEN POSITION IS NULL THEN '없음'
       WHEN POSITION LIKE 'GK' THEN '골키퍼'
       WHEN POSITION LIKE 'DF' THEN '수비수'
       WHEN POSITION LIKE 'MF' THEN '미드필더'
       WHEN POSITION LIKE 'FW' THEN '공격수'
       ELSE POSITION
   END 팀장
FROM
  PLAYER
WHERE
   TEAM_ID = 'K08'
;
-- SOCCER_SQL_025
-- 삼성블루윙즈에서 키순으로  11위부터
-- 20위까지 출력
SELECT 
    B.*
FROM
(SELECT
    ROWNUM RNUM,
    A.*
FROM  (SELECT 
   
    T.TEAM_NAME 팀명,
    P.PLAYER_NAME 선수명,
    P.POSITION 포지션,
    P.BACK_NO 백넘버,
    P.HEIGHT 키
FROM PLAYER P
    JOIN TEAM T
        ON P.TEAM_ID LIKE T.TEAM_ID
WHERE 
    T.TEAM_ID LIKE 
        (SELECT TEAM_ID
FROM TEAM
WHERE TEAM_NAME LIKE '삼성블루윙즈')
 AND P.HEIGHT IS NOT NULL 
ORDER BY P.HEIGHT DESC)A)B
WHERE B.RNUM BETWEEN 11 AND 20
;
-- SOCCER_SQL_026
-- 팀별 골키퍼의 평균 키에서
-- 가장 평균키가 큰 팀명은 ? 울산 현대
-- 태형
SELECT
   A.TNAME
FROM
(SELECT
   (SELECT
   TEAM_NAME
FROM
   TEAM 
WHERE TEAM_ID LIKE T.TEAM_ID) TNAME,
   AVG(P.HEIGHT) AVG_HT,
   T.TEAM_ID
FROM
   TEAM T
   JOIN
   PLAYER P
       ON
       T.TEAM_ID LIKE P.TEAM_ID
WHERE
   P.POSITION LIKE 'GK'
GROUP BY T.TEAM_ID
ORDER BY AVG_HT DESC)A
WHERE ROWNUM = 1
;
-- SOCCER_SQL_027
-- 각 구단별 선수들 평균키가 삼성 블루윙즈팀의
-- 평균키보다 작은 팀의 이름과 해당 팀의 평균키를 
-- 구하시오 
--  형준 (답: 8팀)
SELECT ROWNUM NO, A.팀명, A.키
 FROM (  SELECT (SELECT TEAM_NAME
                   FROM TEAM
                  WHERE TEAM_ID LIKE T.TEAM_ID)
                    팀명,
                ROUND (AVG (P.HEIGHT), 2)
                    키
           FROM PLAYER P
               JOIN TEAM T
                   ON P.TEAM_ID LIKE T.TEAM_ID
          WHERE P.HEIGHT IS NOT NULL
       GROUP BY T.TEAM_ID) A,
      (  SELECT (SELECT TEAM_NAME
                   FROM TEAM
                  WHERE TEAM_ID LIKE T.TEAM_ID)
                    팀명,
                ROUND (AVG (P.HEIGHT), 2)
                    키
           FROM PLAYER P
               JOIN TEAM T
               ON P.TEAM_ID LIKE T.TEAM_ID
       GROUP BY T.TEAM_ID
         HAVING T.TEAM_ID LIKE
                    (SELECT TEAM_ID
                       FROM TEAM
                      WHERE TEAM_NAME LIKE '삼성블루윙즈')) B
WHERE A.키 < B.키
;
-- 혜리
select
   (select tb.team_name
   from team tb
   where tb.team_id like t.team_id) 팀명,
   round(avg(p.height),2) 평균키 
from player p
   join team t
       on p.team_id like t.team_id
group by t.team_id
having avg(p.height)<(
       select avg(pa.height)
       from player pa
           join team ta
               on pa.team_id like ta.team_id
       where ta.team_name like '삼성블루윙즈')
;
-- SOCCER_SQL_028
-- 2012년 경기 중에서 점수차가 가장 큰 경기 
-- 20120317, 일화천마 VS 유나이티드, 6점차경기
-- 세인
SELECT B.SCHE_DATE                    경기일,
      B.WTEAM || 'VS' || B.LTEAM     홈팀VS원정팀,
      B.DSCORE || '점차경기'     점수차
 FROM (SELECT ROWNUM RNUM, A.*
         FROM (  SELECT SC.SCHE_DATE,
                        ABS (SC.HOME_SCORE - SC.AWAY_SCORE)     
                                                    DSCORE,
                        HT.TEAM_NAME  WTEAM,
                        AT.TEAM_NAME  LTEAM
                   FROM SCHEDULE SC
                        JOIN TEAM HT 
                            ON HT.TEAM_ID LIKE SC.HOMETEAM_ID
                        JOIN TEAM AT 
                            ON AT.TEAM_ID LIKE SC.AWAYTEAM_ID
                  WHERE     SC.SCHE_DATE LIKE '2012%'
                        AND SC.HOME_SCORE IS NOT NULL
               ORDER BY DSCORE DESC) A) B
WHERE B.RNUM = 1;
-- 가은
select
   a.*
from
   (select
       sche_date 날짜,
       (select t.team_name 
       from team t 
       where t.team_id like sc.hometeam_id) 홈팀,
   (select t.team_name 
   from team t 
   where t.team_id like sc.awayteam_id) 원정팀,
       abs(sc.home_score-sc.away_score) 점수차
   from schedule sc
   where sc.sche_date like '2012%'
       and sc.GUBUN like 'Y'
   order by 점수차 desc)a
where rownum =1 
;
-- 소진
SELECT A.*
FROM(SELECT
        K.SCHE_DATE 경기날짜,
        HT.TEAM_NAME || ' VS ' || AT.TEAM_NAME 경기,
        CASE
            WHEN K.HOME_SCORE >= 
                K.AWAY_SCORE THEN (K.HOME_SCORE - K.AWAY_SCORE)
            ELSE K.AWAY_SCORE - K.HOME_SCORE
        END 점수차
     FROM
        SCHEDULE K
        JOIN TEAM HT
            ON K.HOMETEAM_ID LIKE HT.TEAM_ID
        JOIN TEAM AT
            ON K.AWAYTEAM_ID LIKE AT.TEAM_ID
     WHERE
        K.SCHE_DATE LIKE '2012%'
        AND K.GUBUN LIKE 'Y'
    
     ORDER BY 점수차 DESC) A
WHERE ROWNUM LIKE 1
;
-- SOCCER_SQL_029
-- 좌석수가 많은 대로 스타디움 순서 매기기
-- 소진
SELECT
    ROWNUM "순서",
    A.*
FROM(SELECT
        STADIUM_NAME 스타디움,
        SEAT_COUNT 좌석수
     FROM
        STADIUM
     ORDER BY SEAT_COUNT DESC) A
;
-- SOCCER_SQL_030
-- 2012년 구단 승리 순으로 순위매기기
-- 
SELECT    
   A.TEAM_NAME 팀명,    
   COUNT(A.SCORE)+COUNT(B.SCORE) 승수
FROM    (SELECT    
           SC.HOME_SCORE - SC.AWAY_SCORE SCORE,
           HT.TEAM_ID TEAM_ID,
           HT.TEAM_NAME TEAM_NAME
       FROM SCHEDULE SC
           JOIN TEAM HT ON HT.TEAM_ID LIKE SC.HOMETEAM_ID
           JOIN TEAM AT ON AT.TEAM_ID LIKE SC.AWAYTEAM_ID
       WHERE
           SC.HOME_SCORE - SC.AWAY_SCORE >0
           AND SC.SCHE_DATE LIKE '2012%') A JOIN
       (SELECT    
           SC1.AWAY_SCORE - SC1.HOME_SCORE SCORE,
           AT1.TEAM_ID TEAM_ID,
           AT1.TEAM_NAME TEAM_NAME
       FROM SCHEDULE SC1
           JOIN TEAM HT1 ON HT1.TEAM_ID LIKE SC1.HOMETEAM_ID
           JOIN TEAM AT1 ON AT1.TEAM_ID LIKE SC1.AWAYTEAM_ID
       WHERE
           SC1.AWAY_SCORE - SC1.HOME_SCORE >0
           AND SC1.SCHE_DATE LIKE '2012%') B 
            ON A.TEAM_ID LIKE B.TEAM_ID
GROUP BY
       A.TEAM_ID,A.TEAM_NAME
ORDER BY    
       COUNT(A.SCORE) DESC
;
-- 소진
SELECT 
    A.WINNER,
    COUNT(A.WINNER) 승리
FROM(SELECT
        K.SCHE_DATE 경기날짜,
        CASE
            WHEN K.HOME_SCORE > K.AWAY_SCORE THEN HT.TEAM_NAME
            WHEN K.AWAY_SCORE > K.HOME_SCORE THEN AT.TEAM_NAME
            ELSE '무승부'
        END WINNER
     FROM SCHEDULE K
            JOIN TEAM HT
                ON K.HOMETEAM_ID LIKE HT.TEAM_ID
            JOIN TEAM AT
                ON K.AWAYTEAM_ID LIKE AT.TEAM_ID
     WHERE
        K.GUBUN LIKE 'Y'
        AND K.SCHE_DATE LIKE '2012%'
    )A
WHERE A.WINNER NOT LIKE '무승부'
GROUP BY A.WINNER
ORDER BY 승리 DESC
;