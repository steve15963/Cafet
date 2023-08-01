package xxx.petmanbe.boardfile.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.board.repository.BoardRepository;
import xxx.petmanbe.boardfile.entity.BoardFile;
import xxx.petmanbe.boardfile.repository.BoardFileRepository;
import xxx.petmanbe.userfile.service.S3Uploader;

@RequiredArgsConstructor
@Service
public class BoardFileServiceImpl implements BoardFileService{

	private final BoardFileRepository boardFileRepository;

	private final BoardRepository boardRepository;

	private final S3Uploader s3Uploader;

	@Transactional
	@Override
	public String keepFile(MultipartFile file, Long boardId) throws IOException {

		if(!file.isEmpty()){
			String storedFileName = s3Uploader.upload(file, "board" );

			Board board = boardRepository.findById(boardId).orElseThrow(()->new IllegalArgumentException());

			BoardFile file1 = BoardFile.builder()
				.boardUrl(storedFileName)
				.board(board)
				.build();

			List<BoardFile> boardFileList = board.getBoardFileList();

			if(Objects.isNull(boardFileList)){
				List<BoardFile> blankBoardFiles = new LinkedList<>();
				blankBoardFiles.add(file1);
				boardFileList = blankBoardFiles;
			}else{
				boardFileList.add(file1);
			}

			board.setBoardFileList(boardFileList);

			boardRepository.save(board);

			boardFileRepository.save(file1);

			return storedFileName;

		}else{
			System.out.println("image is null");
			return null;
		}
	}
}

