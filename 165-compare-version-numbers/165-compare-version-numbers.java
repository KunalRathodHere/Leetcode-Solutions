class Solution {
    public int compareVersion(String version1, String version2) {
        
        int i = 0;
        int j = 0;
        
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        
        System.out.println(a.length + " " + b.length);
        
        while(i < a.length && j < b.length){
            
            int tempa = Integer.valueOf(a[i]);
            int tempb = Integer.valueOf(b[j]);
            
            System.out.println(tempa + " " + tempb);
            
            if(tempa == tempb){
                
                
                
                i++;
                j++;
            }
            
            if(tempa > tempb){
                return 1;
            }
            if(tempa < tempb){
                return -1;
            }
            
        }
        
        if((i == a.length -1) && (j == b.length -1)){
            
            System.out.println("here i am");
            return 0;
            
        }
        
        while(i < a.length){
            
            if(Integer.valueOf(a[i]) > 0)
                return 1;
            i++;
            
        }
        
        while(j < b.length){
            System.out.println("j = " + j);
            if(Integer.valueOf(b[j]) >0)
                return -1;
            j++;
        }
        
        
        
        return 0;
    }
    
}