if("ggplot2" %in% installed.packages("ggplot2") == FALSE)install.packages("ggplot2")
library(ggplot2)
if("RColorBrewer" %in% installed.packages("RColorBrewer") == FALSE)install.packages("RColorBrewer")
library(RColorBrewer)
if("reshape" %in% installed.packages("reshape") == FALSE)install.packages("reshape")
library(reshape)
if("ggthemes" %in% installed.packages("ggthemes") == FALSE)install.packages("ggthemes")
library(ggthemes)


# [1] 데이터 로딩
cancer <- read.csv("https://www.dropbox.com/s/dw59m4q1vaqwayl/example_cancer.csv?dl=1", fileEncoding = "euc-kr")
cancer

# [2] 데이터 구조
str(cancer)

# [3] 연령대별 도수값(클래스의 개수)
degreeOfAge <- table(cut(cancer$age,breaks = (1:11)*10))

# [4] 컬럼명 이름변경
View(degreeOfAge)
rownames(degreeOfAge) <- c('10대','20대','30대','40대','50대','60대','70대','80대','90대','100대')

# [5] 시각화
ggplot2::ggplot(
  data = cancer,
  aes(x=cancer$age)
)+geom_freqpoly(
  binwidth = 10,
  size = 1.4,
  color = 'blue'
)
