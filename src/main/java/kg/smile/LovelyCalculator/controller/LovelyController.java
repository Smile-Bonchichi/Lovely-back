package kg.smile.LovelyCalculator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import kg.smile.LovelyCalculator.aop.SaveLog;
import kg.smile.LovelyCalculator.dto.request.LovelyRequestDto;
import kg.smile.LovelyCalculator.dto.response.LovelyResponseDto;
import kg.smile.LovelyCalculator.service.LovelyCalculateService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(value = "Контроллер для запросов на проверку совмстимости <3")
@RestController
@RequestMapping("/api/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LovelyController {
    final LovelyCalculateService lovelyCalculateService;

    @Autowired
    public LovelyController(LovelyCalculateService lovelyCalculateService) {
        this.lovelyCalculateService = lovelyCalculateService;
    }

    @PostMapping("calculate")
    @ApiOperation("API для подсчета процента совместимости")
    @SaveLog
    public ResponseEntity<LovelyResponseDto> getByPercentLovely(@Valid @RequestBody LovelyRequestDto lovelyRequestDto) {
        return ResponseEntity
                .ok(lovelyCalculateService.calculatePercent(lovelyRequestDto));
    }
}
