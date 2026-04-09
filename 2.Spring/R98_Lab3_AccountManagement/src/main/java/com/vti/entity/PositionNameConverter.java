package com.vti.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<Position.PositionName, String> {

    @Override
    public String convertToDatabaseColumn(Position.PositionName attribute) {
        if (attribute == null) {
            return null;
        }
        if (attribute == Position.PositionName.Scrum_Master) {
            return "Scrum Master";
        }
        return attribute.toString();
    }

    @Override
    public Position.PositionName convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        if (dbData.equals("Scrum Master")) {
            return Position.PositionName.Scrum_Master;
        }
        return Position.PositionName.valueOf(dbData);
    }
}
