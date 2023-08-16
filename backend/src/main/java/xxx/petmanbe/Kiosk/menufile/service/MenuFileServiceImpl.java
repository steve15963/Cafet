package xxx.petmanbe.Kiosk.menufile.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xxx.petmanbe.Kiosk.menu.entity.Menu;
import xxx.petmanbe.Kiosk.menu.repository.MenuRepository;
import xxx.petmanbe.Kiosk.menufile.entity.MenuFile;
import xxx.petmanbe.Kiosk.menufile.repository.MenuFileRepository;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.CommonErrorCode;
import xxx.petmanbe.userfile.service.S3Uploader;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class MenuFileServiceImpl implements MenuFileService{

    private final MenuRepository menuRepository;
    private final S3Uploader s3Uploader;


    @Override
    public boolean keepFile(MultipartFile file, long menuId) throws IOException {

        if(!file.isEmpty()){
            // user파일에 들어가 있음
            String storedFileName = s3Uploader.upload(file, "menu");

            Menu menu = menuRepository.findById(menuId)
                .orElseThrow(()-> new RestApiException(CommonErrorCode.INVALID_PARAMETER));

            MenuFile menuFile = MenuFile.builder()
                    .menu(menu)
                    .url(storedFileName)
                    .build();

            menu.setMenuFile(menuFile);

            menuRepository.save(menu);

            return true;
        }
        else{
            System.out.println("file is null!");
            return false;
        }


    }
}
