# 01 - 05
# 21 - 25
matrix(1:25, nrow =5, byrow = TRUE)

# 01 - 21
# 05 - 25
matrix(1:25, nrow =5, byrow = FALSE)


##선택
mtxSelect<-function(input){
  return(switch(toString(input),
                '1'= 
                  m1 <- c(1,0,0,0,0),
                  m2 <- c(2,3,0,0,0),
                  m3 <- c(4,5,6,0,0),
                  m4 <- c(7,8,9,10,0),
                  m5 <- c(11,12,13,14,15),
                  rbind(m1,m2,m3,m4,m5),
                '2'= 
                  rbind(matrix(c(1:5), nrow = 1, byrow = TRUE),
                  matrix(c(10:6), nrow = 1, byrow = TRUE),
                  matrix(c(11:15), nrow = 1, byrow = TRUE),
                  matrix(c(16:20), nrow = 1, byrow = TRUE),
                  matrix(c(21:25), nrow = 1, byrow = TRUE)),
                '3'=
                  rbind(matrix(c(0,0,1,0,0), nrow = 1, byrow = TRUE),
                        matrix(c(0,2:4,0), nrow = 1, byrow = TRUE),
                        matrix(c(5:9), nrow = 1, byrow = TRUE),
                        matrix(c(0,10:12,0), nrow = 1, byrow = TRUE),
                        matrix(c(0,0,13,0,0), nrow = 1, byrow = TRUE))
  ))
}

## 왼쪽 삼각형
mtxSelect(1)
## 지그재그
mtxSelect(2)
## 다이아몬드
mtxSelect(3)