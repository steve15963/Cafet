package xxx.petmanbe.userfile.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {


	public String keepFile(MultipartFile image, Long userId) throws IOException;
}
