package com.spring4.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data @Lazy
public class ImageDTO {
	private String imgseq, imgname, extension, memId;
}
