## SOCCER_SQL_030 바차트
## 2012년 구단 승리 순으로 순위매기기
df_win_count <- dbGetQuery(conn, 
"SELECT 
    A.WINNER,
    COUNT(A.WINNER) WIN_COUNT
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
           WHERE K.GUBUN LIKE 'Y'
           AND K.SCHE_DATE LIKE '2012%'
    )A
WHERE A.WINNER NOT LIKE '무승부'
GROUP BY A.WINNER
ORDER BY WIN_COUNT DESC
")

df_win_count

barplot(df_win_count[,2],names.arg=df_win_count[,1])


## SOCCER_SQL_029 파이차트
## 좌석수가 많은 대로 스타디움 순서 매기기
df_seat_count <-dbGetQuery(conn,
"SELECT
  ROWNUM,
  A.*
FROM(SELECT
     STADIUM_NAME,
     SEAT_COUNT
     FROM
     STADIUM
     ORDER BY SEAT_COUNT DESC) A")

pie(df_seat_count[,3],paste(substr(df_seat_count[,2],1,2)))


## SOCCER_SQL_028 히스토그램
## 2012년경기의 점수차
df_score_count <- dbGetQuery(conn,
  "SELECT A.*
  FROM(SELECT
        K.SCHE_DATE 경기날짜,
        HT.TEAM_NAME || ' VS ' || AT.TEAM_NAME 경기,
        CASE
          WHEN K.HOME_SCORE >= K.AWAY_SCORE THEN (K.HOME_SCORE - K.AWAY_SCORE)
          ELSE K.AWAY_SCORE - K.HOME_SCORE
        END 점수차
  FROM SCHEDULE K
    JOIN TEAM HT
      ON K.HOMETEAM_ID LIKE HT.TEAM_ID
    JOIN TEAM AT
      ON K.AWAYTEAM_ID LIKE AT.TEAM_ID
  WHERE
        K.SCHE_DATE LIKE '2012%'
        AND K.GUBUN LIKE 'Y'
  ORDER BY 점수차 DESC) A
")

hist(df_score_count[,3],xlab="월별",col = "yellow",border = "blue")


## SOCCER_SQL_027 라인차트
## 각 구단별 선수들의 평균키
df_avg_height <- dbGetQuery(conn,"
  SELECT
    (select tb.team_name
     from team tb
     where tb.team_id like t.team_id) teamname,
     round(avg(p.height),2) avgheight
  from player p
    join team t
    on p.team_id like t.team_id
  group by t.team_id
                  ")

plot(df_avg_height$AVGHEIGHT, type = "o", main="각 구단별 선수들의 평균키", xlab = "구단명", ylab = "평균키")


## SOCCER_SQL_020 산포도
## 2012년 월별 경기수를 구하시오
df_month_count<-dbGetQuery(conn,
                           "SELECT 
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201201%') JAN,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201202%') FEB,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201203%') MAR,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201204%') APR,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201205%') MAY,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201206%') JUN,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201207%') JUL,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201208%') AUG,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201209%') SEP,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201210%') OCT,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201211%') NOV,
                           (SELECT COUNT(*)
                           FROM SCHEDULE
                           WHERE SCHE_DATE LIKE '201212%') DEC
                           FROM DUAL"
)

## 산포도
inputC <- df_month_count[,]
inputM <- c(1:12)
plot(x = inputM, y = inputC,
     xlab = 'month',
     ylab = 'count',
     main = '월별 경기수'
)