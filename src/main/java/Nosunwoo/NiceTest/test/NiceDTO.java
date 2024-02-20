package Nosunwoo.NiceTest.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class NiceDTO {
    private String name = "손흥민";
    private int number = 1234;
    private String location = "남양주시 덕소리";
    private String fruit = "두리안";
    private String animal = "대머리독수리";

}
