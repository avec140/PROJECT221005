import java.util.Scanner;

abstract class GameObject {
    protected int distance;
    protected int x, y;
    public GameObject(int startX, int startY, int distance) {
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean collide(GameObject p) {
        if(this.x == p.getX() && this.y == p.getY())
            return true;
        else
            return false;
    }
    protected abstract void move();
    protected abstract char getShape();
}

class Bear extends GameObject {
    Scanner scan = new Scanner(System.in);

    public Bear(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }
    @Override
    protected void move() { // Bear 이동
        System.out.print("왼쪽(a), 위(w), 아래(s), 오른쪽(d) >> ");
        String key = scan.next();

        switch(key) {
            case "a":
                if(super.y > 0)
                    super.y -= super.distance;
                break;
            case "w": // 위(w)
                if(super.x > 0)
                    super.x -= super.distance;
                break;
            case "s": // 아래(s)
                if(super.x < 9)
                    super.x += super.distance;
                break;
            case "d": // 오른쪽(d)
                if(super.y < 19)
                    super.y += super.distance;
                break;
        }
    }
    @Override
    protected char getShape() {
        return 'B';
    }
}

class Fish extends GameObject { // Fish
    public Fish(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }
    @Override
    protected void move() {
        int key = (int)(Math.random()*4);

        switch(key) {
            case 0:
                if(super.y > 0)
                    super.y -= super.distance;
                break;
            case 1: // 위
                if(super.x > 0)
                    super.x -= super.distance;
                break;
            case 2: // 아래
                if(super.x < 9)
                    super.x += super.distance;
                break;
            case 3: // 오른쪽
                if(super.y < 19)
                    super.y += super.distance;
                break;
        }
    }
    @Override
    public char getShape() {
        return '@';
    }
}

public class problem_open1 {
    char[][] map = new char[10][20];
    Bear bear;
    Fish fish;

    public static void main(String[] args) {
        problem_open1 game = new problem_open1();
        game.run(); }

    public void run() {
        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다 **");

        bear = new Bear(0, 0, 1);
        fish = new Fish((int)(Math.random()*10), (int)(Math.random()*20), 1);
        drawMap();

        int[] moveFishArray = moveFish();
        int index = 0;

        while(true) {
            bear.move();
            if(moveFishArray[index] == 1)
                fish.move();

            index++;
            if(index == 5) {
                moveFishArray = moveFish();
                index = 0;
            }

            drawMap();

            if(bear.collide(fish)) {
                System.out.print("Bears Wins!!");
                break;
            }
        }
    }

    public void drawMap() {
        for(int i=0; i<10; i++)
            for(int k=0; k<20; k++)
                map[i][k] = '-';

        map[fish.getX()][fish.getY()] = fish.getShape();
        map[bear.getX()][bear.getY()] = bear.getShape();

        for(int i=0; i<10; i++) {
            for(int k=0; k<20; k++)
                System.out.print(map[i][k]);
            System.out.println();
        }
    }

    public int[] moveFish() {
        int array[] = {0, 0, 0, 0, 0};
        int cnt = 0; // 1의 개수

        while(true) {
            int index = (int)(Math.random()*4);

            if(array[index] == 0) {
                array[index] = 1;
                cnt++;
            }
            if(cnt == 2)
                break;
        }
        return array;
    }
}