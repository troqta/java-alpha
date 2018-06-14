package com.telerik;

public enum Icons {
    SMILEY(":)"),
    SADFACE(":("),
    WINK(";)"),
    LAUGH(":D"),
    CRY(";("),
    WAOW(":O");

    private final String name;
        private Icons(String name){
            this.name=name;
        }
    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }
    public String toString() {
        return this.name;
    }
}
