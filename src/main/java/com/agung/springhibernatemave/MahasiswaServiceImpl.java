package com.agung.springhibernatemaven.service;

import com.agung.springhibernatemaven.dao.MahasiswaDao;
import com.agung.springhibernatemaven.model.Mahasiswa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agung Setiawan
 */
@Service
@Transactional
public class MahasiswaServiceImpl implements  MahasiswaService{

    @Autowired
    MahasiswaDao mahasiswaDao;
    
    public void setMahasiswaDao(MahasiswaDao mahasiswaDao){
        this.mahasiswaDao=mahasiswaDao;
    }
    
    @Override
    public List<Mahasiswa> getLagus() {
        return mahasiswaDao.getLagus();
    }

    @Override
    public Mahasiswa getMahasiswa(Integer id) {
        return mahasiswaDao.getMahasiswa(id);
    }

    @Override
    public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswaDao.saveMahasiswa(mahasiswa);
    }

    @Override
    public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswaDao.updateMahasiswa(mahasiswa);
    }

    @Override
    public Mahasiswa deleteMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswaDao.deleteMahasiswa(mahasiswa);
    }
    
}
