package Backtracking;

import java.util.*;

public class KeypadCombinations {
    public Map<Integer, List<Character>> map = new HashMap<>();

    public KeypadCombinations() {
        map.put(2, new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
        map.put(3, new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
        map.put(4, new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
        map.put(5, new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
        map.put(6, new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
        map.put(7, new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
        map.put(8, new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
        map.put(9, new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));
    }

    public void keypadCombinations(int[] combination) {
        var list = new ArrayList<String>();
        for (var i : map.get(combination[0])) {
            list.add(i.toString());
        }
        this._keypadCombinations(combination, list, 1);

    }

    private void _keypadCombinations(int[] combination, List<String> list, int index) {
        if (index > (combination.length - 1)) {
            System.out.println(list);
            return;
        }
        var newList = new ArrayList<String>();
        for (var i1 : list) {
            for (var i2 : this.map.get(combination[index])) {
                newList.add(String.format("%s%s", i1, i2));
            }
        }
        _keypadCombinations(combination, newList, index + 1);
    }
}
