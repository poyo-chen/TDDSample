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
 * 若第一次全倒 strike，結束該次計分格。若第一次沒有全倒，則可以再投第二次，且把剩下的球瓶都擊倒就記 spare
 * 如果擊出 strike ，以 10 瓶制為例，則該次計分格的分數需要擊倒十瓶的 10 分再加上後面兩次丟球所打倒的球瓶分數。
 * 如果擊出 spare ，則該次計分格的分數需要擊倒十瓶的10分再加上後面一次丟球所打倒的球瓶分數。
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
        rollSpare(1, 9);
        bowlingGame.roll(4);
        rollMany(17, 0);

        //act
        int score = bowlingGame.score();

        //assert
        assertEquals(18, score);
    }


    /**
     * 第一局即發生 Strike。
     */
    @Test
    void testOneStrike() {
        //arrange
        rollStrike();
        bowlingGame.roll(4);
        bowlingGame.roll(5);
        rollMany(17, 0);

        //act
        int score = bowlingGame.score();

        //assert
        assertEquals(28, score);
    }

    /**
     * 十局皆為Strike，並可加碼打兩球，這兩球也是 Strike。
     */
    @Test
    void testPerfectGame() {
        //arrange
        rollMany(12, 10);

        //act
        int score = bowlingGame.score();

        //assert
        assertEquals(300, score);
    }

    /**
     * 每輪第一下皆為九瓶，第二下沒中。
     */
    @Test
    public void testAllNine() {
        //arrange
        rollMany(10, 9, 0);

        //act
        int score = bowlingGame.score();

        //assert
        assertEquals(90, score);
    }

    /**
     * 發現測試程式有重複的地方，因此我們開始進行重構；我們把重複的for迴圈部分搬出來，另外建一個 rollMany。
     *
     * @param n    丟球次數
     * @param pins 擊倒瓶數
     */
    public void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            bowlingGame.roll(pins);
        }
    }

    public void rollMany(int n, int pins, int pins2) {
        for (int i = 0; i < n; i++) {
            bowlingGame.roll(pins);
            bowlingGame.roll(pins2);
        }
    }

    /**
     * 打出Spare.
     *
     * @param pinsDown
     * @param pinsDown1
     */
    private void rollSpare(int pinsDown, int pinsDown1) {
        bowlingGame.roll(pinsDown);
        bowlingGame.roll(pinsDown1);
    }

    /**
     * 打出Strike.
     */
    private void rollStrike() {
        bowlingGame.roll(10);
    }

}
