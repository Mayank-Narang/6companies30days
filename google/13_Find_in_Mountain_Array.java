/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

//can be improved by taking one step at a time
//finding the mountain then searching in first half and other half respectively returning the lowest index of target

 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int s =0,e=mountainArr.length()-1,ind=-1;
        while(s<e){
            int mid=s+(e-s)/2;
            int n =mountainArr.get(mid);
            if(n>mountainArr.get(mid+1)){
                ind=mid;
                e=mid;
            }
            else{
                s=mid+1;
            }
        }
        if(mountainArr.get(ind)==target)
        return ind;
        int a = bs(mountainArr,target,ind,true);
        
        if(a==-1)
        a=bs(mountainArr,target,ind,false);
        
        return a;
    }
    public int bs(MountainArray mountainArr,int target,int ind,boolean check){
        int s,e;
        int ans=-1;
        if(check){
            s=0;
            e=ind-1;
            
        while(s<=e){
        int mid=s+(e-s)/2;           
        int n=mountainArr.get(mid);
        if(n==target){
            ans=mid;
            while(mid-1>=0){
                if(mountainArr.get(--mid)==target)
                ans=mid;
                else 
                break;
            }
            return ans;
        }
        else if(n>target)
        e=mid-1;
        else
        s=mid+1;
        }
        return ans;
        }
        else{
            s=ind+1;
            e=mountainArr.length()-1;
        while(s<=e){
        int mid=s+(e-s)/2;           
        int n=mountainArr.get(mid);
        if(n==target){
            ans=mid;
            while(mid+1<mountainArr.length()){
                if(mountainArr.get(++mid)==target)
                ans=mid;
                else 
                break;
            }
            return ans;
        }
        else if(n<target)
        e=mid-1;
        else
        s=mid+1;
        }
        return ans;
        }
    }
}
