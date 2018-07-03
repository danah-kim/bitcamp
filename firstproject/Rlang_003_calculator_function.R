# Rlang_003_calculator
cal <- function(num1,num2,op){
  return(switch(
    op,
    '+' = toString(num1+num2),
    '-' = toString(num1-num2),
    '*' = toString(num1*num2),
    '/' = toString(num1%/%num2),
    '%' = toString(num1%%num2)
  ))
}
cat(cal(sample(1:100,1,replace = TRUE),sample(1:100,1,replace = TRUE),'*'))