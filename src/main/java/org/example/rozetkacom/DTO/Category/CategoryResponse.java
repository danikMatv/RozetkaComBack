package org.example.rozetkacom.DTO.Category;

import lombok.Builder;

@Builder
public record CategoryResponse (Long id,String categoryName){
}
