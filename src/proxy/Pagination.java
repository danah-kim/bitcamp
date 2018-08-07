package proxy;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Pagination implements Proxy{
	int totalRecode,
	recodeSize,
	totalPage,
	pageSize,
	pageNum,
	startPage,
	endPage,
	startRow,
	endRow,
	prevBlock,
	nextBlock;
	boolean existPrev = false,
	existNext = false;
	
	@Override
	public Map<?, ?> CarraryOut(Map<?, ?> param) {
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow", String.valueOf(endRow));
		return null;
	}
}
