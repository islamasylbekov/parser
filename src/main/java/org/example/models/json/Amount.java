package org.example.models.json;

import lombok.Data;
import org.example.models.BaseModel;

import javax.persistence.Entity;

@Data
@Entity
public class Amount extends BaseModel {

    private Double amount;

    private String currency;
}
