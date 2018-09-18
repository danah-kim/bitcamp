"use strict";
var app = app || {};
var user = user || {};
//app.init = (()=>{
//	var init = x => {
//		console.log('step1');
//		app.session.context(x);
//		app.onCreate();
//		user.onCreate();
//	};
//	var onCreate = ()=>{
//		console.log('step3');
//		app.setContentView();
//		$('#addMenu').click (() => {
//			location.href = app.x() + '/move/auth/member/add';
//		});
//		$('#modifyMenu').click (()=>{
//			location.href = app.x() + '/move/member/member/modify';
//		});
//		$('#removeMenu').click (()=>{
//			location.href = app.x() + '/move/member/member/remove';
//		});
//		$('#loginMenu').click (() => {
//			location.href = app.x() + '/move/auth/member/login';
//		});
//		$('#logoutMenu').click (() => {
//			location.href = app.x() + '/member/logout';
//			sessionStorage.clear();
//		});
//		$('#addBtn').click (() => {
//			alert('가입버튼클릭');
//			$('#addForm')
//			.attr({
//				action : app.x()+"/member/add", 
//				method : "POST"})
//			.submit();
//		});
//		$('#searchBtn').click (() => {
//			alert('검색버튼클릭');
//			var search = $('.searchInfo');
//			$('#searchForm')
//			.attr({
//				action : app.x()+ '/member/serach'
//					+ '/condition=' + search[0].value 
//					+ '/word=' + search[1].value,
//				method : "GET"})
//			.submit();
//		});
//		$('#modifyBtn').click (() => {
//			alert('수정버튼클릭');
//			$('#modifyForm')
//			.append('<input type="hidden" name="userid" value="' + user.get('userid') + '"/>')
//			.attr({
//				action : app.x()+"/member/modify",
//				method : "POST"})
//			.submit();
//		});
//		$('#removeBtn').click (() => {
//			alert('삭제버튼클릭');
//			$('removeForm')
//			.append('<input type="hidden" name="userid" value="' + user.get('userid') + '"/>')
//			.attr({
//				action : app.x() + "/member/remove",
//				method : "POST"
//			})
//			.submit();
//		});
//		$('#loginBtn').click (() => {
//			$('#loginForm')
//			.attr({
//				action : app.x() + "/member/login",
//				method : "POST"
//			})
//			.submit();
//		});
//	};
//	var setContentView = ()=>{
//		console.log('step4'+ app.session.path('js'));
//	};
//	return{
//		init : init,
//	};
//})();
app = (()=>{
	var init =x=>{
		console.log('step1'+x);
		app.router.init(x);
		onCreate();
	};
	var onCreate =x=>{
		setContentView();
	};
	var setContentView =x=>{
	};
	return{init: init};
})();
app.main = (()=>{
	var ctx, script, style, img, w, header, nav, fluid, content, footerImg, footerBar, login;
	var init =()=>{
		ctx = $.ctx();
		script = $.script();
		style = $.style();
		img = $.img();
		w = $('#wrapper');
		header = script + '/header.js';
		nav = script + '/nav.js';
        fluid = script + '/fluid.js'
        content = script + '/content.js';
        footerImg = script + '/footerImg.js';
        footerBar = script + '/footerBar.js';
        login = script + '/login.js';
		onCreate();
	};
	var onCreate =()=>{
		setContentView();
	};
	var setContentView =()=>{
		$.when(
	            $.getScript(header),
	            $.getScript(nav),
	            $.getScript(fluid),
	            $.getScript(content),
	            $.getScript(footerImg),
	            $.getScript(footerBar),
	            $.Deferred(x=>{
	                $(x.resolve);
	            })
	    ).done(x=>{
	    	w.html(
	    			headerUi()
	    			+ navUi()
			    	+ fluidUi(ctx)
			    	+ contentUi(ctx)
			    	+ footerImgUi(ctx)
//			    	+ footerBarUi()
			    	);
	    	$('#loginMenu').click(x=>{
	    		x.preventDefault();
	    		alert(login);
	    		app.permission.login({login:login, ctx:ctx});
	    	});
	    	$('#blogMenu').click(()=>{
				app.board.init();
			});
	    }).fail(x=>{
	    });
	};
	return{init: init};
})();
app.board = (()=>{
	var ctx, script, style, img, w, header, nav, fluid, content, footerImg, footerBar;
	var init = ()=>{
		onCreate();
	};
	var onCreate =()=>{
		setContentView();
	};
	var setContentView = ()=>{
		alert('게시판');
		$('#nav1').remove();
		$('#content1').empty();
	};
	return{init:init, onCreate:onCreate, setContentView:setContentView};
})();
app.permission = (()=>{
	var login =x=>{
		alert('log');
		$('#nav1').remove();
		$('#fluid1').remove();
		$('#content1').empty();
		$.getScript(x.login,()=>{$('#content1').html(loginUi(x.ctx))});
	};
	return{login: login};
})();
user = {
	session : x => {
		$.each(x, (k, v)=>{
			sessionStorage.setItem(k, v);
		});
	},
	get : x =>{
		return sessionStorage.getItem(x);
	},
	onCreate : () => {
		alert('세션확인'+user.get('userid'));
		$('#userid').text(user.get('userid'));
		$('#name').text(user.get('name'));
		$('#infoTeamid').append(user.get('teamid'));
		$('#infoRoll').append(user.get('roll'));
		$('input[name="teamid"]').val([user.get('teamid')]);
		$('#roll').val(user.get('roll')).prop('selected', true);
	}
}

app.router = {
	init : x => {
		$.getScript(x + '/resources/js/router.js',
			() => {
					$.extend(new Session(x));
					$.getScript($.script() + '/util.js')
						.done(x=>{console.log('실행');})
						.fail(x=>{console.log('실패');})
					;
					app.main.init();
				}
		);
	}
};