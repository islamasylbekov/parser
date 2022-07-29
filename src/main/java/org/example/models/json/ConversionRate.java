package org.example.models.json;

import lombok.Data;
import org.example.models.BaseModel;

import javax.persistence.Entity;

@Data
@Entity
public class ConversionRate extends BaseModel {

    private String settelmentCurrency;

    private String receivingCurrency;

    private Double baseRate;

    private Double transferRate;

}
