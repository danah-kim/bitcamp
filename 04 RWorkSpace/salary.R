# [1] Data Loading
var.csv <- "https://www.dropbox.com/s/9gchq4nbt67lpxu/example_salary.csv?dl=1"
var.salary <- read.csv(
  var.csv,
  fileEncoding = "euc-kr",
  stringsAsFactors = T,
  na = "-"
)

head(var.salary)

# [2] 구조파악
colnames(var.salary)
# 컬럼명변경
colnames(var.salary) <- c("age","wage","special","workingtime","workerCount","career","gender")

# [3] 검색대상을 data.frame으로 전환하기
attach(var.salary)

# [4] 전체 임금 평균 구하기
wage.range <- range(wage, na.rm=T)
wage.range
# 결과 1117605 4064286

highwage <- which(wage==4064286)
var.salary[highwage,]
# age    wage  special workingtime workerCount   career gender
# 48 50-54 4064286 12716896       178.2      439450 10년이상     남


# [5] 사분위 구하기
qnt <- quantile(wage, na.rm = T)
# 0%     25%     50%     75%    100% 
# 1117605 1689658 2120345 2519221 4064286

wage.list <- list(월급평균 = mean(wage, na.rm = T),
                  월급중앙값 = median(wage, na.rm = T),
                  월급범위 = range(wage, na.rm = T),
                  월급사분위 = quantile(wage, na.rm = T)
                  )
# $월급평균
# [1] 2171578
# 
# $월급중앙값
# [1] 2120345
# 
# $월급범위
# [1] 1117605 4064286
# 
# $월급사분위
# 0%     25%     50%     75%    100% 
# 1117605 1689658 2120345 2519221 4064286

wagePerGender <- tapply(wage, gender, mean, na.rm = T)
# 남      여 
# 2477332 1865823

t <- reshape2::melt(wagePerGender)
# Var1   value
# 1   남 2477332
# 2   여 1865823

ggplot(
  t,
  aes(x = Var1, 
      y = value,
      fill = Var1
      )
)+geom_bar(
  stat = "identity"
)

wagePerCareer <- tapply(
  wage, career, mean, na.rm=T
)
# 1~3년미만   10년이상    1년미만  3~5년미만 5~10년미만 
# 1905012    2907119    1730835    2028015    2360462 

t <- reshape2::melt(wagePerCareer)
# Var1   value
# 1  1~3년미만 1905012
# 2   10년이상 2907119
# 3    1년미만 1730835
# 4  3~5년미만 2028015
# 5 5~10년미만 2360462
ggplot(
  t,
  aes(x = Var1, 
      y = value,
      group = 1
      )
)+geom_line(
  color = 'blue',
  size = 2
)+coord_polar()+ylim(0,max(t))
