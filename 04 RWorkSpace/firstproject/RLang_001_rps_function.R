# RLang_001_rps
# 가위 : 1, 바위 : 2, 보자기 : 3
rps <- function(com,user){
  return(c(switch(
    toString(com-user),
    '-2' = "승리",
    '1' = "승리",
    '-1' = "패배",
    '2' = "패배",
    '0' = "비김"
  )))
}
rps(sample(1:3,1,replace = TRUE),sample(1:3,1,replace = TRUE))