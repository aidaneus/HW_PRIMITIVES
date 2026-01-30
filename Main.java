import java.util.Scanner;

public class Main {

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int earnings = 0;
        int spendings = 0;
        int usm_earn = 0;
        int usm_earn_spend = 0;
        int diff = 0;

        
        while(true) {
            System.out.println("Выберите операцию и введите её номер: \n" +
                                "1. Добавить новый доход \n" +
                                "2. Добавить новый расход \n" +
                                "3. Выбрать систему налогообложения");
            input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    earnings += scanner.nextInt();
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    spendings += scanner.nextInt();
                    scanner.nextLine();
                case 3:
                    usm_earn = earnings * 6 / 100;
                    usm_earn_spend = taxEarningsMinusSpendings(earnings, spendings);
                    if (usm_earn < usm_earn_spend) {
                        System.out.println("Мы советуем вам УСН доходы");
                        diff = usm_earn_spend - usm_earn;
                        System.out.println("Ваш налог составит: " + usm_earn);
                        System.out.println("Налог на другой системе: " + usm_earn_spend);
                    } else if (usm_earn_spend < usm_earn) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        diff = usm_earn - usm_earn_spend;
                        System.out.println("Ваш налог составит: " + usm_earn_spend);
                        System.out.println("Налог на другой системе: " + usm_earn);
                    }
                        System.out.println("Экономия: " + diff);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
            System.out.println("\n");
        }
        System.out.println("\nПрограмма завершена!");
        scanner.close();
    }
}
