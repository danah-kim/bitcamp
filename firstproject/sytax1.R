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


