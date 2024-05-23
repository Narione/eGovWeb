package egovframework.example.board.service.impl;

import egovframework.example.board.service.BoardService;
import egovframework.example.board.service.BoardVO;
import egovframework.example.cmmn.SearchVO;
import egovframework.example.file.service.FileVO;
import egovframework.example.file.service.impl.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper mapper;
	private final FileMapper fileMapper;

	@Override
	public int getBoardListCount(SearchVO vo) {
		return mapper.getBoardListCount(vo);
	}
	@Override
	public List<BoardVO> getBoardList(SearchVO vo) {
		return mapper.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(int searchNo) {
		//게시글 조회시 카운트가 증가할 때 조회수에 따른 등급이나 인기글로 설정하는 등
		// 민감한 사항은 정책을 세워서 이곳(service)에서 작업해준다.
		mapper.updateHits(searchNo);
		return mapper.getBoard(searchNo);
	}
	@Override
	public int insertBoard(BoardVO vo) {
		mapper.insertBoard(vo);
		// 글번호를 FileVO 리스트 안에 각각 넣어준다.
		if(!vo.getFileList().isEmpty()){
		List<FileVO> fileList = new ArrayList<>();
		for(FileVO file : vo.getFileList()) {
			file.setBoardNo(vo.getNo());
			fileList.add(file);
		}
		fileMapper.saveFiles(fileList);

		}
		return vo.getNo();
	}
	@Override
	public int updateBoard(BoardVO vo) {
		return mapper.updateBoard(vo);
	}
	@Override
	public int deleteBoard(int deleteNo) {
		return mapper.deleteBoard(deleteNo);
	}
}
