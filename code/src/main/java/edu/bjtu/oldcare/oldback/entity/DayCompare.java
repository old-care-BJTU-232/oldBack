package edu.bjtu.oldcare.oldback.entity;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class DayCompare {
    private int year;
    private int month;
    private int day;
}

