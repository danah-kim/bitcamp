# RLang_006_grade
name <- '홍길동'
kor <- 100
eng <- 90
math <- 100
switch(
  toString(sum(kor,eng,math)%/%3%/%10),
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