package com.vtoebe.hogwartsstudentregister.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum AncestryEnum {
    MUGGLE_BORN("Muggle Born"),
    HALF_BLOOD("Half Blood"),
    PURE_BLOOD("Pure Blood"),
    SQUIB("Squib"),
    HALF_BREED("Half Breed");

    private final String label;
}
