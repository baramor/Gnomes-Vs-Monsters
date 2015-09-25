package net.silvertigerentertainment.GVSM.Stats;

public enum StatType {
	
	Health("HP",100),Mana("MP",100);
	
	public String name;
	public int value;
	
	StatType(String name, int value){
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}