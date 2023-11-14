package basic;

/**
 * @author Lucas Su
 * @create 2023-07-31-13:48
 */
public class FingerCounting {
    public int count1(int weakFinger, int maxCount) {
        if (weakFinger == 0 && maxCount == 0) {
            return 0;
        }
        int currentCount = 1, weakFingerUsed = 0, currentFinger = 0;
        if (weakFinger == 0) weakFingerUsed = 1;
        boolean thumbToPinky = true;

        while (true) {

            // 4 sub-rules
            if (thumbToPinky && currentFinger < 4) {
                currentFinger++;
            } else if (!thumbToPinky && currentFinger > 0) {
                currentFinger--;
            } else if (thumbToPinky && currentFinger == 4) {
                currentFinger--;
                thumbToPinky = false;
            } else if (!thumbToPinky && currentFinger == 0) {
                currentFinger++;
                thumbToPinky = true;
            }

            // universally apply to 4 sub-rules
            currentCount++;
            if (currentFinger == weakFinger) {
                weakFingerUsed++;
            }

            if (weakFingerUsed == maxCount + 1) {
                return currentCount - 1;
            }
        }
    }


    public static void main(String[] args) {
        FingerCounting fingerCounting = new FingerCounting();
        System.out.println(fingerCounting.count1(3, 3));
    }
}
