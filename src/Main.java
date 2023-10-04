
/*Условия:
        1) В игре есть Существа. К ним относятся Игрок и Монстры.
        2) У Существа есть параметры Атака и Защита. Это целые числа от 1 до 30.
        3) У Существа есть Здоровье. Это натуральное число от 0 до N.
        Если Здоровье становится равным 0, то Существо умирает.
        Игрок может себя исцелить до 4-х раз на 30% от максимального Здоровья.
        4) У Существа есть параметр Урон. Это диапазон натуральных чисел M - N. Например, 1-6.
        5) Одно Существо может ударить другое по такому алгоритму:
        - Рассчитываем Модификатор атаки. Он равен разности Атаки атакующего
        и Защиты защищающегося плюс 1
        - Успех определяется броском N кубиков с цифрами от 1 до 6,
         где N - это Модификатор атаки. Всегда бросается хотя бы один кубик.
        - Удар считается успешным, если хотя бы на одном из кубиков выпадает 5 или 6
        - Если удар успешен, то берется произвольное значение из параметра Урон атакующего
         и вычитается из Здоровья защищающегося.*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Monsters monster = new Monsters(2, 7, 7, 1, 4);
        Player player = new Player(4, 5, 9, 2, 5);

        while(player.isAlive() && monster.isAlive()) {
            System.out.println("Выберите действие:");
            System.out.println("1. Исцелиться");
            System.out.println("2. Атаковать монстра");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> player.heal();
                case 2 -> player.attack(monster);
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }

            if(monster.isAlive()) {
                System.out.println("--------------------------" +
                        "\nАтака монстра. Берегись!");
                monster.attack(player);
            }

            System.out.println("--------------------------" +
                    "\nТекущее состояние:");
            System.out.println(player.getStats());
            System.out.println(monster.getStats());
            System.out.println("--------------------------");
        }

        if (!player.isAlive()) {
            System.out.println("Вы проиграли.");
        } else {
            System.out.println("Вы победили!");
        }
    }
}