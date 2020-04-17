package com.agung.springhibernatemaven.controller;

import com.agung.springhibernatemaven.exception.NotFoundException;
import com.agung.springhibernatemaven.model.Mahasiswa;
import com.agung.springhibernatemaven.service.MahasiswaService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Agung Setiawan
 */
@Controller
public class MahasiswaController {
    
    @Autowired
    MahasiswaService mahasiswaService;
    
    public void setMahasiswaService(MahasiswaService mahasiswaService){
        this.mahasiswaService=mahasiswaService;
    }
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("lagus", mahasiswaService.getLagus());
        return "index";
    }
    
    @RequestMapping(value = "tambah",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("mahasiswa", new Mahasiswa());
        return "tambah";
    }
    
    @RequestMapping(value = "tambah",method = RequestMethod.POST)
    public String adding(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa){
        mahasiswaService.saveLagu(mahasiswa);
        return "redirect:/";
    }
    
    @RequestMapping(value = "edit/{id}",method = RequestMethod.GET)
    public String edit(Model model,@PathVariable("id") Integer id){
        Mahasiswa mahasiswa=mahasiswaService.getMahasiswa(id);
        if(mahasiswa==null){
            throw new NotFoundException();
        }
        model.addAttribute("mahasiswa", mahasiswa);
        return "edit";
    }
    
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public String editing(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa){
        mahasiswaService.updateLagu(mahasiswa);
        return "redirect:/";
    }
    
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String deleting(@PathVariable("id") Integer id){
        Mahasiswa mahasiswa=mahasiswaService.getMahasiswa(id);
        if(mahasiswa==null){
            throw new NotFoundException();
        }
        mahasiswaService.deleteMahasiswa(mahasiswa);
        return "redirect:/";
    }
    
    @RequestMapping(value = "pdf",method = RequestMethod.GET)
    public String getPdfReport(Model model, HttpServletResponse response){        
        List<Mahasiswa> lagus=mahasiswaService.getLagus();
        JRDataSource dataSource=new JRBeanCollectionDataSource(lagus);
        
        model.addAttribute("dataSource", dataSource);
        return "pdfReport";
    }
    
    @RequestMapping(value = "xls",method = RequestMethod.GET)
    public String getXlsReport(Model model, HttpServletResponse response){
        List<Mahasiswa> lagus=mahasiswaService.getLagus();
        JRDataSource dataSource=new JRBeanCollectionDataSource(lagus);
        
        model.addAttribute("dataSource", dataSource);
        return "xlsReport";
    }
}
