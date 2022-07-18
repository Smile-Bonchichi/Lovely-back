package kg.smile.LovelyCalculator.service.base.impl;

import kg.smile.LovelyCalculator.exception.base.BaseException;
import kg.smile.LovelyCalculator.service.base.CrudService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CrudServiceImpl<T> implements CrudService<T> {
    final CrudRepository<T, Long> crudRepository;

    public CrudServiceImpl(CrudRepository<T, Long> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public T saveOrUpdate(T t) {
        return crudRepository.save(t);
    }

    @Override
    public T delete(Long id) {
        T t = getById(id);
        if (t != null) {
            crudRepository.delete(t);
        }

        return t;
    }

    @Override
    public T getById(Long id) {
        return crudRepository.findById(id).orElseThrow(() -> new BaseException("Not found", HttpStatus.BAD_REQUEST));
    }

    @Override
    public List<T> findAll() {
        return (List<T>) crudRepository.findAll();
    }
}
