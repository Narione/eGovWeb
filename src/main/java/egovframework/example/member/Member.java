package egovframework.example.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private String id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

}
