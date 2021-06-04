package com.javp.DevWeek_FullStack.sevice;

import com.javp.DevWeek_FullStack.exceptions.BusinessException;
import com.javp.DevWeek_FullStack.exceptions.NotFoundException;
import com.javp.DevWeek_FullStack.mapper.StockMapper;
import com.javp.DevWeek_FullStack.model.dto.StockDTO;
import com.javp.DevWeek_FullStack.model.Stock;
import com.javp.DevWeek_FullStack.repositoy.StockRepositor;
import com.javp.DevWeek_FullStack.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepositor stockRepositor;

    @Autowired
    private StockMapper stockMapper;

    @Transactional
    public StockDTO save(StockDTO dto) {

        Optional<Stock> OptStock = stockRepositor.findByNameAndDate(dto.getName(),dto.getDate());
        if (OptStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = stockMapper.toEntity(dto);
        stockRepositor.save(stock);
        return stockMapper.toDto(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> OptStock = stockRepositor.findByStockUpdate(dto.getName(),
                dto.getDate(), dto.getId());
        if (OptStock.isPresent()){

            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);

        }

        Stock stock = stockMapper.toEntity(dto);
        stockRepositor.save(stock);
        return stockMapper.toDto(stock);
    }
    @Transactional
    public List<StockDTO> findAll() {
        return stockMapper.toListDTO(stockRepositor.findAll());
    }
    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        stockRepositor.deleteById(id);
        return dto;

    }

    @Transactional
    public StockDTO findById(Long id) {
        return stockRepositor.findById(id).map(stockMapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public List<StockDTO> findByToday() {
       return stockRepositor.findByToday(LocalDate.now()).map(stockMapper::toListDTO)
                .orElseThrow(NotFoundException::new);
    }


}
