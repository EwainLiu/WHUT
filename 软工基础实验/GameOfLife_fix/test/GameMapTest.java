import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameMapTest {

    GameMap map = new GameMap(5, 5);

    @Before
    public void setUp() throws Exception {
        boolean[][] map = this.map.getMap();

        map[1][1] = true; //角落
        map[5][3] = true; //边界

        map[3][2] = true; //中间
        map[3][3] = true;
        map[3][4] = true;

        this.map.setMap(map);
    }

    @Test
    public void clearMap() {
        this.map.clearMap();
        boolean[][] zero = new boolean[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                zero[i][j] = false;
            }
        }
        assertEquals(zero, this.map.getMap());

        boolean[][] map = this.map.getMap();
        System.out.println("结果状态：");
        for (int i = 1; i <= map.length - 2; i++) {
            for (int j = 1; j <= map[0].length - 2; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("单元测试：清除地图成功！！！");
    }

    @Test
    public void get_neighbor_count() {
        boolean[][] map = this.map.getMap();
        System.out.println("初始状态：");
        for (int i = 1; i <= map.length - 2; i++) {
            for (int j = 1; j <= map[0].length - 2; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        assertEquals(0, this.map.get_neighbor_count(1, 1));
        System.out.println("map[1][1]周围邻居数：0");
        assertEquals(0, this.map.get_neighbor_count(5, 3));
        System.out.println("map[5][3]周围邻居数：0");

        assertEquals(1, this.map.get_neighbor_count(3, 2));
        System.out.println("map[3][2]周围邻居数：1");
        assertEquals(2, this.map.get_neighbor_count(3, 3));
        System.out.println("map[3][3]周围邻居数：2");
        assertEquals(3, this.map.get_neighbor_count(2, 3));
        System.out.println("map[2][3]周围邻居数：3");
        assertEquals(4, this.map.get_neighbor_count(4, 3));
        System.out.println("map[4][3]周围邻居数：4");

        System.out.println("单元测试：获取邻居数量成功！！！");
        System.out.println();
    }


    @Test
    public void repoduce() {

        boolean[][] cell = {
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, true, true, false, false, false},
                {false, false, false, true, false, false, false},
                {false, false, true, false, true, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false}};

        boolean[][] map = this.map.getMap();
        System.out.println("初始状态：");
        for (int i = 1; i <= map.length - 2; i++) {
            for (int j = 1; j <= map[0].length - 2; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        this.map.repoduce();
        map = this.map.getMap();
        System.out.println("目标状态：\t结果状态：");
        for (int i = 1; i <= map.length - 2; i++) {
            for (int j = 1; j <= map[0].length - 2; j++) {
                System.out.print(cell[i][j] + " ");
            }
            System.out.print("\t");
            for (int j = 1; j <= map[0].length - 2; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        assertEquals(cell, this.map.getMap());

        System.out.println("单元测试：繁殖下一代成功！！！");
    }

}
