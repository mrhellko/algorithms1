package practicum;

import java.util.*;

public class Algorithms {

    /**
     * Отсортируйте список, НЕ используя методы стандартной библиотеки (напр. Collections.sort).
     */
    public static List<Integer> sort(List<Integer> list1) {
        List<Integer> list = new ArrayList<>(list1);
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(minIndex) > list.get(j)) {
                    minIndex = j;
                }
            }
            int tmp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, tmp);
        }
        return list;
    }

    /**
     * Удалите дубликаты из списка.
     * <p>
     * Усложнение: не используйте дополнительные структуры данных
     * для хранения промежуточных значений.
     * (списки, массивы, хэш-таблицы, множества и т.п.).
     * К списку-результату это не относится.
     */
    public static List<Integer> removeDuplicates(List<Integer> list1) {
        List<Integer> list = new ArrayList<>();
        if (!list1.isEmpty()) {
            list.add(list1.get(0));
            int i = 1;
            while (i < list1.size()) {
                if (!list.contains(list1.get(i))) {
                    list.add(list1.get(i));
                }
                i++;
            }
        }
        return list;
    }

    /**
     * Проверьте, является ли список "палиндромом".
     * Палиндром -- это список, который в обе стороны читается одинаково.
     * Например:
     * палиндромы: [1 2 1], [3 2 1 2 3], [2 2 2], []
     * не палиндромы: [1 2 3], [2 2 3], [3 2 1 3 2]
     * <p>
     * Доп. условие: у алгоритма должна быть линейная сложность, O(n)
     */
    public static boolean isPalindrome(List<Integer> list) {
        int cursorLeft = 0;
        int cursorRight = list.size() - 1;
        while (cursorLeft < cursorRight) {
            if (!Objects.equals(list.get(cursorLeft++), list.get(cursorRight--))) return false;
        }
        return true;
    }

    /**
     * Объедините два отсортированных списка в один отсортированный список.
     * Например:
     * [1 3 5] + [2 4 6] = [1 2 3 4 5 6]
     * [1 2 3] + [1 3 5] = [1 1 2 3 3 5]
     * [] + [1] = [1]
     * [7] + [1 4] = [1 4 7]
     * <p>
     * Доп. условие: у алгоритма должна быть линейная сложность, O(n).
     */
    public static List<Integer> mergeSortedLists(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int cursorA = 0;
        int cursorB = 0;
        while (!(cursorA == a.size() && cursorB == b.size())) {
            if (cursorA == a.size()) {
                result.add(b.get(cursorB++));
                continue;
            }
            if (cursorB == b.size()) {
                result.add(a.get(cursorA++));
                continue;
            }
            if (a.get(cursorA) < b.get(cursorB)) {
                result.add(a.get(cursorA++));
            } else {
                result.add(b.get(cursorB++));
            }

        }
        return result;
    }

    /**
     * Проверьте, что в массиве нет дубликатов.
     * Верните true, если дубликатов нет, иначе false.
     * <p>
     * Усложнение: не используйте дополнительные структуры данных
     * (списки, массивы, хэш-таблицы, множества и т.п.).
     */
    public static boolean containsEveryElementOnce(int[] array) {
        return Arrays.stream(array).distinct().count() == array.length;
    }

    /**
     * Определите, является ли один массив перестановкой другого.
     * Т.е. в массивах хранится один и тот же набор элементов, но (возможно) в разном порядке.
     * <p>
     * Для решения нжуно использовать одну хэш-таблицу.
     * <p>
     * Например:
     * [1 2 3] и [3 2 1] = true
     * [1 1 2] и [1 2 1] = true
     * [1 2 3] и [1 2 3] = true
     * [] и [] = true
     * <p>
     * [1 2] и [1 1 2] = false, разный набор элементов
     */
    public static boolean isPermutation(int[] a, int[] b) {
        if (a.length != b.length) return false;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            hashMap.merge(a[i], 1, Integer::sum);
            hashMap.merge(b[i], -1, Integer::sum);
        }
        return hashMap.values().stream().allMatch(v -> v == 0);
    }

    /**
     * Сложная задача.
     * <p>
     * В памяти компьютера изображения (часто) хранятся в виде двумерного массива.
     * Напишите метод, который повернёт "изображение" на 90 градусов вправо.
     * "Изображение" в данном примере -- двумерный массив целых чисел.
     * <p>
     * Например:
     * на входе:
     * [ [1 2]
     * [3 4]
     * [5 6] ]
     * <p>
     * на выходе:
     * [ [5 3 1]
     * [6 4 2] ]
     */
    public static int[][] rotateRight(int[][] image) {
        int[][] resultArray = new int[image[0].length][image.length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                resultArray[j][image.length - i - 1] = image[i][j];
            }
        }
        return resultArray;
    }
}
