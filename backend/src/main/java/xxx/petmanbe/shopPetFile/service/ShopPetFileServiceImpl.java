package xxx.petmanbe.shopPetFile.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.PetErrorCode;
import xxx.petmanbe.shopPet.entity.ShopPet;
import xxx.petmanbe.shopPet.repository.ShopPetRepository;
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

		if (!files.isEmpty()) {

			ShopPet shopPet = shopPetRepository.findById(shopPetId)
				.orElseThrow(()-> new RestApiException(PetErrorCode.PET_NOT_FOUND));

			List<ShopPetFile> shopPetFileList = new LinkedList<>();

			// files을 file로 바꿔서 S3에 넣는다.
			files.stream().forEach((file) -> {
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

		} else {
			System.out.println("image is null");
			return false;
		}
	}
}
