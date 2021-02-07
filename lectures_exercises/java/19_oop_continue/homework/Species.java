package homework;

public class Species extends Family {
	
	private String localisation;
	private String speciesName;
	private boolean isCute;
	private boolean needsWater;
	private String individualName;
	
	public Species() {
		
	}
	
	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
	
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public boolean isCute() {
		return isCute;
	}
	public void setCute(boolean isCute) {
		this.isCute = isCute;
	}
	public boolean isNeedsWater() {
		return needsWater;
	}
	public void setNeedsWater(boolean needsWater) {
		this.needsWater = needsWater;
	}
	
	public void touch() {
		System.out.printf("%s", getLocalisation());
	}
	
	public String getIndividualName() {
		return individualName;
	}

	public void setIndividualName(String individualName) {
		this.individualName = individualName;
	}

	
	
	
	

}
