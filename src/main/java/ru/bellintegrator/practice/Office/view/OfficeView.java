package ru.bellintegrator.practice.Office.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

@ApiModel(description = "Офис")
public class OfficeView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 50)
    @ApiModelProperty(value = "Название", example = "Центральный")
    public String name;

    @Size(max = 50)
    @ApiModelProperty(value = "Адрес", example = "ул. Новая, 2")
    public String address;

    @Size(max = 50)
    @ApiModelProperty(value = "Телефон", example = "+7-909-933-33-44")
    public String phone;

    @ApiModelProperty(value = "Активный?", example = "true")
    public Boolean isActive;

}
