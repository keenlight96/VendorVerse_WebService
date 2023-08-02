package com.webservice.model.dto;

import com.webservice.model.Bill;
import com.webservice.model.Image;
import com.webservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BillDetailDTO {
    private int id;
    private Product product;
    private Bill bill;
    private int quantity;
    private Image image;

}
