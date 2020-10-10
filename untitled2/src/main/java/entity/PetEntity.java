package entity;

import lombok.Data;

@Data
public class PetEntity {
    private String nickname;
    private String birthday;
    private int gender;
    private int breed;
    private String description;
}