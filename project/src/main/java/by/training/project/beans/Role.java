package by.training.project.beans;

public enum Role { // TODO Защита от удаления отеля, когда вводим url с роли клиент
    // TODO защита от get, когда запрос Post
    // TODO можно страну с JOIN
    // TODO чек кластиризованный индекс
    // TODO ALTER Table Create Index
    // TODO к сожалению ничего не найдено
    // TODO к пагинации limits offset
    // TODO запросы обищй метод думать
    // TODO ограничение пароля и полей на символы

    ADMINISTRATOR (0),
    CLIENT (1),
    TOUROPERATOR (2);

    private int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Role{" +
                "value=" + value +
                "} " + super.toString();
    }
}
