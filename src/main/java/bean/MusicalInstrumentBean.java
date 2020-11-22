package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import bo.MusicalInstrument;
import dao.MusicalInstrumentDAO;

@ManagedBean
public class MusicalInstrumentBean {
	// Attributes
	private MusicalInstrument musicalInstrument = new MusicalInstrument();
	private List<MusicalInstrument> musicalInstrumentList;
	
	// Custom Methods
	
	// CREATE ...
	public String saveMusicalInstrument() {
		try {
			MusicalInstrumentDAO.insertMusicaInstrument(musicalInstrument);
			musicalInstrument = new MusicalInstrument();
			int countList = MusicalInstrumentDAO.countMusicalInstrument();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!","Number of Items in the Database: " + countList));
		} catch (Exception e) {
			musicalInstrument = new MusicalInstrument();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Failed!","Data Not Saved!"));
		}			
			return null;
	}
	
	// READ ...
	public String listMusicalInstrument() {
		musicalInstrumentList = MusicalInstrumentDAO.selectAllMusicalInstrument();
		return "ListMusicalInstrument.xhtml";
	}
	
	// UPDATE ...
	public String editMusicalInstrument() {
		try {
			MusicalInstrumentDAO.updateMusicalInstrumentById(musicalInstrument);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "Data Edited successfully!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Failed!","Data Not Edited!"));
		}			
			return null;
	}

	// DELETE ...
	public String deleteMusicalInstrument() {
		try {
			MusicalInstrumentDAO.deleteMusicalInstrumentById(musicalInstrument);
			musicalInstrumentList.remove(musicalInstrument);
			int countList = MusicalInstrumentDAO.countMusicalInstrument();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!","Number of Items in the Database: " + countList));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Failed!","Data Not Excluded!"));
		}
			return null;
	}
	
	// COUNT 
	public String countMusicalInstrument() {
		try {
			int countList = MusicalInstrumentDAO.countMusicalInstrument();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!","Number of Items in the Database: " + countList));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Failed!","Could not count registers!"));
		}
		return null;
	}
	
	// Getters and Setters
	public MusicalInstrument getMusicalInstrument() {
		return musicalInstrument;
	}

	public void setMusicalInstrument(MusicalInstrument musicalInstrument) {
		this.musicalInstrument = musicalInstrument;
	}

	public List<MusicalInstrument> getMusicalInstrumentList() {
		if (musicalInstrumentList == null) {
			musicalInstrumentList = MusicalInstrumentDAO.selectAllMusicalInstrument();
		}
		return musicalInstrumentList;
	}

	public void setMusicalInstrumentList(List<MusicalInstrument> musicalInstrumentList) {
		this.musicalInstrumentList = musicalInstrumentList;
	}
	
}
