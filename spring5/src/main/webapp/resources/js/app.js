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
		app.router.home();
	};
	return{init: init};
})();

app.board = (()=>{
	var ctx, script, style, img, w, header, nav, fluid, content, footerImg, footerBar;
	var init = ()=>{
		ctx = $.ctx();
		script = $.script();
		style = $.style();
		img = $.img();
		onCreate();
	};
	var onCreate =()=>{
		setContentView();
	};
	var setContentView = ()=>{
		$('#fluid1').remove();
		app.service.boards(1);
	};
	return{init:init};
})();

app.permission = (()=>{
	var login =x=>{
		alert('log');
		$('#nav1').remove();
		$('#fluid1').remove();
		$.getScript($.script()+'/compo.js',()=>{
			$.getScript($.script() + '/login.js',()=>{
				$('#content1').html(loginUi($.ctx()));
				$('#login1')
				.children().last()
				.append(ui.anchor({id:'loginBtn', txt:'Login'})
				.addClass('formBtn'));
				$('#loginBtn')
				.click (x => {
					x.preventDefault();
					let y = app.service.nullChk([$('#id').val(), $('#pw').val()]);
					if(y.checker){
						$.ajax({
							url : $.ctx() + '/mbr/login',
							method : 'POST',
							contentType : 'application/json',
							data : JSON.stringify({userid : $('#id').val(), password : $('#pw').val()}),
							success : x => {
								if(typeof x.msg !== "undefined") {
									alert(x.msg)
									}else{
										user.session({
											userid : x.user.userid,
											name : x.user.name,
											age : x.user.age,
											gender : x.user.gender,
											teamid : x.user.teamid,
											roll : x.user.roll
										});
										$('#menu1').html('<a id="myMenu" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">'
															+ '<i class="fa fa-user"></i>'
															+ '</a>'
															+ '<ul class="dropdown-menu" role="menu" aria-labelledby="drop1">'
															+ '<li role="presentation"><a id="myBoard" role="menuitem" tabindex="-1">내게시물</a></li>'
															+ '<li role="presentation"><a id="modifyMenu" role="menuitem" tabindex="-1">정보수정</a></li>'
															+ '<li role="presentation"><a id="removeMenu" role="menuitem" tabindex="-1">탈퇴</a></li>'
															+ '</ul>');
										$('#menu2').html('<a id="logoutMenu"><i class="fa fa-sign-out"></i></a>');
										$('#logoutMenu').click (e => {
											app.init($.ctx());
											sessionStorage.clear();
											alert('로그아웃'+user.get('userid'));
										});
										$('#myBoard').click(()=>{
											alert('확인'+user.get('userid'))
											app.service.myBoard({
												id: user.get('userid'),
												pageNo: 1
											});
										});
										$.getScript($.script() + '/fluid.js', ()=>{
											$('#header1').after(fluidUi($.ctx()));
										});
										$.getScript($.script() + '/nav.js', ()=>{
											$('#header1').after(navUi());
										});
										$('#content1').html(contentUi($.ctx()));
										
									}
							},
							error : (m1, m2, m3)=>{
								alert('에러발생1'+m1);
								alert('에러발생2'+m2);
								alert('에러발생3'+m3);
							}
						});
					}else{
						alert(y.msg);
					}
					
				});
			});
		});
	};
	var join =x=>{
		alert('add');
		$.getScript($.script()+'/compo.js',()=>{
			$.getScript($.script() + '/add.js', ()=>{
				$('#nav1').remove();
	    		$('#fluid1').remove();
	    		$('#content1').empty();
				$('#content1').html(addUi($.ctx()));
				$('#addTable')
				.append(ui.anchor({id:'addBtn', txt:'가입하기'}));
				$('#addBtn')
				.click (e => {
					e.preventDefault();
					var a ='';
					$('[name="subject"]:checked').each(()=> {
						a += $(this).val() + ",";
					});
					let y = app.service.nullChk([$('#userid').val(), 
													$('[name="teamid"]:checked').val(),
													$('[name="subject"]:checked').val(),
													$('#name').val(),
													$('#age').val(),
													$('#roll').val(),
													$('#password').val(),
													$('#gender').val()
					]);
					if(y.checker){
	    				$.ajax({
	    					url : $.ctx() + '/mbr/add',
	    					method : 'POST',
	    					contentType : 'application/json',
	    					data : JSON.stringify({
	    									userid : $('#userid').val(),
	    									teamid : $('[name="teamid"]:checked').val(),
	    									subject : a,
	    									name : $('#name').val(),
	    									age : $('#age').val(),
	    									roll : $('#roll').val(),
	    									password : $('#password').val(),
	    									gender : $('#gender').val()
	    									}),
	    					success : x =>{
	    						app.permission.login();
	    					},
	    					error : (m1, m2, m3)=>{
	    						alert('에러발생1'+m1);
	    						alert('에러발생2'+m2);
	    						alert('에러발생3'+m3);
	    					}
	    				});
					}else{
						alert(y.msg);
					}
				});
			});
		});
	};
	return{login: login, join:join};
})();

app.router = {
	init : x => {
		$.getScript(x + '/resources/js/router.js',
			() => {
					$.extend(new Session(x));
					$.getScript($.script() + '/util.js')
						.done(x=>{console.log('실행');})
						.fail(x=>{console.log('실패');});
					app.main.init();
				}
		);
	},
	home : x => {
		$.when(
	            $.getScript($.script() + '/header.js'),
	            $.getScript($.script() + '/nav.js'),
	            $.getScript($.script() + '/fluid.js'),
	            $.getScript($.script() + '/content.js'),
	            $.getScript($.script() + '/footerImg.js'),
	            $.getScript($.script() + '/footerBar.js'),
	            $.Deferred(x=>{
	                $(x.resolve);
	            })
	    ).done(x=>{
	    	$('#wrapper').html(
	    			headerUi()
	    			+ navUi()
			    	+ fluidUi($.ctx())
			    	+ contentUi($.ctx())
			    	+ footerImgUi($.ctx())
			    	+ footerBarUi()
			    	);
	    	$('#loginMenu').click(x=>{
	    		x.preventDefault();
	    		app.permission.login();
	    	});
	    	$('#addMenu').click (x=>{
	    		x.preventDefault();
	    		app.permission.join();
	    	});
	    	$('#boardMenu').click(x=>{
	    		x.preventDefault();
				app.board.init();
			});
	    })
	    .fail(x=>{
	    	alert('실패?');
	    });
	}
};

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
	};

app.service = {
	nullChk : x =>{
		let rs = {
			checker : true,
			msg : '필수입력값이 입력되지 않았습니다.'
		};
		$(x).each(function(){ if(this === '') rs.checker = false; });
		return rs;
	},
	boards : x =>{
		$.getJSON($.ctx()+'/boards/'+x,d=>{
			$.getScript($.script() + '/compo.js',()=>{
				$('#content1').empty();
				(ui.table({
					type : 'primary',
					id: 'table',
					head: '게시판',
					body: '오픈게시판...누구든지사용가능',
					list:['No', '제목', '내용', '작성일','작성자', '조회수'],
					clazz : 'table table-bordered'
				})).appendTo($('#content1'));
				$(d.list).each(function() {
					$('<tr/>').append(
						$('<td/>').attr({style:'width:5%'}).html(this.bno),
						$('<td/>').attr({style:'width:10%'}).html(this.title),
						$('<td/>').attr({style:'width:50%'}).html(this.content),
						$('<td/>').attr({style:'width:10%'}).html(this.regdate),
						$('<td/>').attr({style:'width:10%'}).html(this.writer),
						$('<td/>').attr({style:'width:5%'}).html(this.viewcnt)
					).appendTo($('tbody'));
				});
				ui.page().appendTo($('#content1'));
				$('<li/>')
					.addClass('page-item ' + ((d.page.existPre) ? '' : 'disabled'))
					.append(
						$('<span/>')
							.html('◀︎')
							.addClass('page-link')
							.attr({style:'cursor: pointer'})
					)
					.appendTo($('.pagination'))
					.click(function(){
						app.service.boards(d.page.pre);
					});
				for (let i = d.page.startPage; i <= d.page.endPage; i++) {
					$('<li/>').addClass('page-item ' + ((d.page.pageNum == i)? 'active' : '')).append(
							$('<span/>')
								.addClass('page-link')
								.attr({style:'cursor: pointer'})
								.html(i)
								.click(function(){
									//console.log($(this).text());
									app.service.boards($(this).text());
								})
					).appendTo($('.pagination'));
		        }
				$('<li/>')
					.addClass('page-item ' + ((d.page.existNext) ? '' : 'disabled'))
					.append(
						$('<span/>')
							.html('▶︎')
							.addClass('page-link')
							.attr({style: 'cursor: pointer'})
					)
					.appendTo($('.pagination'))
					.click(function(){
						app.service.boards(d.page.next);
					});
				});
		});
	},
	myBoard : x=>{
		$.getJSON($.ctx()+'/boards/'+x.id+'/'+x.pageNo, d=>{
			$.getScript($.script() + '/compo.js',()=>{
				$('#fluid1').remove();
				$('#content1').empty();
				(ui.table({
					type : 'primary',
					id: 'table',
					head: '게시판',
					body: '오픈게시판...누구든지사용가능',
					list:['No', '제목', '내용', '작성일','작성자', '조회수'],
					clazz : 'table table-bordered'
				})).appendTo($('#content1'));
				$(d.list).each(function() {
					$('<tr/>').append(
						$('<td/>').attr({style:'width:5%'}).html(this.bno),
						$('<td/>').attr({style:'width:10%'}).html(this.title),
						$('<td/>').attr({style:'width:50%'}).html(this.content),
						$('<td/>').attr({style:'width:10%'}).html(this.regdate),
						$('<td/>').attr({style:'width:10%'}).html(this.writer),
						$('<td/>').attr({style:'width:5%'}).html(this.viewcnt)
					).appendTo($('tbody'));
				});
				ui.page().appendTo($('#content1'));
				$('<li/>')
					.addClass('page-item ' + ((d.page.existPre) ? '' : 'disabled'))
					.append(
						$('<span/>')
							.html('◀︎')
							.addClass('page-link')
							.attr({style:'cursor: pointer'})
					)
					.appendTo($('.pagination'))
					.click(function(){
						app.service.myBoard({
							id: user.get('userid'),
							pageNo: d.page.pre
						});
					});
				for (let i = d.page.startPage; i <= d.page.endPage; i++) {
					$('<li/>').addClass('page-item ' + ((d.page.pageNum == i)? 'active' : '')).append(
							$('<span/>')
								.addClass('page-link')
								.attr({style:'cursor: pointer'})
								.html(i)
								.click(function(){
									//console.log($(this).text());
									app.service.myBoard({
										id: user.get('userid'),
										pageNo: $(this).text()
									});
								})
					).appendTo($('.pagination'));
		        }
				$('<li/>')
					.addClass('page-item ' + ((d.page.existNext) ? '' : 'disabled'))
					.append(
						$('<span/>')
							.html('▶︎')
							.addClass('page-link')
							.attr({style: 'cursor: pointer'})
					)
					.appendTo($('.pagination'))
					.click(function(){
						app.service.myBoard({
							id: user.get('userid'),
							pageNo: d.page.next
						});
					});
				});
		});
	}
};