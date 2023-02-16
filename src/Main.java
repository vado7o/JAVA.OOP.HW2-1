import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        Cars toyota = new Cars("Toyota Camry", 2021, 2400, "красный", 2.4, 220.0);
        Cars volswagen = new Cars("VolsWagen Polo", 2022, 2000, "серый", 1.8, 190.0);
        Cars lexus = new Cars("Lexus RX", 2018, 3500, "белый", 3.5, 250.0);
        Cars mazda = new Cars("Mazda 6", 2019, 1700, "белый", 2.0, 200.0);

        toyota.getInfo();
        volswagen.getInfo();
        lexus.getInfo();
        mazda.getInfo();

        System.out.println("_________________________");
        toyota.move("Челябинск");
        lexus.start_stop();
        lexus.move("Сызрань");
        toyota.start_stop();
        toyota.move("Челябинск");
        lexus.start_stop();
        toyota.start_stop();

        System.out.println("_________________________");

        toyota.compare(volswagen);
        lexus.compare(mazda);

        System.out.println("_________________________");

        double distance = round_dbl(rnd.nextDouble(20.0, 40.0));
        System.out.println("Сейчас состоится гонка на дистанцию " + distance + "км!!!!!!!!!!!!!!!!!!!!");
        Map<String, String> models = Map.of("t", "Toyota Camry", "v", "VolsWagen Polo", "l",
                "Lexus RX", "m", "Mazda 6");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите пожалуйста - на кого Вы готовы сделать ставку.\n" +
                    "Введите 't' - чтобы поставить на Тойоту Камри, 'v' - поставить на ФольсВаген Поло, " +
                    "l - поставить на Лексус РХ или 'm' - поставить на Мазду 6:");
            String user_choice = scanner.nextLine().toLowerCase();

            if (models.containsKey(user_choice)) {
                user_choice = models.get(user_choice);
                System.out.println("Вы поставили на " + user_choice + "! Желаем удачи!");
                System.out.println("Результаты гонки:");
                List<Cars> cars = new ArrayList<>(Arrays.asList(toyota, volswagen, mazda, lexus));
                race(cars, user_choice, distance, rnd);
                break;
            } else {
                System.out.println("Некорректный ввод!!!");
            }
        }
    }

    public static void race(List<Cars> cars, String user_choice, Double distance, Random rnd) {
        for (Cars car : cars) {
            if (Objects.equals(car.getModel(), "Toyota Camry")) car.setMax_speed(rnd.nextDouble(160, 220));
            if (Objects.equals(car.getModel(), "VolsWagen Polo")) car.setMax_speed(rnd.nextDouble(160, 190));
            if (Objects.equals(car.getModel(), "Lexus RX")) car.setMax_speed(rnd.nextDouble(160, 250));
            if (Objects.equals(car.getModel(), "Mazda 6")) car.setMax_speed(rnd.nextDouble(160, 200));
        }
        TreeMap<Double, Cars> timeLap = countTime(cars, distance);
        int count = 1;
        for(Map.Entry<Double, Cars> entry: timeLap.entrySet()) {
            System.out.println(count + ". " + entry.getValue().getColor() + " " + entry.getValue().getModel()
                    + " прошла дистанцию за " + entry.getKey() + " минут (максимальная скорость на трассе = " +
                    round_dbl(entry.getValue().getMax_speed()) + "км/час);");
            count++;
        }
        if (Objects.equals(timeLap.firstEntry().getValue().getModel(), user_choice)) System.out.println(
                "Поздравляем!!! Выбранный Вами участник пришёл первым!!!");
        else System.out.println("Увы, Ваш автомобиль не смог прийти первым...");
    }

    public static TreeMap<Double, Cars> countTime(List<Cars> cars, Double distance) {
        TreeMap<Double, Cars> timeLap = new TreeMap<>();
        for (Cars car: cars) {
            timeLap.put(round_dbl(distance / car.getMax_speed() * 60), car);
        }
        return timeLap;
    }

    public static Double round_dbl(double value) {
        DecimalFormat df = new DecimalFormat("####0.00");
        String num = df.format(value);
        num = num.replace(",", ".");
        return Double.parseDouble(num);
    }


}