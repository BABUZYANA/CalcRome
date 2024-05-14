public class Calc {
    public String Caculate(String string) throws Exception {
        String[] mas = string.split(" ");
        if (mas.length < 3) {
            throw new Exception("Это не математическая операция");
        } else if (mas.length > 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию");
        }
        try {
            int result = getResult(mas);
            return Integer.toString(result);
        } catch (NumberFormatException e) {
            try {
                Roman a = Roman.valueOf(mas[0]);
                Roman b = Roman.valueOf(mas[2]);
                Roman rom3 = getRoman(a, b, mas);
                return rom3.toString();
            } catch (IllegalArgumentException c) {
                throw new IllegalArgumentException("Используются разные системы счисления или введено некорректное значение");
            }
        }
    }

    private static int getResult(String[] mas) throws Exception {
        int a = Integer.parseInt(mas[0]);
        int b = Integer.parseInt(mas[2]);
        if (((a > 10) || (a < 0)) || ((b > 10) || (b < 0))) {
            throw new Exception("Число должно быть от 1 до 10");
        }
        return switch (mas[1]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new Exception("Введен не корректный символ");
        };
    }

    private static Roman getRoman(Roman a, Roman b, String[] mas) throws Exception {
        int rom1 = a.translation;
        int rom2 = b.translation;
        if ((rom1 > 10) || (rom2 > 10)) {
            throw new Exception("Число должно быть от 1 до 10");
        }
        int romRes = switch (mas[1]) {
            case "+" -> rom1 + rom2;
            case "-" -> rom1 - rom2;
            case "*" -> rom1 * rom2;
            case "/" -> rom1 / rom2;
            default -> throw new Exception("Введен не корректный символ");
        };
        if (romRes < 0) {
            throw new Exception("В римских числах нет отрицательных значений");
        }
        return Roman.values()[romRes - 1];
    }
}



