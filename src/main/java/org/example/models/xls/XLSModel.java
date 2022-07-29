package org.example.models.xls;

import lombok.Data;
import org.example.models.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class XLSModel extends BaseModel {

    public LocalDate date;

    public String recipient;

    public Double sum;

    @Column(length = 1024)
    public String operation;

    public String operationId;

}
