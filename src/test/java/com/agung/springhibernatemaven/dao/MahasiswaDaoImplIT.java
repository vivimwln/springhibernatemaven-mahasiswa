package com.agung.springhibernatemaven.dao;

import com.agung.springhibernatemaven.init.WebAppConfigTest;
import com.agung.springhibernatemaven.model.Mahasiswa;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author awanlabs
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebAppConfigTest.class)
@TestExecutionListeners({/*DbUnitTestExecutionListener.class,*/ DependencyInjectionTestExecutionListener.class, 
    TransactionDbUnitTestExecutionListener.class})
@Transactional
public class MahasiswaDaoImplIT {
    
    @Autowired
    MahasiswaDao MahasiswaDao;
    
    @Test
    @DatabaseSetup("classpath:sampleData.xml")
    public void testGetMahasiswas() {
        List<Mahasiswa> daftarMahasiswa=MahasiswaDao.getLagus();
        
        assertNotNull(daftarMahasiswa);
        assertEquals(2, daftarMahasiswa.size());
        assertEquals("Aku dan Bintang", daftarMahasiswa.get(0).getAlamat());
    }
    
    @Test
    @DatabaseSetup("classpath:sampleData.xml")
    public void testGetMahasiswa(){
        Mahasiswa Mahasiswa=MahasiswaDao.getMahasiswa(2);
        
        assertNotNull(Mahasiswa);
        assertEquals("Stand By Me", Mahasiswa.getAlamat());
        assertEquals("Oasis", Mahasiswa.getNama());
    }
    
    @Test
    @DatabaseSetup("classpath:sampleData.xml")
    @ExpectedDatabase("classpath:expectedSave.xml")
    public void testSaveMahasiswa(){
        Mahasiswa Mahasiswa=new Mahasiswa();
        Mahasiswa.setAlamat("Pupus");
        Mahasiswa.setAlamat("Ahmad Dhani");
        Mahasiswa.setNama("Dewa");
        
        Mahasiswa MahasiswaPersisted=MahasiswaDao.saveMahasiswa(Mahasiswa);
        
        assertNotNull(MahasiswaPersisted);
        assertNotNull(MahasiswaPersisted.getId());
    }
    
    @Test
    @DatabaseSetup("classpath:sampleData.xml")
//    @ExpectedDatabase("classpath:expectedUpdate.xml")
    public void testUpdateMahasiswa(){
        Mahasiswa Mahasiswa=MahasiswaDao.getMahasiswa(2);
        assertEquals("Stand By Me", Mahasiswa.getAlamat());
        
        Mahasiswa.setAlamat("Semua Tentang Kita");
        Mahasiswa MahasiswaUpdated=MahasiswaDao.updateMahasiswa(Mahasiswa);
        
        Mahasiswa MahasiswaBaru=MahasiswaDao.getMahasiswa(2);
        
        assertNotNull(MahasiswaUpdated);
        assertEquals("Semua Tentang Kita", MahasiswaUpdated.getAlamat());
        assertEquals("Semua Tentang Kita", MahasiswaBaru.getAlamat());
    }
    
    @Test
    @DatabaseSetup("classpath:sampleData.xml")
    @ExpectedDatabase("classpath:expectedDelete.xml")
    public void testDeleteMahasiswa(){
        Mahasiswa Mahasiswa=MahasiswaDao.getMahasiswa(2);
        Mahasiswa MahasiswaDeleted=MahasiswaDao.deleteMahasiswa(Mahasiswa);
        Mahasiswa MahasiswaKosong=MahasiswaDao.getMahasiswa(MahasiswaDeleted.getId());
        
        assertNull(MahasiswaKosong);
        assertEquals(1, MahasiswaDao.getLagus().size());
    }
}
