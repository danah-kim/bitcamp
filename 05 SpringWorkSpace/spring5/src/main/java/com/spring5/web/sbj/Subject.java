package com.spring5.web.sbj;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data @Lazy
public class Subject {
	String subSeq, subName;
}
