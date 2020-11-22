package bean;

import java.util.ArrayList;
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
	private List<MusicalInstrument> musicalInstrumentList = new ArrayList<MusicalInstrument>();
	
	// Custom Methods
	public String saveMusicalInstrument() {
			MusicalInstrumentDAO.insertMusicaInstrument(musicalInstrument);
			musicalInstrument = new MusicalInstrument();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success!", "Data saved successfully!"));
			return null;
	}
	
	public String listMusicalInstrument() {
		musicalInstrumentList = MusicalInstrumentDAO.selectAllMusicalInstrument();
		return "ListMusicalInstrument.xhtml";
	}

	// Getters and Setters
	public MusicalInstrument getMusicalInstrument() {
		return musicalInstrument;
	}

	public void setMusicalInstrument(MusicalInstrument musicalInstrument) {
		this.musicalInstrument = musicalInstrument;
	}

	public List<MusicalInstrument> getMusicalInstrumentList() {
		return musicalInstrumentList;
	}

	public void setMusicalInstrumentList(List<MusicalInstrument> musicalInstrumentList) {
		this.musicalInstrumentList = musicalInstrumentList;
	}
	
}
