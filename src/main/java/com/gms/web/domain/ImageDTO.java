package com.gms.web.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ImageDTO {
	private String imgseq, imgname, extension, memId;
}
