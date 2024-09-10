package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListFormatter {
    private List<Integer> fiboList;
    private char orientation;
    private char order;
    private char mode;

    public ListFormatter(List<Integer> fiboList, char orientation, char order, char mode) {
        this.fiboList = fiboList;
        this.orientation = orientation;
        this.order = order;
        this.mode = mode;
    }

    public String formattedList() {
        String output = "";
        if (this.mode == 'l') {
            output = listMode();
        } else if (this.mode == 's') {
            output = sumMode();
        }
        return output;
    }

    private String listMode() {
        String breakLine = " ";
        if (this.orientation == 'v')
            breakLine = "\n";
        if (this.order == 'i')
            Collections.reverse(this.fiboList);

        String output = "";
        for (Integer number : this.fiboList) {
            output += breakLine + number;
        }

        return output;
    }

    private String sumMode() {
        int sum = 0;
        for (Integer number : this.fiboList) {
            sum += number;
        }
        return String.valueOf(sum);
    }
}