package com.webservice.model.dto;

import com.webservice.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class ParentDTO {
    private List<Category> categories;
}
