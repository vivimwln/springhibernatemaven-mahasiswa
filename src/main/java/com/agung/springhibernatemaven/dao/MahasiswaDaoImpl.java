package com.agung.springhibernatemaven.dao;

import com.agung.springhibernatemaven.model.Mahasiswa;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Agung Setiawan
 */
@Repository
public class MahasiswaDaoImpl implements MahasiswaDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Mahasiswa> getLagus() {
        return sessionFactory.getCurrentSession().createQuery("select l from Mahasiswa l").list();
    }

    @Override
    public Mahasiswa getMahasiswa(Integer id) {
        return (Mahasiswa) sessionFactory.getCurrentSession().get(Mahasiswa.class, id);
    }

    @Override
    public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
        sessionFactory.getCurrentSession().save(mahasiswa);
        return mahasiswa;
    }

    @Override
    public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa) {
        sessionFactory.getCurrentSession().update(mahasiswa);
        return mahasiswa;
    }

    @Override
    public Mahasiswa deleteMahasiswa(Mahasiswa mahasiswa) {
        sessionFactory.getCurrentSession().delete(mahasiswa);
        return mahasiswa;
    }
    
}
