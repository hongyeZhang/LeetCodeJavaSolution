package algorithm.other;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author : ZHQ
 * @date : 2020/4/10
 */
public class PokerTest {

    /**
     * 手里有一副扑克牌。按照下列规则吧他堆放桌上。一，拿出最上面的一张牌，放桌上，然后把接下来的一张牌放在扑克牌的最下面。
     * 循环，直到没有手牌。现在已知桌上牌的顺序。求原手牌的顺序。
     * @param inputs
     */
    public void fromDeskTopToHand(int[] inputs) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int input : inputs) {
            stack.push(input);
        }

        ArrayDeque<Integer> hand = new ArrayDeque<Integer>(13);
        while (!stack.isEmpty()) {
            if (!hand.isEmpty()) {
                hand.addFirst(hand.pollLast());
            }
            hand.addFirst(stack.pop());
        }

        while (!hand.isEmpty()) {
            System.out.print(hand.pollFirst() + "\t");
        }
        System.out.println();
    }

    @Test
    public void testFromDeskTopToHand() {
        int[] inputs = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        fromDeskTopToHand(inputs);



    }


}
