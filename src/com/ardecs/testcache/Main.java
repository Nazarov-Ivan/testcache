package com.ardecs.testcache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите размер кеша");
            Cache.sizeOfCache = Integer.parseInt(bufferedReader.readLine());
            Cache cache = new Cache();
            System.out.println("Выберите стратегию удаления старых элементов: LFU, MRU, LRU");
            String deleteStrategy = bufferedReader.readLine();
            switch (deleteStrategy) {
                case "LFU":
                    Strategy LFUStrategy = new LFUCache();
                    Strategy.mainStrategy(LFUStrategy);
                    break;
                case "MRU":
                    Strategy MRUStrategy = new MRUCache();
                    Strategy.mainStrategy(MRUStrategy);
                    break;
                case "LRU":
                    Strategy LRUStrategy = new LRUCache();
                    Strategy.mainStrategy(LRUStrategy);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Запустите программу еще раз и введите число");
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
