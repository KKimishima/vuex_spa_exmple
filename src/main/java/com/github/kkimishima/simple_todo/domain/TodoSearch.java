package com.github.kkimishima.simple_todo.domain;

import lombok.Data;
import lombok.ToString;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class TodoSearch {
  private String title;
  private String describe;
  @NumberFormat
  private Long progressId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date minDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date maxDate;

  @Override
  public String toString() {
    SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
    return  "title="      + (this.title == null ? "" : this.title)        +"&"+
            "describe="   + (this.describe == null ? "" : this.describe)  +"&"+
            "minDate="    + (minDate == null ? "" : fm.format(minDate))   +"&" +
            "maxDate="    + (maxDate == null ? "" : fm.format(maxDate))   +"&" +
            "progressId=" + (progressId == null ? "" : progressId.toString());
  }
}
