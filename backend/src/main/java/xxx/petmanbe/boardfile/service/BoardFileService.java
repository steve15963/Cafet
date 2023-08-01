package xxx.petmanbe.boardfile.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;


public interface BoardFileService {
	public String keepFile(MultipartFile file, Long boardId) throws IOException;

}

