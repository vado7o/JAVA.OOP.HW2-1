public class Cars {
    private String model;
    private int year;
    private double price;
    private String color;
    private double power;
    private boolean isOn;
    private double max_speed;

    public Cars(String model, int year, double price, String color, double power, double max_speed) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.power = power;
        this.isOn = false;
        this.max_speed = max_speed;
    }

    public void getInfo(){
        System.out.println("Модель: "+ model + ", год выпуска: " + year + ", цена: " + price + ", цвет: " + color
                + ", мощность: " + power + ", максимальная скорость: " + max_speed);
    }

    public void start_stop() {
        if (!this.isOn) {
            this.isOn = true;
            System.out.println(this.model + " заведена");
        } else {
            this.isOn = false;
            System.out.println(this.model + " заглушена");
        }
    }
    public void move(String target) {
        if (this.isOn) System.out.println(this.model + " поехала в " + target);
        else System.out.println(this.model + " заглушена, поэтому не может ехать. Заведите двигатель чтобы поехать.");
    }

    public void compare(Cars car) {
        if (this.year > car.year) System.out.println(this.model + " младше, чем " + car.model);
        else if (this.year == car.year) System.out.println(this.model + " и " + car.model + " одного возраста.");
        else System.out.println(car.model + " младше, чем " + this.model);
        if (this.price > car.price) System.out.println(this.model + " дороже, чем " + car.model);
        else if (this.price == car.price) System.out.println(this.model + " и " + car.model + " стоят одинаково");
        else System.out.println(car.model + " дороже, чем " + this.model);
        if (this.power > car.power) System.out.println(this.model + " мощнее, чем " + car.model);
        else if (this.power == car.power) System.out.println(this.model + " и " + car.model + " одинаковой мощности");
        else System.out.println(car.model + " мощнее, чем " + this.model);
    }

    public String getModel() {
        return model;
    }

    public void setMax_speed(Double max_speed) {
        this.max_speed = max_speed;
    }

    public Double getMax_speed() {
        return max_speed;
    }

    public String getColor() {
        return color;
    }
}
