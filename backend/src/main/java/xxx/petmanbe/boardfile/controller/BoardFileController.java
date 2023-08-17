package xxx.petmanbe.boardfile.controller;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import xxx.petmanbe.boardfile.service.BoardFileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boardfile")
@Tag(name = "게시글 첨부파일", description = "게시글에 들어가는 첨부파일 저장 API Docs")
@CrossOrigin("*")
public class BoardFileController {

	private final BoardFileService boardFileService;

	@PostMapping(value="/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "해당 게시글에 달린 첨부 파일 가져오기")
	@Transactional
	public ResponseEntity<String> getBoardFile(@RequestPart(value="file", required = false) MultipartFile file) throws
		IOException {

		String url = boardFileService.keepOnlyFile(file);

		return new ResponseEntity<>(url, HttpStatus.OK);
	}
}
