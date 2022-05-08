package source;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Game有2 methods
 * roll(pins : int)
 * 每次玩家都一個球。
 * 參數是擊倒的瓶數。
 * score() : int
 * 在遊戲結束呼叫。
 * 回傳此次遊戲的最後分數。
 * 遊戲有 10 局。每一局1~2次丟球。第10局有2~3次丟球。
 * 分數功能要每次丟球反覆計算。分數計算需依賴下一局。
 */
public class BowlingGameTest {

    BowlingGame bowlingGame = new BowlingGame();

    /**
     * 十局的20球皆掛零。
     */
    @Test
    void testAllZero() {
        //arrange
//        for (int i = 0; i < 20; i++) {
//            bowlingGame.roll(0);
//        }
        rollMany(20, 0);
        //act
        int score = bowlingGame.score();

        //assert
        assertEquals(0, score);
    }

    /**
     * 十局的20球皆得一分。
     */
    @Test
    void testAllOne() {
        //arrange
//        for (int i = 0; i < 20; i++) {
//            bowlingGame.roll(1);
//        }
        rollMany(20, 1);
        //act
        int score = bowlingGame.score();

        //assert
        assertEquals(20, score);
    }

    /**
     * 第一局即發生 Spare。
     */
    @Test
    void testOneSparse() {
        //arrange
        bowlingGame.roll(3);
        bowlingGame.roll(7);
        bowlingGame.roll(3);
        rollMany(17, 0);

        //act
        int score = bowlingGame.score();

        //assert
        assertEquals(16, score);
    }

    /**
     * 第一局即發生 Strike。
     */
    @Test
    void testOneStrike() {

    }

    /**
     * 十局皆為Strike，並可加碼打兩球，這兩球也是 Strike。
     */
    @Test
    void testPerfectGame() {

    }

    /**
     * 發現測試程式有重複的地方，因此我們開始進行重構；我們把重複的for迴圈部分搬出來，另外建一個 rollMany
     *
     * @param n    丟球次數
     * @param pins 擊倒瓶數
     */
    public void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            bowlingGame.roll(pins);
        }
    }
}
