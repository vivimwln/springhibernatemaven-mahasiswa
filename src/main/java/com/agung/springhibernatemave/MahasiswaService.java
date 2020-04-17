package com.agung.springhibernatemaven.service;

import com.agung.springhibernatemaven.model.Mahasiswa;
import java.util.List;

/**
 *
 * @author Agung Setiawan
 */
public interface MahasiswaService {
    public List<Mahasiswa> getLagus();
    public Mahasiswa getMahasiswa(Integer id);
    public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa);
    public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa);
    public Mahasiswa deleteMahasiswa(Mahasiswa mahasiswa);
}
