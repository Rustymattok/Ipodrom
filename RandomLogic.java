package ru.makarov.ipodrom;

import java.util.Random;

/**
 * Created by makarov_vv on 30.09.2015.
 *  ласс отвечает за логику рандома выбора скорости
 */
public class RandomLogic {
    private int vmax;
    private int vmin;

    public RandomLogic() {
        this.vmax = creatVmax();
        this.vmin = creatVmin();
    }
    public static int creatVmax() {
        Random random = new Random();
        int arr[] = {52,57,62,65,45,75,70};
        int n = arr[random.nextInt(arr.length)];
        return n;
    }
    public static int creatVmin() {
        Random random = new Random();
        int arr[] = {58,60,72,65,35,40,45};
        int n = arr[random.nextInt(arr.length)];
        return n;
    }
}
