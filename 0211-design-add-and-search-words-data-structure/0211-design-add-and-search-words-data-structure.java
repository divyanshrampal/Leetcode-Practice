class Node{
		char ch;
		HashMap<Character,  Node> children;
		boolean isEnd;
		
		Node(char ch){
			this.ch = ch;
			children = new HashMap<>();
		}
		
		boolean hasChild(char childCh) {
			return children.containsKey(childCh);
		}
		
		Node addChild(char childCh) {
			if(this.children.containsKey(childCh)) {
				return this.children.get(childCh);
			}
			Node childNode = new Node(childCh);
			this.children.put(childCh, childNode);
			return childNode;
		}
		
		Node getChild(char childCh) {
				return this.children.get(childCh);			
		}
		
		void markEndOfWord() {
			this.isEnd = true;
		}
		
		boolean isEndOfWord() {
			return this.isEnd;
		}
		
		void unmarkEndOfWord() {
			this.isEnd = false;
		}
		
		
	}

class WordDictionary {
    
    Node root;

    public WordDictionary() {
        root = new Node('-');
    }
    
    public void addWord(String word) {
         Node ptr = root;
			for(int i = 0; i<word.length(); i++) {
				char ch = word.charAt(i);
				if(ptr.hasChild(ch)) {
					ptr = ptr.getChild(ch);
				}
				else {
					ptr = ptr.addChild(ch);
				}
			}
			ptr.markEndOfWord();
    }
    
    public boolean searchUtil(Node root, String word){
            Node ptr = root;
			for(int i = 0; i<word.length(); i++) {
				char ch = word.charAt(i);
                if(ch == '.'){
                    for(Character ch2 : ptr.children.keySet()){
                        Node temp = ptr.children.get(ch2);
                        if(searchUtil(temp, word.substring(i+1))){
                            return true;
                        }
                    }
                }
				if(ptr.hasChild(ch)) {
					ptr = ptr.getChild(ch);
				}
				else {
					return false;
				}
			}
			return ptr.isEndOfWord();
    }
    
    public boolean search(String word) {
        
			return searchUtil(root, word);
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */