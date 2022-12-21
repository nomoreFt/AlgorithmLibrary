package jumpToJava.Mineral;

public class MineralCalculator {
    int value;

    public void add(Mineral mineral) {
        value += mineral.getValue();
    }

    public int getValue() {
       return this.value;
    }
}
