package xxx.petmanbe.boardfile.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public interface BoardFileService {
	public Boolean keepFile(List<String> file, Long boardId) throws IOException;

}

