package xxx.petmanbe.userfile.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {


	String keepFile(MultipartFile file, String email) throws IOException;
}
