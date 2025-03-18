package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.constants.Сonstants.*;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters (name = "Название булочки {0}, Цена булочки {1}")
    public static Object[][] testDateGen() {
        return new Object[][] {
                {NAME_BUN_WITH_SESAME, PRICE_20_1F},
                {NAME_RED_BUN, PRICE_100_0f},
                {NAME_WHITE_BUN, PRICE_200_0f},
                {NAME_BLACK_BUN, PRICE_90_0f},
                {EMPTY_STRING,PRICE_300_0f},
                {WITH_SYMBOLS_STRING, PRICE_0_0f},
                {null, PRICE_MINUS_100_0f},
        };
    }

    @Before
    public void createNewBun() {
        bun = new Bun(name, price);
    }

    @Test
    public void getName() {
        assertEquals("Проверяем соответствие названия булочки", name, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("Проверяем соответствие цены", price, bun.getPrice(), DELTA_0);
    }
}

