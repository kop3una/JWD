package by.training.task08.beans;

public enum CandiesXmlTag {
    CANDIES("candies"), // root tag
    CANDY("candy"), // tag our things

    COUNTRY("country"), // attributes
    PRICE("price"),

    NAME("name"), //
    ENERGY("energy"),
    TYPE("type"),
    PRODUCTION("production"),
    DATE_MANUFACTURED("date_manufactured"),

    FATS("fats"),
    PROTEINS("proteins"),
    CARBOHYDRATES("carbohydrates"),
    VALUE("value"),

    WATER("water"),
    CARAMEL("caramel"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    OIL("oil"),
    MILK("milk"),
    SOURCREAM("sourCream"),
    CONDENSEDMILK("condensedMilk"),
    EGGSPROTEIN("eggsProtein"),
    GELATIN("gelatin"),
    CHOCOLATE("chocolate"),
    TYPECHOCOLATE("typeChocolate"),
    WEIGHT("weight"),
    TYPENUTS("typeNuts"),
    NUTS("nuts"),
    INGREDIENTS("ingredients");

    private final String value;

    CandiesXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
