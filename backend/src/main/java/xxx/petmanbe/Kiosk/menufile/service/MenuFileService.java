package xxx.petmanbe.Kiosk.menufile.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MenuFileService {

    public boolean keepFile(MultipartFile file, long menuId) throws IOException;


}
