package egovframework.example.file.service;

import java.util.List;

public interface FileService {
    void saveFiles(int boardNo, List<FileVO> files);

    List<FileVO> selectFileList(int boardNo);

    FileVO selectFile(int id);
}
