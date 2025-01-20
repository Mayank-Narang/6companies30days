class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Set<String> present = new HashSet(),repeat = new HashSet();

        for (int i = 0; i < s.length() -9; i++){

            String each = s.substring(i,i+10);

            if (present.contains(each))
                repeat.add(each);
            present.add(each);

        }

        return new ArrayList(repeat);

    }
}
