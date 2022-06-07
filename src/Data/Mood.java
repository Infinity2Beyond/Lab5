package Data;

public enum Mood {
	SADNESS  ,
    SORROW ,
    GLOOM ,
    APATHY ,
    RAGE ;
	public static String nameList() {
        String nameList = "";
        for (Mood mood : values()) {
            nameList += mood.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
