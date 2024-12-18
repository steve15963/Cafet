package xxx.petmanbe.boardfile.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.board.repository.BoardRepository;
import xxx.petmanbe.boardfile.entity.BoardFile;
import xxx.petmanbe.boardfile.repository.BoardFileRepository;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.BoardErrorCode;
import xxx.petmanbe.userfile.service.S3Uploader;

@RequiredArgsConstructor
@Service
public class BoardFileServiceImpl implements BoardFileService{

	private final BoardFileRepository boardFileRepository;

	private final BoardRepository boardRepository;

	private final S3Uploader s3Uploader;

	@Transactional
	@Override
	public Boolean keepFile(List<MultipartFile> files, Long boardId) throws IOException {

		if(!files.isEmpty()){

			Board board = boardRepository.findById(boardId)
				.orElseThrow(()-> new RestApiException(BoardErrorCode.BOARD_NOT_FOUND));
			List<BoardFile> boardFileList = new LinkedList<>();

			// files을 file로 바꿔서 S3에 넣는다.
			files.stream().forEach((file)->{
				try {
					String storedFileName = s3Uploader.upload(file, "board" );

					BoardFile file1 = BoardFile.builder()
						.boardUrl(storedFileName)
						.board(board)
						.build();

					boardFileList.add(file1);

					boardFileRepository.save(file1);

				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});

			boardRepository.save(board);

			return true;

		}else{
			System.out.println("image is null");
			return null;
		}
	}


	@Transactional
	@Override
	public String keepOnlyFile(MultipartFile file) throws IOException {

			return s3Uploader.upload(file, "board" );
	}
}

