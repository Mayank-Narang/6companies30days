//trie has become my faboritee

class WordDictionary {

    public class TrieNode{

        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }

    }

    TrieNode root;
    int lett;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode crawler = root;

      // System.out.println(word);

        for (int i = 0;i < word.length(); i++){

            lett = word.charAt(i)-'a';

            // System.out.println(word.charAt(i));
            // System.out.println(crawler.children[lett]);

            if (crawler.children[lett] == null)
                crawler.children[lett] = new TrieNode();

            crawler = crawler.children[lett];

        }

        crawler.isEndOfWord = true;

    }
    
    public boolean search(String word) {

        TrieNode crawler = root;
        return proceed(crawler,word,0);

    }

    public boolean proceed(TrieNode crawler,String word,int idx){

        if (idx == word.length()){
            return crawler.isEndOfWord;
        }

        boolean res = false;

            lett = word.charAt(idx)-'a';

            if (lett == -51){
                for (int j = 0;j < 26; j++){

                    if (crawler.children[j] != null){
                        res = res || proceed(crawler.children[j],word,idx+1);
                    }

                }

            }
            else {
                if (crawler.children[lett] == null)
                    return false;

                res = res || proceed(crawler.children[lett],word,idx+1);

            }

        return res;

    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
