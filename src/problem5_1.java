class TV {
    private int size;
    public TV(int size) { this.size = size; }
    protected int getSize() { return size; }
}

class ColorTV extends TV{
    private int Color;
    public ColorTV(int size, int Color) {
        super(size);
        this.Color = Color;
    }
    public void printProperty() {
        System.out.println(super.getSize()+"인치 " + Color+"컬러");
    }
}
public class problem5_1 {
    public static void main(String [] args) {
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();
    }
}