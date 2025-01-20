class Solution {
    class Pair{
        char first;
        int second;
        Pair(char first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public String sortStr(String input){
        char[] ch = input.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public String frequencySort(String s) {
        List<Pair> list = new ArrayList<>();
        String change = sortStr(s);
        int count = 1;
        for (int i = 0; i < change.length()-1; i++){
            if(change.charAt(i)!=change.charAt(i+1)){
                list.add(new Pair(change.charAt(i),count));
                count = 1;
            }
            else count++;
        }
        list.add(new Pair(change.charAt(change.length() - 1),count));
        Collections.sort(list,(a,b) -> b.second - a.second);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++){
            char ch = list.get(i).first;
            for (int j = list.get(i).second; j > 0; j--){
            sb.append(ch);
            }
        }
        return sb.toString();

    }
}
