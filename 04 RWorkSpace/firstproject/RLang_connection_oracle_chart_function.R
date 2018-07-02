## 바차트 생성하기
show_bar_chart <- funtion(input){
  df_win_count <- dbGetQuery(conn,"input")
  return(barplot(x='', y='',name.arg=''))
}
## 파이차트 생성하기
show_pie_chart <- funtion(input){
  df_win_count <- dbGetQuery(conn,"input")
  return()
}
## 히스토그램 생성하기
show_histogram_chart <- funtion(input){
  df_win_count <- dbGetQuery(conn,"input")
  return()
}
## 라인차트 생성하기
show_line_chart <- funtion(input){
  df_win_count <- dbGetQuery(conn,"input")
  return()
}



## 산포도
show_degree_chart("SQL문")
## 주식차트
show_bar_chart("SQL문")
## 바차트
show_bar_chart("SQL문")
## 파이차트
show_pie_chart("SQL문")
## 히스토그램
show_histogram_chart("SQL문")
## 라인차트
show_line_chart("SQL문")
## 산포도
show_degree_chart("SQL문")
## 주식차트
show_bar_chart("SQL문")



# SQL30 바차트 : 구단승리순으로 순위매기기
query = "SELECT A.WINNER,
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
WHERE
K.GUBUN LIKE 'Y'
AND K.SCHE_DATE LIKE '2012%'
)A
WHERE A.WINNER NOT LIKE '무승부'
GROUP BY A.WINNER
ORDER BY WIN_COUNT DESC"
rs <- dbGetQuery(conn, query)
barplot(rs[,2],names.arg=rs[,1], main = "승리수")