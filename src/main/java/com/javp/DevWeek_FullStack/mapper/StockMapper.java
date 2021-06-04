package com.javp.DevWeek_FullStack.mapper;

import com.javp.DevWeek_FullStack.model.dto.StockDTO;
import com.javp.DevWeek_FullStack.model.Stock;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class StockMapper {
    public Stock toEntity(StockDTO dto) {

        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setName(dto.getName());
        stock.setPrice(dto.getPrice());
        stock.setValidation(dto.getVariation());
        stock.setDate(dto.getDate());
        return stock;
    }

    public StockDTO toDto(Stock stock) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setId(stock.getId());
        stockDTO.setName(stock.getName());
        stockDTO.setPrice(stock.getPrice());
        stockDTO.setVariation(stock.getValidation());
        stockDTO.setDate(stock.getDate());

        return stockDTO;
    }

    public List<StockDTO> toListDTO(List<Stock> listStock){
        return listStock.stream().map(this::toDto).collect(Collectors.toList());

    }
}
