class Solution {
    
    public int getRootNode(int n, int[] leftChild, int[] rightChild) {
		HashSet<Integer> uniqueNodes = new HashSet<>();
		int root = -1;
		for(int left : leftChild){
			if(left != -1)
				uniqueNodes.add(left);
		}
		for(int right : rightChild){
			if(right != -1)
				uniqueNodes.add(right);
		}

		for(int i = 0; i < n; i++){
			if(uniqueNodes.contains(i)){
				continue;
			}
			root = i;
			break;
		}

		return root;
		
	}
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> set = new HashSet<>();
		int rootNode = getRootNode(n,leftChild,rightChild);
		if(rootNode == -1){
			return false;
		}
		q.add(rootNode);
		while(q.size() > 0){
			int i = q.remove();
			if(set.contains(i)){
				return false;
			}
			set.add(i);
			if(leftChild[i] != -1){
				q.add(leftChild[i]);
			}
			if(rightChild[i] != -1){
				q.add(rightChild[i]);
			}
		}

		return set.size() == n;
    }
}