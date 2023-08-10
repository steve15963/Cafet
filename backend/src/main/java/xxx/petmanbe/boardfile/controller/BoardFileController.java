package xxx.petmanbe.boardfile.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.boardfile.service.BoardFileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boardfile")
@CrossOrigin("*")
public class BoardFileController {

	private final BoardFileService boardFileService;

	@GetMapping(value="/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Transactional
	public ResponseEntity<String> getBoardFile(@RequestPart(value="file", required = false) MultipartFile file) throws
		IOException {
		// 게시글 생성


		String url = boardFileService.keepOnlyFile(file);

		return new ResponseEntity<>(url, HttpStatus.OK);


		// 결과 전달
		// return new ResponseEntity<>("pictures not in",HttpStatus.CREATED);
	}
}
