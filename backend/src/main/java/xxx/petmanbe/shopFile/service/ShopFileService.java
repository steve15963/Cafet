package xxx.petmanbe.shopFile.service;

import org.springframework.web.multipart.MultipartFile;
import xxx.petmanbe.shopFile.entity.ShopFile;

import java.io.IOException;
import java.util.List;

public interface ShopFileService {


    public boolean keepFile(List<MultipartFile> files, long shopId) throws IOException;

    public List<ShopFile> getShopFile(long shopId);

}
