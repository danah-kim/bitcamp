# ggplot2 패키지에는 미국 동북중부 437개 지역의 
# 인구통계 정보를 담은 midwest 라는 데이터가 
# 들어 있습니다.
# midwest 데이터를 사용해 데이터 분석 문제를 해결하시오
midwest_test <- as.data.frame(ggplot2::midwest)
str(midwest_test)
# 1.  poptotal 변수를 total 로, popasian 변수를 
# asian 으로 수정하세요
midwest_test$total <- midwest_test$poptotal
midwest_test <- subset(midwest_test,select = -poptotal)

midwest_test$asian <- midwest_test$popasian
midwest_test <- subset(midwest_test,select = -popasian)

# 2. total, asian 변수를 이용해 '전체 인구 대비 아시아 인구 
# 백분율' 파생변수를만들고, 히스토그램을 만들어 도시들이
# 어떻게 분포하는지 살펴보시오.
midwest_test$percentage <- (midwest_test$asian/midwest_test$total)*100
hist(midwest_test$percentage)

# 3.아시아 인구 백분율 전체 평균을 구하고, 평균을 초과하면
# 'large' , 그 외에는 'small' 을 부여하는 파생변수를 만드시오.
mean(midwest_test$percentage)
midwest_test$avg <- ifelse(midwest_test$percentage > mean(midwest_test$percentage), "Large", "small")

# 4. 'large' 와 'small' 에 해당하는 지역이 얼마나 되는지 
# 빈도표와 빈도 막대 그래프를 만들어 확인해 보세요.
qplot(midwest_test$avg)