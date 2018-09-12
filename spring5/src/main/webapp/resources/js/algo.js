var algo = algo || {};
algo = {
	init : x => {
		algo.onCreate(x);
		algo.setContextView();
	},
	onCreate : x => {
		algo.router.onCreate(x);
	},
	setContextView : () => {
		$('#wrapper').empty();
	}
};
algo.main = {
	onCreate:() => {
		algo.main.setContextView();
	},
	setContextView : () => {
		$('#wrapper').html('<h1>알고리즘</h1><div id="ctn"></div>'
			+ '<table id="tbl" style="width:800px; height: 300px;'		
			+ 'border-collapse: collapse; border: 1px solid black; margin: 0 auto">'
			+ '<tr style="border: 1px solid black;">'
			+ '<td id="tl" style="width: 50%; border: 1px solid black; text-align: center;"></td>'
			+ '<td id="tr" style="width: 50%; border: 1px solid black;"></td>'
			+ '</tr>'
			+ '</table>'
			+'</div>'
		);
		$('#tl').append('<a id="arith_seq"><h3>등차수열</h3></a>');
		$('#tl').append('<a id="fibonacci_seq"><h3>피보나치수열</h3></a>');
		$('#tl').append('<a id="swit_seq"><h3>스위치수열</h3></a>');
		$('#tl').append('<a id="factorial_seq"><h3>팩토리얼수열</h3></a>');
		$('#arith_seq').click(e=>{
			alert('등차수열 선택');
			algo.series.arith();
		});
		$('#fibonacci_seq').click(e=>{
			alert('피보나치수열 선택');
			algo.series.fibonacci();
		});
		$('#swit_seq').click(e=>{
			alert('스위치수열 선택');
			algo.series.swit(x);
		});
		$('#factorial_seq').click(e=>{
			alert('팩토리얼수열 선택');
			algo.factorial(x);
		});
	}
};
algo.series = {
	arith : x => {
		$('#tr').empty();
		$('#tr').append('<form id="form"></form>');
		$('#form').append('<input id="num" placeholder="숫자를 입력하세요" ></input>');
		$('#form').append('<button type="button" id="btn" >실행</button>');
		$('#btn').click(e=>{
			alert($('#num').val());
		});
	},
	fibonacci : x => {
		$('#tr').empty();
		$('#tr').append('<form id="form"></form>');
		$('#form').append('<input id="num" placeholder="숫자를 입력하세요" ></input>');
		$('#form').append('<button type="button" id="btn" >실행</button>');
		$('#btn').click(e=>{
			alert($('#num').val());
		});
	},
	swit : x => {
		$('#tr').empty();
		$('#tr').append('<form id="form"></form>');
		$('#form').append('<input id="num" placeholder="숫자를 입력하세요" ></input>');
		$('#form').append('<button type="button" id="btn" >실행</button>');
		$('#btn').click(e=>{
			alert($('#num').val());
		});
	},
	factorial : x => {
		$('#tr').empty();
		$('#tr').append('<form id="form"></form>');
		$('#form').append('<input id="num" placeholder="숫자를 입력하세요" ></input>');
		$('#form').append('<button type="button" id="btn" >실행</button>');
		$('#btn').click(e=>{
			alert($('#num').val());
		});
	}
};
algo.array = {
	bubble : x => {},
	insert : x => {},
	select : x => {},
	ranking : x => {}
};
algo.matrix = {
	fiveBy5 : x => {},
	sandGlass : x => {},
	snail : x => {},
	diamond : x => {},
	zigzag : x => {}
};
algo.math = {
		
};
algo.appl = {};
algo.router = {
	onCreate : x => {
		$.getScript(x + '/resources/js/router.js',
			() => {
				$.extend(new Session(x));
				algo.main.onCreate();
			}
		);
	}
};