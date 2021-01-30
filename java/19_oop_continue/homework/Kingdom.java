package homework;

/**
 * Describes one of the five kingdoms of life.
 * Cannot be instantiated.
 * @author tnebes
 *
 */

public class Kingdom extends Domain {

	private static final int rank = 0;
	private String kingdomName;
	private boolean multiCellular;
	private boolean sexuallyReproduce;
	private boolean exclusivelyLandBased;
	
	public Kingdom() {
		
	}
	
	static public int getRank() {
		return rank;
	}
	
	public String getKingdomName() {
		return kingdomName;
	}
	
	public void setKingdomName(String name) {
		this.kingdomName = name;
	}
	
	public boolean isMulticellular() {
		return multiCellular;
	}
	
	public void setMulticellular(boolean isMulticellular) {
		this.multiCellular = isMulticellular;
	}
	
	public boolean isCanSexuallyReproduce() {
		return sexuallyReproduce;
	}
	
	public void setCanSexuallyReproduce(boolean canSexuallyReproduce) {
		this.sexuallyReproduce = canSexuallyReproduce;
	}
	
	public boolean isExclusivelyLandBased() {
		return exclusivelyLandBased;
	}
	
	public void setExclusivelyLandBased(boolean landBased) {
		this.exclusivelyLandBased = landBased;
	}

	
}
