package ru.bellintegrator.practice.Office.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Офис")
public class OfficeAddView {

    @NotNull(message = "orgId cannot be null")
    @ApiModelProperty(value = "Идентификатор организации", hidden = true, example = "1")
    public Long orgId;

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

    @Override
    public String toString() {
        return "{orgId:" + orgId + ";name:" + name + ";age:" + address + "}";
    }
}
