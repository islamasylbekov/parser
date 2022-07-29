package org.example.models.json;

import lombok.Data;
import org.example.models.BaseModel;

import javax.persistence.Entity;

@Data
@Entity
public class Participant extends BaseModel {

    private Long participantId;

    private String phoneNumber;

}
