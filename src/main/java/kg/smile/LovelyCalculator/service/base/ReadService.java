package kg.smile.LovelyCalculator.service.base;

import java.util.List;

public interface ReadService<T> {
    T getById(Long id);

    List<T> findAll();
}
