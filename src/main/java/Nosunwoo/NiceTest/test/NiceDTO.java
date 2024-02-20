package Nosunwoo.NiceTest.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class NiceDTO {
    private String name = "김선우";
    private int number = 1234;
    private String location = "남양주시 덕소리";
    private String fruit = "수박";
    private String animal = "캥거루";

}
