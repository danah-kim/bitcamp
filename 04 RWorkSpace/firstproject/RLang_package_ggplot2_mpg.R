# 기능 설치
install.packages("ggplot2")

# 기능 가져옴
library(ggplot2)

#데이터 불러오기 read.csv(file = "경로명")

x <- c("2","2","3","1","4","4","4","4","4")
x
qplot(x)

# 제거
rm(x)

# manufacturer
# model : model name
# displ : engine displacement, in litres
# year : year of manufacture
# cyl : number of cylinders
# trans : type of transmission
# drv : f = front-wheel drive, r = rear wheel drive, 4 = 4wd
# cty : city miles per gallon
# hwy : highway miles per gallon
# fl : fuel type
# class : "type" of car

####### mpg 데이터 파악하기

#data = mpg, X축에 변수 지정해 그래프 생성
qplot(data = mpg, x = hwy)
# X축 cty
qplot(data = mpg, x = cty)

# mpg 데이터를 데이터 프레임으로 만든다
mpg <- as.data.frame(ggplot2::mpg)
# 상위 5개의 행 자료를 보여줌
head(mpg)
# 하위 5개의 행 자료를 보여줌
tail(mpg)
# 행과 열을 보여줌
dim(mpg)
# 속성타입을 보여줌
str(mpg)
# 요약정보를 보여줌
summary(mpg)

# 데이터 프레임에 추가 데이터(통합연비) 생성 (데이터베이스에 생성되지 않음)
mpg$total <- (mpg$cty + mpg$hwy) / 2 
# 추가내역 확인
head(mpg)
# 통합연비 평균 -> total 연비의 평균과 중앙값이 약 20인것을 확인
# total 연비가 20 ~25 사이에 해당하는 자동차 모델이 가장 많은 것을 확인
# 대부분 25이하이고, 25를 넘기는 자동차는 많지 않음을 알수 있음
mean(mpg$total)
summary(mpg$total)
# 통합연비 히스토그램
hist(mpg$total)

# 합격 판정 변수 만들기 : total이 20이상이면 pass, 미만이면 fail 부여
mpg$test <- ifelse(mpg$total >= 20, "Pass", "fail")
# 20개행의 자료를 보여줌
head(mpg, 20)
# 합격판정을 받은 자동차 수
table(mpg$test)
# 합격판정을 받은 자동차 수의 그래프
qplot(data=mpg, x = test)
qplot(mpg$test)

#연비에 따른 등급 변수 만들기
# 중첩조건문
# total 
# total 30이상 A 
# total 20 ~ 29 B
# total 20 미만 C
mpg$grade <- ifelse(
  mpg$total >= 30, "A",
  ifelse(mpg$total >= 20, "B", 
        ifelse(mpg$total >= 10, "C", "D")))
# 연비에 따른 등급 생성확인
table(mpg$grade)
# 연비에 따른 등급 그래프
qplot(mpg$grade)
# 변수명 변경
mpg <- rename(mpg, company <- manufacture)