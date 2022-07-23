class Solution {
    public int compareVersion(String version1, String version2) {
        
           String[] levels1 = version1.split("\\.");
    String[] levels2 = version2.split("\\.");
    
    int length = Math.max(levels1.length, levels2.length);
    for (int i=0; i<length; i++) {
    	Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
    	Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
    	int compare = v1.compareTo(v2);
    	if (compare != 0) {
    		return compare;
    	}
    }
    
    return 0;
        
        
//         int i = 0;
//         int j = 0;
        
//         String[] a = version1.split("\\.");
//         String[] b = version2.split("\\.");
        
//         System.out.println(a.length + " " + b.length);
        
//         while(i < a.length && j < b.length){
            
//             int tempa = Integer.valueOf(a[i]);
//             int tempb = Integer.valueOf(b[j]);
            
//             System.out.println(tempa + " " + tempb);
            
//             if(tempa == tempb){
                
                
                
//                 i++;
//                 j++;
//             }
            
//             if(tempa > tempb){
//                 return 1;
//             }
//             if(tempa < tempb){
//                 return -1;
//             }
            
//         }
        
//         if((i == a.length -1) && (j == b.length -1)){
            
//             System.out.println("here i am");
//             return 0;
            
//         }
        
//         while(i < a.length){
            
//             if(Integer.valueOf(a[i]) > 0)
//                 return 1;
//             i++;
            
//         }
        
//         while(j < b.length){
//             System.out.println("j = " + j);
//             if(Integer.valueOf(b[j]) >0)
//                 return -1;
//             j++;
//         }
        
        
        
//         return 0;
    }
    
}