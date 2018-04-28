import java.util.List;
import java.util.ArrayList;

public class Order {
    // 订单商品列表
    private List<Goods> goodsList = new ArrayList<>();

    /**
     * 静态嵌套类，不能访问外部类的成员和方法
     */
    public static class Goods {
        private String goodsName;
        private double goodsPrice;

        Goods(String name, double price) {
            this.goodsName = name;
            this.goodsPrice = price;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public double getGoodsPrice() {
            return goodsPrice;
        }

        /**
         * 不可访问外部类的数据，因为静态嵌套类内部没有外部类的引用
         */
        public int getGoodsCount() {
            //return goodsList.size(); // error
            return 0;
        }
    }

    /**
     * 内部类，对象拥有外部类对象的引用，可访问外部对象的数据
     */
    public class Present extends Goods {
        Present(String name) {
            super(name, 0);
        }

        /**
         * 获取奖品数量
         */
        public int getPresentCount() {
            int cnt = 0;
            for (int i = 0; i < Order.this.goodsList.size(); i++) {
                if (Order.this.goodsList.get(i).getGoodsPrice() == 0) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    /**
     * 添加商品
     */
    public void addGoods(Goods g) {
        this.goodsList.add(g);
    }

    /**
     * 打印订单下的所有商品，包括奖品
     */
    public void showOrderGoods() {
        this.goodsList.forEach(g -> System.out.println("名称：" + g.getGoodsName() + "，售价：" + g.getGoodsPrice()));
    }

    public static void main(String[] args) {
        Order o = new Order();
        // 静态嵌套类可直接实例化
        o.addGoods(new Order.Goods("鸭子", 158));
        o.addGoods(new Order.Goods("牛肉", 98));

        // 内部类的实例化依赖于外部类对象
        Present p = o.new Present("塑料袋");
        o.addGoods(p);

        // 内部类对象访问外部类对象的数据
        System.out.println(p.getPresentCount());

        o.showOrderGoods();
    }
}
