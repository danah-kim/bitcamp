"use strict";
function Session(x){
	sessionStorage.setItem('ctx', x);
	sessionStorage.setItem('script', x + '/resources/js');
	sessionStorage.setItem('css', x + '/resources/css');
	sessionStorage.setItem('img', x + '/resources/img');
	return {
		ctx : () => {return sessionStorage.getItem('ctx');},
		script : () => {return sessionStorage.getItem('script');},
		style : () => {return sessionStorage.getItem('css');},
		img : () => {return sessionStorage.getItem('img');}
	};
};
function User(x){
	$.each(x,(k, v)=>{
		sessionStorage.setItem(k, v);
	});
	return {
		userid : () => {return sessionStorage.getItem('userid');},
		name1 : () => {return sessionStorage.getItem('name');},
		age : () => {return sessionStorage.getItem('age');},
		gender : () => {return sessionStorage.getItem('gender');},
		teamid : () => {return sessionStorage.getItem('teamid');},
		roll : () => {return sessionStorage.getItem('roll');},
		subject : () => {return sessionStorage.getItem('subject');}
	};
};