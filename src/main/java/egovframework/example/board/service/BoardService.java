package egovframework.example.board.service;

import egovframework.example.cmmn.SearchVO;

import java.util.List;

public interface BoardService {
    int getBoardListCount(SearchVO vo);

    List<BoardVO> getBoardList(SearchVO vo);

    BoardVO getBoard(int searchNo);

    int insertBoard(BoardVO vo);

    int updateBoard(BoardVO vo);

    int deleteBoard(int deleteNo);
}
