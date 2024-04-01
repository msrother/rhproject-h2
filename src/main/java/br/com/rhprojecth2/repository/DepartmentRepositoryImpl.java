package br.com.rhprojecth2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public abstract class DepartmentRepositoryImpl implements DepartmentRepository{
    @PersistenceContext
    private EntityManager em;
}
