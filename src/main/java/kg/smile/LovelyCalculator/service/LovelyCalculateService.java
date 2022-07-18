package kg.smile.LovelyCalculator.service;

import kg.smile.LovelyCalculator.dto.request.LovelyRequestDto;
import kg.smile.LovelyCalculator.dto.response.LovelyResponseDto;

public interface LovelyCalculateService {
    LovelyResponseDto calculatePercent(LovelyRequestDto lovelyRequestDto);
}
