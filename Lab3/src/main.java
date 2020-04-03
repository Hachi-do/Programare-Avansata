public class main {


    public static void main(String[] args) {
        Knapsack knap = new Knapsack();
        knap.setCapacity(10);
        Book book1 = new Book();
        book1.setPageNumber(300);
        book1.setName("Dragon rising");
        book1.setValue(5);
        Book book2 = new Book("A Blade in the Dark", 300, 5);
        Food food1 = new Food("Cabbage", 2);
        Food food2 = new Food("Rabbit", 2);
        Weapon weapon = new Weapon(Weapon.WeaponType.SWORD, 5, 10);
        knap.addItem(book1);
        knap.addItem(book2);
        knap.addItem(food1);
        knap.addItem(food2);
        knap.addItem(weapon);

        System.out.println(knap);
    }
}
