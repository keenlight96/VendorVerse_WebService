package com.webservice.model.dto;

import com.webservice.model.Bill;
import com.webservice.model.BillDetail;
import com.webservice.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BillDTO {
    private List<Bill> bills;
    private List<BillDetailDTO> billDetailDTOs;
}
