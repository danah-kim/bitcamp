package com.spring5.web.algo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring5.web.cmm.Util;

@RestController
@RequestMapping("/algo")
public class AlgoCtrl {
	@GetMapping("/money/{money}")
	public void money(@PathVariable Integer val) {
		Util.log.accept("넘어온 화폐값: "+val);
	}
	@PostMapping("/money/")
	public @ResponseBody Map<String, Object> 
		money2(@RequestBody Map<String, Object> param) {
		Map<String, Object> map = new HashMap<>();
		Util.log.accept("넘어온 화폐값: "+param.get("money"));
		map.put("test", "test");
		return map;
	}
}