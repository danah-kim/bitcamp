package com.spring5.web.brd;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring5.web.cmm.Util;
import com.spring5.web.page.PageProxy;
import com.spring5.web.page.Pagination;
import com.spring5.web.tx.TxService;


@RestController
public class BoardCtrl {
	static final Logger logger = LoggerFactory.getLogger(BoardCtrl.class); 
	@Autowired Board brd;
	@Autowired BoardMapper brdmapper;
	@Autowired Pagination page;
	@Autowired Map<String, Object> map;
	@Autowired TxService tx;
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@PostMapping("boards/add")
	public @ResponseBody void add(@RequestBody Board param) {
		Util.log.accept("등록하기");
		Util.log.accept(param.toString());
		map.clear();
		map.put("brd", param);
		tx.write(map);
	}
	
	@GetMapping("/boards/{pageNo}")
	public @ResponseBody Map<String, Object> list(@PathVariable String pageNo) {
		//logger.info("BoardContoller :","list..");
		//Util.log.accept("page:"+pageNo);
		PageProxy pxy = new PageProxy();
		map.clear();
		map.put("pageNum", (pageNo.equals("undefined"))? 1 : Integer.parseInt(pageNo));
		map.put("totalRecode", brdmapper.countAll());
		pxy.carraryOut(map);
		page = pxy.getPagination();
		map.clear();
		map.put("list", brdmapper.listAll(page));
		map.put("page", page);
		return map;
	}
	
	@GetMapping("/boards/{id}/{pageNo}/{boardNo}")
	public @ResponseBody Map<String, Object> mylist(@PathVariable String id, 
													@PathVariable String pageNo,
													@PathVariable String boardNo) {
		//logger.info("조회 :");
		//Util.log.accept("id:"+id+" page:"+pageNo+" boardNo:"+boardNo);
		PageProxy pxy = new PageProxy();
		map.clear();
		Function<String[], Object> f = (x) -> {
			String[] arr = {"startRow", "endRow", "userid"};
			for(int i = 0; i < arr.length; i++){
				map.put(arr[i],(x[i].equals(""))? "" : (i==2) ? x[i] : Integer.parseInt(x[i]));
			}
			map.put("boardNo", (boardNo.equals("undefined"))? "" : Integer.parseInt(boardNo));
			return (x[0].equals("")) ? brdmapper.listOne(map).size() : brdmapper.listOne(map);
		};
		map.put("pageNum", (pageNo.equals("undefined"))? 1 : Integer.parseInt(pageNo));
		map.put("totalRecode", f.apply(new String[] {"", "", id}));
		pxy.carraryOut(map);
		page = pxy.getPagination();
		map.clear();
		map.put("list", f.apply(new String[] {String.valueOf(page.getStartRow()), String.valueOf(page.getEndRow()), id}));
		//Util.log.accept("결과"+map.get("list"));
		map.put("page", page);
		return map;
	}
	
	@PostMapping("/boards/update")
	public void update(@RequestBody Board param) {
		logger.info("업데이트 :");
		Util.log.accept("확인:"+param);
		brdmapper.update(param);
	}
	
	@PostMapping("/boards/remove")
	public Boolean delete(@RequestBody Map<?,?> param) {
		logger.info("삭제 :");
		Util.log.accept("확인:"+param);
		return tx.delete(param);
	}
	
	class FileForm {
        private List<MultipartFile> files;
        public List<MultipartFile> getFiles() {
         return files;
        }
        public void setFiles(List<MultipartFile> files) {
         this.files = files;
        }
	}
	@PostMapping("/boards/fileupload/")
	public Object fileupload(@ModelAttribute("uploadForm") FileForm uploadForm) throws IOException{
		Util.log.accept("파일업로드 :");
		List<MultipartFile> files = uploadForm.getFiles();

		//success.jsp 로 보낼 파일 이름 저장
		  List<String> fileNames = new ArrayList<String>();
		  if (null != files && files.size() > 0) {
		   for (MultipartFile multipartFile : files) {
		    String fileName = multipartFile.getOriginalFilename();
		    String path = uploadPath + fileName;

		File f = new File(path);

		multipartFile.transferTo(f);

		fileNames.add(fileName);
		Util.log.accept("fileupload SUCCESS !! ");
		   }
		  }
		  //map.addAttribute("files", fileNames);
		  return "success";
	}
	@PostMapping("/uploadAjax")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		logger.info("이름"+file.getOriginalFilename());
		logger.info("크기"+file.getSize());
		logger.info("타입"+file.getContentType());
		return new ResponseEntity<>(file.getOriginalFilename(), HttpStatus.CREATED);
	}
}