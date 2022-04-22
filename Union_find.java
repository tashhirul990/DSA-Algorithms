// union finding graph Algo
public class Union_find {
	// s- sum of total nodes in the union
	// root - represent the parent node of the current node
	static int root[] , s[];
	
	// finding parent of the given node
	static int find( int node ) {
		if( node==root[node] ) {
			return node;
		}
		
		return root[node]= find( root[node] );
		
	}
	// unoin of two nodes
	static void union( int x , int y ) {
		
		int p1=find( x);
		int p2= find( y );
		if( p1==p2 ){
            return ;
        }
		if( s[p1]> s[p2] ) {
			
			root[p2]=root[p1];
			s[ p1 ]+=s[p2];
			
		}else {
			root[p1]=root[p2];
			s[ p2 ]+=s[p1];
		}
		
	}
	
	public static void main(String[] args) {
		
		int v=10;
		root=new int[v];
		s=new int[v];
		
		for(int i=0;i<v;i++) {
			root[i]=i;
			s[i]=1;
		}
		
		union(0, 9);
		union(9, 6);
		union(4, 8);
		
		for(int i=0;i<v;i++) {
			System.out.print(root[i]+" ");
		}
		System.out.println();
		for(int i=0;i<v;i++) {
			System.out.print(s[i]+" ");
		}
		System.out.println();
		System.out.println( find(4) );
		
	}
		
}
