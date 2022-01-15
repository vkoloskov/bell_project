package ru.bellintegrator.practice.Office.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Офис")
public class OfficeUpdateView {

    @NotNull
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public long id;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Центральный")
    public String name;

    @NotEmpty(message = "address cannot be null")
    @Size(max = 50)
    @ApiModelProperty(value = "Адрес", example = "ул. Новая, 2")
    public String address;

    @Size(max = 50)
    @ApiModelProperty(value = "Телефон", example = "+7-909-933-33-44")
    public String phone;

    @ApiModelProperty(value = "Активный?", example = "true")
    public Boolean isActive;
    
}
