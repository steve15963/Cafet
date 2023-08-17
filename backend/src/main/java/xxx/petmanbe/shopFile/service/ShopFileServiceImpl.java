package xxx.petmanbe.shopFile.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.ShopErrorCode;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.shopFile.entity.ShopFile;
import xxx.petmanbe.shopFile.repository.ShopFileRepository;
import xxx.petmanbe.userfile.service.S3Uploader;

@RequiredArgsConstructor
@Service
public class ShopFileServiceImpl implements ShopFileService{

    private final S3Uploader s3Uploader;

    private final ShopRepository shopRepository;

    private final ShopFileRepository shopFileRepository;

    @Override
    public boolean keepFile(List<MultipartFile> files, long shopId) throws IOException {


        if (!files.isEmpty()) {

            Shop shop = shopRepository.findById(shopId)
                    .orElseThrow(()-> new RestApiException(ShopErrorCode.SHOP_NOT_FOUND));

            List<ShopFile> shopFileList = new LinkedList<>();

            // files을 file로 바꿔서 S3에 넣는다.
            files.stream().forEach((file) -> {
                try {
                    String storedFileName = s3Uploader.upload(file, "shop" );

                    ShopFile file1 = ShopFile.builder()
                            .url(storedFileName)
                            .shop(shop)
                            .build();

                    shopFileList.add(file1);

                    shopFileRepository.save(file1);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            shopRepository.save(shop);

            return true;

        } else {
            return false;
        }
    }

    @Override
    public List<ShopFile> getShopFile(long shopId) {

        Shop shop = shopRepository.findById(shopId)
            .orElseThrow(() -> new RestApiException(ShopErrorCode.SHOP_NOT_FOUND));

		return shop.getShopFileList();
    }
}
