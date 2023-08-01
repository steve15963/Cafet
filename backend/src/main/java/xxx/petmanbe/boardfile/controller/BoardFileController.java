package xxx.petmanbe.boardfile.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.boardfile.service.BoardFileService;

@RestController
@RequestMapping(value="/api/file/board")
@RequiredArgsConstructor
public class BoardFileController {

	private final BoardFileService boardFileService;

	// @PostMapping(value = "/{boardId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	// public String saveBoardFile(@RequestPart(value="file") MultipartFile file, @PathVariable Long boardId) throws
	// 	IOException {
	//
	// 	String url = boardFileService.keepFile(file, boardId);
	//
	// 	return url;
	// }

}

