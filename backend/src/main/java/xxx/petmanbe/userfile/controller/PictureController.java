package xxx.petmanbe.userfile.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.userfile.service.FileService;

@RestController
@RequestMapping(value="/api/picture")
@RequiredArgsConstructor
public class PictureController {

	private final FileService fileService;

	@PostMapping(value = "user/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String savePicture(@RequestPart(value = "image")MultipartFile image, @PathVariable String email) throws IOException {

		String url = fileService.keepFile(image, email);

		return url;
	}
}

