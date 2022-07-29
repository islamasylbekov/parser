package org.example.models.json;

import lombok.Data;
import org.example.models.BaseModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Data
public class Entry  extends BaseModel {

    private Double amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entry_type_id")
    private EntryType entryType;

    private LocalDate businessDay;

    private Long consolidatedEntryId;
}
