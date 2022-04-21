package com.vtoebe.hogwartsstudentregister.payloads.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class HouseToken {
    @JsonProperty("sorting-hat-choice")
    private UUID houseToken;
}
