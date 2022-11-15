// Creates the balanced cell factory, can be used to create totally ran cell generation factory
public interface CellFactoryCreator<T extends Cell> {
    public T generateCell();
}
