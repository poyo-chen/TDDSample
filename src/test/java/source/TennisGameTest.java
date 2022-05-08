package source;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * output:
 *   3:1 —> [forty fifteen]
 *   if after deuce, first player win —> [first player win]
 *   if after deuce, second player win —> [second player win]
 *   if after deuce, second player win —> [second player win]
 *
 *
 * class rule:
 *   score String
 *   firstPlayerScore void
 *   secondPlayerScore void
 *
 * 使用者案例
 *	正常情況(不考慮 deuce)
 *      顯示比分(尚未結束的比分)
 *      比賽結束
 *
 *  規格情況(deuce)
 *      顯示比分(尚未結束的比分)
 *      比賽結束
 *
 * */
public class TennisGameTest {


    TennisGame game = new TennisGame();

    @Test
    @DisplayName("love love")
    void test_0_0() {
        //arrange

        //act
        String result = game.score();

        //assert
        assertEquals("love love", result);
    }

    @Test
    @DisplayName("forty thirty")
    void test_3_2() {
        //arrange
        firstPlayerScore(3);
        secondPlayerScore(2);

        //act
        String result = game.score();

        //assert
        assertEquals("forty thirty", result);
    }


    @Test
    @DisplayName("love fifteen")
    void test_0_1() {
        //arrange
        firstPlayerScore(0);
        secondPlayerScore(1);

        //act
        String result = game.score();

        //assert
        assertEquals("love fifteen", result);
    }

    @Test
    @DisplayName("first player win")
    void test_4_1() {
        //arrange
        firstPlayerScore(4);
        secondPlayerScore(1);

        //act
        String result = game.score();

        //assert
        assertEquals("first player win", result);
    }

    @Test
    @DisplayName("second player win")
    void test_2_4() {
        //arrange
        firstPlayerScore(2);
        secondPlayerScore(4);

        //act
        String result = game.score();

        //assert
        assertEquals("second player win", result);
    }

    @Test
    @DisplayName("deuce")
    void test_3_3() {
        //arrange
        firstPlayerScore(3);
        secondPlayerScore(3);

        //act
        String result = game.score();

        //assert
        assertEquals("deuce", result);
    }

    @Test
    @DisplayName("deuce")
    void test_4_4() {
        //arrange
        firstPlayerScore(4);
        secondPlayerScore(4);

        //act
        String result = game.score();

        //assert
        assertEquals("deuce", result);
    }

    @Test
    @DisplayName("first player advantage")
    void test_4_3() {
        //arrange
        firstPlayerScore(4);
        secondPlayerScore(3);

        //act
        String result = game.score();

        //assert
        assertEquals("first player advantage", result);
    }


    @Test
    @DisplayName("second player advantage")
    void test_3_4() {
        //arrange
        firstPlayerScore(3);
        secondPlayerScore(4);

        //act
        String result = game.score();

        //assert
        assertEquals("second player advantage", result);
    }

    @Test
    @DisplayName("first player win")
    void test_6_4() {
        //arrange
        firstPlayerScore(6);
        secondPlayerScore(4);

        //act
        String result = game.score();

        //assert
        assertEquals("first player win", result);
    }

    @Test
    @DisplayName("second player win")
    void test_3_5() {
        //arrange
        firstPlayerScore(3);
        secondPlayerScore(5);

        //act
        String result = game.score();

        //assert
        assertEquals("second player win", result);
    }

    private void firstPlayerScore(int times) {
        for (int i = 0; i < times; i++) {
            game.firstPlayerScore();
        }
    }

    private void secondPlayerScore(int times) {
        for (int i = 0; i < times; i++) {
            game.secondPlayerScore();
        }
    }
}
