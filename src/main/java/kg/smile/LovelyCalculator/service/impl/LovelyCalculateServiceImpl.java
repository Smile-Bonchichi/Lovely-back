package kg.smile.LovelyCalculator.service.impl;

import kg.smile.LovelyCalculator.dto.request.LovelyRequestDto;
import kg.smile.LovelyCalculator.dto.response.LovelyResponseDto;
import kg.smile.LovelyCalculator.entity.Lovely;
import kg.smile.LovelyCalculator.exception.LovelyCalculateException;
import kg.smile.LovelyCalculator.service.LovelyCalculateService;
import kg.smile.LovelyCalculator.service.database.LovelyService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LovelyCalculateServiceImpl implements LovelyCalculateService {
    final LovelyService lovelyService;

    final Random random;

    @Autowired
    public LovelyCalculateServiceImpl(LovelyService lovelyService,
                                      Random random) {
        this.lovelyService = lovelyService;
        this.random = random;
    }

    @Override
    public LovelyResponseDto calculatePercent(LovelyRequestDto lovelyRequestDto) {
        try {
            List<Lovely> lovelies = lovelyService.findAll();

            Lovely lovely = lovelies.stream()
                    .filter(x -> x.getFirstName().equalsIgnoreCase(lovelyRequestDto.getFirstName()))
                    .filter(x -> x.getSecondName().equalsIgnoreCase(lovelyRequestDto.getSecondName()))
                    .findFirst()
                    .orElse(
                            Lovely.builder()
                                    .firstName(lovelyRequestDto.getFirstName())
                                    .secondName(lovelyRequestDto.getSecondName())
                                    .percentLovely(getPercentLovely(
                                            lovelyRequestDto.getFirstName(),
                                            lovelyRequestDto.getSecondName())
                                    ).build()
                    );

            if (lovely.getId() == null) {
                lovelyService.saveOrUpdate(lovely);
            }

            return LovelyResponseDto.builder()
                    .percent(lovely.getPercentLovely())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new LovelyCalculateException(
                    "При подсчете процентов, произошла ошибка",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    private BigDecimal getPercentLovely(String firstName, String secondName) {
        int sumF = 0;
        int sumS = 0;
        for (int i = 0; i < firstName.length(); i++) {
            sumF += firstName.charAt(i);
        }

        for (int i = 0; i < secondName.length(); i++) {
            sumS += secondName.charAt(i);
        }

        return new BigDecimal(String.valueOf((double) ((sumF + sumS) / 100) / (random.nextInt(9) + 1)));
    }
}
