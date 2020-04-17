/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.springhibernatemaven.controller;

import com.agung.springhibernatemaven.exception.NotFoundException;
import com.agung.springhibernatemaven.model.Mahasiswa;
import com.agung.springhibernatemaven.service.MahasiswaService;
import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

/**
 *
 * @author awanlabs
 */
public class MahasiswaControllerTest {
    
    MahasiswaController mahasiswaController;
    View view;
    MockMvc mockMvc;
    MahasiswaService mahasiswaService;
    
    @Before
    public void setUp(){
        mahasiswaController=new MahasiswaController();
        view=EasyMock.createMock(View.class);
        mahasiswaService=EasyMock.createMock(MahasiswaService.class);
        
        mahasiswaController.setMahasiswaService(mahasiswaService);
        mockMvc=MockMvcBuilders.standaloneSetup(mahasiswaController).setSingleView(view).build();
    }
    
    @Test
    public void testIndex() throws Exception{
        List<Mahasiswa> daftarMahasiswa=new ArrayList<Mahasiswa>();
        EasyMock.expect(mahasiswaService.getMahasiswas()).andReturn(daftarMahasiswa);
        EasyMock.replay(mahasiswaService);
        
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(model().attribute("Lagus", daftarMahasiswa));
    }
    
    
    @Test
    public void testAdd() throws Exception{
        mockMvc.perform(get("/tambah")).andExpect(status().isOk()).andExpect(view().name("tambah"));
    }
    
//    @Test
//    public void testAdding(){
//        mockMvc.perform(post(null, urlVariables));
//    }

    @Test
    public void testEdit() throws Exception{
        Mahasiswa mahasiswa=new Mahasiswa();
        EasyMock.expect(mahasiswaService.getMahasiswa(1)).andReturn(mahasiswa);
        EasyMock.replay(mahasiswaService);
        
        mockMvc.perform(get("/edit/1")).andExpect(status().isOk()).andExpect(view().name("edit"))
                .andExpect(model().attribute("mahasiswa", mahasiswa));
    }
    
    @Test
    public void testEditNotFound() throws Exception{
        EasyMock.expect(mahasiswaService.getMahasiswa(1)).andReturn(null);
        EasyMock.replay(mahasiswaService);
        
        mockMvc.perform(get("/edit/1")).andExpect(status().is(404));
    }
}
