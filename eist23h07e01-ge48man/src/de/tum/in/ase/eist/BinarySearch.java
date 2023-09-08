package de.tum.in.ase.eist;

import java.util.List;

public class BinarySearch implements SearchStrategy {
    @Override
    public int performSearch(List<Chapter> book, String name) {
        int l = 0;
        int r = book.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            Chapter chapter = book.get(m);
            if (chapter.getName().compareTo(name) == 0) {
                return chapter.getPageNumber();
            } else if (chapter.getName().compareTo(name) < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}
