package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Человек")
public class PersonView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @ApiModelProperty(value = "Имя", example = "Иван")
    public String name;

    @ApiModelProperty(value = "Возраст", example = "27")
    public Integer age;

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";age" + age + "}";
    }
}