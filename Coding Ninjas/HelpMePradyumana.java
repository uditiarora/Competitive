import java.util.*;
public class Main {
 
   static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEnd;
	}
   
   private static void insert(TrieNode root, String word) {
		TrieNode temp = root;
		for (int i = 0; i < word.length(); ++i) {
			int index = word.charAt(i) - 'a';
			if (temp.children[index] == null) {
				temp.children[index] = new TrieNode();
			}
			temp = temp.children[index];
		}
		temp.isEnd = true;
	}
   private static void recursiveSearch(TrieNode temp, List<String> results, String output) {
		if (temp.isEnd) {
			results.add(output);
		}
		for (int i = 0; i < 26; ++i) {
			if (temp.children[i] != null) {
				recursiveSearch(temp.children[i], results, output + (char) (i + 'a'));
			}
		}
 
	}
 
	private static void search(TrieNode root, String prefix, List<String> results) {
		TrieNode temp = root;
      int flag= 0;
		for (int i = 0; i < prefix.length(); ++i) {
			int index = prefix.charAt(i) - 'a';
			if (temp.children[index] == null) {
				return;
			}
			temp = temp.children[index];
          flag=1;
		}
      if(flag==1){
		recursiveSearch(temp, results, prefix);
      }
	}
        
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		TrieNode root = new TrieNode();
		for (int i = 0; i < N; ++i) {
			String word = sc.next();
			insert(root, word.toLowerCase());
		}
		int Q = sc.nextInt();
 
		for (int i = 0; i < Q; ++i) {
			String prefix = sc.next();
			List<String> results = new ArrayList<>();
			search(root, prefix, results);
			if (results.size() == 0) {
				System.out.println("No suggestions");
				insert(root, prefix);//if the prefix to be searched is not present in trie we insert that prefix
			} 
                        else 
                        {
                        for (String s : results) {
                                System.out.println(s);
                            }
			}
		} 
    }
    
}