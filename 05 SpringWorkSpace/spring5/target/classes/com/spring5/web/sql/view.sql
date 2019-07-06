create or replace view mem_view
	as
		select
			(select * from board) board,
			(select * from member) member,
			(select * from point) point