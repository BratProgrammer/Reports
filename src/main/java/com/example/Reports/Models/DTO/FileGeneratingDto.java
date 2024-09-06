package com.example.Reports.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileGeneratingDto {

    private String uuid;

    private String username;

    private String filename;

}
