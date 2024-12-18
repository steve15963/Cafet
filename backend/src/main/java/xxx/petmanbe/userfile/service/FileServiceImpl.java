package xxx.petmanbe.userfile.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.FileErrorCode;
import xxx.petmanbe.exception.errorcode.UserErrorCode;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;
import xxx.petmanbe.userfile.entity.UserFile;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService{

	private final UserRepository userRepository;

	private final S3Uploader s3Uploader;

	@Transactional
	@Override
	public String keepFile(MultipartFile file, String email) throws IOException {

		if(!file.isEmpty()){
			// user파일에 들어가 있음
			String storedFileName = s3Uploader.upload(file, "user");

			User user = userRepository.findByEmail(email)
				.orElseThrow(()-> new RestApiException(UserErrorCode.USER_NOT_FOUND));

			UserFile file1 = UserFile.builder()
				.userUrl(storedFileName)
				.user(user)
				.build();

			user.setUserFile(file1);

			userRepository.save(user);

			//why?
			// userFileRepository.save(file1);
			
			return storedFileName;
		}

		throw new RestApiException(FileErrorCode.FILE_NOT_FOUND);
	}
}
