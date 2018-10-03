"use strict";
var app = app || {};
var user = user || {};
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
		alert('로그인');
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
					if($.fn.nullChk([$('#id').val(), $('#pw').val()])){
						alert('필수 입력값이 입력되지 않았습니다.');
					}else{
						$.ajax({
							url : $.ctx() + '/mbr/login',
							method : 'POST',
							contentType : 'application/json',
							data : JSON.stringify({userid : $('#id').val(), password : $('#pw').val()}),
							success : x => {
								if(typeof x.msg !== "undefined") {
									alert(x.msg);
								}else{
									$.getScript($.script() + '/router.js', () => {
										$.extend(new User(x.user));
										$.cookie("logID", x.user.userid);
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
											$.removeCookie("logID");
											alert('로그아웃'+$.userid());
											alert($.cookie("logID"));
										});
										$('#myBoard').click(()=>{
											app.service.myBoard({
												id: $.userid(),
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
									});
								}
							},
							error : (m1, m2, m3)=>{
								alert('에러발생1'+m1);
								alert('에러발생2'+m2);
								alert('에러발생3'+m3);
							}
						});
					}
				});
			});
		});
	};
	var join =x=>{
		alert('가입하기');
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
					if($.fn.nullChk([$('#userid').val(), 
						$('[name="teamid"]:checked').val(),
						$('[name="subject"]:checked').val(),
						$('#name').val(),
						$('#age').val(),
						$('#roll').val(),
						$('#password').val(),
						$('#gender').val()])
					){
						alert('필수 입력값이 입력되지 않았습니다.');
					}else{
						let a ='';
						$('[name="subject"]:checked').each(function() {
							a += $(this).val() + ",";
						});
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
	    	$('#dragMenu').click(x=>{
	    		alert('클릭');
	    		x.preventDefault();
	    		$('#content1').html(
	    			'<h3>Ajax File Upload</h3>'
	    			+'<div class="fileDrop"></div>'
	    			+'<div class="uploadedList"></div>'
	    		);
	    		$(".fileDrop")
                .attr('style','width:100%;height:200px;border:1px dotted blue')
                .on('dragenter dragover',e=>{
                    e.preventDefault();
                })
                $(".fileDrop").on('drop',e=>{
                    e.preventDefault();
                    var files = e.originalEvent.dataTransfer.files;
                    var file = files[0];
                    console.log(file);
                    var formData = new FormData();
                    formData.append('file',file);
                    $.ajax({
                        url:$.ctx()+'/uploadAjax',
                        data : formData,
                        dataType:'text',
                        processData:false,
                        contentType:false,
                        type:'post',
                        success:d=>{
                            alert(d);
                        }
                    })
                })
			});
	    })
	    .fail(x=>{
	    	alert('실패?');
	    });
	}
};

app.service = {
	boards : x =>{
		$.getJSON($.ctx()+'/boards/'+x, d=>{
			$.getScript($.script() + '/compo.js', ()=>{
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
				for (let i = d.page.startPage-1; i <= d.page.endPage+1; i++) {
					$('<li/>')
					.addClass('page-item ' + ((((d.page.startPage-1 == i) && !d.page.existPre) || ((d.page.endPage+1 == i) && !d.page.existNext)) ? 
												'disabled' :
												(d.page.pageNum == i) ? 
												'active' 
												: ''))
					.append(
						$('<span/>')
							.addClass('page-link')
							.attr({style:'cursor: pointer'})
							.html((d.page.startPage-1 == i) ? '◀︎' : (d.page.endPage+1 == i) ? '▶︎︎' : i)
					)
					.appendTo($('.pagination'))
					.click(function(){
						//console.log($(this).text());
						app.service.boards((d.page.startPage-1 == i) ? d.page.pre : (d.page.endPage+1 == i) ? d.page.next : $(this).text());
					});
		        }
			});
		});
	},
	myBoard : x=>{
		$.getJSON($.ctx()+'/boards/'+x.id+'/'+x.pageNo+'/'+x.boardNo, d=>{
			$.getScript($.script() + '/compo.js',()=>{
				$('#fluid1').remove();
				$('#content1').empty();
				(ui.table({
					type : 'primary',
					id: 'table',
					head: '게시판',
					body: '오픈게시판...누구든지사용가능',
					list:['No', '제목', '내용', '작성일','작성자', '조회수', '삭제'],
					clazz : 'table table-bordered'
				})).appendTo($('#content1'));
				$(d.list).each(function() {
					$('<tr/>').append(
						$('<td/>').attr({style:'width:5%'}).html(this.bno),
						$('<td/>')
						.attr({style:'width:10%; cursor: pointer'})
						.html(this.title)
						.click(()=>{
							app.service.updateBoard({
								id: $.userid(),
								boardNo: this.bno
							});
						}),
						$('<td/>').attr({style:'width:50%'}).html(this.content),
						$('<td/>').attr({style:'width:10%'}).html(this.regdate),
						$('<td/>').attr({style:'width:10%'}).html(this.writer),
						$('<td/>').attr({style:'width:5%'}).html(this.viewcnt),
						$('<td/>').attr({style:'width:5%'})
						.append(
							$('<input/>')
							.attr({type: 'checkbox', name: 'boardChk'}
							)
							.click(()=>{
								if(confirm('삭제하시겠습니까?')){
									alert('삭제완료');
									console.log(this.bno);
									$.ajax({
										url : $.ctx() + '/boards/remove',
										method : 'POST',
										contentType : 'application/json',
										data : JSON.stringify({boardNo : this.bno,
																userid : $.userid()}),
										success : x => {
											app.service.myBoard({
												id: $.userid()
											});
										},
										error : (m1, m2, m3)=>{
											alert('에러발생1'+m1);
											alert('에러발생2'+m2);
											alert('에러발생3'+m3);
										}
									});
								}else{
									$(this).prop('checked', false);
								}
							})
						)
					).appendTo($('tbody'));
				});
				ui.page().appendTo($('#content1'));
				for (let i = d.page.startPage-1; i <= d.page.endPage+1; i++) {
					$('<li/>')
					.addClass('page-item ' + ((((d.page.startPage-1 == i) && !d.page.existPre) || ((d.page.endPage+1 == i) && !d.page.existNext)) ? 
												'disabled' :
												(d.page.pageNum == i) ? 
												'active' 
												: ''))
					.append(
						$('<span/>')
							.addClass('page-link')
							.attr({style:'cursor: pointer'})
							.html((d.page.startPage-1 == i) ? '◀︎' : (d.page.endPage+1 == i) ? '▶︎︎' : i)
					)
					.appendTo($('.pagination'))
					.click(function(){
						app.service.myBoard({
							id: $.userid(),
							pageNo : (d.page.startPage-1 == i) ? d.page.pre : (d.page.endPage+1 == i) ? d.page.next : $(this).text()
						});
					});
		        }
				$('<div/>')
				.addClass('btn-group')
				.attr({role: 'group', style: 'float: right;'})
				.append(
					$('<button/>')
					.addClass('btn btn-default')
					.attr({id: 'boardUpdate', type: 'button'})
					.html('등록')
					.click(()=>{
						app.service.addBoard();
					})
				)
				.appendTo($('#content1'));
			});
		});
	},
	addBoard : x=>{
			$.getScript($.script() + '/compo.js',()=>{
				$('#content1').empty();
				(ui.table({
					type : 'primary',
					id: 'table',
					head: '게시글 작성하기',
					list:['제목', '내용', '작성일','작성자'],
					clazz : 'table table-bordered'
				})).appendTo($('#content1'));
				$('<tr/>').append(
					$('<td/>').attr({style:'width:5%'}).append($('<input/>').attr({type: 'text', id: 'title'})),
					$('<td/>').attr({style:'width:50%'}).append($('<input/>').attr({type: 'text', id: 'content'})),
					$('<td/>').attr({style:'width:10%', type: 'text', id: 'regdate'}).html(new Date().getFullYear()+'-'+(new Date().getMonth()+1)+'-'+new Date().getDate()),
					$('<td/>').attr({style:'width:10%', type: 'text', id: 'writer'}).html($.userid())
				).appendTo($('tbody'));
				$('<div/>')
				.addClass('btn-group')
				.attr({role: 'group', style: 'float: right;'})
				.append(
						$('<form id = "frm" action = "uploadForm" '
								+' method="post" enctype="multipart/form-data"  />'
								+'<input type = "file" name="file">'
								+'<input type = "submit">'
								+'</form>')
							.click(e=>{
								    $.ajax({
								        url:$.ctx()+'/boards/fileupload',
								        type:'POST',
								        data:new FormData($('frm')),
								        async:false,
								        cache:false,
								        contentType:false,
								        processData:false
								    }).done(function(response){
								        alert(response);
								    });
							}),
							$('<br/>'),
					$('<button/>')
					.addClass('btn btn-default')
					.attr({id: 'boardUpdate', type: 'button'})
					.html('저장')
					.click(x=>{
						x.preventDefault();
						if($.fn.nullChk([$('#title').val(), $('#content').val()])){
							alert('필수 입력값이 입력되지 않았습니다.');
						}else{
							$.ajax({
								url : $.ctx() + '/boards/add',
								method : 'POST',
								contentType : 'application/json',
								data : JSON.stringify({title : $('#title').val(), 
														content : $('#content').val(),
														writer : $.userid()}),
								success : x => {
									app.service.myBoard({
										id: $.userid()
									});
								},
								error : (m1, m2, m3)=>{
									alert('에러발생1'+m1);
									alert('에러발생2'+m2);
									alert('에러발생3'+m3);
								}
							});
						}
					})
				)
				.appendTo($('#content1'));
			});
	},
	updateBoard : x=>{
		$.getJSON($.ctx()+'/boards/'+x.id+'/'+x.pageNo+'/'+x.boardNo, d=>{
			$.getScript($.script() + '/compo.js',()=>{
				$('#fluid1').remove();
				$('#content1').empty();
				(ui.table({
					type : 'primary',
					id: 'table',
					head: '수정하기',
					list:['제목', '내용', '작성일','작성자'],
					clazz : 'table table-bordered'
				})).appendTo($('#content1'));
				$('<tr/>').append(
					$('<td/>').attr({style:'width:10%'}).append($('<input/>').attr({type: 'text', id: 'title'}).val(d.list[0].title)),
					$('<td/>').attr({style:'width:50%'}).append($('<input/>').attr({type: 'text', id: 'content'}).val(d.list[0].content)),
					$('<td/>').attr({style:'width:10%'}).html(d.list[0].regdate),
					$('<td/>').attr({style:'width:10%'}).html(d.list[0].writer)
				).appendTo($('tbody'));
				$('<div/>')
				.addClass('btn-group')
				.attr({role: 'group', style: 'float: right;'})
				.append(
					$('<button/>')
					.addClass('btn btn-default')
					.attr({id: 'boardUpdate', type: 'button', value: d.list[0].bno})
					.html('저장')
					.click(function(){
						if($.fn.nullChk([$('#title').val(), $('#content').val()])){
							alert('필수 입력값이 입력되지 않았습니다.');
						}else{
							$.ajax({
								url : $.ctx() + '/boards/update',
								method : 'POST',
								contentType : 'application/json',
								data : JSON.stringify({bno : $(this).val(),
														title : $('#title').val(), 
														content : $('#content').val()}
								),
								success : x => {
									app.service.myBoard({
										id: $.userid()
									});
								},
								error : (m1, m2, m3)=>{
									alert('에러발생1'+m1);
									alert('에러발생2'+m2);
									alert('에러발생3'+m3);
								}
							});
						}
					})
				)
				.appendTo($('#content1'));
			});
		});
	}
};