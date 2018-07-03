# RLang_006_grade
name <- '홍길동'
kor <- 100
eng <- 90
math <- 100
switch(
  toString(sum(kor,eng,math)%/%3/10),
  '10' = grade <- 'A',
  '9' = grade <- 'A',
  '8' = grade <- 'B',
  '7' = grade <- 'C',
  '6' = grade <- 'D'
)
cat("****************************************************")
cat("    이름    |    총점    |    평균    |    등급    |")
cat("----------------------------------------------------")
cat(name, " | " ,sum(kor,eng,math)," | ",sum(kor,eng,math)%/%3, " | " ,grade)
cat("****************************************************")


# stmt를 합치면 function이 된다.
# 4가지(name, argument, body, return value)
grade <- function(name, kor,eng,math){
  return(c(name, sum(c(kor, eng, math)), mean(c(kor, eng, math)), switch(
    toString(mean(c(kor, eng, math))/10),
    '10' = 'A',
    '9' = 'A',
    '8' = 'B',
    '7' = 'C',
    '6' = 'D',
    '5' = 'F'
  )))
}
result <- grade("강감찬",60,60,60)
cat(result)
cat("**************************************************** \n
    |    이름    |    총점    |    평균    |    등급    |\n
    ----------------------------------------------------\n
    | " , result[1], " | " ,result[2]," | ",result[3], " | " ,result[4]," |\n
    ****************************************************")
