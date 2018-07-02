help("solve")
?solve
# java : int a = 3;
a <- "3"
a
b <- 4
c <- a + b
a <- 3
c <- a + b
c
a <- c(1,2,3,4)
a

# 데이터 타입을 다르게 할 경우 큰타입으로 자동변환
a <- c(1,"2",3,"4")
a


# concat 함수 
# int[] arr = new int[3];
# arr[0] = 1;
# arr[1] = 2;
# arr[2] = 3;
# arr <- c(1,2,3)
x <- c(1,2,3,4,5,6,7,8,9,10)
mysum <-sum(x)
x
mysum
sum((x-mean(x))^2)/(length(x)-1)


# seq 함수 
?seq
# JAVA setLength == R seq(length())
x <- seq(length=10,from=1,by=1)
x
x <- sum(seq(length=100,from=1,by=1))
x
sum(seq(length=100,from=1,by=1))


# sample 함수 
?sample
sample(1:3,1,replace = TRUE)


# RLang_001_rps
# 가위 : 1, 바위 : 2, 보자기 : 3
com <- sample(1:3,1,replace = TRUE)
user <- 1
if(user>=4)print("오류") else
if(user-com == -2 || user-com == 1) print("승리")else 
if (user-com == -1 || user-com == 2) print("패배") else
print("비김")


# switch
com <- sample(1:3,1,replace = TRUE)
user <- 2
cat('컴퓨터 : ', com)
res <- toString(user-com)
cat('결과 : ', res)
x <- switch(
  res,
  '-2' = "승리",
  '1' = "승리",
  '-1' = "패배",
  '2' - "패배",
  '0' = "비김"
)
print(x)

# 단축 
print(switch(
  toString(2-sample(1:3,1,replace = TRUE)),
  '-2' = "승리",
  '1' = "승리",
  '-1' = "패배",
  '2' = "패배",
  '0' = "비김"
))


# RLang_003_bmi
bmi <- 160 / ((50 / 100) * (50 / 100))
if(bmi >= 35.0){
  print("3단계 비만")
}else
  if(bmi >= 30.0){
    print("2단계 비만")
  }else
    if(bmi >= 25.0){
      print("1단계 비만")
    }else
      if(bmi >= 20.0){
      print("비만 전단계")
        }else
          if(bmi >= 18.5){
            print("정상")
          }else
            if(bmi < 18.5){
              print("저체중")
            }


# vector Type Example
print(
  c(1:10)
)

print(
  seq(from=1, to=10, by=2)
)

print(
  seq(from=1, length=10, by=2)
)

print(
  seq(1,10,2)
)

print(
  rep(1:5)
)

print(
  rep(1:5, each=2)
)

print(
  rep(1:5, times=2)
)

print(
  rep(1:5, each=2, times=3)
)

print(
  rep(1:5, times=3, each=2)
)

print(
  rep(1:5, times=3, each=2, len=5)
)

print(
  rep(1:5, each=2, times=3, len=5)
)


# Rlang_003_calculator
num1 <- sample(1:10,1,replace = TRUE)
num2 <- sample(1:10,1,replace = TRUE)
op <- '/'
cat(num1,op,num2,'=',switch(
      op,
      '+' = toString(num1+num2),
      '-' = toString(num1-num2),
      '*' = toString(num1*num2),
      '/' = toString(num1%/%num2),
      '%' = toString(num1%%num2)
      )
)

# RLang_004_sum_from1to5
# 1+2+3+4+5 = 15
for(i in 1:5){
  if(i==5){cat(i,'=',sum(c(1:5)))}
  else{cat(i,'+')}
}


# RLang_005_sum_swap_opcode
1-2+3-4+5-6+...-100 = -50
x <- seq(from=2, to=100, by=2)
y <- seq(from=1, to=100, by=2)
for(i in 1:100){
  if(i==100){cat(i,'=',sum(y-x))}else
  if(i%%2 == 1){cat(i,'-')}else
  {cat(i,'+')}
}

x <- 0
for(i in 1:100){
  if(i==100){
    x = x-i
    cat(i,'=',x)
  }else
    if(i%%2 == 1){
      x = x+i
      cat(i,'-')}else
      {
        x = x-i
        cat(i,'+')}
}

x <- 0
for(i in 1:100){
  if(i==100)
    cat(i,'=',sum(seq(1,100,2))-sum(seq(2,100,2)))
  else if(i%%2 == 1) 
    cat(i,'-')
  else
    cat(i,'+')
}

x <- 0
for(i in 1:100){
  if(i == 100)
    cat(i, '=', sum(seq(1,100,2)) - sum(seq(2,100,2)))
  else
    switch(
      toString(i %% 2),
      '0' = cat(i,'+'),
      '1' = cat(i,'-')
  )
}


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
cat(name, " | " ,sum(kor,eng,math)," | ",sum(kor,eng,math)%/%3, " | " ,grade)