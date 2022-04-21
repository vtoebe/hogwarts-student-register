package com.vtoebe.hogwartsstudentregister.payloads;

import com.vtoebe.hogwartsstudentregister.enums.AncestryEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class StudentRequest {
    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    private AncestryEnum ancestry;

    @NotNull
    private String wand;

    @NotNull
    private String patronus;
}
