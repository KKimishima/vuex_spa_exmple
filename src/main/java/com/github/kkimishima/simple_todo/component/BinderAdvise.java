package com.github.kkimishima.simple_todo.component;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

@ControllerAdvice
@Component
public class BinderAdvise {
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    dateFormat.setLenient(false);
    timeFormat.setLenient(false);
    binder.registerCustomEditor(java.sql.Date.class,
        new CustomDateEditor(dateFormat, true));
    binder.registerCustomEditor(java.sql.Time.class, new CustomDateEditor(timeFormat,true));
  }
}
