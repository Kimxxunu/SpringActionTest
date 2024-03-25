package Nosunwoo.NiceTest.test.nice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class NiceDTO {
    private String name;
    private int number;
    private String location;
    private String fruit;
    private String animal;
    
}