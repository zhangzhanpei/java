package generic;

/**
 * 泛型类，典型的就是各种容器类如 List、Set、Map
 * @param <T>
 */
class GenericClass<T> {
    private T value;

    GenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}

class Test {
    public static void main(String[] args) {
        // 实例化时指定类型
        GenericClass<String> genericString = new GenericClass<>("Generic Class");
        System.out.println(genericString.getValue());
        
        GenericClass<Integer> genericInteger = new GenericClass<>(666);
        System.out.println(genericInteger.getValue());
    }
}
