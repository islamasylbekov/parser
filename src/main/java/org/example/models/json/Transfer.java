package org.example.models.json;

import lombok.Data;
import org.example.models.BaseModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@Entity
public class Transfer extends BaseModel {

    private LocalDate transferDate;

    private String originatorReferenceNumber;

    private String platformReferenceNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originator_id")
    private Participant originator;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id")
    private Participant receiver;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_amount_id")
    private Amount paymentAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "display_fee_amount_id")
    private Amount displayFeeAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fee_amount_id")
    private Amount feeAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reciever_fee_amount_id")
    private Amount recieverFeeAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "settelment_amount_id")
    private Amount settelmentAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiving_amount_id")
    private Amount receivingAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conversion_rate_id")
    private ConversionRate conversionRate;

    private String externalCheckId;

    private String externalConfirmId;

}
