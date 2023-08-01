package xxx.petmanbe.userfile.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
	public String keepFile(String file, String email) throws IOException {

		if(!file.isEmpty()){
			// user파일에 들어가 있음
			// String storedFileName = s3Uploader.upload(image, "user");

			User user = userRepository.findByEmail(email).orElseThrow(()-> new IllegalArgumentException());

			UserFile file1 = UserFile.builder()
				.userUrl(file)
				.user(user)
				.build();

			user.setUserFile(file1);

			userRepository.save(user);

			//why?
			// userFileRepository.save(file1);
			
			return file;
		}
		else{
			System.out.println("image is null!");
			return null;
		}
	}
}
