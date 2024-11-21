package org.mikan.altairkit.api.gui;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {

    public static <T>List<T> getPageItems(List<T> items, int page, int spaces) {
        int upperBound = page * spaces;
        int lowerBound = upperBound - spaces;
        List<T> itemsList = new ArrayList<>();

        for(int i = lowerBound; i < upperBound; ++i) {
            try {
                itemsList.add(items.get(i));
            } catch (IndexOutOfBoundsException var8) {
                break;
            }
        }

        return itemsList;
    }

    public static boolean isPageValid(List<?> items, int page, int spaces) {
        if (page <= 0) {
            return false;
        } else {
            int upperBound = page * spaces;
            int lowerBound = upperBound - spaces;
            return items.size() > lowerBound;
        }
    }

}
