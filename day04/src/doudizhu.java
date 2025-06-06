public class doudizhu {
    //斗地主
    public static void main(String[] args) {

        start();
    }

        public static void start(){
            //定义数组
            String[] cards = new String[54];
            String[] colors = {"♥", "♠", "♣", "♦"};
            String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

            int index = 0;
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < colors.length; j++) {
                    cards[index++] = colors[j] + numbers[i];
                }
            }
            cards[index++] = "小王";
            cards[index] = "大王";

            for (int i = 0; i < cards.length; i++) {
                System.out.print(cards[i] + " ");
            }
            System.out.println();

            //洗牌
            for (int i = 0; i < cards.length; i++) {
                int index1 = (int) (Math.random() * cards.length);
                int index2 = (int) (Math.random() * cards.length);
                //索引位置交换
                //定义一个临时变量
                String temp = cards[index2];
                //将index1位置的元素赋值给index2
                cards[index2] = cards[index1];
                //将临时变量的元素赋值给index1
                cards[index1] = temp;
            }
            System.out.println("洗牌后：");
            for (int i = 0; i < cards.length; i++) {
                System.out.print(cards[i] + "\t");
            }
        }


}
