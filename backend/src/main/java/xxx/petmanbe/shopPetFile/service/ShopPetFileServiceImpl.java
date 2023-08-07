package xxx.petmanbe.shopPetFile.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.boardfile.entity.BoardFile;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.shop.service.ShopService;
import xxx.petmanbe.shopPet.entity.ShopPet;
import xxx.petmanbe.shopPet.repository.ShopPetRepository;
import xxx.petmanbe.shopPet.service.ShopPetService;
import xxx.petmanbe.shopPetFile.entity.ShopPetFile;
import xxx.petmanbe.shopPetFile.repository.ShopPetFileRepository;
import xxx.petmanbe.userfile.service.S3Uploader;

@RequiredArgsConstructor
@Service
public class ShopPetFileServiceImpl implements ShopPetFileService{

	private final S3Uploader s3Uploader;

	private final ShopPetRepository shopPetRepository;

	private final ShopPetFileRepository shopPetFileRepository;

	@Override
	public boolean keepFile(List<MultipartFile> files, long shopPetId) throws IOException {

		if(!files.isEmpty()){

			ShopPet shopPet = shopPetRepository.findById(shopPetId).orElseThrow(()-> new IllegalArgumentException());

			List<ShopPetFile> shopPetFileList = new LinkedList<>();

			// files을 file로 바꿔서 S3에 넣는다.
			files.stream().forEach((file)->{
				try {
					String storedFileName = s3Uploader.upload(file, "shopPet" );

					ShopPetFile file1 = ShopPetFile.builder()
						.url(storedFileName)
						.shopPet(shopPet)
						.build();

					shopPetFileList.add(file1);

					shopPetFileRepository.save(file1);

				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});

			shopPetRepository.save(shopPet);

			return true;

		}else{
			System.out.println("image is null");
			return false;
		}



	}
}
