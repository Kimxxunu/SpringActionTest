package Nosunwoo.NiceTest.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class NiceDTO {
    private String name = "마동석";
    private int number = 1004;
    private String location = "춘천시 후평동";
    private String fruit = "apple";
    private String animal = "대머리독수리";

}
