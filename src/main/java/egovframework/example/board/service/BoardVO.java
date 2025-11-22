package egovframework.example.board.service;

import egovframework.example.file.service.FileVO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class BoardVO {
	private int no;
	private String writer;
	private String title;
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modifyDate;
	private int hits;
	private List<FileVO> fileList;


//	public void setCreateDate(String createDate) {
//		this.createDate = LocalDate.parse(createDate);
//	}

}
