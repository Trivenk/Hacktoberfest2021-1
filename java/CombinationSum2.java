class Solution {
    List<List<Integer>> res=new ArrayList<>();
    Set<List<Integer>> s=new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        back(candidates,0,target,new ArrayList());
        
        for(List<Integer> e:s)
            res.add(e);
        
        return res;
        
    }
    
    public void back(int[] arr,int start,int target,List<Integer> l)
    {
        if(target==0)
        {
            s.add(new ArrayList(l));
            return;
        }
        if(target<0)
        {
            return;
        }
        
        for(int i=start;i<arr.length;i++)
        {
             if(i > start && arr[i] == arr[i-1]) {
                continue;
            }
            l.add(arr[i]);
            
            back(arr,i+1,target-arr[i],l);
            l.remove(l.size()-1);
        
        }
    }
}
