# Rlang_003_calculator
cal <- function(num1,num2,op){
  return(c(num1,op,num2,'=',(switch(
    op,
    '+' = num1+num2,
    '-' = num1-num2,
    '*' = num1*num2,
    '/' = num1%/%num2,
    '%' = num1%%num2)
  )))
}
cal(sample(1:100,1,replace = TRUE),sample(1:100,1,replace = TRUE),'*')