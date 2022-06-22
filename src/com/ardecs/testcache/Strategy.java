package com.ardecs.testcache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.ardecs.testcache.Cache.cacheList;

public interface Strategy {

    public void add(String key, String value);

    public Cache get(String key);

    public static void allDelete(){
        cacheList.clear();
        System.out.println("Кеш очищен");
    }

    public static void mainStrategy(Strategy strategy){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.println("Введите команду");
                String key = bufferedReader.readLine();
                if (key.equals("delete")) {
                    allDelete();
                } else if (strategy.get(key)==null){
                    System.out.println("Результат команды " + key +
                            " не закеширован, введите пожалуйста результат");
                    String value = bufferedReader.readLine();
                    strategy.add(key,value);
                    System.out.println("Результат сохранен");
                }  else {
                    System.out.println("Результатом выполнения команды " +
                            key + " является " + strategy.get(key).getValue());
                }
        }
        }
        catch (NumberFormatException e) {
            System.out.println("Запустите программу еще раз и введите число");
        }
        catch (IOException e) {
            System.out.println("Ошибка");
        }



    }

}
