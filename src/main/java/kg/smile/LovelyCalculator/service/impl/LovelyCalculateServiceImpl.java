package kg.smile.LovelyCalculator.service.impl;

import kg.smile.LovelyCalculator.dto.request.LovelyRequestDto;
import kg.smile.LovelyCalculator.dto.response.LovelyResponseDto;
import kg.smile.LovelyCalculator.service.LovelyCalculateService;
import kg.smile.LovelyCalculator.service.database.LovelyService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LovelyCalculateServiceImpl implements LovelyCalculateService {
    final LovelyService lovelyService;

    @Autowired
    public LovelyCalculateServiceImpl(LovelyService lovelyService) {
        this.lovelyService = lovelyService;
    }

    @Override
    public LovelyResponseDto calculatePercent(LovelyRequestDto lovelyRequestDto) {
        return null;
    }
}
