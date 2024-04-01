package br.com.rhprojecth2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public abstract class JobPositionRepositoryImpl implements JobPositionRepository{
    @PersistenceContext
    private EntityManager em;
}
