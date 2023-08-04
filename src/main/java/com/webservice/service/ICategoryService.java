package com.webservice.service;

import com.webservice.model.Category;
import com.webservice.model.dto.ParentDTO;

import java.util.List;

public interface ICategoryService extends ICrudService<Category> {
     List<Category> getByParent(String parent);
     List<ParentDTO> getAllParentDTO();
}
