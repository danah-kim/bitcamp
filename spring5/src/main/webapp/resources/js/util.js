"use strict";
$.prototype.nullChk = x =>{
	let flag = false;
	let i = 0;
	for (i in x){
		if(x[i] === '') flag = true;
	}
	return flag;		
}
$.prototype.zeroChk = x =>{
	let flag = false;
	let i = 0;
	for (i in x){
		if(x[i] == 0) flag =true;
	}
	return flag;		
}