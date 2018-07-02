system('defaults write org.R-project.R force.LANG en_US.UTF-8')

install.packages("DBI")
install.packages("RMySQL")

library(RMySQL)
con <- dbConnect(MySQL(), host = "203.236.209.54", dbname = "mariadb",
                 user = "mariadb", password = "mariadb", port = 3306)