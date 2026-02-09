class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

  ///////////////////////////BAGRUT///////////////////////

  public static boolean ex6(BinNode<Range> tree)
	  {
	      if(tree == null)
	          return true;
	        
	      if(tree.hasLeft())
	      {
	          if((tree.getValue().getLow()!= tree.getLeft().getValue().getLow()) && (tree.getValue().getHigh()<tree.getLeft().getValue().getHigh()))
	              return false;
	      }
	    
	      if(tree.hasRight())
	      {
	          if(tree.getValue().getHigh()!= tree.getRight().getValue().getHigh() && (tree.getValue().getLow()>tree.getRight().getValue().getLow()))
	              return false;
	      }
	    
	      if(tree.hasLeft()&&tree.hasRight())
	      {
	          if(tree.getLeft().getValue().getHigh()>tree.getRight().getValue().getLow())
	              return false;
	      }
	    
	      return ex6(tree.getLeft()) && ex6(tree.getRight());
	  }

///////////////////////////trees/////////////////////////  

   

  public static void ex11a(BinNode<Integer> root) 
	{
        if (root == null)
            return;
            
        boolean even = root.getValue() % 2 == 0;
        boolean leftOk = !root.hasLeft() || root.getLeft().getValue() % 2 == 0;
        boolean rightOk = !root.hasRight() || root.getRight().getValue() % 2 == 0;
        
        if (even && leftOk && rightOk)
            System.out.println(root.getValue());
            
        ex11a(root.getLeft());
        ex11a(root.getRight());
    }
    
    public static int ex11b(BinNode<Integer> root) 
	{
        if (root == null)
            return 0;
            
        boolean even = root.getValue() % 2 == 0;
        boolean leftOk = !root.hasLeft() || root.getLeft().getValue() % 2 == 0;
        boolean rightOk = !root.hasRight() || root.getRight().getValue() % 2 == 0;
        
        if (even && leftOk && rightOk)
            return ex11b(root.getLeft()) + ex11b(root.getRight()) + 1;
        else    
            return ex11b(root.getLeft()) + ex11b(root.getRight());
    }
    
    public static boolean ex11c(BinNode<Integer> root) 
	{
        if (root == null)
            return false;
            
        boolean even = root.getValue() % 2 == 0;
        boolean leftOk = !root.hasLeft() || root.getLeft().getValue() % 2 == 0;
        boolean rightOk = !root.hasRight() || root.getRight().getValue() % 2 == 0;
        
        if (even && leftOk && rightOk)
            return true;
            
        if (ex11c(root.getLeft()) || ex11c(root.getRight()))
            return true;
        else    
            return false;
    }
    
    public static boolean ex11d(BinNode<Integer> root) 
	{
        if (root == null)
            return true;
            
        boolean even = root.getValue() % 2 == 0;
        boolean leftOk = !root.hasLeft() || root.getLeft().getValue() % 2 == 0;
        boolean rightOk = !root.hasRight() || root.getRight().getValue() % 2 == 0;
        
        if (!(even && leftOk && rightOk))
            return false;
            
        if (!(ex11d(root.getLeft()) || ex11d(root.getRight())))
            return false;
        else    
            return true;
    }

public static int ex12(BinNode<Integer> tree)
	{
	    if(tree == null)
	        return 0;
	    if(tree.getValue()==null)
	        return 0;
	    if(tree.getValue()>=10 && tree.getValue()<100)
	        return ex12(tree.getLeft()) + ex12(tree.getRight()) + 1;
	    else
	        return ex12(tree.getLeft()) + ex12(tree.getRight());
	}
	
	public static int ex14(BinNode<Integer> tree)
	{
	    if(tree == null)
	        return 0;
	    if(!tree.hasLeft() && !tree.hasRight())
	        return ex14(tree.getLeft()) + ex14(tree.getRight()) + 1;
	    else
	        return ex14(tree.getLeft()) + ex14(tree.getRight());
	}

  	public static int ex16(BinNode<Integer> tree)
	{
	    if(tree == null)
	        return 0;
	    if(tree.hasLeft() && tree.hasRight())
	        return ex16(tree.getLeft()) + ex16(tree.getRight()) + 1;
	    return ex16(tree.getLeft()) + ex16(tree.getRight());
	}
	
	public static int ex17(BinNode<Integer> tree)
	{
	    if(tree == null)
	        return 0;
	    if(tree.hasRight()&&tree.hasLeft())
	    {
	        if(!isLeaf(tree.getLeft())&&!isLeaf(tree.getRight()))
	            return ex17(tree.getLeft()) + ex17(tree.getRight()) + 1;
	    }
	    return ex17(tree.getLeft()) + ex17(tree.getRight());
	}
	
	public static boolean ex18(BinNode<Integer> t1, BinNode<Integer> t2)
	{
	    if(t1== null)
	        return false;
	    if(!t2.getValue() == t1.getValue())
	    {
	        return ex18(t1.getLeft(),t2) || ex17(t1.getRight(),t2);
	    }
	    return ex18(t1,t2.getLeft()) && ex18(t1,t2.getRight());
	}

	public static boolean ex20(BinNode<Integer> t, int n)
	{
	    if(t == null)
	        return false;
	    if(n==0)
	        return true;
	    if(t.getValue() != n)
	        return ex20(t.getLeft(), n) || ex20(t.getRight(), n);
	    return ex20(t, n-1);
	}

}
