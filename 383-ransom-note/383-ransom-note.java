class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] arr = new int[27];
        Arrays.fill(arr, 0);
        
        for(int i =0; i<magazine.length(); i++){
            System.out.println(magazine.charAt(i) - 'a');
            arr[magazine.charAt(i) - 'a']++;
        }
        
        for(int i =0; i<ransomNote.length(); i++){
            if(arr[ransomNote.charAt(i) - 'a'] > 0){
                arr[ransomNote.charAt(i) - 'a']--;
            }
            else{
                return false;
            }
        }
        
        return true;
    }
}