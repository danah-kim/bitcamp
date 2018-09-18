"use strict";
var ui = {
	div : x => {
		return $('<div/>').attr(x);
	},
	anchor : x => { 
		return $('<a/>').attr({href: '#'}).html(x.txt);
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
		/*ui.span({
			id: "basic-addon1",
			value: x.div__val
		}).appendTo($('#input-group-prepend'));*/
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
	}
}