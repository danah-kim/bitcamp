# RLang_002_bmi
bmi <- 160 / ((50 / 100) * (50 / 100))
if(bmi >= 35.0){
  print("3단계 비만")
}else
  if(bmi >= 30.0){
    print("2단계 비만")
  }else
    if(bmi >= 25.0){
      print("1단계 비만")
    }else
      if(bmi >= 20.0){
        print("비만 전단계")
      }else
        if(bmi >= 18.5){
          print("정상")
        }else
          if(bmi < 18.5){
            print("저체중")
          }
