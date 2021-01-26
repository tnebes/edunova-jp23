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
	private boolean isMulticellular;
	private boolean canSexuallyReproduce;
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
		return isMulticellular;
	}
	
	public void setMulticellular(boolean isMulticellular) {
		this.isMulticellular = isMulticellular;
	}
	
	public boolean isCanSexuallyReproduce() {
		return canSexuallyReproduce;
	}
	
	public void setCanSexuallyReproduce(boolean canSexuallyReproduce) {
		this.canSexuallyReproduce = canSexuallyReproduce;
	}
	
	public boolean isExclusivelyLandBased() {
		return exclusivelyLandBased;
	}
	
	public void setExclusivelyLandBased(boolean landBased) {
		this.exclusivelyLandBased = landBased;
	}

	
}
