package xxx.petmanbe.userfile.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.userfile.entity.UserFile;
import xxx.petmanbe.userfile.repository.UserFileRepository;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService{

	private final UserFileRepository userFileRepository;

	private final UserRepository userRepository;

	private final S3Uploader s3Uploader;

	@Transactional
	@Override
	public String keepFile(MultipartFile image, Long userId) throws IOException {

		if(!image.isEmpty()){
			// user파일에 들어가 있음
			String storedFileName = s3Uploader.upload(image, "user");

			UserFile file1 = UserFile.builder()
				.userUrl(storedFileName)
				.build();

			User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException());

			user.setUserFile(file1);

			userRepository.save(user);

			userFileRepository.save(file1);
			
			return storedFileName;
		}
		else{
			System.out.println("image is null!");
			return null;
		}
	}
}
