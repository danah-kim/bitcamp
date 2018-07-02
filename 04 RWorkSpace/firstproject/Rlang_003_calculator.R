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