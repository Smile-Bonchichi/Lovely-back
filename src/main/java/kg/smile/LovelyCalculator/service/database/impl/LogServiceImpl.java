package kg.smile.LovelyCalculator.service.database.impl;

import kg.smile.LovelyCalculator.entity.Log;
import kg.smile.LovelyCalculator.repository.LogRepository;
import kg.smile.LovelyCalculator.service.base.impl.CrudServiceImpl;
import kg.smile.LovelyCalculator.service.database.LogService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogServiceImpl extends CrudServiceImpl<Log> implements LogService {
    final LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        super(logRepository);
        this.logRepository = logRepository;
    }
}
