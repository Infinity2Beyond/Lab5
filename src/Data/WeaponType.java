package Data;

public enum WeaponType {
	AXE,
    PISTOL,
    KNIFE,
    MACHINE_GUN;
	public static String nameList() {
        String nameList = "";
        for (WeaponType weapontype : values()) {
            nameList += weapontype.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
