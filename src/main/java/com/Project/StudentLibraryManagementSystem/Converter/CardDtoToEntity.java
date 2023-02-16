package com.Project.StudentLibraryManagementSystem.Converter;

import com.Project.StudentLibraryManagementSystem.DTOs.CardStatusDto;
import com.Project.StudentLibraryManagementSystem.Model.Card;

public class CardDtoToEntity {
    public static Card cardConverter(CardStatusDto cardDto){
        Card card = Card.builder().cardStatus(cardDto.getCardStatus()).build();
        return card;
    }
}
