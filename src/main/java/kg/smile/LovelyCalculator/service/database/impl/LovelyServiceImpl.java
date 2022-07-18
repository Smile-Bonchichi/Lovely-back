package kg.smile.LovelyCalculator.service.database.impl;

import kg.smile.LovelyCalculator.entity.Lovely;
import kg.smile.LovelyCalculator.repository.LovelyRepository;
import kg.smile.LovelyCalculator.service.base.impl.CrudServiceImpl;
import kg.smile.LovelyCalculator.service.database.LovelyService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LovelyServiceImpl extends CrudServiceImpl<Lovely> implements LovelyService {
    final LovelyRepository lovelyRepository;

    @Autowired
    public LovelyServiceImpl(LovelyRepository lovelyRepository) {
        super(lovelyRepository);
        this.lovelyRepository = lovelyRepository;
    }
}
