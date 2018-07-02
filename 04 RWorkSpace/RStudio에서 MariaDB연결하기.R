system('defaults write org.R-project.R force.LANG en_US.UTF-8')
system('defaults write org.R-project.R force.LANG ko_KR.UTF-8')

install.packages("DBI")
install.packages("RMySQL")

library(RMySQL)
con <- dbConnect(MySQL(), host = "203.236.209.54", dbname = "mariadb",
                 user = "mariadb", password = "mariadb", port = 3306)

dbListTables(con)

board  <- read.csv("/Users/danah/SpringWorkspace/Library/board.csv", header = T)

View(board)
dbWriteTable(con, "BOARD", board, overwrite = TRUE)

query <- "select * from BOARD"
dbGetQuery(con,query)
