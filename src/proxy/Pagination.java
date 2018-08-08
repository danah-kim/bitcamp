package proxy;

import lombok.Data;
import service.MemberServiceImpl;

@Data
public class Pagination implements Proxy{
	int count, totalRecode, recodeSize, 
	totalPage, pageSize, 
	pageNum, startPage, endPage,
	startRow, endRow;
	boolean existPrev = false, existNext = false;
	
	@Override
	public void carraryOut(Object o) {
		this.pageNum = (int) o;
		this.count = MemberServiceImpl.getInstance().countMember();
		this.totalRecode = MemberServiceImpl.getInstance().countMember();
		this.recodeSize = 5;
		this.totalPage = (totalRecode-1)/recodeSize+1;
		this.pageSize = 5;
		this.startPage = 1 + (int) (pageNum-1)%pageSize * pageSize;
		/*this.startPage = 1 + (int) (Math.ceil((pageNum-1)/pageSize)) * pageSize;*/
		this.endPage = (totalPage < startPage + pageSize  - 1) ? totalPage : (startPage + pageSize -1);
		this.startRow = 1 + ((pageNum-1) * recodeSize);
		this.endRow = (totalRecode < startRow + recodeSize - 1) 
										? totalRecode 
										: pageNum*(recodeSize);
		this.existPrev = (startPage != 1);
		this.existNext = (endPage < totalPage && startPage != totalPage);
	}
	
	
}
