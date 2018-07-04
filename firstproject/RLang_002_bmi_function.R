# RLang_002_bmi
bmi <- function(height, weight){
  bmi <- weight / ((height / 100) * (height / 100))
  return(if(bmi >= 35.0){
    "3단계 비만"
  }else
    if(bmi >= 30.0){
      "2단계 비만"
    }else
      if(bmi >= 25.0){
        "1단계 비만"
      }else
        if(bmi >= 20.0){
          "비만 전단계"
        }else
          if(bmi >= 18.5){
            "정상"
          }else
            if(bmi < 18.5){
              "저체중"
            })
}

bmi(160,60)