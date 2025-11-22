package egovframework.example.file.service.impl;

import egovframework.example.file.service.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements egovframework.example.file.service.FileService {
    private final FileMapper mapper;

    @Override
    public void saveFiles(int boardNo, List<FileVO> files){
        if(files.isEmpty()){
            return;
        }
        for(FileVO file : files){
            file.setBoardNo(boardNo);
        }

        mapper.saveFiles(files);
    }

    @Override
    public List<FileVO> selectFileList(int boardNo){
        return mapper.selectFileList(boardNo);

    }

    @Override
    public FileVO selectFile(int id){
        return mapper.selectFile(id);
    }

}
