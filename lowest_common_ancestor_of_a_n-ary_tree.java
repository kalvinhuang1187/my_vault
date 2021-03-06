/*
Given a n-ary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

        _______3______
       /       |      \
    ___5__     7    ___1__
   /      \        /   |  \
   6       2       0   4   8
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of 
nodes 5 and 4 is 3
*/

Node LCA(Node root, Node a, Node b) { 
    if(a == root || b == root)
        return root;
    
    int count = 0;
    Node temp = null;
  
    for(Node iter : root.children) {
        Node res = LCA(iter, a, b);

        if(res != null) {
            count++;
            temp = res;
        }
    }
    
    if(count == 2)
        return root;
      
    return temp;
}

