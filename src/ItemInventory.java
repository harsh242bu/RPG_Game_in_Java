// Abstraction of list of items

import java.util.ArrayList;
import java.util.List;

public class ItemInventory<T extends Item> {
    private List<T> items;

    ItemInventory() {
        this.items = new ArrayList<T>();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public void addItems(List<T> items) {
        this.items.addAll(items);
    }

    public int getSize() {
        return items.size();
    }

    public void remove(T item) {
        items.remove(item);
    }

    public void printItems(int counter) {
        items.get(0).getHeader();
        for (Item item : items) {
            System.out.printf("%-4s", (counter + ". "));
            item.printItem();
            counter++;
        }
    }
}
