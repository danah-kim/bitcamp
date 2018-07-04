# Data Frame 생성
grade <- function(name, kor,eng,math){
  res <- c(kor,eng,math)
  return(list(name= name, 
              sum = sum(res), 
              mean = mean(res), 
              grade = switch(
                toString(mean(res)%/%10),
                '10' = 'A',
                '9' = 'A',
                '8' = 'B',
                '7' = 'C',
                '6' = 'D',
                '5' = 'F'
  )))
}

result1 <- grade("A",60,60,60)
result2 <- grade("B",70,70,70)
result3 <- grade("C",80,80,80)
result4 <- grade("D",90,90,90)
result5 <- grade("E",100,100,100)
class.data <- data.frame(
  name = c(result1$name,result2$name,result3$name,result4$name,result5$name),
  sum = c(result1$sum,result2$sum,result3$sum,result4$sum,result5$sum),
  mean = c(result1$mean,result2$mean,result3$mean,result4$mean,result5$mean),
  grade = c(result1$grade,result2$grade,result3$grade,result4$grade,result5$grade)
)

# 데이타 요약 
print(class.data)

# 데이터 추출
print(data.frame(class.data$name,class.data$mean))

## 파이 차트
pie(class.data$mean,class.data$name)
x <- class.data$mean
pct <- round(x / sum(x) * 100)
labels <- paste(class.data$name, pct,"%",sep="")
pie(x,labels,y)


## 바 차트
barplot(class.data$mean,names.arg=class.data$name)


