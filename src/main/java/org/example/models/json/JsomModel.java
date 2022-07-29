package org.example.models.json;

import lombok.Data;
import org.example.models.BaseModel;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "model")
public class JsomModel extends BaseModel {

    private String checkSum;

    private int ceFileId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jsomModel")
    private List<Transfers> transfers;
}
