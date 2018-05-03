package oop;

/**
 * 如果一个类从父类继承了一个方法，而且它又实现了一个接口，父类和接口中有同名方法时，父类的方法优先于接口的方法
 */
class Employee {
    private String name;
    private double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // 声明为 final 的方法不能在子类中覆盖
    final public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }
}

/**
 * 管理者继承自员工
 */
class Manager extends Employee {
    // 奖金
    private double bonus;

    Manager(String name, double salary) {
        // name 和 salary 都是私有属性，需调用父类构造函数进行初始化，父类构造函数调用必须是子类构造函数的第一个语句
        super(name, salary);
    }

    // 设置奖金
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * 管理者的薪水由 “底薪 + 奖金” 构成，因此需要覆盖父类的方法
     */
    @Override
    public double getSalary() {
        return super.getSalary() + this.bonus;
    }
}
