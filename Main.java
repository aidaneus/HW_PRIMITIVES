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

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int earnings = 0;
        int spendings = 0;
        int usmEarn = 0;
        int usmEarnSpend = 0;
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
                    usmEarn = taxEarnings(earnings);
                    usmEarnSpend = taxEarningsMinusSpendings(earnings, spendings);
                    if (usmEarn < usmEarnSpend) {
                        System.out.println("Мы советуем вам УСН доходы");
                        diff = usmEarnSpend - usmEarn;
                        System.out.println("Ваш налог составит: " + usmEarn);
                        System.out.println("Налог на другой системе: " + usmEarnSpend);
                    } else if (usmEarnSpend < usmEarn) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        diff = usmEarn - usmEarnSpend;
                        System.out.println("Ваш налог составит: " + usmEarnSpend);
                        System.out.println("Налог на другой системе: " + usmEarn);
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
