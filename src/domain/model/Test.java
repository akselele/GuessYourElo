package domain.model;

import db.GameDBinMemory;

public class Test {
    public static void main(String[] args) {
        ShopService gb = new ShopService();
        System.out.println(gb.getRandom());
        System.out.println(gb.getRandom().substring(23,41));

        System.out.println(gb.checkRank("Challenger", "5da761ccdddba2ba1d"));

    }
}
