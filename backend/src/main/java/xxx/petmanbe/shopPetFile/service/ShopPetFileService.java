package xxx.petmanbe.shopPetFile.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ShopPetFileService {
	public boolean keepFile(List<MultipartFile> files, long shopPetId) throws IOException;

}
