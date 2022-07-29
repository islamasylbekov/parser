package org.example.models.json;

import lombok.Data;
import org.example.models.BaseModel;

import javax.persistence.Entity;

@Data
@Entity
public class EntryType extends BaseModel {

    private String name;

    private String type;

}
