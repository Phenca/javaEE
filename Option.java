public class Option {
    private String desc;
    private float price;

    public Option(String desc, float price) {
        this.desc = desc;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Option{" +
                "desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }
}