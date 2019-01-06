package pojo;
// Generated Oct 2, 2018 12:18:12 PM by Hibernate Tools 4.3.1

import dao.RegisterDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




/**
 * Register generated by hbm2java
 */
@ManagedBean
@SessionScoped
public class Register  implements java.io.Serializable {


     private Integer registerId;
     private String registerName;
     private String registerAddress;
     private String registerEmail;
     private String registerContact;
     private String msg;
     private Integer selectedId;
     private List<Register> listMhs;

     

    public Integer getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Integer selectedId) {
        this.selectedId = selectedId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Register() {
    }

    public Register(String registerName, String registerAddress, String registerEmail, String registerContact) {
       this.registerName = registerName;
       this.registerAddress = registerAddress;
       this.registerEmail = registerEmail;
       this.registerContact = registerContact;
    }
   
    public Integer getRegisterId() {
        return this.registerId;
    }
    
    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }
    public String getRegisterName() {
        return this.registerName;
    }
    
    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }
    public String getRegisterAddress() {
        return this.registerAddress;
    }
    
    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }
    public String getRegisterEmail() {
        return this.registerEmail;
    }
    
    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }
    public String getRegisterContact() {
        return this.registerContact;
    }
    
    public void setRegisterContact(String registerContact) {
        this.registerContact = registerContact;
    }

public void cleardata(){
        this.registerId = null;
        this.registerName = null;
        this.registerAddress = null;
        this.registerEmail = null;
        this.registerContact = null;
    }

    public void simpanData(){
            RegisterDAO kryDAO = new RegisterDAO();
            kryDAO.nambah(this);
            this.msg = "Regist success, please wait your confirmation message";
            cleardata();
        }

    public List<Register> lihatDataRegister()
    {
        this.msg = null;
        RegisterDAO mhsDao = new RegisterDAO();
        listMhs = mhsDao.getAllRegister();
        return listMhs;   
    }
    
    public List<Register> getAllIDRegister()
    {
        RegisterDAO mhsDao = new RegisterDAO();
        listMhs = mhsDao.getIDRegister();
        return listMhs;
    }
    
    public void ambilRegisterByID()
    {
        RegisterDAO mhsDao = new RegisterDAO();
        List<Register> ls = mhsDao.getRegisterByID(selectedId);
        
        this.registerId = ls.get(0).registerId;
        this.registerName = ls.get(0).registerName;
        this.registerAddress = ls.get(0).registerAddress;
        this.registerEmail = ls.get(0).registerEmail;
        this.registerContact = ls.get(0).registerContact;
    }
    
    public void updateMahasiswa()
    {
        RegisterDAO mhsDao = new RegisterDAO();
        mhsDao.updateMahasiswa(this);
        this.msg = "Berhasil mengubah data mahasiswa..";
        this.cleardata();
    }
    
    public void deleteMahasiswa()
    {
        RegisterDAO mhsDao = new RegisterDAO();
        mhsDao.deleteMahasiswa(this);
        this.msg = "Berhasil menghapus data mahasiswa..";
        this.cleardata();
    }
    
    public String back(){
        String adaw = "home.xhtml";
        return adaw;
    }


}

