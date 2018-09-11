package com.spring5.img;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data @Lazy
public class Image {
	private String imgseq, imgname, extension, memId;
}
