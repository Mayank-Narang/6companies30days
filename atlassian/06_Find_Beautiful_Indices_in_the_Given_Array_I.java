class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        
        List<Integer> ans = new ArrayList<>();
        //find indices corresponding to string a

        int len = s.length()-a.length();

        int found = s.indexOf(a);

        while (found != -1 && found <= len){
            ans.add(found);
            found = s.indexOf(a,found+1);
        }

        //find indices corresponding to string b

        List<Integer> bb = new ArrayList<>();

        len = s.length() - b.length();

        found = s.indexOf(b);

        while (found != -1 && found <= len){
            bb.add(found);
            found = s.indexOf(b,found+1);
        }

        for (int i = 0; i < ans.size(); i++){

            int min = ans.get(i)-k;
            int max = ans.get(i)+k;
            boolean f = false;

            for (int j = 0; j < bb.size(); j++){

                int val = bb.get(j);

                if (val >= min && val <= max){
                    f = true;
                    break;
                }

            }

            if (!f)
                ans.set(i,-1);

        }

        List<Integer> anss = new ArrayList<>();

        for (int i : ans){

            if (i > -1)
                anss.add(i);

        }

        return anss;

    }
}
