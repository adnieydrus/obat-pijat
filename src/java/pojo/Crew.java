package pojo;
// Generated Oct 2, 2018 12:18:12 PM by Hibernate Tools 4.3.1

import dao.CrewDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Transient;
import javax.servlet.http.Part;




/**
 * Crew generated by hbm2java
 */
@ManagedBean
@SessionScoped
public class Crew  implements java.io.Serializable {


     private Integer crewId;
     private Integer admin;
     private String crewName;
     private String crewImage;
     private String crewDesc;
    private String msg;
    private Integer selectedID;

    public Integer getSelectedID() {
        return selectedID;
    }

    public void setSelectedID(Integer selectedID) {
        this.selectedID = selectedID;
    }
    
    
    @Transient
    private Part image;
    private List<Crew> listMhs;

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Crew() {
    }

    public Crew(Integer admin, String crewName, String crewImage, String crewDesc) {
       this.admin = admin;
       this.crewName = crewName;
       this.crewImage = crewImage;
       this.crewDesc = crewDesc;
    }
   
    public Integer getCrewId() {
        return this.crewId;
    }
    
    public void setCrewId(Integer crewId) {
        this.crewId = crewId;
    }
    public Integer getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Integer admin) {
        this.admin = admin;
    }
    public String getCrewName() {
        return this.crewName;
    }
    
    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public List<Crew> getListMhs() {
        return listMhs;
    }

    public void setListMhs(List<Crew> listMhs) {
        this.listMhs = listMhs;
    }
    public String getCrewImage() {
        return this.crewImage;
    }
    
    public void setCrewImage(String crewImage) {
        this.crewImage = crewImage;
    }
    public String getCrewDesc() {
        return this.crewDesc;
    }
    
    public void setCrewDesc(String crewDesc) {
        this.crewDesc = crewDesc;
    }
    
    public void cleardata(){
        this.crewId = null;
        this.admin = null;
        this.crewName = null;
        this.crewImage = null;
        this.crewDesc = null;
    }

    public void simpanData(){
            CrewDAO kryDAO = new CrewDAO();
            kryDAO.nambah(this);
            this.msg = " Has Been Sent";
            cleardata();
        }

    public String doUpload() {
		String path = null;
		String pathValue = null;
		try {
			InputStream in = image.getInputStream();
			File f = new File("C:\\Users\\Windows 10 Pro\\Documents\\NetBeansProjects\\obat_pijat\\web\\images\\"+image.getSubmittedFileName());
			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);
			
			byte[] buffer = new byte[1024];
			int length;
			while ((length=in.read(buffer))>0){
				out.write(buffer, 0, length);
			}
			out.close();
			in.close();
			
			path = String.valueOf(f.getAbsolutePath());
			pathValue = "images\\"+image.getSubmittedFileName();
			System.out.println("upload success");
		} catch (Exception e) {
			System.out.println(e);
		}
		return pathValue;
	}
    
    public void addServicelist() {
		CrewDAO dao = new CrewDAO();
		setCrewImage(doUpload());
		dao.addNewServicelist(this);
		clearAll();
	}
    
    public void clearAll(){
        crewId = null;
        admin = null;
        crewName = null;
        crewImage = null;
        crewDesc = null;
        
    }

    public List<Crew> lihatDataCrew()
    {
        this.msg = null;
        CrewDAO mhsDao = new CrewDAO();
        listMhs = mhsDao.getAllCrew();
        return listMhs;   
    }
    
    public List<Crew> getAllIDCrew()
    {
        CrewDAO mhsDao = new CrewDAO();
        listMhs = mhsDao.getIDCrew();
        return listMhs;
    }
    
    public void ambilCrewByID()
    {
        CrewDAO mhsDao = new CrewDAO();
        List<Crew> ls = mhsDao.getCrewByID(selectedID);
        this.crewId = ls.get(0).crewId;
        this.admin = ls.get(0).admin;
        this.crewName = ls.get(0).crewName;
        this.crewImage = ls.get(0).crewImage;
        this.crewDesc = ls.get(0).crewDesc;
    }
    
    public void updateMahasiswa()
    {
        CrewDAO mhsDao = new CrewDAO();
        mhsDao.updateMahasiswa(this);
        this.msg = "Data Has Been Updated";
        this.cleardata();
    }
    
    public void deleteMahasiswa()
    {
        CrewDAO mhsDao = new CrewDAO();
        mhsDao.deleteMahasiswa(this);
        this.msg = "Data Has Been Deleted";
        this.cleardata();
    }
    
}

