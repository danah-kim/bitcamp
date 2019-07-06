package com.spring5.web.brd;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring5.web.cmm.Criteria;
import com.spring5.web.cmm.SearchCriteria;

@Component
public interface BoardService {

	  public void regist(Board board) throws Exception;

	  public Board read(Integer bno) throws Exception;

	  public void modify(Board board) throws Exception;

	  public void remove(Integer bno) throws Exception;

	  public List<Board> listAll() throws Exception;

	  public List<Board> listCriteria(Criteria cri) throws Exception;

	  public int listCountCriteria(Criteria cri) throws Exception;

	  public List<Board> listSearchCriteria(SearchCriteria cri) 
	      throws Exception;

	  public int listSearchCount(SearchCriteria cri) throws Exception;
	  
	  
	  public List<String> getAttach(Integer bno)throws Exception;

}
