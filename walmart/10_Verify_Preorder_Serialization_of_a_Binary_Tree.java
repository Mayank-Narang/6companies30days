//even though a simple solution but was not able to properly figure out this one

class Solution {
    public boolean isValidSerialization(String preorder) {
        int diff = 1;

        String[] each = preorder.split(",");

        for (String e : each){

            if (--diff < 0) return false;
            if (!e.equals("#")) diff += 2;

        }

        return diff == 0;

    }
}
