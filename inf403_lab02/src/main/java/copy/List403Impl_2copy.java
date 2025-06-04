package copy;

public class List403Impl_2copy <T> implements List403_2copy <T>{

    private Object[] values;
    private int size;


    public List403Impl_2copy() {
        this.size = 0;
        this.values = new Object[10];
    }

    public void add(T element) {
        if (size >= values.length) {
            grow();
        }
        values[size++] = element;
    }

    public void add(T element, int position) throws IndexOutOfBoundsException {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за массив");
        }
        if (size >= values.length) {
            grow();
        }
        for (int i = size; i != position; i--) {
            values[i] = values[i-1];
        }
        values[position] = element;
        size++;
    }

    public T remove(int position) throws IndexOutOfBoundsException {
        if (position > size  || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за массив");
        }
        T temp = (T)values[position];
        for (int i = position; i < size - 1; i++) {
            values[i] = values[i+1];
        }
        values[size-1] = null;
        size--;
        return temp;
    }

    public int size() {
        return size;

    }

    public T get(int position) throws IndexOutOfBoundsException {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за массив");
        }
        return (T)values[position];
    }

    public boolean sort(boolean asc) {
        if (asc) {
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i - 1; j++) {
                    if ((int)values[j] > (int)values[j+1]) {
                        Object f = values[j];
                        values[j] = values[j+1];
                        values[j+1] = f;
                    }
                }
            }
        } else {
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i -1; j++) {
                    if ((int)values[j] < (int)values[j+1]) {
                        Object f = values[j];
                        values[j] = values[j+1];
                        values[j+1] = f;
                    }
                }
            }
        }
        return asc;

    }

    private void grow() {
        Object[] newValues = new Integer[(int) (size * 1.5)];
        for (int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }

    @Override
    public String toString() {
        String res = "";
        StringBuilder strbuild = new StringBuilder();
        for (int i = 0; i < size; i++) {
            res += values[i] + " ";
            strbuild.append(values[i]).append(" ");
        }
        return strbuild.toString();
    }
}

