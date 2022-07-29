package org.example.models.json;

import lombok.Data;
import org.example.models.BaseModel;

import javax.persistence.*;

@Data
@Entity
public class Transfers extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    private Entry entry;

    @OneToOne(cascade = CascadeType.ALL)
    private Transfer transfer;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private JsomModel jsomModel;

}
