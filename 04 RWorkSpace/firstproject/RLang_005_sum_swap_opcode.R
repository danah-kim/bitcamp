# RLang_005_sum_swap_opcode
1-2+3-4+5-6+...-100 = -50
x <- seq(from=2, to=100, by=2)
y <- seq(from=1, to=100, by=2)
for(i in 1:100){
  if(i==100){cat(i,'=',sum(y-x))}else
    if(i%%2 == 1){cat(i,'-')}else
    {cat(i,'+')}
}

x <- 0
for(i in 1:100){
  if(i==100){
    x = x-i
    cat(i,'=',x)
  }else
    if(i%%2 == 1){
      x = x+i
      cat(i,'-')}else
      {
        x = x-i
        cat(i,'+')}
}

x <- 0
for(i in 1:100){
  if(i==100)
    cat(i,'=',sum(seq(1,100,2))-sum(seq(2,100,2)))
  else if(i%%2 == 1) 
    cat(i,'-')
  else
    cat(i,'+')
}

x <- 0
for(i in 1:100){
  if(i == 100)
    cat(i, '=', sum(seq(1,100,2)) - sum(seq(2,100,2)))
  else
    switch(
      toString(i %% 2),
      '0' = cat(i,'+'),
      '1' = cat(i,'-')
    )
}