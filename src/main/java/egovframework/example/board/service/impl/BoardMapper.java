package egovframework.example.board.service.impl;

import egovframework.example.board.service.BoardVO;
import egovframework.example.cmmn.SearchVO;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
	int getBoardListCount(SearchVO vo);
	List<BoardVO> getBoardList(SearchVO vo);
	BoardVO getBoard(int searchNo);
	int insertBoard(BoardVO vo);
	int updateBoard(BoardVO vo);
	void updateHits(int boardNo);
	int deleteBoard(int deleteNo);
}
