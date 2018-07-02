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


