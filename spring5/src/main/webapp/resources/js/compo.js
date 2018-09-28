"use strict";
var ui = {
	div : x => {
		return $('<div/>').attr(x);
	},
	anchor : x => { 
		return $('<a/>').attr({href: '#', id: x.id}).html(x.txt);
	},
	ul : x => {
		let y = $('<ul/>');
		for(var i=0; i<x.len; i++){
			$('<li/>').attr({id: x.id+'-'+i}).appendTo(y);
		}
		return y;
	},
	input : x=>{
		let y = ui.div({}).addClass("input-group mb-3");
		(ui.div({id:'input-group-prepend'})
				.addClass("input-group-prepend"))
				.html('<span class="input-group-text" id="basic-addon1">'+ x.txt+'</span>').appendTo(y);
		$("<input/>").attr({
			id : x.id,
			type: x.type,
			placeholder:x.holder ,
			"aria-label":"Username", 
			"aria-describedby":"basic-addon1"
		}).addClass("form-control").appendTo(y);
		return y;
	},
	label : x => {
		return $('<label/>').attr('for', x.id).text(x.txt);
	},
	button : x => {
		return $('<button/>').attr('type', 'button').addClass("btn btn-"+x.clazz).html(x.txt);
	},
	table : x => {
		let pp = $('<div class="panel panel-'+x.type+'"/>').attr({style:'margin: 50px auto; text-align: center;'});
		let ph = $('<div class="panel-heading">');
		let pb = $('<div class="panel-body">');
		ph.html(x.head).appendTo(pp);
		pb.appendTo(pp);
		$('<p/>').html(x.body).appendTo(pb);
		let t = $('<table/>');
		let thead = $('<thead/>');
		let th = $('<th/>');
		let tr = $('<tr/>');
		$(x.list)
		.each(function() {
			$('<th/>').html(this).appendTo(tr);
		});
		tr.appendTo(thead);
		thead.appendTo(t);
		$('<tbody/>').appendTo(t);
		t.attr({id:x.id}).addClass(x.clazz).appendTo(pp);
		return pp;
	},
	page : x=>{
		return $('<nav/>').attr({style:'text-align: center;'}).append($('<ul/>').addClass('pagination'));
	}
}