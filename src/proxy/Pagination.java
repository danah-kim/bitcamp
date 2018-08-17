package proxy;

import java.util.HashMap;

import lombok.Data;

@Data
public class Pagination implements Capable{
	int count, totalRecode, recodeSize, 
	totalPage, pageSize, 
	pageNum, startPage, endPage,
	startRow, endRow,
	pre, next;
	boolean existPre = false, existNext = false;
	
	@Override
	public void carrayOut(Object o) {
		@SuppressWarnings("unchecked")
		HashMap<String,Object> map = (HashMap<String, Object>) o;
		this.pageNum = (int) map.get("pageNum");
		this.totalRecode = (int) map.get("totalRecode");
		this.recodeSize = 5;
		this.totalPage = (totalRecode-1)/recodeSize+1;
		this.pageSize = 5;
		this.startPage = 1 + (int) (Math.ceil((pageNum-1)/pageSize)) * pageSize;
		this.endPage = (totalPage < startPage + pageSize  - 1) ? totalPage : (startPage + pageSize -1);
		this.startRow = 1 + ((pageNum-1) * recodeSize);
		this.endRow = (totalRecode < startRow + recodeSize - 1) 
										? totalRecode 
										: pageNum*(recodeSize);
		this.existPre = (startPage != 1);
		this.existNext = (endPage < totalPage && startPage != totalPage);
		this.pre = startPage-5;
		this.next= endPage+1;
	}
	
	
}
