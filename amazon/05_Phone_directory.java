//not a hard question(even though it says so). only hard part about this question was implementation of trie.

class Solution{
    
    class Trie{
        
        boolean end;
        List<Integer> list;
        Trie[] arr;
        
        Trie(){
            
            end = false;
            list = new ArrayList<>();
            arr = new Trie[26];
            
        }
        
    }
    
    ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        
        Arrays.sort(contact);
        
        Trie crawler = new Trie();
        Trie head = crawler;
        
        for (int j = 0; j < contact.length; j++){
            
            String each = contact[j];
            crawler = head;
            
            for (int i = 0; i < each.length(); i++){
                
                if (crawler.arr[each.charAt(i)-'a'] == null){
                    crawler.arr[each.charAt(i)-'a'] = new Trie();
                }
                
                crawler = crawler.arr[each.charAt(i)-'a'];
                crawler.list.add(j);
                
            }
            
            crawler.end = true;
            
        }
        
        crawler = head;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int i = 0;
        
        for (; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if (crawler.arr[ch-'a'] == null)
                break;
            ans.add(new ArrayList<>());
                
            crawler = crawler.arr[ch-'a'];
            
            for (int j = 0; j < crawler.list.size(); j++){
                
                String str = contact[crawler.list.get(j)];
                
                if (!ans.get(i).contains(str))
                    ans.get(i).add(str);
                
            }
            
        }
        
        while (i < s.length()){
            
            ans.add(new ArrayList<>());
            ans.get(i++).add("0");
            
        }
        
        return ans;
        
    }
}
