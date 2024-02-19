package Nosunwoo.NiceTest.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class NiceDTO {
    private String name = "김민재";
    private int number = 1004;
    private String location = "남양주시 덕소리";
    private String fruit = "banana";
    private String animal = "대머리독수리";

}
